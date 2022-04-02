"""
给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。

你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。

 

示例 1：


输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[[7,4,1],[8,5,2],[9,6,3]]
示例 2：


输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 

提示：

n == matrix.length == matrix[i].length
1 <= n <= 20
-1000 <= matrix[i][j] <= 1000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/rotate-image
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
import copy
from typing import List, Set, Tuple


class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        width = len(matrix)
        copy_matrix = copy.deepcopy(matrix)
        replace_i = 0
        replace_j = width - 1

        for i in range(width):
            for j in range(width):
                value = copy_matrix[i][j]
                matrix[replace_i][replace_j] = value
                if replace_i != width - 1:
                    replace_i += 1
                else:
                    replace_i = 0
                    replace_j -= 1


if __name__ == '__main__':
    matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]

    Solution().rotate(matrix)
    print(matrix)



    #
    # 0,0 -> 0,3
    # 0,1 -> 1,3
    # 0,2 -> 2, 3
    # ...
    # 1, 0 ->1, 2
    #
    # 5, 1, 9, 11
    # 2, 4, 8, 10
    # 13,3, 6,  7
    # 15,14,12,16
