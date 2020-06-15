package q41;

import javax.xml.transform.Result;

/*
给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
示例 1:

输入: [1,2,0]
输出: 3
示例 2:

输入: [3,4,-1,1]
输出: 2
示例 3:

输入: [7,8,9,11,12]
输出: 1

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/first-missing-positive
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;

        int oneCount = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 1) {
                oneCount++;
                break;
            }
        }
        if (oneCount == 0) {
            return 1;
        }
        if (len == 1) {
            return 2;
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] <= 0 || nums[i] > len) {
                nums[i] = 1;
            }
        }
        for (int i = 0; i < len; i++) {
            int currentValue = Math.abs(nums[i]);

            if (currentValue == len) {
                nums[0] = -1 * Math.abs(nums[0]);
            } else {
                nums[currentValue] = -1 * Math.abs(nums[currentValue]);  // 如果出现了这个整数, 那么对应索引的值会变成负数
            }
        }
        for (int i = 1; i < len; i++) {
            if (nums[i] > 0) {
                return i;
            }
        }
        if (nums[0] > 0) {
            return len;
        }
        return len + 1;

    }

    public static void main(String[] args) {
        int[] a = {0, -1, 3, 1};
        Solution solution = new Solution();
        int i = solution.firstMissingPositive(a);
        System.out.println(i);
    }
}
