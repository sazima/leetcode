"""

给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。



示例 1：

输入：nums = [1,1,2]
输出：
[[1,1,2],
 [1,2,1],
 [2,1,1]]
示例 2：

输入：nums = [1,2,3]
输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]


提示：

1 <= nums.length <= 8
-10 <= nums[i] <= 10


"""
from typing import List



class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        result = []
        already_index = set()
        nums.sort()
        self._back_track([], nums, result, already_index)
        return result

    def _back_track(self, current_result: List[int], nums: List[int], result: List[List[int]], already_index):
        if len(current_result) == len(nums):
            result.append(list(current_result))
            return

        previous = None
        for index, i in enumerate(nums):
            if index in already_index:
                continue
            if previous is not None and previous == i:
                continue
            previous = i
            already_index.add(index)
            current_result.append(i)
            self._back_track(current_result, nums, result)
            current_result.pop()
            already_index.remove(index)


