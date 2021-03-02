package com.megetood.solution.interview.binarytree;

import com.megetood.solution.interview.TreeNode;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/09/18 13:54
 */
public class HasPathSum {
    public boolean hasPathSum(TreeNode root, int sum) {

        return pathSum(root, sum);
    }

    private boolean pathSum(TreeNode root, int sum) {
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }
        if (pathSum(root.left, sum - root.val)) {
            return true;
        }
        if (pathSum(root.right, sum - root.val)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Integer[] nums = {5,4,8,11,null,13,4,7,2,null,null,null,1};
        TreeNode root = BinaryTreeUtil.generate(nums);
        boolean res = new HasPathSum().hasPathSum(root, 22);
        System.out.println(res);
    }

}
