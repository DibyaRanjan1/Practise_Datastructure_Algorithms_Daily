package Heap;

public class Heap {
    public int Capacity;
    public int Size;
    public int[] arr;

    public Heap(int capacity){
        this.Capacity = capacity;
        this.arr = new int[capacity];
    }

    public int Left(int i){
        return (2*i+1);
    }
    public int Right(int i){
        return (2*i+2);
    }

    public void DecreaseKey(int index, int newValue){
        arr[index] = newValue;

        for(int i = index; i>=0 && arr[i]< arr[i-1];i--){
            int temp = arr[i-1];
            arr[i-1] = arr[i];
            arr[i]=temp;
        }
    }

    public void BuildHeap(){

       for(int i = (Size-2)/2; i >=0;i--){
           Heapify(i);
       }
    }
    public void Delete(int index, int value){

        if(index > Size-1){return;}

      DecreaseKey(index,Integer.MIN_VALUE);
        ExtractMin();

    }
    public int ExtractMin(){
        int i = 0;
        if(Size ==0){
            return Integer.MIN_VALUE;
        }
        if(Size ==1){
            Size--;
            return arr[i];

        }
       int deletedValue = arr[i];
       arr[i] = arr[Size-1] ;
       Size --;

       Heapify(i);
return arr[Size];
    }
    public void Heapify(int i){

       int leftIndex = this.Left(i);
       int rightIndex = this.Right(i);

       int smallest = i;

       if(leftIndex < this.Size && arr[leftIndex] < arr[i]){
           smallest = leftIndex;
       }
        if(rightIndex < Size && arr[rightIndex] < arr[smallest]){
           smallest = rightIndex;
       }

       if(smallest != i){
           int temp = arr[i];
           arr[i] = arr[smallest];
           arr[smallest] = temp;

           Heapify(smallest);
       }
    }

    public void Insert(int x){
        if(this.Size == this.Capacity) return;

        ++this.Size;
        this.arr[Size-1] = x;
        for(int i= this.Size-1; i!=0 && this.arr[i] < this.arr[i-1];--i){
            int temp = arr[i-1];
            arr[i-1] = arr[i];
            arr[i] = temp;
        }
    }

    public void Print(){
        for(int i=0;i< this.Size;i++){
            System.out.println(this.arr[i]);
        }
    }

    public static void main(String[] args) {
        Heap heap = new Heap(6);

        heap.Insert(1);
        heap.Insert(10);
        heap.Insert(5);
        heap.Insert(9);
        heap.Insert(3);
        heap.Insert(7);

        // Make Heap not follow rule
        //heap.arr[1] = 20;


        // heap.Print();

         heap.Heapify(1);

        //heap.ExtractMin();

        heap.DecreaseKey(3,2);
    }
}
