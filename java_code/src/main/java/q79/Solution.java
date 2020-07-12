package q79;

/*
给定一个二维网格和一个单词，找出该单词是否存在于网格中。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

 

示例:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

给定 word = "ABCCED", 返回 true
给定 word = "SEE", 返回 true
给定 word = "ABCB", 返回 false
 

提示：

board 和 word 中只包含大写和小写英文字母。
1 <= board.length <= 200
1 <= board[i].length <= 200
1 <= word.length <= 10^3

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/word-search
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int[][] used = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtrack(board, used, word, i, j, m, n)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, int[][] used, String remainWord, int i, int j, int m, int n) {
        if (used[i][j] == 1) {
            return false;
        }
        boolean res = false;
        if (board[i][j] == remainWord.charAt(0)) {
            used[i][j] = 1;
            String remainWord1 = remainWord.substring(1);
            if (remainWord1.length() == 0) { // 匹配完成, 返回true
                return true;
            }
            if (i + 1 < m) {
                res = backtrack(board, used, remainWord1, i + 1, j, m, n);
                if (res) {
                    return true;
                }
            }
            if (i - 1 >= 0) {
                res = backtrack(board, used, remainWord1, i - 1, j, m, n);
                if (res) {
                    return true;
                }
            }
            if (j + 1 < n) {
                res = backtrack(board, used, remainWord1, i, j + 1, m, n);
                if (res) {
                    return true;
                }
            }
            if (j - 1 >= 0) {
                res = backtrack(board, used, remainWord1, i, j - 1, m, n);
                if (res) {
                    return true;
                }
            }
            used[i][j] = 0;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        boolean res = solution.exist(board, "ABCCEE");
        System.out.println(res);
    }
}
