package q77;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

示例:

输入: n = 4, k = 2
输出:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/combinations
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    private final List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(1, n, k, new ArrayList<>());
        return result;
    }

    private void backtrack(int start, int n, int k, List<Integer> current) {
        if (current.size() == k) {
            result.add(current);
            return;
        }
        for (int i = start; i <= n - (k - current.size()) + 1; i++) {  // 剪枝
            ArrayList<Integer> newCurrent = new ArrayList<>(current);
            newCurrent.add(i);
            backtrack(i + 1, n, k, newCurrent);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> result = s.combine(4, 2);
        System.out.println(result);

    }
}
