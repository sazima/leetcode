package q34;

import sun.security.util.Length;

import java.util.Arrays;

/*
给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

你的算法时间复杂度必须是 O(log n) 级别。

如果数组中不存在目标值，返回 [-1, -1]。

示例 1:

输入: nums = [5,7,7,8,8,10], target = 8
输出: [3,4]
示例 2:

输入: nums = [5,7,7,8,8,10], target = 6
输出: [-1,-1]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        // 二分查找
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                int L = mid;
                int R = mid;
                // 查找到之后, 再查找这个位置周围的数
                while (true) {
                    if (L <0) {
                        break;
                    }
                    if (nums[L] == target) {
                        L --;
                    } else  {
                        break;
                    }
                }
                while (true) {
                    if (R >= nums.length) {
                        break;
                    }
                    if (nums[R] == target) {
                        R ++;
                    }else {
                        break;
                    }
                }
                return new int[]{L+1, R-1};
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = {1 , 2, 2, 3};
//        int[] a = {5, 7, 7, 8, 8, 10};
        int target = 2;
        int[] ints = s.searchRange(a, target);
        System.out.println(Arrays.toString(ints));
    }
}
