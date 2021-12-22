"""
实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列（即，组合出下一个更大的整数）。

如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

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
示例 4：

输入：nums = [1]
输出：[1]
 

提示：

1 <= nums.length <= 100
0 <= nums[i] <= 100

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/next-permutation
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
from typing import List, Dict



class Solution:
    # 先找出最大的索引 k 满足 nums[k] < nums[k+1]，如果不存在，就翻转整个数组；
    # 再找出另一个最大索引 l 满足 nums[l] > nums[k]；
    # 交换 nums[l] 和 nums[k]；
    # 最后翻转 nums[k+1:]。
    #
    # 作者：powcai
    # 链接：https://leetcode-cn.com/problems/next-permutation/solution/xia-yi-ge-pai-lie-by-powcai/
    # 来源：力扣（LeetCode）
    # 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    def swap(self, i, j, nums):
        c = nums[i]
        nums[i] = nums[j]
        nums[j] = c

    def paste(self, start, end, nums: list, new_element: list):
        i = 0
        for index in range(start, end):
            nums[index] = new_element[i]
            i += 1


    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        sort_nums = sorted(nums)
        num_to_index = {}   # type: Dict[int, int]
        num_to_next_num = {}   # type: Dict[int, int]
        for index, n in enumerate(nums):
            num_to_index[n]  = index

        for index, n in enumerate(sort_nums):
            if index < len(sort_nums) - 1 and n != sort_nums[index + 1]:
                num_to_next_num.setdefault(n, sort_nums[index + 1])

        changed = False
        for index in range(len(nums) - 1, -1, -1):
            num = nums[index]
            next_num = num_to_next_num.get(num)
            if not next_num:
                continue
            next_index = None
            while True:
                if next_num is None:
                    break
                _index = num_to_index[next_num]
                if _index < index:
                    next_num = num_to_next_num.get(next_num)
                    continue
                else:
                    next_index = _index
                    break
                    # next_num = num_to_next_num.get(next_num)
                # num = next_number

            if next_index is None:
                continue
            self.swap(index, next_index, nums)
            self.paste(index + 1, len(nums), nums, sorted(nums[index + 1:]))
            changed = True
            break
            # nums[index] = next_number
            # nums[next_index] = num
            # changed = True
            # # 翻转index + 1:
            # # 0,  1, 2, 3, 4 | 5, 6, 7, 8
            # right_part = sorted(nums[index + 1:])
            # # this_index = next_index + 1
            # for right_index, n in enumerate(right_part):
            #     if right_index >= len(right_part) // 2:
            #         break
                # nums[right_index + this_index] = nums[-right_index - 1]

        if not changed:
            for index, n in enumerate(nums):
                nums[index] = sort_nums[index]







if __name__ == '__main__':
    # [1,3,2] => [2, 1, 3]
    # 1, 5, 7 -> 1 7 5
    a = [1, 3, 4]
    a = [1, 3, 2]  #  2, 3, 1
    a = [5,4,7,5,3,2]  # 5,5,7,4,3,2
    Solution().nextPermutation(a)
    print(a)

    pass
