package q35;

import jdk.nashorn.internal.ir.ReturnNode;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/*
给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

你可以假设数组中无重复元素。

示例 1:

输入: [1,3,5,6], 5
输出: 2
示例 2:

输入: [1,3,5,6], 2
输出: 1
示例 3:

输入: [1,3,5,6], 7
输出: 4
示例 4:

输入: [1,3,5,6], 0
输出: 0

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/search-insert-position
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int middle = 0;
        int res = 0;

        while (true) {
            // 1, 2, 3, 5  4
            if (left > right) {
                return left;
            }
            middle = (left + right) / 2;
            if (target == nums[middle]) {
                return middle;
            }
            if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = {1, 3, 5, 6};
        int i = solution.searchInsert(a, 2);
        System.out.println(i);

    }
}
