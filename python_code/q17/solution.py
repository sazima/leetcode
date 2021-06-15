"""
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。





示例 1：

输入：digits = "23"
输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
示例 2：

输入：digits = ""
输出：[]
示例 3：

输入：digits = "2"
输出：["a","b","c"]
"""
from typing import List


class Solution:
    _digit_to_letters = {
        '2': ['a', 'b', 'c'],
        '3': ['d', 'e', 'f'],
        '4': ['g', 'h', 'i'],
        '5': ['j', 'k', 'l'],
        '6': ['m', 'n', 'o'],
        '7': ['p', 'q', 'r', 's'],
        '8': ['t', 'u', 'v'],
        '9': ['w', 'x', 'y', 'z']

    }

    def letterCombinations(self, digits: str) -> List[str]:
        if not digits:
            return []
        results = []
        self._back_track(digits, results, 0, '')
        return results

    def _back_track(self, digits: str, results: List[str], index: int, current_result: str):
        if index == len(digits):
            results.append(current_result)
            return
        current_digit = digits[index]
        current_letters = self._digit_to_letters[current_digit]
        for letter in current_letters:
            c = current_result + letter
            self._back_track(digits, results, index + 1, c)


if __name__ == '__main__':
    a = '23'
    res = Solution().letterCombinations(a)
    print(res)