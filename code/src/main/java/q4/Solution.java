package q4;


import java.util.ArrayList;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int start1 = 0, start2 = 0, totalStart = 0;
        int len1 = nums1.length, len2 = nums2.length;
        int totalLen = len1 + len2;
        Integer middleIndex = (totalLen - 1) / 2;
        boolean oneMiddle = totalLen % 2 != 0;  // 中位数是不是一个数
        ArrayList<Integer> newList = new ArrayList<>();
        boolean num1IsEnd = len1 == 0;  // 循环中第一个列表是否结束
        boolean num2IsEnd = len2 == 0;

        while (true) {
            int newListSize = newList.size();
            if (num2IsEnd || (!num1IsEnd && nums1[start1] < nums2[start2] )) {
                newList.add(nums1[start1]);
                num1IsEnd = start1 == len1 - 1;
                start1 += 1;
            } else {
                newList.add(nums2[start2]);
                num2IsEnd = start2 == len2 - 1;
                start2 += 1;
            }
            newListSize += 1;
            if (oneMiddle && middleIndex == totalStart) {
                return newList.get(newListSize - 1);
            } else if (!oneMiddle && middleIndex + 1 == totalStart) {
                return ((double) newList.get(newListSize - 1) + newList.get(newListSize - 2)) / 2;
            }
            totalStart += 1;
        }
    }

    public static void main(String[] args) {
        int[] l1 = {0, 0};
        int[] l2 = {0, 0};
        double res = new Solution().findMedianSortedArrays(l1, l2);
        System.out.println(res);

    }
}
