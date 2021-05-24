from typing import List


class Solution:

    def twoSum(self, nums: List[int], target: int) -> List[int]:
        num_to_index = dict()
        for index, num1 in enumerate(nums):
            num2 = target - num1
            if num2 in num_to_index:
                return [num_to_index[num2], index]
            num_to_index[num1] = index


if __name__ == '__main__':
    print(Solution().twoSum([2,7,11,15], 9))