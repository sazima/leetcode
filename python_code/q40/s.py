"""

给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的每个数字在每个组合中只能使用一次。

注意：解集不能包含重复的组合。 

 

示例 1:

输入: candidates = [10,1,2,7,6,1,5], target = 8,
输出:
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
示例 2:

输入: candidates = [2,5,2,1,2], target = 5,
输出:
[
[1,2,2],
[5]
]
 

提示:

1 <= candidates.length <= 100
1 <= candidates[i] <= 50
1 <= target <= 30

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/combination-sum-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
from typing import List


class Solution:

    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        result = []
        candidates.sort()
        self.back_track([], candidates, target, 0, result)
        return result

    def back_track(self, current_result: List[int], candidates: List[int], target: int, start_index: int, result):
        sum_ = sum(current_result)
        # print(current_result)
        if sum_ == target:
            result.append(list(current_result))
            return

        previous = None
        for index, i in enumerate(candidates[start_index:]):
            if previous and previous == i:
                continue
            previous = i
            if i > 0 and sum_ + i > target:
                return
            current_result.append(i)
            self.back_track(current_result, candidates, target, start_index + index + 1, result)
            current_result.pop()


if __name__ == '__main__':
    # candidates = [2, 3, 5]
    # target = 8
    candidates = [10,1,2,7,6,1,5]
    target = 8
    res = Solution().combinationSum2(candidates, target)
    print(res)
