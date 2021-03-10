package com.megetood.solution.model;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/08/26 12:36
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        ListNode cur = this;
        StringBuilder builder = new StringBuilder();
        while (cur!=null){
            builder.append(cur.val).append(">");
            cur = cur.next;
        }

        return builder.append("NULL").toString();
    }
}