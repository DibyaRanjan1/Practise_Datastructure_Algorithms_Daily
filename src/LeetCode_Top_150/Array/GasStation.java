package LeetCode_Top_150.Array;

public class GasStation {
    public static void main(String[] args) {

    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
      int total_surplus=0;
      int surPlus=0;
      int start=0;
      for(int i=0;i< gas.length;i++){
          total_surplus = total_surplus + gas[i]-cost[i];
          surPlus = surPlus + gas[i] - cost[i];

          if(surPlus<0){
              surPlus = 0;
              start = i+1;
          }

      }
      return total_surplus < 0? -1:start;
    }
}
