package q131;

import java.util.ArrayList;
import java.util.List;

/*
131. 分割回文串
给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。

返回 s 所有可能的分割方案。

示例:

输入: "aab"
输出:
[
  ["aa","b"],
  ["a","a","b"]
]
 */
public class Solution {
    private List<List<String>> result = new ArrayList<>();

    // 5ms, 25% , 回溯法
    public List<List<String>> partition(String s) {
        dps(s, new ArrayList<>());
        return result;
    }
    private void dps(String s,  ArrayList<String> tmp) {
        if (s == null || s.length() == 0) {
            result.add(new ArrayList<>(tmp));
        }
        for (int i=1; i<=s.length(); i++) {
            if (isPalidrome(s.substring(0, i))) {
                tmp.add(s.substring(0, i));
                dps(s.substring(i, s.length()), tmp);
                tmp.remove(tmp.size() - 1);
            }
        }

    }
    private  boolean isPalidrome(String sb) {
        int left = 0;
        int right = sb.length() - 1;
        while (left < right) {
            if (sb.charAt(left) != sb.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<String>> res = s.partition("aab");
        System.out.println(res);
    }
}
