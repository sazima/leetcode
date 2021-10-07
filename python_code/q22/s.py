"""
22. 括号生成
数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。

有效括号组合需满足：左括号必须以正确的顺序闭合。



示例 1：

输入：n = 3
输出：["((()))","(()())","(())()","()(())","()()()"]
示例 2：

输入：n = 1
输出：["()"]
"""
from typing import List


# 回溯法
class Solution:

    def generateParenthesis(self, n: int) -> List[str]:
        self.result = []
        self.backtracking('', 0, 0, n)
        return self.result

    def backtracking(self, ans: str, close: int, open_: int, n: int):
        if close > open_:
            return
        if open_ == n and close == n:
            self.result.append(ans)
            return
        if open_ < n:
            ans += '('
            self.backtracking(ans, close, open_ + 1, n)
            ans = ans[:-1]
        if open_ > close:
            ans += ')'
            self.backtracking(ans, close + 1, open_, n)
            ans = ans[:-1]


if __name__ == '__main__':
    s = Solution()
    res = s.generateParenthesis(5)
    print(res)
