package q67;

/*
给你两个二进制字符串，返回它们的和（用二进制表示）。

输入为 非空 字符串且只包含数字 1 和 0。

 

示例 1:

输入: a = "11", b = "1"
输出: "100"
示例 2:

输入: a = "1010", b = "1011"
输出: "10101"
 

提示：

每个字符串仅由字符 '0' 或 '1' 组成。
1 <= a.length, b.length <= 10^4
字符串如果不是 "0" ，就都不含前导零。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/add-binary
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int add = 0;
        StringBuilder result = new StringBuilder();
        while (true) {
            if (i < 0 && j < 0) {
                break;
            }
            char curentA = i >= 0 ? a.charAt(i) : '0';
            char curentB = j >= 0 ? b.charAt(j) : '0';
            i --;
            j --;
            int sum = (curentA - '0') + (curentB - '0') + add;
            switch (sum) {
                case 0:
                    result.append("0");
                    add = 0;
                    break;
                case 1:
                    result.append("1");
                    add = 0;
                    break;
                case 2:
                    result.append("0");
                    add = 1;
                    break;
                case 3:
                    result.append("1");
                    add = 1;
                    break;
            }
        }
        if (add != 0) {
            result.append(add);
        }
        return result.reverse().toString();
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.addBinary("11", "1");
        System.out.println(s);

    }

}
