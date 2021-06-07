"""

14. 最长公共前缀
编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。



示例 1：

输入：strs = ["flower","flow","flight"]
输出："fl"
示例 2：

输入：strs = ["dog","racecar","car"]
输出：""
解释：输入不存在公共前缀。


提示：

0 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] 仅由小写英文字母组成
"""
from typing import List


class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        result = strs[0]
        for s in strs[1:]:
            new_result = ""
            for i in range(0, min([len(s), len(result)])):
                if s[i] == result[i]:
                    new_result += s[i]
                else:
                    break
            result = result if len(result) < len(new_result) else new_result
        return result


if __name__ == '__main__':
    a = ["flower","flow","flight"]
    res = Solution().longestCommonPrefix(a)
    print(res)
