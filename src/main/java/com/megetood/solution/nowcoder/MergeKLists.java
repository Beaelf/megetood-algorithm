package com.megetood.solution.nowcoder;

import com.google.common.collect.Lists;
import com.megetood.solution.model.ListNode;

import java.util.ArrayList;
import java.util.List;

public class MergeKLists {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        return merge(lists);
    }

    private static ListNode merge(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }

        if (lists.size() == 1) {
            return lists.get(lists.size() - 1);
        }

        ListNode lastNode = null;
        if (lists.size() % 2 != 0) {
            lastNode = lists.get(lists.size() - 1);
        }

        List<ListNode> toMergedList = new ArrayList<>(lists.size() / 2);
        for (int i = 1; i < lists.size(); i += 2) {
            toMergedList.add(merge(lists.get(i - 1), lists.get(i)));
        }
        if(lastNode != null){
            toMergedList.add(lastNode);
        }

        return merge(toMergedList);
    }

    public static ListNode merge(ListNode node1, ListNode node2) {
        ListNode res = new ListNode(0);
        ListNode cur = res;
        ListNode n1 = node1;
        ListNode n2 = node2;
        while (n1 != null || n2 != null) {
            if (n1 != null && n2 == null) {
                cur.next = n1;
                n1 = n1.next;
            } else if (n1 == null && n2 != null) {
                cur.next = n2;
                n2 = n2.next;
            } else if (n1.val <= n2.val) {
                cur.next = n1;
                n1 = n1.next;
            } else {
                cur.next = n2;
                n2 = n2.next;
            }
            cur = cur.next;
        }

        return res.next;
    }

    public static ListNode generateList(List<Integer> list) {
        ListNode ret = new ListNode(0);
        ListNode cur = ret;
        for (Integer l : list) {
            cur.next = new ListNode(l);
            cur = cur.next;
        }

        return ret.next;
    }

    public static void main(String[] args) {
        ListNode node1 = generateList(Lists.newArrayList(1, 3, 5));
        ListNode node2 = generateList(Lists.newArrayList(2, 4, 6));

        ArrayList<ListNode> list = Lists.newArrayList(node1, node2);

        ListNode res = merge(list);

//        System.out.println(merge(node1, node2));
        System.out.println(res);
    }
}
