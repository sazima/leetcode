package q82;

import utils.ListNode;


/*
删除排序链表中的重复元素 II
给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。

示例 1:

输入: 1->2->3->3->4->4->5
输出: 1->2->5
示例 2:

输入: 1->1->1->2->3
输出: 2->3

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode result = null;
        ListNode resultTail =  null;

        ListNode current = head;

        while (current != null) {

            while (current != null) {
                if (current.next != null && current.val == current.next.val) {
                    int val = current.val;
                    while (current != null && current.val == val) {  // 跳过重复的
                        current = current.next;
                    }
                } else {
                    break;
                }
            }
            if (current == null) {
                break;
            }
            if (resultTail == null) {
                result = new ListNode(current.val);
                resultTail = result;
            } else {
                resultTail.next = new ListNode(current.val);
                resultTail = resultTail.next;
            }
            current = current.next;
        }
        return result;
    }

    public static void main(String[] args) {
//        ListNode listNode = ListNode.fromArray(new int[]{1, 2, 3, 3, 4, 4, 5});
        ListNode listNode = ListNode.fromArray(new int[]{1, 1});
        Solution solution = new Solution();
        ListNode res = solution.deleteDuplicates(listNode);
        res.printNode();

    }
}
