package Revision.BackTrack.DP;

public class KnapSack {
    public static void main(String[] args) {

        int[] weight = new int[]{1,2,4,5};
        int[] value = new int[]{5,4,8,6};
        int maxWeight = 5;
        int n = 4;
      int result =   knapsack(weight,value,n,maxWeight);
    }

    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
       return knapsack_recur(n-1,weight,value,n,maxWeight);
    }

    static int knapsack_recur(int index,int[] weight, int[] value, int n, int maxWeight){

        if(index ==0){
            if(maxWeight >= weight[index]) return value[index];
            return 0;
        }

        int take =Integer.MIN_VALUE;
        if(weight[index] <= maxWeight){
            take =  value[index] +  knapsack_recur(index-1,weight ,value,n,maxWeight - weight[index]);
        }

        int notTake = knapsack_recur(index-1,weight,value,n,maxWeight);
        return Math.max(take,notTake);

    }
}
