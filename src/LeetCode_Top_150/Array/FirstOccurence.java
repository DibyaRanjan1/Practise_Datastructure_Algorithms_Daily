package LeetCode_Top_150.Array;

public class FirstOccurence {
    public static void main(String[] args) {
        FirstOccurence f = new FirstOccurence();
        f.strStr("mississippi","issip");
    }


    // Not working with all test cases
    public int strStr(String haystack, String needle) {
        if(needle.length() > haystack.length()) return -1;
        if(haystack.length()==1 && needle.length()==1 && haystack.charAt(0)==needle.charAt(0)) return 0;
        int j=0;
        for(int i=0;i<haystack.length();i++){

            if(j==needle.length()) {
                return i-j;
            }

            if(haystack.charAt(i) == needle.charAt(j)){
                j++;
            }else {
                j=0;
                if(haystack.charAt(i)==needle.charAt(j)){
                    j++;
                }
            }
        }
        if(j==needle.length()) {
            return haystack.length()-j;
        }
        return -1;
    }

    //Optimized Solution
    public int strStr_Optimize(String haystack, String needle) {
        int n = needle.length();
        int m = haystack.length();

        for(int i = 0;i<m-n;i++){
            for(int j=0;j<n;j++){
                if(haystack.charAt(i+j)!=needle.charAt(j)){
                    break;
                }
                if(j==n-1) return i;
            }
        }
        return -1;
    }
}
