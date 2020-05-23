package q60;

import javax.swing.text.StyledEditorKit;
import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.List;

/*
给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。

按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：

"123"
"132"
"213"
"231"
"312"
"321"
给定 n 和 k，返回第 k 个排列。

说明：

给定 n 的范围是 [1, 9]。
给定 k 的范围是[1,  n!]。
示例 1:

输入: n = 3, k = 3
输出: "213"
示例 2:

输入: n = 4, k = 9
输出: "2314"

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/permutation-sequence
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    //执行用时 :
    //2 ms
    //, 在所有 Java 提交中击败了
    //84.80%
    //的用户
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();  // 原始数字
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
            factorial *= i;
        }
        StringBuilder result = new StringBuilder();
        k --;
        while (n != 0) {
//            int remainSize = numbers.size();
            //            if (remainSize == 0) {
//                break;
//            }
            // 比如n为3, 刚开始每两个数( 1* 2)一组, 然后每一个(1)数一组, 然后剩下最后一个数
            factorial /= n;
            int index = k / factorial;
            k = k % factorial;
            result.append(numbers.remove(index));
            n--;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String res = solution.getPermutation(4, 1);
        System.out.println(res);

    }
}
