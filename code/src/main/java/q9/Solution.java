package q9;

import java.rmi.Remote;

/*
判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

示例 1:

输入: 121
输出: true
示例 2:

输入: -121
输出: false
解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
示例 3:

输入: 10
输出: false
解释: 从右向左读, 为 01 。因此它不是一个回文数。
进阶:

你能不将整数转为字符串来解决这个问题吗？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/palindrome-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    /*
    思路是从个位开始读数字, 将低位数字放到高位, 看最后的新数与原来的数是否相同
     */
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int temp = 1;  // 一个倍数, 用来获取当前位数字
        int reverseInt = 0;
        while (true) {
            int currentValue = x / temp % 10;  // 当前位数字
            reverseInt = reverseInt * 10 + currentValue;
            if (x / 10 < temp) {  // 遍历完毕
                break;
            }
            temp *= 10;
        }
        //
        System.out.println(reverseInt);
        return reverseInt == x;
    }

    public static void main(String[] args) {
        int a = 1410110141;
        Solution s = new Solution();
        System.out.println(s.isPalindrome(a));
    }
}
