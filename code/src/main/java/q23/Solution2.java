package q23;

import utils.ListNode;

public class Solution2 {
    // 分而治之, 超过95%
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len ==0) {
            return null;
        }
        int count = 1;
        // 比如有3个，  count =1; 0，1合并 ->  count =2; 0, 2合并  -> count =4; 完成
        // 比如有6个  count =1;  0,1合并,23合并,45合并 -> count=2  02,46...
        while (count <= len) {
            for (int i=0; i<len - count; i += count * 2) {
                lists[i] = mergeTwoLists(lists[i], lists[i + count]);
            }
            count *= 2;
        }
        return lists[0];
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode a = l1;
        ListNode b = l2;
        ListNode res = new ListNode(0);
        ListNode res1 = res;
        while (a != null || b != null) {
            if (a != null && b != null) {
                if (a.val > b.val) {
                    res.next = b;
                    b = b.next;
                } else {
                    res.next = a;
                    a = a.next;
                }
            } else if (a == null) {
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
        Solution2 solution = new Solution2();
        ListNode node1 = ListNode.fromArray(new int[]{1, 4, 5});
        ListNode node2 = ListNode.fromArray(new int[]{1, 3, 4});
        ListNode node3 = ListNode.fromArray(new int[]{2, 6});
        ListNode[] a = {node1, node2, node3};
        solution.mergeKLists(a);

    }
}
