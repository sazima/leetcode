package q33;

/*
假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

你可以假设数组中不存在重复的元素。

你的算法时间复杂度必须是 O(log n) 级别。

示例 1:

输入: nums = [4,5,6,7,0,1,2], target = 0
输出: 4
示例 2:

输入: nums = [4,5,6,7,0,1,2], target = 3
输出: -1

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int middle = 0;
        while (left <= right) {
            middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                return middle;
            }
            // 先根 据 nums[middle] 与 nums[left] 的关系判断 middle 是在左段还是右段
            if (nums[middle] >= nums[left]) {    // 左边是有序的
                if (target>=nums[left] && target < nums[middle]) {  //在左边有序的数组中如果可以找到目标值, 则right = middle - 1, 否则就在右侧无序的那一部分
                    right = middle -1;
                } else {
                    left = middle + 1;
                }
            } else {
                if (target <=nums[right] && target > nums[middle]) {
                    left = middle + 1;
                }else {
                    right = middle - 1;
                }
            }
        }
        return -1;
    }

}
