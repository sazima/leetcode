from typing import List


# > 90%
class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        len_nums = len(nums)
        if len_nums < 4:
            return []
        result = []
        nums.sort()
        for index1 in range(len_nums - 3):
            num = nums[index1]
            if index1 > 0 and nums[index1 - 1] == num:
                continue
            if num + nums[len_nums - 3] + nums[len_nums - 1] + nums[len_nums - 2] < target:
                continue
            if num + nums[index1 + 3] + nums[index1 + 1] + nums[index1 + 2] > target:
                break

            for index2 in range(index1 + 1, len_nums - 2):
                if index2 > index1 + 1 and nums[index2] == nums[index2 - 1]:
                    continue
                if num + nums[index2] + nums[len_nums - 1] + nums[len_nums - 2] < target:
                    continue
                if num + nums[index2] + nums[index2 + 1] + nums[index2 + 2] > target:
                    break
                # 双指针
                left = index2 + 1
                right = len_nums - 1
                while left < right:
                    sum_ = num + nums[index2] + nums[left] + nums[right]
                    if sum_ > target:
                        while right > left and nums[right - 1] == nums[right]:
                            right -= 1
                        right -= 1
                    elif sum_ < target:
                        while right > left and nums[left + 1] == nums[left]:
                            left += 1
                        left += 1
                    else:
                        result.append([num, nums[left], nums[right], nums[index2]])
                        while right > left and nums[right - 1] == nums[right]:
                            right -= 1
                        right -= 1
                        while right > left and nums[left + 1] == nums[left]:
                            left += 1
                        left += 1

        return result


if __name__ == '__main__':
    nums = [1,0,-1,0,-2,2]
    target = 0
    res = Solution().fourSum(nums, target)
    print(res)
