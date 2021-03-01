package com.megetood.solution.interview.linkedlist;

/**
 * Reverse a linked list from position m to n. Do it in one-pass.
 *
 * @author chengdong.lei@hand-china.com 2020/09/14 11:23
 */
public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode prev = null;
        ListNode cur = head;
        boolean reverse = false;
        ListNode left = null;
        ListNode right = null;
        ListNode nodeL = null;
        ListNode nodeR = null;
        while (cur != null) {
            ListNode next = cur.next;
            if (cur.val == m) {
                reverse = true;
                nodeL = cur;
                left = prev;
            }
            if (reverse == true) {
                cur.next = prev;
            }
            if (cur.val == n) {
                reverse = false;
                nodeR = cur;
                right = next;
                if (left != null) {
                    left.next = nodeL;
                }
                if (nodeR != null) {
                    nodeR.next = right;
                }
                break;
            }
            prev = cur;
            cur = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        System.out.println(n1);
        ListNode res = new ReverseBetween().reverseBetween(n1, 2, 4);
        System.out.println(res);
    }
}
