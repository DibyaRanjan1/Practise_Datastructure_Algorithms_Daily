package BinarySearch.Medium_Problems;

public class Min_Bouquest {

    public static void main(String[] args) {
     Min_Bouquest m = new Min_Bouquest();
     m.minDays(new int[]{1,10,3,10,2},3,1);
    }

    public int minDays(int[] bloomDay, int m, int k) {
          int numberOfFlowers = bloomDay.length;
          long val = (long) m*k;

          if(val > numberOfFlowers) return -1;

          int[] maxmin = this.findMax(bloomDay);
          int low = maxmin[1];
          int high = maxmin[0];

          while (low<=high){
              int midDays = low+(high-low)/2;

                boolean isPossible = findDays(bloomDay,midDays,k,m);
                if(isPossible){
                    high = midDays-1;
                }else {
                    low = midDays+1;
                }
          }

return low;
    }

    public boolean findDays(int[] bloomday, int days, int k,int m){
         int result = 0;
         int count=0;
        for(int i=0;i< bloomday.length;i++){

          if(bloomday[i] <= days){
              ++count;
          }else {
              result = result+(count/k);
              count=0;
          }
        }
            result = result+(count/k);

        return result >=m;
    }

    public int[] findMax(int[] piles){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        int[] minmax = new int[]{max,min};

        for(int i=0;i<piles.length;i++){
            if(piles[i] > max){
                max = piles[i];
            }

            if(piles[i] < min){
                min = piles[i];
            }
        }
       minmax[0] = max;
        minmax[1] = min;
        return minmax;
    }


}
