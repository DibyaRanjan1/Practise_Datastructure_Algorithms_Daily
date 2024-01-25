package LeetCode_Top_150.Math;

public class PalindromeNumber {
    public static void main(String[] args) {
        PalindromeNumber p = new PalindromeNumber();
        p.isPalindrome(12211);
    }

    public boolean isPalindrome(int x) {
       int number = x;
        if(x <0 || (x%10 ==0 && x!=0)) return false;


       int revertedNumber = 0;

       while (x > revertedNumber){

           revertedNumber = revertedNumber *10 + (x%10);
           x = x/10;
       }

       return revertedNumber ==x || x == revertedNumber/10;
    }
}
