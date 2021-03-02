package com.megetood.solution.interview.linkedlist;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/09/14 12:28
 */
public class LinkedListUtil {
    private LinkedListUtil() {
    }
    public static ListNode createListNode(int[] arr) {
       return createListNode(arr,arr.length);
    }
    public static ListNode createListNode(int[] arr, int n) {
        if (n == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i = 1; i < n; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }

        return head;
    }

    public static void deleteListNode(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            ListNode delNode = cur;
            cur = cur.next;
            delNode.next = null;
        }
    }
}
