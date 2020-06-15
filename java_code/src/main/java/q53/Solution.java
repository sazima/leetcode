package q53;

/*
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例:

输入: [-2,1,-3,4,-1,2,1,-5,4],
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-subarray
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    // 执行用时 :
    //162 ms
    //, 在所有 Java 提交中击败了
    //5.05%
    //的用户
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int result = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            result = Math.max(result, sum);
            for (int j = i + 1; j < nums.length; j++) {
                sum = sum + nums[j];
                result = Math.max(result, sum);
            }
        }
        return result;
    }

    public static void main(String[] args) {


        int[] a = {-2, 1};//  -3, 4, -1, 2, 1, -5, 4};
        Solution solution = new Solution();
        int i = solution.maxSubArray(a);
        System.out.println(i);


    }
}
