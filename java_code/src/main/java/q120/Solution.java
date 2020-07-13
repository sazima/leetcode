package q120;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
120. 三角形最小路径和
给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。

相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。



例如，给定三角形：

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。



说明：

如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 */
public class Solution {
    // 3ms 74%, 动态规划
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        if (row == 0) {
            return 0;
        }
        int column = triangle.get(row - 1).size();

        int[][] dp = new int[row][column];

        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < row; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i-1][j] + triangle.get(i).get(j);
                } else if(i == j) {
                    dp[i][j] = dp[i-1][j-1] + triangle.get(i).get(j);
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1]) + triangle.get(i).get(j);
                }
            }
        }
        int res = dp[row - 1][0];
        for (int i = 1; i<column; i++) {
            res = Math.min(res, dp[row -1][i]);
        }
        return res;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        ArrayList<List<Integer>> a = new ArrayList<>();
        a.add(Collections.singletonList(2));
        a.add(Arrays.asList(3, 4));
        a.add(Arrays.asList(6, 5, 7));
        a.add(Arrays.asList(4, 1, 8, 3));
        int res = solution.minimumTotal(a);
        System.out.println(res);

    }
}
