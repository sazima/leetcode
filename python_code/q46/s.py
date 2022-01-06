"""
给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。

 

示例 1：

输入：nums = [1,2,3]
输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
示例 2：

输入：nums = [0,1]
输出：[[0,1],[1,0]]
示例 3：

输入：nums = [1]
输出：[[1]]
 

提示：

1 <= nums.length <= 6
-10 <= nums[i] <= 10
nums 中的所有整数 互不相同
通过次数482,949提交次数615,697

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/permutations
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
from typing import List


class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        result = []
        self._back_track([], nums, result)
        return result

    def _back_track(self, current_result: List[int], nums: List[int], result: List[List[int]]):
        if len(current_result) == len(nums):
            result.append(list(current_result))
            return

        for i in nums:
            if i in current_result:
                continue
            current_result.append(i)
            self._back_track(current_result, nums, result)
            current_result.pop()



if __name__ == '__main__':
    res = Solution().permute([1, 2, 3])
    print(res)