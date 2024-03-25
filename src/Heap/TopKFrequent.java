package Heap;

import java.util.*;

public class TopKFrequent {
    public static void main(String[] args) {

    }

    public int[] topKFrequent(int[] nums, int k) {

        if(nums.length == k) return nums;

        Map<Integer,Integer> countmap = new HashMap<>();

        for(int i=0;i< nums.length;i++){
            countmap.put(nums[i],countmap.getOrDefault(nums[i],0)+1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>((n1,n2)->{
            return countmap.get(n1)-countmap.get(n2);
        });

        for(int n : countmap.keySet()){
            heap.add(n);
            if(heap.size() > k){
                heap.poll();
            }
        }

        int[] ans = new int[k];

        for(int i=k-1;i>=0;--i){
            ans[i] = heap.poll();
        }
        return ans;
    }

    public int[] topKFrequent_bucketSort(int[] nums, int k) {

        if(nums.length == k) return nums;

        Map<Integer,Integer> countmap = new HashMap<>();

        for(int i=0;i< nums.length;i++){
            countmap.put(nums[i],countmap.getOrDefault(nums[i],0)+1);
        }

        List<Integer>[] bucket = new List[nums.length+1];

        for(int n: countmap.keySet()){
            int frq = countmap.get(n);
            if(bucket[frq]==null){
                bucket[frq] = new ArrayList<>();
            }
            bucket[frq].add(n);
        }

        List<Integer> result = new ArrayList<>();
        for(int i=bucket.length-1;i>=0;--i){
            if(bucket[i]==null) continue;
            for(int j:bucket[i]){
                result.add(j);
            }
        }

        int[] ans = new int[k];
        for(int i=0;i<k;i++){
            ans[i] = result.get(i);
        }


        return ans;
    }
}
