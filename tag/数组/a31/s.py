"""
31. 下一个排列
整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。

例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。
更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。
如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。

例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
给你一个整数数组 nums ，找出 nums 的下一个排列。
必须 原地 修改，只允许使用额外常数空间。

示例 1：
输入：nums = [1,2,3]
输出：[1,3,2]

示例 2：
输入：nums = [3,2,1]
输出：[1,2,3]

示例 3：
输入：nums = [1,1,5]
输出：[1,5,1]
"""
from typing import List

# 我们需要将一个左边的「较小数」与一个右边的「较大数」交换，以能够让当前排列变大，从而得到下一个排列。
#
# 同时我们要让这个「较小数」尽量靠右，而「较大数」尽可能小。当交换完成后，「较大数」右边的数需要按照升序重新排列。这样可以在保证新排列大于原来排列的情况下，使变大的幅度尽可能小。
#
#
#
# 作者：LeetCode-Solution
# 链接：https://leetcode.cn/problems/next-permutation/solution/xia-yi-ge-pai-lie-by-leetcode-solution/
# 来源：力扣（LeetCode）
# 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        index1 = None
        # 找第一个 i < i + 1的
        for i in range(len(nums) - 2, -1, -1):
            if nums[i] < nums[i + 1]:
                index1 = i
                break
        if index1 is None:
            nums.sort()
            return
        # 找第一个 > index1 的
        index2 = None
        for i in range(len(nums) - 1, index1 , -1):
            if nums[i] > nums[index1]:
                index2 = i
                break
        if index2 is None:
            nums.sort()
            return
        nums[index1], nums[index2] = nums[index2], nums[index1]
        tail_nums = sorted(nums[index1 + 1 :])
        for index, i in enumerate(tail_nums):
            nums[index1 + 1+ index ] = i



if __name__ == '__main__':
    # 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
    nums = [2, 3, 1]
    nums = [1, 3, 2]  # [2,1,3]
    res = Solution().nextPermutation(nums)
    print(nums)


