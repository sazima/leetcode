package q62;

/*
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

问总共有多少条不同的路径？



例如，上图是一个7 x 3 的网格。有多少可能的路径？

 

示例 1:

输入: m = 3, n = 2
输出: 3
解释:
从左上角开始，总共有 3 条路径可以到达右下角。
1. 向右 -> 向右 -> 向下
2. 向右 -> 向下 -> 向右
3. 向下 -> 向右 -> 向右
示例 2:

输入: m = 7, n = 3
输出: 28
 

提示：

1 <= m, n <= 100
题目数据保证答案小于等于 2 * 10 ^ 9
通过次数103,768提交次数171,655

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/unique-paths
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    private int result = 0;

    // 回溯法 超时
    public int uniquePaths(int m, int n) {
        backtrack(1, 1, m, n);
        return result;
    }

    private void backtrack(int rightCount, int downCount, int m, int n) {
        if (rightCount == m && downCount == n) {
            result ++;
        }
        if (rightCount < m) {
            backtrack(rightCount + 1, downCount, m, n);
        }
        if (downCount < n) {
            backtrack(rightCount, downCount + 1, m, n);
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int i = s.uniquePaths(25, 9);
        System.out.println(i);
    }

}
