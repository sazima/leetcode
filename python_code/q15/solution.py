"""
15. 三数之和
给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。

注意：答案中不可以包含重复的三元组。



示例 1：

输入：nums = [-1,0,1,2,-1,-4]
输出：[[-1,-1,2],[-1,0,1]]
示例 2：

输入：nums = []
输出：[]
示例 3：

输入：nums = [0]
输出：[]


提示：

0 <= nums.length <= 3000
-105 <= nums[i] <= 105
通过次数531,083提交次数1,643,919

"""
from typing import List


class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        len_nums = len(nums)
        if len_nums < 3:
            return []
        nums.sort()
        result = []
        for index, n in enumerate(nums):
            if n > 0:
                break
            if index > 0 and nums[index] == nums[index - 1]:
                continue
            # 双指针
            left = index + 1
            right = len_nums - 1
            while left < right:
                sum_ = nums[left] + nums[right] + n
                if sum_ < 0:
                    left += 1
                elif sum_ > 0:
                    right -= 1
                else:
                    result.append([nums[left], nums[right], n])
                    while left < right and nums[left] == nums[left + 1]:
                        left += 1
                    while left < right and nums[right] == nums[right - 1]:
                        right -= 1
                    left += 1
                    right -= 1
            return result


if __name__ == '__main__':
    a =
    res = Solution().threeSum()
