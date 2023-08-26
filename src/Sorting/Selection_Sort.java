package Sorting;

public class Selection_Sort {
    public static void main(String[] args) {
        Selection_Sort s = new Selection_Sort();

        int[] array = new int[]{1,2,6,4,5,3};
        s.insertionSort(array,6);
    }

    public void selectionSort(int[] array,int n){

        for(int i=0;i<=n-2;i++){
            int min = i;

            for(int j=i;j<=n-1;j++){
                if(array[j] < array[min]){
                    min = j;
                }
            }

            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;

        }
    }

    public void bubbleSort(int[] array, int n){

        for(int i=n-1;i>=0;i--){
            boolean isSwaphappened = false;
            for(int j=0;j<i;j++){
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    isSwaphappened = true;
                }
            }

            if(!isSwaphappened) break;
        }
    }

    public void insertionSort(int[] array, int n){
        for(int i=0;i<n;i++){
            int j=i;

            while (j>0 && array[j-1] > array[j]){
                int temp = array[j-1];
                array[j-1] = array[j];
                array[j] = temp;
                j--;
            }
        }
    }
}
