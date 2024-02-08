package Revision.BackTrack.DP;

public class CountSubsetSumK {
    public static void main(String[] args) {
       CountSubsetSumK c = new CountSubsetSumK();
     int count =   c.findWays(new int[]{1,1,4,5},5);
    }

    public  int findWays(int[] num, int tar) {
        return findWays_recur(num.length-1,num,tar);
    }

    private int findWays_recur(int index, int[] num, int tar){
        if(tar==0) return 1;
        if(index==0){
            if(num[index] == tar) return 1;
        }
        if(index <0 || tar <0) return 0;

       int takeCount =0;

       if(num[index] <= tar)  takeCount =  findWays_recur(index-1,num,tar - num[index]);
        int notTakeCount = findWays_recur(index-1,num,tar);

        return (takeCount+notTakeCount);
    }
}
