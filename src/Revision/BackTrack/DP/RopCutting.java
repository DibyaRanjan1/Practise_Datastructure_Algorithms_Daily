package Revision.BackTrack.DP;

public class RopCutting {
    public static void main(String[] args) {
      int result = cutRod(new int[]{2,5,7,8,10},5);
    }

    public static int cutRod(int price[], int n) {
      return cutRod_recur(price,n,n-1);
    }

    public static int cutRod_recur(int price[], int n, int index) {

        if(index==0){
            return n * price[0];
        }
       int cut = Integer.MIN_VALUE;

       int rodLength = index+1;

       if(rodLength <=n ) {
          cut = price[index] + cutRod_recur(price, n-rodLength, index);
       }

       int notCut = cutRod_recur(price,n,index-1);

       return Math.max(cut,notCut);
    }
}
