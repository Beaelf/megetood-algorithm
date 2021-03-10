package com.megetood.solution.nowcoder;

import com.megetood.solution.interview.linkedlist.ListNode;

import java.util.Stack;

/**
 * 假设链表中每一个节点的值都在 0 - 9 之间，那么链表整体就可以代表一个整数。
 * 给定两个这种链表，请生成代表两个整数相加值的结果链表。
 * 例如：链表 1 为 9->3->7，链表 2 为 6->3，最后生成新的结果链表为 1->0->0->0。
 * <p>
 * [9,3,7],[6,3] -> {1,0,0,0}
 *
 * @author Chengdong Lei
 * @date 2021/1/22
 */
public class AddInList {

    private static Integer temp = 0;

    /**
     * @param head1 ListNode类
     * @param head2 ListNode类
     * @return ListNode类
     */
    public ListNode addInList(ListNode head1, ListNode head2) {
        // write code here
        Stack<Integer> nums1 = new Stack<>();
        Stack<Integer> nums2 = new Stack<>();
        Stack<Integer> res = new Stack<>();

        // init nums1,nums2
        init(head1, head2, nums1, nums2);

        // calculate
        return calculate(nums1, nums2, res);
    }

    private ListNode calculate(Stack<Integer> nums1, Stack<Integer> nums2, Stack<Integer> res) {
        while (!nums1.isEmpty() || !nums2.isEmpty()) {
            if (nums1.isEmpty() && nums2.isEmpty()) {
                return toLinkNode(res);
            }

            if (!nums1.isEmpty() && nums2.isEmpty()) {
                res.push(add(nums1.pop(), 0));
            } else if (nums1.isEmpty() && !nums2.isEmpty()) {
                res.push(add(nums2.pop(), 0));
            } else {
                res.push(add(nums1.pop(), nums2.pop()));
            }
        }

        return toLinkNode(res);
    }

    private void init(ListNode head1, ListNode head2, Stack<Integer> nums1, Stack<Integer> nums2) {
        ListNode cur1 = head1;
        while (cur1 != null) {
            nums1.push(cur1.val);
            cur1 = cur1.next;
        }

        ListNode cur2 = head2;
        while (cur2 != null) {
            nums2.push(cur2.val);
            cur2 = cur2.next;
        }
    }

    private ListNode toLinkNode(Stack<Integer> stack) {
        ListNode dummyheader = new ListNode(0);
        ListNode cur = dummyheader;
        while (!stack.isEmpty()) {
            cur.next = new ListNode(stack.pop());
            cur = cur.next;
        }

        return dummyheader.next;
    }

    private Integer add(Integer a, Integer b) {
        int res = a + b + temp;
        temp = res / 10;
        return res % 10;
    }

    public static void main(String[] args) {
        Integer res = new AddInList().add(9, 9);
        Integer res2 = new AddInList().add(1, 3);
        System.out.println(temp + "," + res);
    }
}
