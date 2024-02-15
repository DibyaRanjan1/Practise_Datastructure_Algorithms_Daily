package Revision.BackTrack.DP;

public class ShortestommonSuperSequence {
    public static void main(String[] args) {
     ShortestommonSuperSequence s = new ShortestommonSuperSequence();
     s.shortestCommonSupersequence("acd","ced");
    }

    public String shortestCommonSupersequence(String str1, String str2) {
     int n = str1.length();
     int m = str2.length();



     //int res = recur(n-1,str1,m-1,str2,dp);
        String res = tabulation(str1,str2);
      return res;
    }

    private int recur(int index1, String str1, int index2, String str2,int[][] dp){



        if(index1 <0 || index2 <0) return 0;
        if(dp[index1][index2]!=0) return dp[index1][index2];

        int take = 0;
        if(str1.charAt(index1) == str2.charAt(index2)){
            take = 1 + recur(index1-1,str1,index2-1,str2,dp);
        }

        int notTake = Math.max(recur(index1-1,str1,index2,str2,dp),recur(index1,str1,index2-1,str2,dp));

        return dp[index1][index2] =  Math.max(take,notTake);

    }

    private String tabulation(String str1, String str2){

    int n = str1.length();
    int m = str2.length();

    int[][] dp = new int[n+1][m+1];

    for(int i=0;i<=n;i++){
        dp[i][0] = 0;
    }
        for(int i=0;i<=m;i++){
            dp[0][i] = 0;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                int take =0;
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    take =1  + dp[i-1][j-1];
                }
                int notTake = Math.max(dp[i-1][j],dp[i][j-1]);
                dp[i][j] = Math.max(take,notTake);
            }
        }
        StringBuffer sb = new StringBuffer();
        
        while (n >0 && m >0){
            if(str1.charAt(n-1) == str2.charAt(m-1)){
                --n;
                --m;
                sb.append(str1.charAt(n-1));
            } else if (dp[n-1][m] > dp[n][m-1]) {
                sb.append(str1.charAt(n-1));
                --n;
            }else {
                sb.append(str2.charAt(m-1));
                --m;
            }
        }

        while (n>0){
            sb.append(str1.charAt(n-1));
            --n;
        }

        while (m>0){
            sb.append(str2.charAt(m-1));
            --m;
        }

       String res =  sb.reverse().toString();
        return res;

    }


}
