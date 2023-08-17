package BinarySearch.Medium_Problems;

public class Capacity_Ship {
    public static void main(String[] args) {
    Capacity_Ship c = new Capacity_Ship();
    c.shipWithinDays(new int[]{1,2,3,1,1},4);

    }

    public int shipWithinDays(int[] weights, int days) {
           int low=Integer.MAX_VALUE;
           int high =0;

        for(int i=0;i<weights.length;i++){
            high = high+ weights[i];
            low = Math.min(low,weights[i]);
        }
           int resultWeight = low;

           while (low<=high){
               int mid = low+(high-low)/2;

             boolean isPossible =  findDays(weights,days,mid);

             if(isPossible){
                resultWeight = Math.max(resultWeight,high);
                high = mid-1;
             }else {
                 low = mid+1;
             }
           }
     return low;
    }

    public boolean findDays(int[] weights, int days, int midWeight){
         int count=0;
         int sum=0;
         int result=0;
        for(int i=0;i< weights.length;i++){
            if(weights[i] > midWeight){
                return false;
            }
            sum = sum+ weights[i];
             if(sum == midWeight){
                 ++result;
                 sum=0;
             } else if (sum>midWeight) {
                 ++result;
                 sum = weights[i];
             }
        }
        if(sum==0) return result<=days;
        ++result;

        return result<=days;
    }

}
