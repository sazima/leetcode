package q74;

import java.util.concurrent.atomic.AtomicBoolean;

/*
编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：

每行中的整数从左到右按升序排列。
每行的第一个整数大于前一行的最后一个整数。
示例 1:

输入:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
输出: true
示例 2:

输入:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
输出: false

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/search-a-2d-matrix
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int index = -1;
        int rowLength = matrix.length;
        if (rowLength == 0) {
            return false;
        }
        int columnLength = matrix[0].length;
        if (columnLength == 0) {
            return false;
        }
        for (int i = 0; i<rowLength; i++) {
            if (matrix[i][0] <= target && matrix[i][columnLength - 1] >= target) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return false;
        }
        int left = 0;
        int right = columnLength - 1;
        int[] currentRow = matrix[index];
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (currentRow[mid] == target) {
                return true;
            }else if(currentRow[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int[][] a = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        int[][] a = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        Solution solution = new Solution();
        boolean b = solution.searchMatrix(a, 3);
        System.out.println(b);
    }

}
