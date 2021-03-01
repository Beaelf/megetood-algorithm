package com.megetood.solution.interview.binarytree;

import com.megetood.solution.interview.TreeNode;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/09/21 9:01
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return null;
        }

        if (root == null) {
            return null;
        }

        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;

    }
}
