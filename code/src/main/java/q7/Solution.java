package q7;

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
class Solution {
    public int reverse(int x) {
        String stringResult = "";
        if (x < 0) {
            stringResult =  "-" + new StringBuilder().append(x * -1).reverse().toString();
        } else {
            stringResult = new StringBuilder().append(x).reverse().toString();
        }
        try {
            return Integer.parseInt(stringResult);
        }catch (Exception e) {
            return 0;
        }
    }
    public static void main(String[] args) {
        int a = 1534236469;
//        System.out.println(Integer.parseInt("9646324351"));
        Solution solution = new Solution();
        System.out.println(solution.reverse(a));
//        System.out.println(String.valueOf(a));
    }
}
