package LeetCode_Top_150.Array;

public class RemoveDuplicate {
    public static void main(String[] args) {

    }

    public int removeDuplicates(int[] array) {

      int slow=0;
      for(int i=1;i< array.length;i++){
          if(array[slow]!=array[i]){
              array[++slow] = array[i];
          }
      }
      return array.length- slow;
    }
}
