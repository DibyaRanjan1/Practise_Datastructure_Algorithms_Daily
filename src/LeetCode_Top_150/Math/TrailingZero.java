package LeetCode_Top_150.Math;

public class TrailingZero {
    public static void main(String[] args) {
       TrailingZero t = new TrailingZero();
       t.trailingZeroes(30);
    }

    public int trailingZeroes(int n) {
        if(n==0) return 0;
     long factResult = findfactorial(n);

     int count=0;

     while (factResult >0){
         long zero = factResult%10;
         if(zero ==0){
             count++;
         }else {
             break;
         }
         factResult = factResult/10;
     }
     return count;
    }

    private long findfactorial(int n){
        if(n<=1) return 1;

       return n * findfactorial(n-1);
    }
}
