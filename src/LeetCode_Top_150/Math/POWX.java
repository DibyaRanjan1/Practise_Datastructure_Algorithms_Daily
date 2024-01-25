package LeetCode_Top_150.Math;

public class POWX {
    public static void main(String[] args) {

    }

    public double myPow(double x, int n) {

       return util(x,(long)n);
    }

    private double util(double x, long n){
        double result =1;

        if(n<0){
            n = -1*n;
            x = 1/x;
        }

        while (n!=0){

            if(n%2==1){
                result = result * x;
                n = n-1;
            }
            x = x*x;
            n = n/2;
        }
        return result;
    }
}
