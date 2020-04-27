package q15;

import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;

import javax.swing.tree.VariableHeightLayoutCache;
import java.lang.reflect.Array;
import java.util.*;

/*
给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。

 

示例：

给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/3sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < len - 1; i++) {
            int currentValue = nums[i];
            if (currentValue > 0) {
                break;
            }
            if (i > 0 && currentValue == nums[i - 1]) {  // 避免重复值
                continue;
            }
            int L = i + 1;
            int R = len - 1;
            while (L < R) {

                int tempSum = nums[L] + nums[R] + currentValue;
                if (tempSum == 0) {
                    result.add(Arrays.asList(nums[L], currentValue, nums[R]));
                    L++;
                    while (L < R - 1 && nums[L] == nums[L - 1]) {  // 跳过重复值
                        L++;
                    }
                    R--;
                    while (R > L + 1 && nums[R] == nums[R + 1]) { // 跳过重复值
                        R--;
                    }
                } else if (tempSum < 0) {
                    L++;
                    while (L < R - 1&& nums[L] == nums[L - 1]) {  // 跳过重复值
                        L++;
                    }
                } else {
                    R--;
                    while (R > L + 1 && nums[R] == nums[R + 1]) {  // 跳过重复值
                        R--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] a = {-1, 0, 1, 2, -1, -4};
        int[] a = {0, 0, 0};
        List<List<Integer>> lists = solution.threeSum(a);
        System.out.println(lists);

    }


}
