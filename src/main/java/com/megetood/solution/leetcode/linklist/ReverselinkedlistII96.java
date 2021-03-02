package com.megetood.solution.leetcode.linklist;

import com.megetood.solution.interview.linkedlist.LinkedListUtil;
import com.megetood.solution.interview.linkedlist.ListNode;

/**
 * reverse linked list II
 *
 * @author Lei Chengdong
 * @date 2020/11/16
 */
public class ReverselinkedlistII96 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return head;
        }
        int i = 1;
        ListNode left = new ListNode(0);
        if (m > 1) {
            left = head;
            for (; i < m - 1; i++) {
                left = left.next;
            }
        } else {
            left.next = head;
        }

        System.out.println(left);
        ListNode start = left.next;
        left.next = null;

        ListNode node = start.next;
        ListNode prev = start;
        start.next = null;
        int j = 1;
        while (node != null && j <= n - m) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
            j++;
        }
        left.next = prev;
        start.next = node;

        return m == 1 ? prev : head;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5};
        ListNode head = LinkedListUtil.createListNode(arr);
        ListNode res = new ReverselinkedlistII96().reverseBetween(head, 1, 2);
        System.out.println(res);
    }
}
