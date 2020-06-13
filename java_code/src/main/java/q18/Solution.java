package q18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。

注意：

答案中不可以包含重复的四元组。

示例：

给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。

满足要求的四元组集合为：
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/4sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {

    // 双指针
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        if (len < 4) {
            return new ArrayList<>();
        }
        ArrayList<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < len - 2; i++) {
            if ( i != 0 && nums[i] == nums[i-1]) {
                continue;
            }
            for (int j = i + 1; j < len - 1; j++) {
                if (j != i+1 && nums[j] == nums[j-1]) {
                    continue;
                }
                int sum1 = nums[i] + nums[j];
                int L = j + 1;
                int R = len - 1;
                while (L < R) {
                    if (nums[L] + nums[R] + sum1 == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[L], nums[R]));
                        R --;
                        while (nums[R] == nums[R + 1] && R > L) {
                            R--;
                        }
                        L ++;
                        while (nums[L] == nums[L - 1] && R > L) {
                            L ++;
                        }
                    }else if (nums[L] + nums[R] + sum1 > target) {
                        R --;
                    } else {
                        L ++;
                    }
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = {1, 0, -1, 0, -2, 2};
        List<List<Integer>> res = s.fourSum(a, 0);
        System.out.println(res);


    }


}
