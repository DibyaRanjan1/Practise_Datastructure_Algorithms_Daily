package DynamicProgramming;

import java.util.Arrays;

public class Uniquepaths {
    public static void main(String[] args) {
        Uniquepaths u = new Uniquepaths();
int result = u.uniquePaths(3,2);
    }

    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m+1][n+1];
        for(int i=0;i<memo.length;i++){
            Arrays.fill(memo[i],-1);
        }
    return   dp(m,n,0,0,memo);
    }

    private int dp(int m, int n, int mIndex,int nIndex,int[][] memo){

        if(memo[mIndex][nIndex] !=-1) return memo[mIndex][nIndex];
        if(mIndex == m-1 && nIndex ==n-1){
            return 1;
        }
        if(mIndex >=m || nIndex >=n) return 0;

       return memo[mIndex][nIndex] =  dp(m,n,mIndex+1,nIndex,memo) + dp(m,n,mIndex,nIndex+1,memo);
    }

    public int uniquePaths_tabulation(int m, int n) {

        int[][] tab = new int[m][n];
        for(int i=0;i<tab.length;i++){
            Arrays.fill(tab[i],-1);
        }


        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                if(i==0 && j==0){
                    tab[i][j] = 1;
                    continue;
                }
                int up=0;
                int down=0;

                if(i>0){
                    up = tab[i-1][j];
                }
                if(j>0){
                    down = tab[i][j-1];
                }

             tab[i][j] =  up+down;

            }
        }
        return tab[m-1][n-1];
    }
}
