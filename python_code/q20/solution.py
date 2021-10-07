"""
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
 

示例 1：

输入：s = "()"
输出：true
示例 2：

输入：s = "()[]{}"
输出：true
示例 3：

输入：s = "(]"
输出：false
示例 4：

输入：s = "([)]"
输出：false
示例 5：

输入：s = "{[]}"
输出：true

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
class Solution:
    def isValid(self, s: str) -> bool:
        parentheses_map = {
            ')': '(',
            '}': '{',
            ']': '['
        }
        parentheses_list = []
        for index, i in enumerate(s):
            if i in parentheses_map:  # 是右括号
                if not parentheses_list:
                    return False
                if parentheses_list[-1] != parentheses_map[i]:
                    return False
                parentheses_list.pop()
            else:
                parentheses_list.append(i)
        if parentheses_list:
            return False
        return True

