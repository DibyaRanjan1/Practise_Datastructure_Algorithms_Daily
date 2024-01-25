package Greedy;

public class Rope_Colour {
    public static void main(String[] args) {
        Rope_Colour r = new Rope_Colour();
       int result = r.minCost("aaabbbabbbb",new int[]{3,5,10,7,5,3,5,5,4,8,1});
    }

    public int minCost(String colors, int[] neededTime) {

        int total=0;

        int i=0;
        int j=0;



        while (i<colors.length()&&j<neededTime.length){
            int keepmax=0; int currtotal=0;

            while (j< neededTime.length && colors.charAt(i)==colors.charAt(j)){
                currtotal += neededTime[j];
                keepmax = Math.max(keepmax,neededTime[j]);
                j++;
            }
            total += currtotal-keepmax;
            i=j;
        }


        return total;
    }

    public int minCost_SinglePass(String colors, int[] neededTime){

        int totalTime=0;
        int currentMaxKeep = 0;

        for(int i=0;i<colors.length();i++){

            if(i>0 && colors.charAt(i)!= colors.charAt(i-1)){
                currentMaxKeep =0;
            }

            totalTime+= Math.min(currentMaxKeep,neededTime[i]);
            currentMaxKeep = Math.max(currentMaxKeep,neededTime[i]);
        }
        return totalTime;
    }
}
