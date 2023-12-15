    package Tree.MediumProblems;

    import java.util.ArrayDeque;
    import java.util.Deque;
    import java.util.List;


    public class SumRootToLeave {


        public static void main(String[] args) {

        }

        int sum=0;
        public int sumNumbers(TreeNode root) {
            sumNumbers_util(root,0);
            return sum;
        }

        public void sumNumbers_util(TreeNode root,int num ) {
    if(root!=null){
        num = 10*num + root.val;

        if(root.left ==null && root.right ==null){
            sum += num;

        }

        sumNumbers_util(root.left,num);
        sumNumbers_util(root.right,num);
    }
        }


    }
