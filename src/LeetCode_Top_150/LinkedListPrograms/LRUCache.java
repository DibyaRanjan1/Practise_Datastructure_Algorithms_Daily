package LeetCode_Top_150.LinkedListPrograms;

import java.util.HashMap;

public class LRUCache {

    public static void main(String[] args) {

        LRUCache l = new LRUCache(2);
        l.put(1,1);
        l.put(2,2);

        l.put(3,3);
    }

    private HashMap<Integer,DoublyLinkedListNode> map = null;
    private int capacity;
    DoublyLinkedListNode left;
    DoublyLinkedListNode right;

    public LRUCache(int capacity) {
        this.capacity = capacity;
      map = new HashMap<>();
      this.left = new DoublyLinkedListNode(0,0);
      this.right = new DoublyLinkedListNode(0,0);
      this.right.prev = this.left;
      this.left.next = this.right;
    }

    public int get(int key) {
      if(map.containsKey(key)){
        remove(map.get(key));
        Insert(map.get(key));
        return map.get(key).data;
      }
      return -1;
    }

    public void put(int key, int value) {
       if(map.containsKey(key)){
          remove(map.get(key));
       }
       map.put(key,new DoublyLinkedListNode(value,key));
       Insert(map.get(key));

       if(map.size() > capacity){
           DoublyLinkedListNode lu = this.left.next;
           remove(lu);
           map.remove(lu.key);
       }
    }

    private void Insert(DoublyLinkedListNode node){
        DoublyLinkedListNode prev = this.right.prev;
        DoublyLinkedListNode next = this.right;

        prev.next = node;
        next.prev = node;

        node.next = next;
        node.prev = prev;
    }

    private void remove(DoublyLinkedListNode node){

        DoublyLinkedListNode prev = node.prev;
        DoublyLinkedListNode next = node.next;

        prev.next =next;
        next.prev = prev;
    }

}

class DoublyLinkedListNode{

    DoublyLinkedListNode prev;
    DoublyLinkedListNode next;

   public int data;
   public int key;

    public DoublyLinkedListNode(int data,int key){
        this.data = data;
        this.key = key;
    }

}


