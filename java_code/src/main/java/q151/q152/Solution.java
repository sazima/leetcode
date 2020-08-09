package q151.q152;

/*
    152. 乘积最大子数组
给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。

 

示例 1:

输入: [2,3,-2,4]
输出: 6
解释: 子数组 [2,3] 有最大乘积 6。
示例 2:

输入: [-2,0,-1]
输出: 0
解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-product-subarray
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    // 1ms 96%, 动态规划
    public int maxProduct(int[] nums) {
        int[] maxDps = new int[nums.length + 1];
        int[] minDps = new int[nums.length + 1];
        maxDps[1] = nums[0];
        minDps[1] = nums[0];
        for (int i = 1; i<nums.length; i++) {
            if (nums[i] < 0) {
                minDps[i + 1] = Math.min(nums[i], nums[i] * maxDps[i]);
                maxDps[i + 1] = Math.max(nums[i], nums[i] * minDps[i]);
            } else {
                minDps[i + 1] = Math.min(nums[i], nums[i] * minDps[i]);
                maxDps[i + 1] = Math.max(nums[i], nums[i] * maxDps[i]);
            }
        }
        int result = maxDps[1];
        for (int i = 1; i<maxDps.length; i++) {
            result = Math.max(maxDps[i], result);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.maxProduct(new int[]{2,3,-2,4});
        System.out.println(res);
    }
}
