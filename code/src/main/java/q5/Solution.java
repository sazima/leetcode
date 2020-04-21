package q5;

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
class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len == 0) {
            return "";
        }
        String result = String.valueOf(s.charAt(0));
        for (int i = len - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) != s.charAt(j)) {
                    continue;
                }
                if (i - j < result.length()) {
                    continue;
                }
                String jToi = s.substring(j, i + 1);
                if (jToi.equals(new StringBuilder(jToi).reverse().toString())) {
                    result = jToi;
                }
            }
        }
        return result;
    }
     public static void main(String[] args) {
        System.out.println(new Solution ().longestPalindrome("babad"));
     }
}
