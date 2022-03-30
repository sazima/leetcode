"""
45. 跳跃游戏 II
给你一个非负整数数组 nums ，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

你的目标是使用最少的跳跃次数到达数组的最后一个位置。

假设你总是可以到达数组的最后一个位置。



示例 1:

输入: nums = [2,3,1,1,4]
输出: 2
解释: 跳到最后一个位置的最小跳跃数是 2。
     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
示例 2:

输入: nums = [2,3,0,1,4]
输出: 2
"""
from typing import List


class Solution:
    def jump(self, nums: List[int]) -> int:
        end =0  #  // 上次跳跃可达范围右边界（下次的最右起跳点）
        max_far = 0  #  目前能跳到的最远位置
        step = 0

        for i in range(0, len(nums) - 1):
            max_far = max(max_far, i + nums[i])
            if i == end:
                end = max_far
                step += 1
        return step



if __name__ == '__main__':
    a = [2,3,0,1,4]
    res = Solution().jump( a)
    print(res)
