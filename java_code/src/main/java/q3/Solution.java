package q3;


import java.util.HashMap;
import java.util.Map;

public class Solution {
    // 请你找出其中不含有重复字符的 最长子串 的长度。
    public static int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        int i = 0;
        for (int j = 0; j < len; j++) {
            char currentValue = s.charAt(j);

            if (map.containsKey(currentValue)) {
                i = Math.max(map.get(currentValue), i);
            }

            ans = Math.max(j - i + 1, ans);
            map.put(currentValue, j + 1);
        }
        return ans;
    }

}
