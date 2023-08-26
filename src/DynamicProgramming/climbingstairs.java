package DynamicProgramming;

public class climbingstairs {
    public static void main(String[] args) {

    }

    public int climbStairs(int n) {
        int prev2 = 0;
        int prev = 1;
        int total = 0;
      for(int i=1;i<n;i++){
          total =  prev + prev2;
          prev2 = prev;
          prev = total;
      }
      return total;
    }

}
