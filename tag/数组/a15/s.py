"""
给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
注意：答案中不可以包含重复的三元组。
示例 1：
输入：nums = [-1,0,1,2,-1,-4]
输出：[[-1,-1,2],[-1,0,1]]

示例 2：
输入：nums = []
输出：[]

示例 3：
输入：nums = [0]
输出：[]
来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/3sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
from typing import List


class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        result = []
        has_result0 = False
        if nums[0] > 0:
            return []

        for i in range(1, len(nums) - 1):
            if nums[i] == nums[i-1] == nums[i+1] == 0 :
                if not has_result0:
                    result.append([0, 0, 0])
                    has_result0 = True
                    continue
                else:
                    continue
            if nums[i] < 0 and nums[i] == nums[i + 1] and i != len(nums) - 2: # 小于0, 使用右边的作为中间数
                continue
            if nums[i] >= 0 and nums[i] == nums[i - 1]: # 大于0 使用左边的作为中间数
                continue
            left = 0
            right = len(nums) - 1
            target = -nums[i]

            while left < i < right:
                temp = nums[left] + nums[right]
                if temp == target:
                    result.append([nums[left], nums[i], nums[right]])
                    while True:
                        right -= 1
                        if nums[right + 1] != nums[right] or right <= i:
                            break
                    while True:
                        left += 1
                        if nums[left - 1] != nums[left] or left >= i:
                            break

                if temp > target:
                    while True:
                        right -= 1
                        if nums[right + 1] != nums[right] or right <= i:
                            break
                if temp < target:
                    while True:
                        left += 1
                        if nums[left - 1] != nums[left] or left >= i:
                            break
        return result


if __name__ == '__main__':
    nums = [-1, -1, 0, 0, 1, -4]
    nums = [1, 1, -2]
    nums = [0, 0, 0]
    nums = [-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6]
    res = Solution().threeSum(nums)
    print(res)
