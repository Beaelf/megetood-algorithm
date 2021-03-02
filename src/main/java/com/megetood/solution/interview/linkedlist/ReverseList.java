package com.megetood.solution.interview.linkedlist;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/09/14 10:10
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head.next;
        ListNode prev = head;
        head.next = null;
        while (cur != null) {
            ListNode next = cur.next;

            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public ListNode reverseList2(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            ListNode next = cur.next;

            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    // cur->next->next.next
    public void reverse(ListNode cur) {
        if (cur == null || cur.next == null) {
            return;
        }
        ListNode next = cur.next;

        reverse(next.next);

        next.next = cur;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        ListNode head = LinkedListUtil.createListNode(arr, arr.length);
        System.out.println(head);
        ListNode res = new ReverseList().reverseList2(head);
        System.out.println(res);
        LinkedListUtil.deleteListNode(head);
        System.out.println(head);
    }


}
