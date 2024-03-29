package Tree.MediumProblems;

import java.util.ArrayDeque;
import java.util.Queue;

public class ValidateBinaryTreeNodes {
    public static void main(String[] args) {

    }

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        boolean[] roots = new boolean[leftChild.length];

        for(int child:leftChild){
            if(child!=-1){
                roots[child]=true;
            }
        }

        for(int child:rightChild){
            if(child!=-1){
                if(roots[child]) return false;
                roots[child]=true;
            }
        }

        int root=-1;
        for(int i=0;i<n;i++){
            if(!roots[i]){
                if(root==-1){
                    root = i;
                }else {
                    return false;
                }
            }
        }
        if(root==-1) return false;
        return isBinaryTreeValid(root,leftChild,rightChild);
    }

    private boolean isBinaryTreeValid(int root, int[] leftChild, int[] rightChild){
        boolean[] visited = new boolean[leftChild.length];
        Queue<Integer> nodes = new ArrayDeque<>();
        nodes.add(root);
        visited[root]=true;

        while (!nodes.isEmpty()){
            int currentNode = nodes.poll();

            if(leftChild[currentNode]!=-1){
                if(visited[leftChild[currentNode]]) return false;

                nodes.add(leftChild[currentNode]);
                visited[leftChild[currentNode]]=true;
            }

            if(rightChild[currentNode]!=-1){
                if(visited[rightChild[currentNode]]) return false;

                nodes.add(rightChild[currentNode]);
                visited[rightChild[currentNode]]=true;
            }
        }

        for(boolean visit:visited){
            if(!visit){
                return false;
            }
        }
        return true;
    }

}
