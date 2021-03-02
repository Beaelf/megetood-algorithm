package com.megetood.solution.interview.binarytree;

import com.megetood.solution.interview.TreeNode;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/09/18 13:05
 */
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }

        invertTree(root.left);
        invertTree(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
    }
}
