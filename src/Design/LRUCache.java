package Design;

import java.util.HashMap;

public class LRUCache {
    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        lRUCache.get(1);    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.get(2);    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.get(1);    // return -1 (not found)
        lRUCache.get(3);    // return 3
        lRUCache.get(4);    // return 4


    }

    DoublyLinkedListNode head = new DoublyLinkedListNode(0,0);
    DoublyLinkedListNode tail = new DoublyLinkedListNode(0,0);
    HashMap<Integer,DoublyLinkedListNode> map = new HashMap<>();
    int capacity;

    public LRUCache(int capacity){
        this.capacity = capacity;
        head.next = tail;
        tail.prev =head;

    }

    public int get(int key) {
      if(map.containsKey(key)){
          DoublyLinkedListNode node = map.get(key);
          remove(node);
          insert(node);
          return map.get(key).value;
      }
      return -1;
    }

    public void put(int key, int value) {
       if(map.containsKey(key)){
           DoublyLinkedListNode node = map.get(key);
           remove(node);
       }

        if(map.size() >= capacity){
            DoublyLinkedListNode node = tail.prev;
            remove(node);
            map.remove(node.key);
        }
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(key,value);
        insert(newNode);
    }

    private void insert(DoublyLinkedListNode node){
        map.put(node.key,node);
        DoublyLinkedListNode headNext = head.next;
        head.next = node;
        node.prev =head;
        headNext.prev = node;
        node.next = headNext;
    }

    private void remove(DoublyLinkedListNode node){

        map.remove(node.key);
        DoublyLinkedListNode prev = node.prev;
        DoublyLinkedListNode next = node.next;

        if(prev!=null){
            prev.next = next;

            next.prev = prev;
        }


    }

    private class DoublyLinkedListNode{
        public DoublyLinkedListNode prev;
        public DoublyLinkedListNode next;
         int key;
        int value;

        public DoublyLinkedListNode(int key, int value){
            this.key  = key;
            this.value = value;
        }

    }
}
