"""
8. 四数之和
给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：

0 <= a, b, c, d < n
a、b、c 和 d 互不相同
nums[a] + nums[b] + nums[c] + nums[d] == target
你可以按 任意顺序 返回答案 。



示例 1：

输入：nums = [1,0,-1,0,-2,2], target = 0
输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
示例 2：

输入：nums = [2,2,2,2,2], target = 8
输出：[[2,2,2,2]]


提示：

1 <= nums.length <= 200
-109 <= nums[i] <= 109
-109 <= target <= 109
"""
from typing import List


class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        nums.sort()
        result = []
        for i in range(0, len(nums) - 2):
            this_value = nums[i]
            if target > 0 and this_value > target:
                break
            if i != 0 and this_value == nums[i - 1]:
                continue
            target1 = target - this_value
            # 找和为target1
            pre_j = None
            for j in range(i + 1, len(nums) - 1):
                if pre_j is not None and nums[j] == pre_j:
                    continue
                j_and_i = nums[j] + nums[i]
                #  需要大于0的， 但是当前值大于目标值， 然后后面肯定要找不到
                if target1 > 0 and j_and_i > target1:
                    break
                pre_j = nums[j]
                left = j + 1
                right = len(nums) - 1

                while left < right:
                    sum1 =  nums[j] + nums[left] + nums[right]
                    if sum1 == target1:
                        result.append([nums[i], nums[j], nums[left], nums[right]])
                        while True:
                            left += 1
                            if left >= right or nums[left] != nums[left - 1]:
                                break
                    elif sum1 > target1:
                        while True:
                            right -= 1
                            if nums[right] != nums[right + 1] or left >= right:
                                break
                    else:
                        while True:
                            left += 1
                            if left >= right or nums[left] != nums[left - 1]:
                                break
        return result

if __name__ == '__main__':
    # a = [1, 2, 3, 4, 5]
    a = [1,0,-1,0,-2,2]
    # a = [-3,-2,-1,0,0,1,2,[-3,-2,-1,0,0,1,2,3]3]
    a = [-3,-2,-1,0,0,1,2,3]

    res = Solution().fourSum(nums=a, target=0)
    print(res)