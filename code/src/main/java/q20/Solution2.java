package q20;

import java.util.HashMap;
import java.util.Objects;
import java.util.Stack;

public class Solution2 {
    HashMap<String, String> map = new HashMap<String, String>(){{
        put(")", "(");
        put("]", "[");
        put("}", "{");
    }};

    /*
    执行用时 :
    3 ms
    , 在所有 Java 提交中击败了
    44.28%
    的用户
     */
    public boolean isValid(String s) {
        Stack<String> stack = new Stack<>();

        for(int i =0; i< s.length(); i++) {
            String currentValue = String.valueOf(s.charAt(i));

            // 如果出现了右括号， 则判断栈顶的左括号是否匹配
            // {}()[]
            if (stack.size() > 0) {
                if (map.containsKey(currentValue)) {
                    String topElement = stack.pop();
                    if (!Objects.equals(topElement, map.get(currentValue))) {
                        return false;
                    }
                } else {
                    stack.push(currentValue);
                }
            } else {
                stack.push(currentValue);
            }
        }
        return stack.isEmpty();
    };

    public static void main(String[] args) {
        String a = "{[]}";
        boolean res = new Solution2().isValid(a);
        System.out.println(res);
    }
}
