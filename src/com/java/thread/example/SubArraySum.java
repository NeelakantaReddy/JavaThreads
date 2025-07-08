package com.java.thread.example;

public class SubArraySum {

    public static void main(String[] args) {
        System.out.println(new SubArraySum().twoSum(new int[]{1, 3, 5, 2, 8, 1, 5}, 3));
    }

    public int twoSum(int[] nums, int k) {
        int sum = 0;
        for(int i=0;i<k;i++){
            sum += nums[i];
        }
        int max = 0;
        for(int j=k; j<nums.length; j++){
            int csum = sum;
            csum = csum + nums[j];
            csum = csum - nums[j-k];
            max = Math.max(csum, max);
            sum = csum;
        }
        return max;
    }
}
