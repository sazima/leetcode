package q1139;

/*
给你一个由若干 0 和 1 组成的二维网格 grid，请你找出边界全部由 1 组成的最大 正方形 子网格，并返回该子网格中的元素数量。如果不存在，则返回 0。

 

示例 1：

输入：grid = [[1,1,1],
             [1,0,1],
             [1,1,1]]
输出：9
示例 2：

输入：grid = [[1,1,0,0]]
输出：1
 

提示：

1 <= grid.length <= 100
1 <= grid[0].length <= 100
grid[i][j] 为 0 或 1

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/largest-1-bordered-square
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
        if (n == 0) {
            return 0;
        }
        int res = 0;
        int[][][] dps = new int[m + 1][n + 1][2];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {

                if (grid[i - 1][j - 1] == 1) {
                    dps[i][j][0] = dps[i][j - 1][0] + 1;
                    dps[i][j][1] = dps[i - 1][j][1] + 1;
                    int size = Math.min(dps[i][j][0], dps[i][j][1]);
                    // todo: 未理解, 看最左边的顶点往上延伸的最多能有的1的个数是不是大于当前size，看最上边的顶点往左延伸的最多能有的1的个数是不是大于当前size?
                    while (dps[i][j-size+1][1] < size || dps[i-size+1][j][0] < size) {
                        size--;
                    }

                    res = Math.max(size, res);
                }
            }
        }
        return res * res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] a = {{1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}};
        int res = solution.largest1BorderedSquare(a);
        System.out.println(res);
    }
}
