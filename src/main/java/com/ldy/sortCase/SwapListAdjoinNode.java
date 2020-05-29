package com.ldy.sortCase;

/**
 * Create by liudongyang8 on 2020/5/28
 */
public class SwapListAdjoinNode {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        ListNode.printListNode(swap(listNode1));
    }
    public static ListNode swap(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tail = dummy;

        while(head != null && head.next != null) {
            ListNode firstNode = head;
            ListNode secondNode = head.next;

            firstNode.next = secondNode.next;
            secondNode.next = firstNode;
            tail.next = secondNode;

            tail = firstNode;
            head = firstNode.next;
        }
        return dummy.next;
    }
}
