package com.ldy.sortCase;

/**
 * Create by liudongyang8 on 2020/5/28
 */
public class DeleteBackNNode {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        printTest(removeNthFromEnd(listNode1, 4));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slowNode = dummy;
        ListNode quickNode = dummy;
        int i = 1;
        while (true) {
            if (i > n+1) {
                break;
            }
            quickNode = quickNode.next;
            i++;
        }
        while (quickNode != null) {
            quickNode = quickNode.next;
            slowNode = slowNode.next;
        }
        slowNode.next = slowNode.next.next;
        return dummy.next;
    }

    public static void printTest(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
    }
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
