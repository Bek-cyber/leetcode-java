package com.project.leetcodejava.easy;


public class LC1480_RunningSumOf_1dArray {
    public int[] runningSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }

        int[] result = new int[nums.length];
        int prefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            result[i] = prefixSum;
        }

        return result;
    }
}
