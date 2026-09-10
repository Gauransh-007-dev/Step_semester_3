package main.java.week4.assigment_problems;

import java.util.Arrays;

public class ProductExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }
        
        int rightSuffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * rightSuffix;
            rightSuffix *= nums[i];
        }
        
        return answer;
    }
}