package com.megetood.solution.interview.binarytree;

import com.megetood.solution.interview.TreeNode;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/09/18 12:33
 */
public class MinDepth {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int r = min(root.right);
        int l = min(root.left);
        if (r == 0) {
            return l + 1;
        }
        if (l == 0) {
            return r + 1;
        }
        return Math.min(l, r) + 1;
    }

    private int min(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        return Math.min(leftDepth, rightDepth) + 1;
    }
}
