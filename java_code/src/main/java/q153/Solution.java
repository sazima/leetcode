package q153;

/*
153. 寻找旋转排序数组中的最小值
假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

请找出其中最小的元素。

你可以假设数组中不存在重复元素。

示例 1:

输入: [3,4,5,1,2]
输出: 1
示例 2:

输入: [4,5,6,7,0,1,2]
输出: 0

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    // 0ms 100%
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int middle = 0;
        while (l < r) {
            middle = (l + r) / 2;
            if (nums[middle] >= nums[l]) {  // 左边递增
                if (nums[r] > nums[l]) {
                    return nums[l];
                } else {  // 在右边
                    l = middle + 1;
                }
            } else {  // 右边递增
                if (middle != 0 && nums[middle] < nums[middle - 1]) {
                    return nums[middle];
                }
                r = middle - 1;
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int res = solution.findMin(new int[]{4, 5, 6, 7, -2, 1, 2});
        int res = solution.findMin(new int[]{3,1});
        System.out.println(res);
    }

}
