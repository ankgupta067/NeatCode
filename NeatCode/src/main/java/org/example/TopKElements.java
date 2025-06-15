package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TopKElements {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2,3,0,0};
        int k = 2;
        TopKElementsWithHash(nums, k);
    }




    private static void TopKElementsWithHash(int[] nums, int k) {

        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i] , hashMap.getOrDefault(nums[i],0) + 1);
        }

        List<Integer>[] buckets = new List[nums.length +1];
        for(var kv : hashMap.entrySet()){
            if (buckets[kv.getValue()] != null){
                buckets[kv.getValue()].add(kv.getKey());
            }else {
                buckets[kv.getValue()] = new ArrayList<>();
                buckets[kv.getValue()].add(kv.getKey());
            }
        }

        for (int i = buckets.length - 1; i  > 0 ; i--) {
            if (buckets[i] != null){
                for ( var x : buckets[i]){
                    if (k > 0){
                        System.out.println(x);
                        k--;
                    }else {
                        return;
                    }
                }
            }
        }
    }


}
