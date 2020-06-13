package utils;

import java.util.ArrayList;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static ListNode fromArray(int[] nodeArray) {
        ListNode preNode = null;
        for (int i = nodeArray.length - 1; i >= 0; i--) {
            ListNode node = new ListNode(nodeArray[i]);
            node.next = preNode;
            preNode = node;
        }
        return preNode;
    }

    public void printNode() {
        System.out.println(val);
        ListNode nextNode = this;

        while (true) {
            nextNode = nextNode.next;
            if (nextNode == null) {
                break;
            }
            System.out.println(nextNode.val);
        }
    }

}

