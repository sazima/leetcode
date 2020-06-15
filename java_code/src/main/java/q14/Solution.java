package q14;

import javax.swing.tree.VariableHeightLayoutCache;

/*

编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1:

输入: ["flower","flow","flight"]
输出: "fl"
示例 2:

输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。
说明:

所有输入只包含小写字母 a-z
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        if (length == 0) {
            return "";
        }
        String firstStr = strs[0];
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < firstStr.length(); i++) {
            char c = firstStr.charAt(i);
            for (int j = 1; j < length; j++) {
                if (strs[j].length() - 1 < i || strs[j].charAt(i) != c) {
                    return result.toString();
                }
            }
            result.append(c);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"aa", "a"};
        Solution s = new Solution();
        System.out.println(s.longestCommonPrefix(strs));

    }
}
