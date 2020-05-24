package q23;

import utils.ListNode;

import java.util.*;

/*
合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

示例:

输入:
[
  1->4->5,
  1->3->4,
  2->6
]
输出: 1->1->2->3->4->4->5->6

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    // 暴力解法执行用时：2617 ms
    //内存消耗：42.3 MB
    public ListNode mergeKLists(ListNode[] lists) {
        Set<Integer> endIndex = new HashSet<>();
        int len = lists.length;
        ArrayList<ListNode> listsArray = new ArrayList<>(Arrays.asList(lists));
        ListNode resultNode = null;
        ListNode temp = null;
        while (endIndex.size() < len) {
            Map<Integer, Integer> tempMap = new HashMap<Integer, Integer>();
            int index = -1;
            for (int i = 0; i < len; i++) {
                if (listsArray.get(i) == null) {
                    endIndex.add(i);
                    continue;
                }
                if ( listsArray.get(i) == resultNode) {
                    index = i;
                    break;
                }
                int currentValue = listsArray.get(i).val;
                tempMap.put(currentValue, i);
            }
            if (tempMap.isEmpty()) {
                break;
            }
            if (index == -1) {
                Integer min = Collections.min(tempMap.keySet());
                index = tempMap.get(min);
            }
            if (resultNode != null) {
                resultNode.next = listsArray.get(index);
                listsArray.set(index, listsArray.get(index).next);
                resultNode = resultNode.next;
            } else {
                resultNode = listsArray.get(index);
                listsArray.set(index, listsArray.get(index).next);
                temp = resultNode;
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode node1 = ListNode.fromArray(new int[]{1, 4, 5});
        ListNode node2 = ListNode.fromArray(new int[]{1, 3, 4});
        ListNode node3 = ListNode.fromArray(new int[]{2, 6});
        ListNode[] a = {node1, node2, node3};
        ListNode listNode = s.mergeKLists(a);
        listNode.printNode();
    }
}
