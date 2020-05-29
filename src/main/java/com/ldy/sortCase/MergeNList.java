package com.ldy.sortCase;

/**
 * Create by liudongyang8 on 2020/5/28
 */
public class MergeNList {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        ListNode listNode4 = new ListNode(2);
        ListNode listNode5 = new ListNode(8);
        ListNode listNode6 = new ListNode(9);
        listNode4.next = listNode5;
        listNode5.next = listNode6;

        ListNode listNode7 = new ListNode(4);
        ListNode listNode8 = new ListNode(7);
        ListNode listNode9 = new ListNode(10);
        listNode7.next = listNode8;
        listNode8.next = listNode9;

        ListNode[] nodeArray = new ListNode[]{listNode1, listNode4, listNode7};
        int n = nodeArray.length;
        ListNode result = null;
        for (ListNode listNode : nodeArray) {
            result = mergeTwoList(result, listNode);
        }

        ListNode.printListNode(result);
    }

    public static ListNode mergeTwoList(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(0);
        ListNode pre = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = l1 == null ? l2 : l1;
        return preHead.next;
    }
}
