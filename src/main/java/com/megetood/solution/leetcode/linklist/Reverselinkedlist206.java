package com.megetood.solution.leetcode.linklist;

import com.megetood.solution.interview.linkedlist.LinkedListUtil;
import com.megetood.solution.interview.linkedlist.ListNode;

/**
 * reverse linked list
 *
 * @author Lei Chengdong
 * @date 2020/11/16
 */
public class Reverselinkedlist206 {

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode node = head.next;
        ListNode prev = head;
        head.next = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode head = LinkedListUtil.createListNode(arr);
        ListNode listNode = new Reverselinkedlist206().reverseList(head);
        System.out.println(listNode);
    }
}
