"""

16. 最接近的三数之和
给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。

返回这三个数的和。

假定每组输入只存在恰好一个解。



示例 1：

输入：nums = [-1,2,1,-4], target = 1
输出：2
解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
示例 2：

输入：nums = [0,0,0], target = 1
输出：0


提示：

3 <= nums.length <= 1000
-1000 <= nums[i] <= 1000
-104 <= target <= 104
通过次数348,317提交次数762,938
"""
from typing import List


class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        nums.sort()
        min_distance = None
        result = None

        for i in range(len(nums) - 1):
            current_value = nums[i]
            left = i + 1
            right = len(nums) - 1

            while left < right:
                value = current_value + nums[left] + nums[right]
                if target == value:
                    return value

                if min_distance is None:
                    min_distance = abs(target - value)
                    result = value
                else:
                    if abs(target - value) < min_distance:
                        result = value
                        min_distance = abs(target - value)
                if target< value:
                    while True:
                        right -= 1
                        if nums[right] != nums[right + 1] or right <= left:
                            break
                else:
                    while True:
                        left += 1
                        if nums[left - 1] != nums[left] or right <= left:
                            break
        return result




if __name__ == '__main__':
    n = [0,2,1,-3]
    t = 1
    res = Solution().threeSumClosest(n, t)
    print(res)