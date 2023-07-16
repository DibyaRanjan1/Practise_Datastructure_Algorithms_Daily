package Array;

import java.util.ArrayList;

public class Array_Problems {
    public static void main(String[] args) {
       int n = 6;
        int[] A = {16,17,4,3,5,2};

        leaders(A,6);
    }

    static ArrayList<Integer> leaders(int arr[], int n){
        // Your code here
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        list.add(arr[n-1]);
        int max = arr[n-1];

        for(int i=n-2;i>=0;i--){
            if(arr[i] > max){
                list.add(arr[i]);
                max = arr[i];
            }
        }

        for(int i=list.size()-1;i>=0;i--){
            result.add(list.get(i));
        }

return result;

    }
}
