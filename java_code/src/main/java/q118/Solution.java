package q118;

import com.sun.rowset.internal.Row;

import java.util.ArrayList;
import java.util.List;

/*
118. 杨辉三角
给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。



在杨辉三角中，每个数是它左上方和右上方的数的和。

示例:

输入: 5
输出:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 */
public class Solution {
    // 普通两层for, 0ms
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        for (int j = 0; j < numRows; j++) {
            ArrayList<Integer> tempResult = new ArrayList<>(j+1);
            for (int i = 0; i < j + 1; i++) {
                if (i == 0 || i == j) {
                    tempResult.add(1);
                } else {
                    List<Integer> topResult = result.get(j - 1);
                    tempResult.add(topResult.get(i - 1) + topResult.get(i));
                }
            }
            result.add(tempResult);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> result = s.generate(5);
        System.out.println(result);
    }
}
