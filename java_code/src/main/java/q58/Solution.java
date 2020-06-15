package q58;

/*
给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。

如果不存在最后一个单词，请返回 0 。

说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。

 

示例:

输入: "Hello World"
输出: 5

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/length-of-last-word
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    // slow
    public int lengthOfLastWord(String s) {
        int result = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (i != len - 1) {

                if (s.charAt(i) == ' ') {
                    if (s.charAt(i + 1) != ' ') {
                        result = 0;
                    }
                } else {
                    result++;
                }

            } else {
                if (s.charAt(i) != ' ') {
                    result++;
                }
            }
        }
        return result;
    }


    public int lengthOfLastWord2(String s) {
        String[] s1 = s.split(" ");
        if (s1.length == 0) {
            return 0;
        } else {
            return s1[s1.length - 1].length();
        }

    }

    // 0 ms
    public int lengthOfLastWord3(String s) {
        int result = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (result == 0) {
                    continue;
                } else {
                    return result;
                }
            } else {
                result += 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int re = s.lengthOfLastWord3("     h   ");
        System.out.println(re);
    }
}
