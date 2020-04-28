package q17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。



示例:

输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    ArrayList<String> result = new ArrayList<>();
    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    public List<String> letterCombinations(String digits) {
        if (!digits.equals("")) {
            backtrack("", digits);
        }
        return result;
    }

    /**
     * @param before     已经组合的字符串
     * @param nextDigits 剩下的数字们
     */
    public void backtrack(String before, String nextDigits) {
        if (nextDigits.length() == 0) {
            result.add(before);
            System.out.println(before);
        } else {
            String next = nextDigits.substring(0, 1);
            String letters = phone.get(next);
            for (int i = 0; i < letters.length(); i++) {
                String currentLetter = letters.substring(i, i + 1);
                backtrack(before + currentLetter, nextDigits.substring(1));
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String a= "23";
        List<String> strings = s.letterCombinations(a);
        System.out.println(strings);
    }

}
