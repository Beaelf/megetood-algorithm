package com.megetood.solution.nowcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 树的前序，中序，后序便利
 *
 * @author Lei Chengdong
 * @date 2020/11/23
 */
public class ThreeOrders {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    /**
     * @param root TreeNode类 the root of binary tree
     * @return int整型二维数组
     */
    public int[][] threeOrders(TreeNode root) {
        // write code here
        int[] preRes = preOrder(root);
        int[] leveRes = inOrder(root);
        int[] postRes = postOrder(root);
        int[][] res = {preRes, leveRes, postRes};
        return res;
    }

    // 前序遍历
    private int[] preOrder(TreeNode root) {
        if (root == null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            list.add(cur.val);

            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    // 中序遍历
    private int[] inOrder(TreeNode root) {
        if (root == null) {
            return null;
        }

        List<Integer> list = new ArrayList<>();
        inOrder(root, list);

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

    // 后续遍历
    private int[] postOrder(TreeNode root) {
        if (root == null) {
            return null;
        }

        List<Integer> list = new ArrayList<>();
        postOrder(root, list);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void postOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        postOrder(root.left, list);
        postOrder(root.right, list);
        list.add(root.val);
    }

    public static void main(String[] args) {
        TreeNode left = new TreeNode();
        left.val = 2;
        TreeNode right = new TreeNode();
        right.val = 3;

        TreeNode root = new TreeNode();
        root.val = 1;
        root.left = left;
        root.right = right;

        /*
            1
            2 3
         */
        int[][] res = new ThreeOrders().threeOrders(root);
        System.out.println(Arrays.deepToString(res));
    }


}
