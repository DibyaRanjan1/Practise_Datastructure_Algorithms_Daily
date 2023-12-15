package Greedy;

import java.util.Arrays;

public class AssignCookies {
    public static void main(String[] args) {
      AssignCookies a = new AssignCookies();
      a.findContentChildren(new int[]{1,2,3},new int[]{1,1});
    }

    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);
        int child=0;

        for(int i=0;i< s.length && child< g.length;i++){
            if( s[i] >= g[child]) child++;
        }
        return child;
    }
}
