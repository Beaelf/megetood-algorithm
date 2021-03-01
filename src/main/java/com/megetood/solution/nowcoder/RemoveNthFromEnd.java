package com.megetood.solution.nowcoder;

import java.util.Stack;

/**
 * todo
 *
 * @author Lei Chengdong
 * @date 2020/11/24
 */
public class RemoveNthFromEnd {
    /**
     * @param head ListNode类
     * @param n    int整型
     * @return ListNode类
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // write code here
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        for (int i = 0; i < n - 1; i++) {
            stack.pop();
        }
        ListNode remNode = stack.pop();
        if(stack.isEmpty()){
            head=head.next;
            remNode.next=null;
            return head;
        }
        ListNode prev = stack.pop();
        prev.next = remNode.next;
        remNode.next = null;

        return head;
    }


    public static class ListNode {
        int val;
        ListNode next = null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode node = new ListNode();
        head.val = 1;
        node.val = 2;
        head.next = node;
        ListNode res = new RemoveNthFromEnd().removeNthFromEnd(head, 2);
        System.out.println(res);

    }

}
