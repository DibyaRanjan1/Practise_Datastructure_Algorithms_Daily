package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Understanding {
    public static void main(String[] args) {

        Understanding u = new Understanding();
        int[] array = new int[]{3,1,2};
        //u.reverseArray(array,0, array.length-1);
        //u.reverseArray1(array,0);
        u.PrintSubsequence(0,new ArrayList<>(),array,3);
    }

    public void reverseArray(int[] array,int startIndex,int endIndex){

        if(startIndex>=endIndex){
            return;
        }

        int temp = array[startIndex];
        array[startIndex] = array[endIndex];
        array[endIndex] = temp;

        reverseArray(array,startIndex+1,endIndex-1);
    }

    public void reverseArray1(int[] array,int startIndex){

        if(startIndex>=array.length/2){
            return;
        }

        int temp = array[startIndex];
        array[startIndex] = array[array.length-1-startIndex];
        array[array.length-1-startIndex] = temp;

        reverseArray1(array,startIndex+1);
    }

    public void PrintSubsequence(int index, List<Integer> ds,int[] arr,int n){
        if(index ==n){
            for(Integer it:ds){
                System.out.print(it + " ");
            }
            System.out.println();
            return;
        }

        ds.add(arr[index]);
        PrintSubsequence(index+1,ds,arr,n);
        ds.remove(ds.size()-1);

        PrintSubsequence(index+1,ds,arr,n);
    }
}
