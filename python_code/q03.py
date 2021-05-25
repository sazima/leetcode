"""
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: s = "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: s = "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
示例 4:

输入: s = ""
输出: 0
"""
# 执行用时：
# 76 ms
# , 在所有 Python3 提交中击败了
# 64.18%
# 的用户
# 内存消耗：
# 15 MB
# , 在所有 Python3 提交中击败了
# 64.82%
# 的用户
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        already_set = set()
        left = 0
        max_len = 0
        current_len = 0
        for i in s:
            current_len += 1
            while i in already_set:
                already_set.remove(s[left])
                left += 1
                current_len -= 1
            already_set.add(i)
            max_len = max([current_len, max_len])
        return max_len


if __name__ == '__main__':
    res  = Solution().lengthOfLongestSubstring("pwwkew")
    print(res)