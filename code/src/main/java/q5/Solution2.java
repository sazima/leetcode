package q5;

import sun.security.util.Length;

/*
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：
输入: "cbbd"
输出: "bb"
 */
class Solution2 {
    public String longestPalindrome(String s) {
        if (s.length() == 0) {
            return "";
        }
        int start = 0;
        int end = 0;
        for (int j = 0; j < s.length(); j++) {
            int len = expandAroundCenter(s, j, j);
            int len2 = expandAroundCenter(s, j, j+1);
            len = Math.max(len, len2);
            if (len > end - start) {
                start = j - (len - 1) / 2;
                end = j + len  / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int l, int r) {
        int left = l;
        int right = r;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left --;
            right ++;
        }
        return right - left - 1;
    }
    public static void main(String[] args) {
        System.out.println(new Solution2().longestPalindrome("babad"));
    }
}
