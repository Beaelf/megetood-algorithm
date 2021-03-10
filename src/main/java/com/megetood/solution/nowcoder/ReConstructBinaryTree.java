package com.megetood.solution.nowcoder;

import com.megetood.solution.interview.TreeNode;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class ReConstructBinaryTree {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return build(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private TreeNode build(int[] pre, int preL, int preR, int[] in, int inL, int inR) {
        if (preL > preR) {
            return null;
        }

        TreeNode root = new TreeNode(pre[preL]);
        for (int i = inL; i <= inR; i++) {
            if (in[i] == root.val) {
                root.left = build(pre, preL + 1, preL + i - inL, in, inL, i - 1);
                root.right = build(pre, preL + i - inL + 1 , preR, in, i + 1, inR);
                break;
            }
        }

        return root;
    }

}
