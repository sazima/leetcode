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


提示：

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums 是一个非递减数组
-109 <= target <= 109
通过次数396,466提交次数938,060
"""
from typing import List


class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        l = 0
        r = len(nums) - 1

        while l <= r:
            m = (l + r + 1) // 2
            value = nums[m]
            if value == target:
                min_left = max_right = m
                while True:  # 向左找
                    if min_left == 0:
                        break
                    if nums[min_left - 1] == target:
                        min_left -= 1
                    else:
                        break
                if min_left == 0 and nums[-1] == target:  # 首尾
                    return [0, len(nums) - 1]
                while True:  # 向右找
                    if max_right == len(nums) - 1:
                        break
                    if nums[max_right + 1] == target:
                        max_right += 1
                    else:
                        break
                return [min_left, max_right]

            else:
                if nums[r] > nums[m]:  # 右边增序
                    if nums[m + 1] <= target <= nums[r]:  # 右边
                        l = m + 1
                    else:
                        r = m - 1
                else:
                    if nums[m - 1] >= target >= nums[l]:  # 在左侧
                        r = m - 1
                    else:
                        l = m + 1
        return [-1, -1]


if __name__ == '__main__':
    nums = [5, 7, 7, 8, 8, 10]
    target = 8
    res = Solution().searchRange(nums, target)
    print(res )
    pass
