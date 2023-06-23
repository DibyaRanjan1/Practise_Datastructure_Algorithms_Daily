package Stack;

import java.util.HashMap;
import java.util.Stack;

public class StackProblems {
    public static void main(String[] args) {
     String input = "{}}}{{{";
     //paranthesisChecker(input);
        long[] arr = {1,3,2,4};
        nextLargerElement(arr,4);
    }

    public static boolean paranthesisChecker(String input){
        HashMap<Character,Character> masterSyntax = new HashMap<Character,Character>();
        masterSyntax.put('{','}');
        masterSyntax.put('[',']');
        masterSyntax.put('(',')');

        Stack<Character> s1 = new Stack<Character>();

        int length = input.length();

        for(int i =0;i<length;i++){

            Object val = input.charAt(i);
            if(masterSyntax.containsKey(val)){
                  s1.push(input.charAt(i));
            }else {
                if(s1.isEmpty()){
                    continue;
                }
              Character res =   s1.peek();
               Character resval =  masterSyntax.get(res);
              if(resval == input.charAt(i)){
                  s1.pop();
              }else {
                  return false;
              }
            }

        }

        if(s1.isEmpty()){
            return true;
        }
        return false;
    }

    public static long[] nextLargerElement(long[] arr, int n){

        Stack<Long> s1 = new Stack<>();
        long[] resultArray = new long[n];
        for(int i=n-1; i>=0; i--){

            while (!s1.isEmpty() && arr[i] > s1.peek() ){
                s1.pop();
            }
            if(s1.isEmpty()){
                resultArray[i] = -1;
            }else {
                resultArray[i] = s1.peek();
            }
            s1.push(arr[i]);
        }
        return resultArray;
    }


}
