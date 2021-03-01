package com.megetood.solution.nowcoder;

/**
 * 给定一棵二叉树以及这棵树上的两个节点 o1 和 o2，请找到 o1 和 o2 的最近公共祖先节点。
 *
 * @author Lei Chengdong
 * @date 2020/11/25
 */
public class LowestCommonAncestor {


    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    /**
     * @param root TreeNode类
     * @param o1   int整型
     * @param o2   int整型
     * @return int整型
     */
    public int lowestCommonAncestor(TreeNode root, int o1, int o2) {

        if (root == null) {
            return -1;
        }

        if (root.val > o1 && root.val > o2) {
            return lowestCommonAncestor(root.left, o1, o2);
        }
        if (root.val < o1 && root.val < o2) {
            return lowestCommonAncestor(root.right, o1, o2);
        }

        return root.val;
    }




}
