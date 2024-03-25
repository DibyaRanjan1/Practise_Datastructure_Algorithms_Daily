package Tree.MediumProblems;

public class SubTreeRemovalQueries {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(8);
        root.right = new TreeNode(9);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(1);

        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(6);

   root.right.left = new TreeNode(3);
   root.right.right = new TreeNode(7);

        SubTreeRemovalQueries s = new SubTreeRemovalQueries();
        s.treeQueries(root,new int[]{3,2,4,8});
    }

    public int[] treeQueries(TreeNode root, int[] queries) {

      int[] result = new int[queries.length];

       for(int i=0;i<queries.length;i++){
           TreeNode dummy = new TreeNode(-1);
           dummy.left = root;
           deleteNode(dummy.left,queries[i]);
          int height = findHeight(dummy.left);
          if(height >0){
              --height;
          }
          result[i] = height;
       }


return result;

    }

    private int findHeight(TreeNode root){
        if(root ==null) return 0;
        return 1 + Math.max(findHeight(root.left),findHeight(root.right));

    }

    private TreeNode deleteNode(TreeNode root, int node){
        if(root ==null) return null;

        if(root.val == node){
            return null;
        }
       root.left = deleteNode(root.left,node);
       root.right = deleteNode(root.right,node);
       return root;
    }
}
