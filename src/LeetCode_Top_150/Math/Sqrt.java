package LeetCode_Top_150.Math;

public class Sqrt {
    public static void main(String[] args) {

    }

    public int mySqrt(int x) {

        if(x<2) return x;
        int left = 2; int right = x/2;
        int middle = 0;
        long num=0;

        while (left<=right){
            middle = left+ (right-left)/2;

            num = (long)(middle * middle);

            if(num > x){
                right = middle-1;
            } else if (num < x) {
                left = middle+1;
            }else {
                return middle;
            }
        }
        return right;

    }
}
