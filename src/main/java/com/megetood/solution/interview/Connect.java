package com.megetood.solution.interview;

import com.megetood.solution.interview.binarytree.BinaryTreeUtil;

import javax.swing.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/09/28 9:15
 */
public class Connect {
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node last = null;
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                Node cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                if (i != 1) {
                    last.next = cur;
                }
                last = cur;
            }

        }
        return root;
    }

}
