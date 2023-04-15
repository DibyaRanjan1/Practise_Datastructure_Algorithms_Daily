package BinarySearchTree;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

public class CeilingOnLeftSideOfArray {
    public static void main(String[] args) {

        //Problem: find ceiling values of the element in the array.
        int[] inputArray = {2,8,30,15,25,12};

        PrintCeiling(inputArray);
    }

    private static void PrintCeiling(int[] array){

        if(array.length ==0){
            return;
        }
        System.out.println(-1);
        TreeSet intTreeset = new TreeSet();

        intTreeset.add(array[0]);

        for(int i=1;i<array.length;i++){
         Object resultObject = intTreeset.ceiling(array[i]);
            int result = resultObject != null ? (Integer) resultObject : -1;
            System.out.println(result);
            intTreeset.add(array[i]);
        }
    }
}
