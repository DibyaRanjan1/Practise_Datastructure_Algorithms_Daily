package Tree.MediumProblems;

import java.util.LinkedList;
import java.util.Queue;

public class MaxWidthOfBinaryTree {
    public static void main(String[] args) {

    }

    // not considering null
    int getMaxWidth(Node root) {
        if(root ==null) return 0;
        int maxWidth = 0;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()){

            int qSize = q.size();
            maxWidth = Math.max(maxWidth,qSize);


            for(int i=0;i<qSize;i++){
                Node curr = q.poll();

                if(curr.left!=null)
                q.add(curr.left);

                if(curr.right!=null)
                q.add(curr.right);
            }
        }

        return maxWidth;
    }

    int getMaxWidthConsiderNull(Node root){

        int maxWidth =0;
        Queue<pair1> q = new LinkedList<>();
        q.add(new pair1(root,0));

        while (!q.isEmpty()){
            int size = q.size();
            pair1 p1 = q.peek();
            int minIndex = p1.index;
              int first=0;int last=0;

            for(int i=0;i<size;i++){
                pair1 curr = q.poll();
                int currIndex = curr.index - minIndex;

                if(i==0) first = currIndex;
                if(i ==size-1) last = currIndex;

                if(curr.node.left!=null)
                    q.add(new pair1(curr.node.left,2*currIndex+1));

                if(curr.node.right!=null)
                    q.add(new pair1(curr.node.right,2*currIndex+2));
            }
            maxWidth = Math.max(maxWidth,last-first+1);
        }
        return maxWidth;

    }
}

class pair1{
    Node node;
    int index;

    public pair1(Node node,int index){
        this.node = node;
        this.index = index;
    }

}
