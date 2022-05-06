"""
11. 盛最多水的容器
给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。

找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

返回容器可以储存的最大水量。

说明：你不能倾斜容器。



示例 1：



输入：[1,8,6,2,5,4,8,3,7]
输出：49
解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
"""
from typing import List


# 暴力
class Solution:
    def maxArea(self, height: List[int]) -> int:
        res = 0
        for i in range(len(height) - 1) :
            for j in range(i + 1, len(height)):
                res = max([res, (j - i) * min([height[i], height[j]])])
        return res

if __name__ == '__main__':
    res = Solution().maxArea([1,8,6,2,5,4,8,3,7])
    print(res)
