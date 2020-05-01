package q24;

import utils.ListNode;

public class Solution2 {
    public ListNode swapPairs(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode first = head;
        ListNode second = first.next;
        first.next = swapPairs(second.next);
        second.next = first;
        return second;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        ListNode a = ListNode.fromListArray(new int[]{1, 2, 3, 4, 5});
        ListNode res = s.swapPairs(a);
        System.out.println("done");
        res.printNode();
    }
}
