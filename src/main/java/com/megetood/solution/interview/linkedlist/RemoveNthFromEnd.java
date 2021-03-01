package com.megetood.solution.interview.linkedlist;

import java.util.prefs.NodeChangeEvent;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/09/14 16:46
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode start = dummyNode;
        ListNode end = start;
        int i = 0;
        while (end != null) {
            if (i >= n + 1) {
                start = start.next;
            }
            end = end.next;
            i++;
        }

        System.out.println(start);
        ListNode target = start.next;
        start.next = target.next;
        target.next = null;
        System.out.println(start);
        return dummyNode.next;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode start = dummyNode;
        ListNode end = dummyNode;
        for (int i = 0; i < n + 1; i++) {
            end = end.next;
        }
        System.out.println("end "+end);
        while (end != null) {
            start = start.next;
            end = end.next;
        }

        ListNode target = start.next;
        start.next = target.next;
        target.next = null;

        ListNode retNode = dummyNode.next;
        dummyNode.next=null;

        return retNode;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2};
        ListNode head = LinkedListUtil.createListNode(arr);
        ListNode he = new RemoveNthFromEnd().removeNthFromEnd2(head, 2);
        System.out.println(he);
    }
}
