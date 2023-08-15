package BinarySearchTree.LeetCode;

public class BST_Construction_PreOrder {
    public static void main(String[] args) {
         int[] arr = new int[]{8,5,1,7,10,12};

         BST_Construction_PreOrder b = new BST_Construction_PreOrder();
         b.bstFromPreorder(arr);
    }

    public TreeNode bstFromPreorder(int[] preorder) {

        if(preorder ==null) return null;

       if(preorder.length ==1){
          TreeNode root =new TreeNode(preorder[0]);
           return root;
       }

     return util(preorder,Integer.MAX_VALUE,new int[]{0});
    }

    private TreeNode util(int[] preOrder,int bound,int[] index){

        if(preOrder.length == index[0] || preOrder[index[0]] > bound){
            return null;
        }

        TreeNode node = new TreeNode(preOrder[index[0]++]);

       node.left =  util(preOrder, node.val, index);
        node.right = util(preOrder,bound,index);
        return node;
    }
}
