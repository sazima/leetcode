"""

34. 在排序数组中查找元素的第一个和最后一个位置
给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

如果数组中不存在目标值 target，返回 [-1, -1]。

进阶：

你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？


示例 1：

输入：nums = [5,7,7,8,8,10], target = 8
输出：[3,4]
示例 2：

输入：nums = [5,7,7,8,8,10], target = 6
输出：[-1,-1]
示例 3：

输入：nums = [], target = 0
输出：[-1,-1]

"""
from typing import List


class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        left = 0
        right = len(nums) - 1
        min_index = -1
        max_index = -1

        while left <= right:
            mid = (left + right) // 2
            if nums[mid] == target:
                temp_mid1 = mid
                temp_mid2 = mid
                while True:
                    min_index = temp_mid1
                    temp_mid1 -= 1
                    if temp_mid1 < 0:
                        break
                    if nums[temp_mid1] != target:
                        break
                while True:
                    max_index = temp_mid2
                    temp_mid2 += 1
                    if temp_mid2 >= len(nums):
                        break
                    if nums[temp_mid2] != target:
                        break
                break


            elif nums[mid] < target:
                left = mid + 1
            else:
                right = mid - 1
        return [min_index, max_index]


if __name__ == '__main__':
    nums = [5,7,7,8,8,10]; target = 8
    nums = [1]; target = 1
    res = Solution().searchRange(nums, target)
    print(res)