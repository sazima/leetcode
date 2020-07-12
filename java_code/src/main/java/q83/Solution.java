package q83;


import utils.ListNode;

/*
83. 删除排序链表中的重复元素
给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。

示例 1:

输入: 1->1->2
输出: 1->2
示例 2:

输入: 1->1->2->3->3
输出: 1->2->3

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode result = new ListNode(head.val);
        ListNode resultTail = result;  // 尾部

        ListNode current = head;

        while (null != current) {
            if (current.val == resultTail.val) {
                current = current.next;
            } else {
                resultTail.next = new ListNode(current.val);
                current = current.next;
                resultTail = resultTail.next;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode = ListNode.fromArray(new int[]{1, 1, 2, 3, 4, 5});
        ListNode result = solution.deleteDuplicates(listNode);
        result.printNode();

    }
}
