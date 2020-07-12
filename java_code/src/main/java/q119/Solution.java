package q119;

import java.util.ArrayList;
import java.util.List;

/*
给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。



在杨辉三角中，每个数是它左上方和右上方的数的和。

示例:

输入: 3
输出: [1,3,3,1]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/pascals-triangle-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> result = new ArrayList<>(rowIndex + 1);

        for (int i=0; i<rowIndex + 1; i++) {
            result.add(0);
        }

        for (int i = 0; i < rowIndex + 1; i++) {
            for (int j=i; j>=0; j--) {
                if (j == 0 || j == i) {
                    result.set(j, 1);
                } else {
                    result.set(j, result.get(j-1) + result.get(j));
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Integer> result = s.getRow(3);
        System.out.println(result);
    }
}
