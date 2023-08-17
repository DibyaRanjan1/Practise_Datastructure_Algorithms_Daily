package BinarySearch.Medium_Problems;

public class Koko_Eating_Bananas {
    public static void main(String[] args) {
        Koko_Eating_Bananas k = new Koko_Eating_Bananas();
          k.minEatingSpeed(new int[]{30,11,23,4,20},5);
    }

    public int minEatingSpeed(int[] piles, int h) {
        if(piles==null) return -1;
        int high = this.findMax(piles);
        int low=0;
        int result = Integer.MAX_VALUE;

        while (low<=high){
            int mid = low+ (high-low)/2;

          int banaCountPerHour =  this.findTimeForEatingBanana(piles,mid);
           if(banaCountPerHour <=h){
               high = mid-1;
           }else {
            low = mid+1;
           }
        }

    return low;
    }

    public int findTimeForEatingBanana(int[] piles, int banana){
        int count=0;
        for(int i=0;i<piles.length;i++){
            count = (int) (count+ Math.ceil((double)(piles[i])/(double)(banana)));
        }
        return count;
    }

    public int findMax(int[] piles){
        int max = Integer.MIN_VALUE;

        for(int i=0;i<piles.length;i++){
            if(piles[i] > max){
                max = piles[i];
            }
        }
        return max;
    }
}
