package q20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/*
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

示例 1:

输入: "()"
输出: true
示例 2:

输入: "()[]{}"
输出: true
示例 3:

输入: "(]"
输出: false
示例 4:

输入: "([)]"
输出: false
示例 5:

输入: "{[]}"
输出: true

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    HashMap<String, String> map = new HashMap<String, String>() {{
        put("(", ")");
        put("[", "]");
        put("{", "}");
    }};

    public boolean isValid(String s) {


        /*
        执行用时 :
        2 ms
        , 在所有 Java 提交中击败了
        86.93%
        的用户
        内存消耗 :
        38.1 MB
        , 在所有 Java 提交中击败了
        5.48%
        的用户
         */
        ArrayList<String> result = new ArrayList<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            String currentValue = String.valueOf(s.charAt(i));
            // 如果出现了左括号， 则判断右括号是否匹配
            if (result.size() > 0) {
                if (map.containsKey(currentValue)) {
                    String lastValue = result.remove(result.size() - 1);
                    if (!Objects.equals(lastValue, map.get(currentValue))) {
                        return false;
                    }
                } else {
                    result.add(currentValue);
                }
            } else {
                result.add(currentValue);
            }

        }
        return result.size() == 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String a = "{[]}";
        boolean valid = s.isValid(a);
        System.out.println(valid);
    }
}
