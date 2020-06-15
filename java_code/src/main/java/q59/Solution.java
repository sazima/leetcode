package q59;

import java.util.Arrays;

/*
给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。

示例:

输入: 3
输出:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/spiral-matrix-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        int top = 0;
        int right = n - 1;
        int left = 0;
        int bottom = n - 1;
        String go = "right";
        int[][] result = new int[n][n];
        int r = 0;  // row 行
        int c = 0;  // colume 列
        for (int i=1; i<=n*n; i++) {
            result[r][c] = i;
            switch (go) {
                case "right":
                    c ++;
                    if (c == right) {
                        go = "down";
                        top ++;
                    }
                    break;
                case "down":
                    r ++;
                    if (r == bottom) {
                        go = "left";
                        right --;
                    }
                    break;
                case "left":
                    c --;
                    if (c == left) {
                        bottom --;
                        go = "up";
                    }
                    break;
                case "up":
                    r --;
                    if (r == top) {
                        left ++;
                        go = "right";
                    }
                    break;

            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] res = s.generateMatrix(3);
        System.out.println(Arrays.deepToString(res));
    }
}
