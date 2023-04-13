package BinarySearchTree;

public class BST {
    public static void main(String[] args) {

        Node root = new Node(15);

        root.left = new Node(5);
        root.right = new Node(20);

        root.left.left = new Node(3);

        root.right.left = new Node(18);
        root.right.left.left = new Node(16);

        root.right.right = new Node(80);

        // positive Scenario
      boolean isKeyPresent =  SearchItemInBSTUsingRecursion(root,18);
        System.out.println(isKeyPresent);

        // positive Scenario
        boolean isKeyPresentNegative =  SearchItemInBSTUsingRecursion(root,88);
        System.out.println(isKeyPresentNegative);

      boolean isKeyPresetIteration =  SearchItemInBSTUsingIteration(root,80);
        System.out.println(isKeyPresetIteration);

        boolean isKeyPresetIterationNegative =  SearchItemInBSTUsingIteration(root,800);
        System.out.println(isKeyPresetIterationNegative);

       Node newRoot = InsertIntoBinaryTreeRecursion(root,90);

    }

    public static boolean SearchItemInBSTUsingRecursion(Node node, int key){

        if(node ==null){
            return false;
        } else if (node.key == key) {
            return true;
        }
        else if(node.key > key){
          return  SearchItemInBSTUsingRecursion(node.left,key);
        }
        else
           return SearchItemInBSTUsingRecursion(node.right,key);
    }

    public static boolean SearchItemInBSTUsingIteration(Node node, int key){

        Node temp = node;

        while(node!=null){

            if(node.key == key){
                return true;
            }

            if(node.key > key){
                node = node.left;
            }
            if(node.key < key){
                node = node.right;
            }
        }

        return false;
    }

    public static Node InsertIntoBinaryTreeRecursion(Node root,int key){

        if(root == null){
            return new Node(key);
        }
        if(root.key >  key){
          root.left =  InsertIntoBinaryTreeRecursion(root.left, key);
        }
       else if(root.key < key){
              root.right = InsertIntoBinaryTreeRecursion(root.right,key);
        }
        return root;
    }

    public static Node InsertIntoBinaryTreeInteration(Node root,int key){
       Node newNode = new Node(key);
       Node curr = root;
       Node parent = null;
       while(curr!=null){
           parent = curr;
           if(curr.key > key){
               curr = curr.left;
           } else if (curr.key < key) {
               curr = curr.right;
           }
           else{
               return root;
           }
       }

       if(parent ==null){
           parent = newNode;
       }
       if (parent.key > key){
           parent.left = newNode;
       } else if (parent.key < key) {
           parent.right = newNode;
       }
       else{
           return root;
       }
      return root;

    }
}

