package Recursion;

public class Understanding {
    public static void main(String[] args) {

        Understanding u = new Understanding();
        int[] array = new int[]{1,2,3,4,5,6,7};
        //u.reverseArray(array,0, array.length-1);
        u.reverseArray1(array,0);
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
}
