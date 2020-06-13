package q16;

import java.util.Arrays;

/*
给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.

与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).

 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int length = nums.length;
        int resultSum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < length - 2; i++) {
            int L = i + 1;
            int R = length - 1;
            while (L < R) {
                int tempSum = nums[L] + nums[R] + nums[i];
                if (tempSum > target) {
                    if (tempSum - target < Math.abs(resultSum - target)) {
                        resultSum = tempSum;
                    }
                    R--;
                    while (nums[R] == nums[R + 1] && R > L) {
                        R--;
                    }
                } else if (tempSum < target) {
                    if (target - tempSum < Math.abs(resultSum - target)) {
                        resultSum = tempSum;
                    }
                    L++;
                    while (nums[L] == nums[L - 1] && R > L) {
                        L++;
                    }
                } else {
                    return tempSum;
                }
            }
        }
        return resultSum;
    }

    public static void main(String[] args) {
        int[] a = {-3,-2,-5,3,-4};
        Solution s = new Solution();
        int res = s.threeSumClosest(a, -1);
        System.out.println(res);

    }
}
