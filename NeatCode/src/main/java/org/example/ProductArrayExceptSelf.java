package org.example;

import java.util.Arrays;

public class ProductArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,3};
        int[] results = new int[nums.length];

        // left pass
        int lastresult = 1;
        for (int i = 0; i < nums.length; i++) {
            results[i] = lastresult;
            lastresult = lastresult * nums[i];
        }
        //right pass
        lastresult = 1;
        for (int i = nums.length - 1; i >= 0 ; i--) {
            results[i] = lastresult * results[i];
            lastresult = lastresult * nums[i];
        }

        Arrays.stream(results).forEach(System.out::println);

    }
}
