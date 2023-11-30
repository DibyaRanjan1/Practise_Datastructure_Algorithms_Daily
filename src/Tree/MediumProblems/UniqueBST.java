package Tree.MediumProblems;

import java.util.Arrays;

public class UniqueBST {
    public static void main(String[] args) {

     UniqueBST u = new UniqueBST();


    int result = u.numTrees(3);

    }

    public int numTrees(int n) {

        int[] memo = new int[n+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(memo,-1);
        }

       return numTrees_dp(n,memo);
    }

    public int numTrees_dp(int n,int[] memo) {

        int sum = 0;

        if(n == 1 || n==0) return 1;
        for(int i=1;i<=n;i++){

            int leftSubTree =1;
            int rightSubTree = 1;

            if(memo[i-1]==-1) {
                leftSubTree = numTrees(i-1);
            }else {
                leftSubTree = memo[i-1];
            }

            if(memo[n-i] == -1){
                rightSubTree = numTrees(n-i);
            }else {
                rightSubTree = memo[n-i];
            }

            sum += leftSubTree*rightSubTree;
        }
        return sum;
    }


    public int numTrees_tabulation(int n) {

         int[] dp = new int[n+1];
         dp[0] = 1;
         dp[1] = 1;

         for(int i=2;i<=n;i++){

            for(int j=1;j<=i;j++){
                dp[i] = dp[j-1]*dp[i-j];
            }
         }
         return dp[n];

    }




}
