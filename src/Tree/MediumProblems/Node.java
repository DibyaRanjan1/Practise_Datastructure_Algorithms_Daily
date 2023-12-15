package Tree.MediumProblems;

public class Node {
    public int data;
    public Node left,right,next;
    public Node(int d)
    {
        data=d;
    }
    public Node(){

    }
    public Node(int _val, Node _left, Node _right, Node _next){
        data = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
