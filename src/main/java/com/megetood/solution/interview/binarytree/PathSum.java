package com.megetood.solution.interview.binarytree;

import com.megetood.solution.interview.TreeNode;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/09/20 14:52
 */
public class PathSum {
    public int pathSum(TreeNode root, int sum) {
        if(root == null){
            return 0;
        }
        
        int res = findPath(root, sum);

        res += pathSum(root.left, sum);
        res += pathSum(root.right, sum);

        return res;
    }

    private int findPath(TreeNode node, int num) {
        int res = 0;

        if (node == null) {
            return res;
        }

        if (node.val == num) {
            res += 1;
        }

        res += findPath(node.left, num - node.val);
        res += findPath(node.right, num - node.val);

        return res;
    }
}
