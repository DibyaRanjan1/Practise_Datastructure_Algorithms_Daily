package SlidingWindow.Medium;

public class LongestPalindrome {
    public static void main(String[] args) {

        LongestPalindrome longestPalindrome = new LongestPalindrome();
      //String ans =  longestPalindrome.longestPalindrome("cbbd");

      String ans1 = longestPalindrome.longestPalindrome_Optimize("cbbd");
    }

    public String longestPalindrome(String s) {
       int startIndex=0;
       int endIndex=s.length()-1;
       String ans= s.substring(0,1);


       if(isPalindrome(startIndex,endIndex,s)){
           return s;
       }
       int tempEndIndex=endIndex-1;

       while (startIndex < endIndex) {
           while (startIndex < tempEndIndex) {

               if (isPalindrome(startIndex, tempEndIndex, s)) {
                   if(ans.length() < (tempEndIndex-startIndex)+1){
                       ans = s.substring(startIndex, tempEndIndex+1);
                   }
               }
               --tempEndIndex;
           }
           tempEndIndex =endIndex;
           ++startIndex;
       }

       if(ans.length()==1) return "";

return ans;

    }

    private boolean isPalindrome(int start,int end, String s){
        while (start<end){
            if(s.charAt(start)!= s.charAt(end)) return false;
            ++start;
            --end;
        }
        return true;
    }



        public String longestPalindrome_Optimize(String s) {
            int[] ans = new int[] { 0, 0 };

            for (int i = 0; i < s.length(); i++) {
                int oddLength = expand(i, i, s);
                if (oddLength > ans[1] - ans[0] + 1) {
                    int dist = oddLength / 2;
                    ans[0] = i - dist;
                    ans[1] = i + dist;
                }

                int evenLength = expand(i, i + 1, s);
                if (evenLength > ans[1] - ans[0] + 1) {
                    int dist = (evenLength / 2) - 1;
                    ans[0] = i - dist;
                    ans[1] = i + 1 + dist;
                }
            }

            int i = ans[0];
            int j = ans[1];
            return s.substring(i, j + 1);
        }

        private int expand(int i, int j, String s) {
            int left = i;
            int right = j;

            while (
                    left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)
            ) {
                left--;
                right++;
            }

            return right - left - 1;
        }

}
