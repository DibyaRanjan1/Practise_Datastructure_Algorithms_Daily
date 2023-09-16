package LeetCode_Top_150.Hashmap;

import java.util.HashSet;

public class HappyNumber {
    public static void main(String[] args) {
      HappyNumber h = new HappyNumber();
      h.isHappy(116);
    }

    public boolean isHappy(int n) {
        int slowRunner = n;
        int fastRunner = getSum(n);

        while (fastRunner!=1 && fastRunner!=slowRunner){
           slowRunner = getSum(slowRunner);
           fastRunner = getSum(getSum(fastRunner));
        }

        return fastRunner==1;

    }

    private int getSum(int n){
        int sum=0;
        while (n>0){

            int mod = n%10;
            sum = sum + (mod * mod);
            n = n/10;
        }
        return sum;
    }
}
