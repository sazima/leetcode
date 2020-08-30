package q166;

import java.util.HashMap;
import java.util.Map;

/*
给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以字符串形式返回小数。

如果小数部分为循环小数，则将循环的部分括在括号内。

示例 1:

输入: numerator = 1, denominator = 2
输出: "0.5"
示例 2:

输入: numerator = 2, denominator = 1
输出: "2"
示例 3:

输入: numerator = 2, denominator = 3
输出: "0.(6)"

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/fraction-to-recurring-decimal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    private Map<Long, Integer> remainIndexMap = new HashMap<>();

    // 18ms 16%
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        boolean isNegative =  ((numerator < 0 && denominator > 0 )|| (numerator >0 && denominator < 0)) ;
        long intNumber = Math.abs((long) numerator) / Math.abs((long) denominator);
        long remain = Math.abs((long) numerator) % Math.abs((long) denominator);

        String absResult;
        if (remain == 0){
            absResult = String.valueOf(intNumber);
        } else {
            absResult = intNumber + "." + calculatePoint((long) remain * 10, Math.abs((long) denominator), 0, new StringBuilder());
        }
        return isNegative ? "-" + absResult : absResult;
    }
    public String calculatePoint(long remain, long denominator, int index, StringBuilder result) {
        if (remainIndexMap.containsKey(remain)) {
            Integer i = remainIndexMap.get(remain);
            return result.substring(0, i) + "(" + result.substring(i) + ")";

        } else {
            remainIndexMap.put(remain, index);
            result.append(remain / denominator);
            remain = remain % denominator;
            if (remain == 0) {
                return result.toString();
            }
            return calculatePoint(remain * 10, denominator, index + 1, result);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.fractionToDecimal(-1, -2147483648);
        System.out.println(s);

    }
}
