package com.megetood.solution.interview.linkedlist;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/09/14 10:09
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        ListNode node = this;
        while (node!=null){
            res.append(node.val);
            res.append("->");
            node = node.next;
        }
        res.append("NULL");
        return res.toString();
    }
}
