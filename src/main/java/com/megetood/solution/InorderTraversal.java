package com.megetood.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * 中序遍历
 *
 * @author chengdong.lei@hand-china.com 2020/09/11 10:57
 */
public class InorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderTraversal(root, res);
        return res;
    }

    private void inorderTraversal(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }

        inorderTraversal(node.left, res);
        res.add(node.val);
        inorderTraversal(node.right, res);
    }
}
