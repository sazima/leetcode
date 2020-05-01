package q22;
import java.util.ArrayList;
import java.util.List;
/*
数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
示例：

输入：n = 3
输出：[
       "((()))",
       "(()())",
       "(())()",
       "()(())",
       "()()()"
     ]

 */
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }
    // 回溯
    private void backtrack(List<String> result, String currentResult, int open, int close, int n) {
        if (currentResult.length() == n * 2) {
            result.add(currentResult);
            return;
        }
        // 回溯
        if (open < n) {
            currentResult += '(';
            backtrack(result, currentResult, open + 1, close, n);
        }

        currentResult = currentResult.substring(0, currentResult.length() - 1); // 恢复原状态
        if (open > close) {
            currentResult += ')';
            backtrack(result, currentResult, open, close + 1, n);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int a = 3;
        System.out.println(s.generateParenthesis(3));
    }
}
