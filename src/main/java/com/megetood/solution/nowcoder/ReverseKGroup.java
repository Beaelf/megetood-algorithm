package com.megetood.solution.nowcoder;

/**
 * 将给出的链表中的节点每\ k k 个一组翻转，返回翻转后的链表
 * 如果链表中的节点数不是\ k k 的倍数，将最后剩下的节点保持原样
 * 你不能更改节点中的值，只能更改节点本身。
 * 要求空间复杂度 \ O(1) O(1)
 * 例如：
 * 给定的链表是1\to2\to3\to4\to51→2→3→4→5
 * 对于 \ k = 2 k=2, 你应该返回 2\to 1\to 4\to 3\to 52→1→4→3→5
 * 对于 \ k = 3 k=3, 你应该返回 3\to2 \to1 \to 4\to 53→2→1→4→5
 *
 * @author Lei Chengdong
 * @date 2020/11/25
 */
public class ReverseKGroup {

    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * @param head ListNode类
     * @param k    int整型
     * @return ListNode类
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||head.next==null){
            return head;
        }
        // write code here
        ListNode res = new ListNode(0);
        ListNode prevTail = null;
        boolean isFirst = true;
        while (head != null) {
            ListNode Cur = head;

            int i = 0;
            for (; i < k && head != null; i++) {
                if (i < k - 1) {
                    head = head.next;
                } else {
                    ListNode del = head;
                    head = head.next;
                    del.next = null;
                }
            }
            ListNode tail = Cur;
            if(i==k){
                Cur = reverseList(Cur);
            }

            if (prevTail != null) {
                prevTail.next = Cur;
            }
            prevTail = tail;

            if (isFirst) {
                res.next = Cur;
                isFirst = false;
            }
        }
        return res.next;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
