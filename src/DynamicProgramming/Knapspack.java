package DynamicProgramming;

public class Knapspack {

    public static void main(String[] args) {
     int result =  knapsack(new int[]{1,2,4,5},new int[]{5,4,8,6},4,5);
    }

    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
         return dp_recur(n-1,weight,value,n,maxWeight);
    }

    private static int dp_recur(int index,int[] weight,int[] value,int n,int maxWeight){

        if(index ==0 ){
            if( weight[index]<= maxWeight) return value[index];
            return 0;
        }

        int nottake = dp_recur(index-1,weight,value,n,maxWeight);

       int take = Integer.MIN_VALUE;

       if(weight[index] <= maxWeight)
       take = value[index]+dp_recur(index-1,weight,value,n,maxWeight-weight[index]);

        return Math.max(nottake,take);
    }
}
