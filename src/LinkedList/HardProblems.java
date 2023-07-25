package LinkedList;

public class HardProblems {
    public static void main(String[] args) {
        Node head = null;

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);

        head = node1;
        head.next = node2;
        head.next.next = node3;
        head.next.next.next = node4;
        head.next.next.next.next = node5;

        head.next.next.next.next.next = node6;
        head.next.next.next.next.next.next = node7;
        head.next.next.next.next.next.next.next = node8;

        reverseKNodes(head,3);

        //rotateRight(head,3);


//
//        head.random = node4;
//        head.next.random = node1;
//        head.next.next.random = null;
//        head.next.next.next.random = node2;
//
//        System.out.println("Original list:(current node:node pointed by next pointer, node pointed by random pointer)");
//        printList(head);
//
//        System.out.println("Copy list:(current node:node pointed by next pointer,node pointed by random pointer)");
//        Node newHead = copyRandomList(head);
//        printList(newHead);

//        Node head = null;
//        Node node1 = new Node(3);
//        node1.bottom = new Node(9);
//        node1.bottom.bottom = new Node(17);
//
//        Node node2 = new Node(10);
//        node2.bottom = new Node(47);
//        node1.next = node2;
//
//        Node node3 = new Node(7);
//        node3.bottom = new Node(15);
//        node3.bottom.bottom = new Node(30);
//        node2.next = node3;
//
//        Node node4 = new Node(14);
//        node4.bottom = new Node(22);
//        node3.next = node4;
//
//        head = node1;
//        flatten(head);

    }

    static void printList(Node head) {
        while(head != null) {
            System.out.print(head.data+":");
            if(head.next != null)
                System.out.print(head.next.data);
            else
                System.out.print("NULL");
            if(head.random != null)
                System.out.print(","+head.random.data);
            else
                System.out.print(",NULL");
            System.out.println();
            head = head.next;
        }
    }

    static Node copyRandomList(Node head) {

        Node temp = head;

        while(temp!=null){
            Node newNode = new Node(temp.data);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = temp.next.next;
        }

        temp = head;

        while (temp!=null){
              temp.next.random = (temp.random == null)? null: temp.random.next;
              temp = (temp.next == null)?null: temp.next.next;
        }

        temp = head;
        Node dummyNode = new Node(0);
        Node current = dummyNode;

        while(temp!=null){

            current.next = temp.next;
            temp.next = temp.next.next;
            temp = temp.next;
            current = current.next;
        }

        return dummyNode.next;


    }


    public static Node flatten(Node root){

        if(root ==null || root.next ==null){
            return root;
        }

      root.next =  flatten(root.next);

       root = merge(root,root.next);

     return  root;

    }

    private static Node merge(Node a , Node b){
        Node dummy = new Node(0);
        Node res = dummy;

        while (a !=null && b!=null){

            if(a.data < b.data){

                dummy.bottom = a;
                a = a.bottom;
                dummy = dummy.bottom;

            }else {
                dummy.bottom = b;
                b = b.bottom;
                dummy = dummy.bottom;
            }
        }

        if(a ==null){
            dummy.bottom = b;
        }else {
            dummy.bottom = a;
        }

        return res.bottom;
    }

    public static Node rotateRight(Node head, int k) {

        if(head ==null || head.next ==null || k==0){
            return head;
        }
        Node temp = head;

        int length = 1;
        while (temp.next !=null){
            temp = temp.next;
            ++ length;
        }

        temp.next = head;

        k = k%length;
        int end = length-k;

        while (end >0){
            temp = temp.next;
            --end;
        }

        head = temp.next;
        temp.next = null;

        return head;
    }


public static Node reverseKNodess(Node head,int k){
        if(head ==null || head.next ==null || k==0 || k==1){
            return head;
        }

        Node dummyHead = new Node(0);
    dummyHead.next = head;

        int length = getLinkedListLength(head);

    Node pre = dummyHead;
    Node cur;
    Node nex;

    while(length >= k) {
        cur = pre.next;
        nex = cur.next;
        for(int i=1;i<k;i++) {
            cur.next = nex.next;
            nex.next = pre.next;
            pre.next = nex;
            nex = cur.next;
        }
        pre = cur;
        length -= k;
    }
    return dummyHead.next;
}

    public static Node reverseKNodeEasyUtility(Node head,int k,int length){


        if(head ==null || head.next ==null || k==0 || k==1 || length == 0){
            return head;
        }
        int count=0;


        Node current = head;
        Node prev = null;
        Node next = null;

        while (count < k){
            ++count;
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        --length;



        if(current !=null){
            head.next = reverseKNodeEasyUtility(current.next,k,length);
        }

        return prev;
    }

    public static Node reverseKNodeEasy(Node head,int k){

        int length = getLinkedListLength(head);

        Node dummy = new Node(0);
        dummy.next = head;

        Node temp = dummy.next;

        int end = length-k;
        while (end >0){
            --end;
            temp = temp.next;
        }

       Node result = reverseKNodeEasyUtility(head,k,length);
       result.next = temp.next;
        return result.next;

    }


    static Node reverseKNodes(Node head,int k) {
        if(head == null||head.next == null) return head;

        int length = getLinkedListLength(head);

        Node dummyHead = new Node(0);
        dummyHead.next = head;

        Node pre = dummyHead;
        Node cur;
        Node nex;

        while(length >= k) {
            cur = pre.next;
            nex = cur.next;
            for(int i=1;i<k;i++) {
                cur.next = nex.next;
                nex.next = pre.next;
                pre.next = nex;
                nex = cur.next;
            }
            pre = cur;
            length -= k;
        }
        return dummyHead.next;
    }
    private static int getLinkedListLength(Node node)
    {
        int length = 0;

        while (node !=null){
            node = node.next;
            ++length;
        }

        return length;
    }
}


