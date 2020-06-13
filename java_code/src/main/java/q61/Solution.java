package q61;

import utils.ListNode;

import java.util.ArrayList;
import java.util.List;

/*
给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。

示例 1:

输入: 1->2->3->4->5->NULL, k = 2
输出: 4->5->1->2->3->NULL
解释:
向右旋转 1 步: 5->1->2->3->4->NULL
向右旋转 2 步: 4->5->1->2->3->NULL
示例 2:

输入: 0->1->2->NULL, k = 4
输出: 2->0->1->NULL
解释:
向右旋转 1 步: 2->0->1->NULL
向右旋转 2 步: 1->2->0->NULL
向右旋转 3 步: 0->1->2->NULL
向右旋转 4 步: 2->0->1->NULL

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/rotate-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null  || k == 0) {
            return head;
        }
        List<ListNode> list = new ArrayList<>();
        ListNode currentNode = head;
        while (currentNode != null) {
            list.add(currentNode);
            currentNode = currentNode.next;
        }
        int listSize = list.size();
        k = k % listSize;
        // 保持原样
        if (k == 0) {
            return head;
        }
        // 最后一个指向第一个
        ListNode last = list.get(listSize - 1);
        last.next = head;
        // 倒数第k + 1个指向为null
        ListNode lastK = list.get(listSize - k - 1);
        lastK.next = null;
        return list.get(listSize - k);
    }

    public static void main(String[] args) {
        ListNode a = ListNode.fromArray(new int[]{1, 2});
        Solution solution = new Solution();
        ListNode res = solution.rotateRight(a, 1);
        res.printNode();

    }
}
