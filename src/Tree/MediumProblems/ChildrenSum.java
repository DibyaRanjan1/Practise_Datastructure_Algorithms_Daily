package Tree.MediumProblems;

public class ChildrenSum {
    public static void main(String[] args) {
        Node  root = new Node(2);
        root . left = new Node(35);
        root . left . left = new Node(2);
        root . left . right = new Node(3);
        root . right = new Node(10);
        root . right . left = new Node(5);
        root . right . right = new Node(2);

        changeTree(root);
    }

    static void changeTree(Node root){
reOrder(root);
    }

    static void reOrder(Node root){
        if(root ==null) return;

        int sum=0;
        if(root.left!=null){
            sum = sum + root.left.data;
        }

        if(root.right!=null){
            sum = sum + root.right.data;
        }

        if(root.data > sum){
            if(root.left!=null){
                root.left.data = root.data;
            }
            if(root.right!=null){
                root.right.data = root.data;
            }
        }

        reOrder(root.left);
        reOrder(root.right);

        int total=0;
        if(root.left!=null) total = total+root.left.data;
        if(root.right!=null) total = total+root.right.data;

        if(root.left!=null || root.right!=null)
       root.data = total;

    }
}
