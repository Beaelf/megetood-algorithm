package com.megetood.solution.interview.binarytree;

import com.megetood.solution.interview.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/09/20 14:01
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        if (root.left == null && root.right == null) {
            res.add(String.valueOf(root.val));
            return res;
        }

        List<String> lefts = binaryTreePaths(root.left);
        List<String> rights = binaryTreePaths(root.right);

        for (int i = 0; i < lefts.size(); i++) {
            res.add(root.val + "->" + lefts.get(i));
        }
        for (int i = 0; i < rights.size(); i++) {
            res.add(root.val + "->" + rights.get(i));
        }
        return res;
    }
}
