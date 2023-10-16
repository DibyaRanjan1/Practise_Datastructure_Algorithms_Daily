package LeetCode_Top_150.Array;

public class HIndex {
    public static void main(String[] args) {
      HIndex h = new HIndex();
      h.hIndex(new int[]{3,0,6,1,5});
    }

    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] buckets = new int[n+1];
        for(int c : citations) {
            if(c >= n) {
                buckets[n]++;
            } else {
                buckets[c]++;
            }
        }
        int count = 0;
        for(int i = n; i >= 0; i--) {
            count += buckets[i];
            if(count >= i) {
                return i;
            }
        }
        return 0;
    }
}
