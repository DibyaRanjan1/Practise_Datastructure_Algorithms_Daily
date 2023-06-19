package Array;

public class sort_0_1_2 {
    public static void main(String[] args) {
        int[] a = {0,2,1,2,0};
        sort012(a,5);
    }

    public static void sort012(int a[], int n)
    {
        // code here
        int low =0;
        int mid =0;
        int high = n-1;

        while(mid <= high){
            if(a[mid] == 0){
                int temp = a[mid];
                a[mid] = a[low];
                a[low] = temp;

                ++ low;
                ++ mid;
            } else if (a[mid]==2) {
                int temp1 = a[mid];
                a[mid] = a[high];
                a[high] = temp1;

                -- high;
            }else {
                ++ mid;
            }
        }
    }
}
