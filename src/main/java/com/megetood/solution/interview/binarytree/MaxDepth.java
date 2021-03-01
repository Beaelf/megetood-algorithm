package com.megetood.solution.interview.binarytree;

import com.megetood.solution.interview.TreeNode;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/09/18 12:33
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMaxDepth = maxDepth(root.left);
        int rightMaxDepth = maxDepth(root.right);
        return Math.max(leftMaxDepth, rightMaxDepth) + 1;
    }

}
