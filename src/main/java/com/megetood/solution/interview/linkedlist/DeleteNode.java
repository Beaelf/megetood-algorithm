package com.megetood.solution.interview.linkedlist;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/09/14 16:25
 */
public class DeleteNode {
    public void deleteNode(ListNode node) {
        ListNode delNode = node.next;
        node.val = delNode.val;
        node.next = delNode.next;
        delNode.next=null;
    }
}
