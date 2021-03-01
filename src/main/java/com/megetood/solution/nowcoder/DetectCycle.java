package com.megetood.solution.nowcoder;

import java.util.HashSet;
import java.util.Set;

/**
 * 对于一个给定的链表，返回环的入口节点，如果没有环，返回null
 *
 * @author Lei Chengdong
 * @date 2020/11/24
 */
public class DetectCycle {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        ListNode cur = head;
        Set<ListNode> set = new HashSet<>();
        while (cur != null) {
            if (set.contains(cur)) {
                return cur;
            }
            set.add(cur);
            cur = cur.next;
        }
        return null;
    }
}
