package BinarySearchTree.LeetCode;

import BinarySearchTree.Node;

public class Inorder_Succ_Pred {
    public static void main(String[] args) {

    }

    static Node pre;
    static Node suc;

    public static void findPreSuc(Node root, int key) {



        Node curr = root;
        Node curr1 = root;

          while (curr!=null){
              if(key >= curr.key){
                  curr = curr.right;
              }else {
                  suc = curr;
                  curr = curr.left;
              }
          }

          while (curr1!=null){
              if(key < curr1.key){

                  curr1 = curr1.left;
              }else {
                  pre = curr;
                  curr1 = curr1.right;
              }
          }


    }
}
