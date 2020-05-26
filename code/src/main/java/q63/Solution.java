package q63;

public class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length; // 竖直方向
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            } else {
                dp[i][0] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            } else
                dp[0][i] = 1;
        }
        for (int j=1; j<n; j++) {
            for (int i=1; i<m; i++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0; // 当出现１时候，表示有障碍，设值为 0
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        int res = s.uniquePathsWithObstacles(new int[][]{{1}});
        int res = s.uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}});
        System.out.println(res);

    }
}
