package Revision.BackTrack.DP;

public class WildCardMatching {
    public static void main(String[] args) {
     WildCardMatching w = new WildCardMatching();
     boolean res = w.isMatch("abdefcd","ab*cds");
    }

    public boolean isMatch(String s, String p) {
        int n = s.length()-1;
        int m = p.length()-1;

        Boolean[][] memo = new Boolean[n+1][m+1];


     return recur(n,s,m,p,memo);
    }

    private boolean recur(int index1, String s, int index2, String p,Boolean[][] memo){

       if(index1<0 && index2<0) return true;
       if(index2<0 && index1 >=0) return false;
       if(index2 >=0 && index1<0){
           for(int i=0;i<=index2;i++){
               if(p.charAt(i)!='*') return false;
           }
           return true;
       }

       if(memo[index1][index2]!=null) return memo[index1][index2];

        if(s.charAt(index1) == p.charAt(index2) || p.charAt(index2) == '?'){
          return  memo[index1][index2] =  recur(index1-1,s,index2-1,p,memo);
        } else if (p.charAt(index2)== '*') {
            return memo[index1][index2] =  recur(index1-1,s,index2,p,memo) || recur(index1,s,index2-1,p,memo);
        }
          return false;

    }
}
