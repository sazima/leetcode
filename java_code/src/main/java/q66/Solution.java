package q66;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/*
给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

你可以假设除了整数 0 之外，这个整数不会以零开头。

示例 1:

输入: [1,2,3]
输出: [1,2,4]
解释: 输入数组表示数字 123。
示例 2:

输入: [4,3,2,1]
输出: [4,3,2,2]
解释: 输入数组表示数字 4321。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/plus-one
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        if (len == 0) {
            return new int[]{1};
        }
        int sum = digits[len - 1] + 1;
        digits[len - 1] = sum % 10;
        int add = sum / 10;
        for (int i = len - 2; i >= 0; i--) {
            if (add == 0) {
                return digits;
            }
            int tempSum = digits[i] + add;
            digits[i] = tempSum % 10;
            add = tempSum / 10;
        }

        if (add > 0) {
            int[] result = new int[len + 1];
            result[0] = add;
            System.arraycopy(digits, 0, result, 1, len);
            return result;
        } else {
            return digits;
        }
    }

    public int[] plusOne1(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = digits[i] + 1;
            digits[i] = digits[i] % 10;
            // 不是0的话说明没有进位, 直接停止
            if (digits[i] != 0) {
                return digits;
            }
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] ints = s.plusOne(new int[]{1, 9});

        System.out.println(Arrays.toString(ints));
    }
}
