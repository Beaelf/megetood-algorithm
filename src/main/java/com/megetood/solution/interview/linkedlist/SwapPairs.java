package com.megetood.solution.interview.linkedlist;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/09/14 15:34
 */
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode prev = dummyNode;
        while (prev.next != null && prev.next.next != null) {
            ListNode cur = prev.next;
            ListNode R = cur.next;
            ListNode next = R.next;

            prev.next = R;
            R.next = cur;
            cur.next = next;

            prev = cur;
        }

        ListNode retNode = dummyNode.next;
        dummyNode.next = null;

        return retNode;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        ListNode head = LinkedListUtil.createListNode(arr);
        System.out.println(head);
        ListNode res = new SwapPairs().swapPairs(head);
//        System.out.println(res);
    }
}
