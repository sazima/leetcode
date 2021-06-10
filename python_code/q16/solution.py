"""


给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。



示例：

输入：nums = [-1,2,1,-4], target = 1
输出：2
解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。


提示：

3 <= nums.length <= 10^3
-10^3 <= nums[i] <= 10^3
-10^4 <= target <= 10^4

"""
from typing import List


class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        len_numbers = len(nums)
        nums.sort()
        result = None
        for index in range(0, len_numbers - 1):
            n = nums[index]
            left = index + 1
            right = len_numbers - 1
            while left < right:
                sum_ = n + nums[left] + nums[right]
                if sum_ == target:
                    return target
                elif sum_ > target:  # 如果和大于目标值，right 向左
                    while left < right and nums[right] == nums[right - 1]:
                        right -= 1
                    right -= 1
                else:
                    while left < right and nums[left] == nums[left + 1]:  # left 向右
                        left += 1
                    left += 1
                if result is None:
                    result = sum_
                else:
                    if abs(sum_ - target) < abs(result - target):
                        result = sum_
        return result


if __name__ == '__main__':
    nums = [1,2,5,10, 11]
    target = 12
    res = Solution().threeSumClosest(nums, target)
    print('result', res)

