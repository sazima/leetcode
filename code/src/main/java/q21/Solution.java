package q21;

/*
将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

示例：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        boolean l1End = l1 == null;
        ListNode a = l1;
        ListNode b = l2;
        ListNode res = new ListNode(0);
        ListNode res1 = res;
        while (a != null || b != null) {
            if (a!=null && b!=null) {
                if (a.val > b.val) {
                    res.next = b;
                    b = b.next;
                } else {
                    res.next = a;
                    a = a.next;
                }
            }else if (a == null) {
                res.next = b;
                break;
            } else {
                res.next = a;
                break;
            }
            res = res.next;
        }
        return res1.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;

        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(4);
        n1.next = n5;
        n5.next = n6;
        ListNode l = s.mergeTwoLists(n1, n2);
        ListNode next = l;
        while (true){
            if (next == null) {
                break;
            }
            System.out.println(next.val);
            next = next.next;
        }
    }

}
