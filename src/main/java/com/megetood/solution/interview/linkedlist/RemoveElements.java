package com.megetood.solution.interview.linkedlist;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/09/14 12:57
 */
public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while (cur.next != null) {
            if (cur.next.val == val) {
                ListNode delNode = cur.next;
                cur.next = delNode.next;
                delNode.next = null;
            } else {
                cur = cur.next;
            }
        }
        ListNode retNode = dummyHead.next;
        dummyHead.next = null;
        return retNode;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        ListNode head = LinkedListUtil.createListNode(arr, arr.length);
        System.out.println(head);
        ListNode res = new RemoveElements().removeElements(head, 1);
        System.out.println(head);
        System.out.println(res);
    }
}
