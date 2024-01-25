package LeetCode_Top_150.Heap;

import java.util.*;

public class kSmallestPairs {
    public static void main(String[] args) {

    }

    class Pair{
        int index1;
        int index2;

        Pair(int index1,int index2){
            this.index1 = index1;
            this.index2 = index2;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[0] - b[0]));
        pq.add(new int[]{nums1[0]+nums2[0],0,0});
        int num1Length = nums1.length;
        int nums2Length = nums2.length;

        List<List<Integer>> result = new ArrayList<>();

        Set<Pair> visited = new HashSet<>();

        while (k>0 && !pq.isEmpty()){

           int[] item = pq.poll();
           int i = item[1];
           int j = item[2];

           result.add(List.of(nums1[i],nums2[j]));

           if(i+1 <num1Length && !visited.contains(new Pair(i+1,j))){
              pq.offer(new int[]{nums1[i+1]+nums2[j],i+1,j});
              visited.add(new Pair(i+1,j));
           }

            if(j+1 <nums2Length && !visited.contains(new Pair(i,j+1))){
                pq.offer(new int[]{nums1[i]+nums2[j+1],i,j+1});
                visited.add(new Pair(i,j+1));
            }
        --k;
        }
        return result;

    }
}
