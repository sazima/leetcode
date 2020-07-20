package q130;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
130. 被围绕的区域
给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。

找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。

示例:

X X X X
X O O X
X X O X
X O X X
运行你的函数后，矩阵变为：

X X X X
X X X X
X X X X
X O X X
解释:

被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 */
public class Solution {
    // 思路: 将所有和边缘的o相连的o找到, 并替换成#. 遍历完成后, 再讲所有的#替换成o, 把所有的o替换成x
    // 遍历加回溯
    // 3ms 44%
    public void solve(char[][] board) {
        int row = board.length;
        if (row == 0) {
            return;
        }
        int column = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j] != 'O') {
                    continue;
                }
                boolean atEdge = i == 0 || i == row - 1 || j == 0 || j == column - 1;
                if (atEdge) {
                    dfs(i, j, board, row, column);
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(int i, int j, char[][] board, int row, int column) {
        if (i < 0 || i > row - 1 || j > column - 1 || j < 0 || board[i][j] == '#' || board[i][j] == 'X') {
            return;
        }
        board[i][j] = '#';
        dfs(i - 1, j, board, row, column);
        dfs(i + 1, j, board, row, column);
        dfs(i, j - 1, board, row, column);
        dfs(i, j + 1, board, row, column);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] a = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        solution.solve(a);
    }

}
