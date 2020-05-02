package q29;

/*
给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。

返回被除数 dividend 除以除数 divisor 得到的商。

整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2

 

示例 1:

输入: dividend = 10, divisor = 3
输出: 3
解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
示例 2:

输入: dividend = 7, divisor = -3
输出: -2
解释: 7/-3 = truncate(-2.33333..) = -2

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/divide-two-integers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.time.chrono.MinguoChronology;

public class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (divisor == 1) {
            return dividend;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (divisor == -1) {
            return -dividend;
        }
        boolean isNegative = false;
        if ((dividend < 0 && divisor > 0) || ((dividend > 0 && divisor < 0))) {
            isNegative = true;
        }
        long a = dividend;
        long b = divisor;
        a = a > 0 ? a : -a;
        b = b > 0 ? b : -b;
        long res = div(a, b);
        return (int) (isNegative ? -res : res);
    }

    private long div(long a, long b) {
        if (a < b) {
            return 0;
        }
        long count = 1;
        long tb = b;
        // 比如13/2
        while (true) {
            if (tb + tb > a) {
                break;
            }
            tb = tb + tb;
            count = count + count;
        }
        return count + div(a - tb, b);
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int div = s.divide(-2147483648, 2);
        System.out.println(div);
    }
}
