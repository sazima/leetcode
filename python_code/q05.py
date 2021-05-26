"""
给你一个字符串 s，找到 s 中最长的回文子串。



示例 1：

输入：s = "babad"
输出："bab"
解释："aba" 同样是符合题意的答案。
示例 2：

输入：s = "cbbd"
输出："bb"
示例 3：

输入：s = "a"
输出："a"
示例 4：

输入：s = "ac"
输出："a"


提示：

1 <= s.length <= 1000
s 仅由数字和英文字母（大写和/或小写）组成

"""
class Solution:
    def longestPalindrome(self, s: str) -> str:
        len_s = len(s)
        if len_s <= 1:
            return s
        result = ''
        len_result = 0
        for i in range(0, len_s):
            # i 是中间的
            # 作为中间的
            left = i
            right = i
            while 1:
                if left < 0 or right >= len_s or s[left] != s[right]:
                    if right - left - 1 > len_result:
                        result = s[left+1:right]
                        len_result = len(result)
                    break
                left -= 1
                right += 1
            # 或者 i, i+1 同时作为中间
            left = i
            right = i + 1
            while 1:
                if left < 0 or right >= len_s or s[left] != s[right]:
                    if right - left - 1 > len_result:
                        result = s[left+1:right]
                        len_result = len(result)
                    break
                left -= 1
                right += 1
        return result


if __name__ == '__main__':
    print(Solution().longestPalindrome("ac"))

