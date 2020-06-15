package q31;

import java.util.Arrays;

public class Solution2 {
    public void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int i = nums.length - 2;
        // 从右向左找到当前位置比前一个小的
        while (true) {
            if (i < 0 || nums[i] < nums[i + 1]) {
                break;
            }
            i--;
        }

        if (i >= 0) {
            // 从右向左, 找到第一个比i值打的 => 交换j和j的位置  =>排序i+1后的数字

            for (int j = nums.length - 1; j >= 0; j--) {

                if (nums[j] > nums[i]) {
                    swap(nums, i, j);
                    Arrays.sort(nums, i+1, nums.length);
                    return;
                }
            }
        }

        Arrays.sort(nums);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
//        int[] a = {2, 3, 1}; // => 321 => 312
        int[] a = {1, 5, 1}; // => 511 => 511
        s.nextPermutation(a);
        System.out.println(Arrays.toString(a));

    }
}
