package q7;

import java.util.ArrayList;

/*

给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

示例 1:

输入: 123
输出: 321
 示例 2:

输入: -123
输出: -321
示例 3:

输入: 120
输出: 21
注意:

假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class Solution2 {
    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        int a = 1; // 除数
        int result = 0;
        while (true) {
            int currentValue = x / a % 10;  // 当前位数值
            result = result * 10 + currentValue;
            if ((a > x / 10 &&  x > 0) || (-a < x / 10 && x < 0)) {  // 判断是否到了最大位
                break;
            }
            if (result > Integer.MAX_VALUE / 10) {  // 会不会溢出
                return 0;
            }
            if (result < Integer.MIN_VALUE / 10) { // 会不会溢出
                return 0;
            }
            a *= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        int a = -1;
//        System.out.println(Integer.parseInt("9646324351"));
        Solution2 s2 = new Solution2();
        System.out.println(s2.reverse(a));
//        System.out.println(String.valueOf(a));
    }
}
