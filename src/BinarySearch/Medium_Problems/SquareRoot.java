package BinarySearch.Medium_Problems;

public class SquareRoot {
    public static void main(String[] args) {

    }

    long floorSqrt(long x)
    {
        long low=1;
        long high = x;
        long answer = 1;

        while (low<=high){
            long mid = low + (high-low)/2;
            long tempResult = mid*mid;

            if(tempResult > x){
                high = mid-1;
            } else if(tempResult < x) {
                low = mid+1;
                answer =Math.max(answer,mid);
            }else {
                return mid;
            }
        }
        return answer;
    }
}
