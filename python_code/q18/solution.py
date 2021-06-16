"""
给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。

注意：答案中不可以包含重复的四元组。



示例 1：

输入：nums = [1,0,-1,0,-2,2], target = 0
输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
示例 2：

输入：nums = [], target = 0
输出：[]


提示：

0 <= nums.length <= 200
-109 <= nums[i] <= 109
-109 <= target <= 109
"""
from typing import List



# 超过2%， 待优化
class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        nums.sort()
        result = []
        self._back_track(nums, result, 0, [], target, 0)
        return result

    def _back_track(self, nums: List[int], result: List[List[int]], index: int, current_result: List[int], target: int, current_sum: int):
        if len(current_result) == 4:
            if current_sum == target:
                result.append(list(current_result))
            return
        if index >= len(nums):
            return
        i = index
        while i < len(nums):
            n = nums[i]
            if len(nums) -i < 4 - len(current_result):
                break
            # if current_sum + n > target:
            #     break
            if nums[i] > 0 and current_sum > target - nums[i] * (4 - len(current_result)):
                break
            if current_sum + (4 - len(current_result)) * nums[-1] < target:
                break
            current_result.append(n)
            self._back_track(nums, result, i + 1, current_result, target, current_sum + n)
            current_result.pop()
            while i + 1 < len(nums) and n == nums[i + 1]:
                i += 1
            i += 1


if __name__ == '__main__':
    # nums = [1,0,-1,0,-2,2]
    # nums = [2, 2, 2, 2, 2]
    nums = [1,-2,-5,-4,-3,3,3,5]
    target  = -11
    # target = 0
    res = Solution().fourSum(nums, target)
    print(res)
