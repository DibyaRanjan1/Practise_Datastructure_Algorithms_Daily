package LeetCode_Top_150.Math;

import java.util.LinkedList;

public class PlusOne {
    public static void main(String[] args) {
PlusOne p = new PlusOne();
int[] res =  p.plusOne(new int[]{1,2,9});
    }

    public int[] plusOne(int[] digits) {
       int carry =1;

        LinkedList<Integer> result = new LinkedList<>();

       for(int i= digits.length-1;i>=0;i--){

          int sum = ( carry + digits[i]);
           int dig = sum%10;
           result.addFirst(dig);
            carry = sum/10;

       }

       if(carry==1) result.addFirst(carry);

      return result.stream().mapToInt(i->i).toArray();
    }

    public int[] plusOne_optimize(int[] digits) {

        for(int i= digits.length-1;i>=0;i--){

           if(digits[i]==9){
               digits[i]=0;
           }else {
               digits[i]++;
               return digits;
           }

        }

        digits = new int[digits.length+1];
        digits[0] = 1;
        return digits;
    }
}
