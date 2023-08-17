package BinarySearch.Medium_Problems;

public class SquareRoot {
    public static void main(String[] args) {
     SquareRoot s = new SquareRoot();
    long result = s.nThRoot(27,3);
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
                answer =mid;
            }else {
                return mid;
            }
        }
        return answer;
    }

    long nThRoot(long x, long nROOT){

        long low =1;
        long high=x;

        while (low<=high){

            long mid = low+(high-low)/2;
            int tempresult = this.findRootValue(mid,x,nROOT);
            if(tempresult == 1 ) return mid;
            if(tempresult ==2 ){
                high = mid-1;
            }else {
                low = mid+1;
            }
        }
        return -1;

    }

    int findRootValue(long mid,long x, long n){
        long ans=1;
        for(int i=1;i<=n;i++){
            ans = ans* mid;
            if(ans>x) return 2;
        }
        if(ans==x) return 1;
        return 0;
    }
}
