package q70;

public class Solution2 {

    // 动态规划 执行用时 :
    //0 ms
    //, 在所有 Java 提交中击败了
    //100.00%
    //的用户
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        int[] dps = new int[n];
        dps[0] = 1;
        dps[1] = 2;
        for (int i=2; i<n; i++) {
            dps[i] = dps[i - 1] + dps[i - 2];
        }
        return dps[n-1];
    }
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int i = solution2.climbStairs(44);
        System.out.println(i);
    }
}
