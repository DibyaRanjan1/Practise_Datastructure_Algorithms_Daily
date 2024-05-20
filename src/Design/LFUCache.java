package Design;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {

    Map<Integer, DoublyLinkedList> freqList;
    Map<Integer,DoubleLinkedListNode> map;
    int capacity =0;
    int curSize;
    int minFreq;

    public LFUCache(int capacity) {
   freqList = new HashMap<>(capacity);
   map = new HashMap<>(capacity);
   this.capacity = capacity;
   this.curSize=0;
   this.minFreq =0;
    }

    private void update(DoubleLinkedListNode currNode){
         int currFreq = currNode.freq;

        DoublyLinkedList oldLst = freqList.get(currFreq);
        oldLst.remove(currNode);

        if(oldLst.listSize ==0 && minFreq == currFreq){
            ++minFreq;
            freqList.remove(currFreq);
        }

        currNode.freq++;
        DoublyLinkedList lst = freqList.getOrDefault(currNode.freq,new DoublyLinkedList());
        lst.insert(currNode);
        freqList.put(currNode.freq,lst);
    }

    public int get(int key) {
      if(!map.containsKey(key)) return -1;

     update(map.get(key));
      return map.get(key).data;
    }

    public void put(int key, int value) {
        if(capacity ==0) return;

      if(!map.containsKey(key)){
          ++curSize;
          if(curSize> capacity){
              DoublyLinkedList lst = freqList.get(minFreq);
              map.remove(lst.tail.prev.key);
              freqList.remove(lst.tail.prev);
              --curSize;
          }
          DoubleLinkedListNode newNode = new DoubleLinkedListNode(key,value);
          minFreq =1;

          DoublyLinkedList lst = freqList.getOrDefault(minFreq,new DoublyLinkedList());
          lst.insert(newNode);
          map.put(key,newNode);
          freqList.put(1,lst);

      }else {
          DoubleLinkedListNode currNode = map.get(key);
          currNode.data = value;
          update(currNode);
      }
    }

    class DoubleLinkedListNode{
        public int freq=0;
        public int data;
        public int key;
        DoubleLinkedListNode prev;
        DoubleLinkedListNode next;

        DoubleLinkedListNode(int key,int val){
            this.data = val;
            this.freq=1;
            this.key = key;
        }
    }

    class DoublyLinkedList{

        DoubleLinkedListNode head;
        DoubleLinkedListNode tail;
        int listSize;

        DoublyLinkedList(){
            this.listSize=0;
           this.head = new DoubleLinkedListNode(0,0);
           this.tail = new DoubleLinkedListNode(0,0);
           this.head.next = tail;
           this.tail.prev = head;
        }

        public void insert(DoubleLinkedListNode node){
            DoubleLinkedListNode next = head.next;
            node.next = next;
            node.prev =head;
            next.prev =node;
            head.next = node;
            ++listSize;
        }

        public void remove(DoubleLinkedListNode node){
            DoubleLinkedListNode prev = node.prev;
            DoubleLinkedListNode next = node.next;
            prev.next =next;
            next.prev =prev;
            --listSize;
        }
    }
}
