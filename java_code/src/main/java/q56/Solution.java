package q56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/*
给出一个区间的集合，请合并所有重叠的区间。

示例 1:

输入: [[1,3],[2,6],[8,10],[15,18]]
输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例 2:

输入: [[1,4],[4,5]]
输出: [[1,5]]
解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-intervals
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int[][] merge(int[][] intervals) {
        Comparator<int[]> c = Comparator.comparingInt(o -> ((int[]) o)[0]);
        Arrays.sort(intervals, c);
        int len = intervals.length;
        if (len == 0) {
            return new int[][]{};
        }
        ArrayList<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        for (int i = 1; i < len; i++) {
            int[] currentValue = intervals[i];
            int[] lastResult = result.get(result.size() - 1);
            if (lastResult[1] >= currentValue[0]) {
//                lastResult[0] = Math.min(lastResult[0], currentValue[0]);
                lastResult[1] = Math.max(lastResult[1], currentValue[1]);
            } else {
                result.add(currentValue);
            }
        }
        return result.toArray(new int[0][]);

    }

    public static void main(String[] args) {
        int[][] a = {{1, 3}, {0, 0}};
        Solution s = new Solution();
        int[][] res = s.merge(a);
        System.out.println(Arrays.deepToString(res));

    }
}
