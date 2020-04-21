package q6;

import java.util.ArrayList;
import java.util.List;

/*


将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。

比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：

L   C   I   R
E T O E S I I G
E   D   H   N
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。

请你实现这个将字符串进行指定行数变换的函数：

string convert(string s, int numRows);
示例 1:

输入: s = "LEETCODEISHIRING", numRows = 3
输出: "LCIRETOESIIGEDHN"
示例 2:

输入: s = "LEETCODEISHIRING", numRows = 4
输出: "LDREOEIIECIHNTSG"
解释:

L0    D6    R
E1  O E   I I
E2 C  I H   N
T3    S9    G

*/
class Solution {
    public String convert(String s, int numRows) {
        if (s.length() == 1 || numRows == 1) {
            return s;
        }
        ArrayList<StringBuilder> stringBuildersRows = new ArrayList<>();
        for (int i=0; i<numRows; i++) {
            stringBuildersRows.add(new StringBuilder());
        }
        int currentRow = 0;
        String redirect = "down";
        for (int i=0; i<s.length(); i++) {
            stringBuildersRows.get(currentRow).append(s.charAt(i));
            int div = currentRow / (numRows - 1);
            int remain = currentRow % (numRows - 1);
            if (i != 0 && remain == 0 && div % 2 == 0) {  // 转为向下
                redirect = "down";
            }
            if (i != 0 && remain == 0 && div % 2 == 1) {
                redirect = "up";
            }
            if (redirect.equals("up")) {  // 向上
                currentRow --;
            }else{ // 向下
                currentRow ++;
            }
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder row: stringBuildersRows) {
            result.append(row);
        }
        return result.toString();
    }
    public static void main(String[] args) {
        String s = "LEETCODEISHIRING";
        int n = 4;
        Solution solution = new Solution();
        System.out.print(solution.convert(s, n));

    }
}
