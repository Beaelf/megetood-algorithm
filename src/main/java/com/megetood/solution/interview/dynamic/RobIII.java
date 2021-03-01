package com.megetood.solution.interview.dynamic;

import com.megetood.solution.interview.TreeNode;
import com.megetood.solution.interview.binarytree.BinaryTreeUtil;

import java.util.Arrays;

/**
 * @author Lei Chengdong
 * @date 2020/12/4
 */
public class RobIII {
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }

        TreeNode L = root.left;
        TreeNode R = root.right;

        if (L == null && R == null) {
            return root.val;
        }

        if (L != null && R == null) {
            return Math.max(root.val + rob(L.left) + rob(L.right), rob(L));
        }
        if (L == null && R != null) {
            return Math.max(root.val + rob(R.left) + rob(R.right), rob(R));
        }


        return Math.max(
                root.val + rob(L.left) + rob(L.right) + rob(R.left) + rob(R.right),
                rob(L) + rob(R)
        );
    }

    public static void main(String[] args) {
        Integer[] tree = {3, 2, 3, null, 3, null, 1};
        System.out.println(Arrays.toString(tree));
        TreeNode root = BinaryTreeUtil.generate(tree);

        int res = new RobIII().rob(root);
        System.out.println(res);

    }
}
