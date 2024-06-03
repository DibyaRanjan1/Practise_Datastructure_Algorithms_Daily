package SlidingWindow.Medium;

public class LongestRepeatingCharReplacement {
    public static void main(String[] args) {
   LongestRepeatingCharReplacement longestRepeatingCharReplacement = new LongestRepeatingCharReplacement();
   longestRepeatingCharReplacement.characterReplacement("AABABBA",1);
    }

    public int characterReplacement(String s, int k) {
        int maxLength=0;
        int leftIndex=0;
        int rightIndex=0;
        int maxFreq=0;
        int[] freq = new int[26];

        while (rightIndex < s.length()){
            freq[s.charAt(rightIndex)-'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(rightIndex)-'A']);

            if(rightIndex-leftIndex+1-maxFreq >k){
               freq[s.charAt(leftIndex)-'A']--;
               ++leftIndex;
            }
            maxLength = Math.max(maxLength,rightIndex-leftIndex+1);
          ++rightIndex;
        }
        return maxLength;
    }
}
