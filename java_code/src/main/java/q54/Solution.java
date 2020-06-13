package q54;

import jdk.nashorn.internal.ir.CaseNode;

import java.util.ArrayList;
import java.util.List;

/*
输入:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
输出: [1,2,3,6,9,8,7,4,5]
示例 2:

输入:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
输出: [1,2,3,4,8,12,11,10,9,5,6,7]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/spiral-matrix
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    //执行用时 :
    //0 ms
    //, 在所有 Java 提交中击败了
    //100.00%
    //的用户
    public List<Integer> spiralOrder(int[][] matrix) {
        int rowLen = matrix.length;
        if (rowLen == 0) {
            return new ArrayList<>();
        }
        int colsLen = matrix[0].length;
        int c = 0;
        int r = 0;
        String go = colsLen == 1 ?  "down"  : "right";
        int top = 0, right=colsLen - 1, left=0, down=rowLen - 1;
        List<Integer> result = new ArrayList<>();
        for (int i=0; i<colsLen * rowLen; i++) {
            result.add(matrix[r][c]);
            switch (go) {
                case "right":
                    c ++;
                    if (c == right) {
                        go = "down";
                        top++;
                    }
                    break;
                case "left":
                    c --;
                    if (c == left) {
                        go = "up";
                        down --;
                    }
                    break;
                case "down":
                    r ++;
                    if (r == down) {
                        go = "left";
                        right --;
                    }
                    break;
                case "up":
                    r --;
                    if (r == top) {
                        go = "right";
                        left ++;
                    }
                    break;

            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] ints = {new int[]{1, 2, 3},
                        new int[]{4, 5, 6},
                        new int[]{7, 8, 9}};
        List<Integer> s = solution.spiralOrder(ints);
        System.out.println(s);
    }
}
