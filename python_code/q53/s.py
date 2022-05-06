"""
给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
子数组 是数组中的一个连续部分。
----------------------
示例 1：
输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
输出：6
解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
----------------------
示例 2：
输入：nums = [1]
输出：1
示例 3：
输入：nums = [5,4,-1,7,8]
输出：23
提示：
1 <= nums.length <= 105
-104 <= nums[i] <= 104
"""
from typing import List


class Solution:

    def maxSubArray(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]
        sum_ = nums[0]
        max_ans =nums[0]
        for index, n in enumerate(nums[1:]):
            sum_ = max(n, sum_ + n)
            max_ans = max(max_ans, sum_)
        return max_ans


if __name__ == '__main__':
    res = Solution().maxSubArray([-2,1,-3,4,-1,2,1,-5,4])
    print(res)

