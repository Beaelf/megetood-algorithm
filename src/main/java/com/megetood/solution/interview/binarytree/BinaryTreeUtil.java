package com.megetood.solution.interview.binarytree;

import com.megetood.solution.interview.TreeNode;
import com.megetood.solution.interview.queue.LevelOrder;
import com.megetood.structure.Array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 *
 * @author Lei Chengdong
 * @date 2020/09/18
 */
public class BinaryTreeUtil {
    public static TreeNode generate(Integer[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int index = 0;
        TreeNode root = new TreeNode(nums[index]);
        generate(root, nums, index);
        return root;
    }

    private static void generate(TreeNode node, Integer[] nums, int index) {
        if (node == null) {
            return;
        }

        int l = index * 2 + 1;
        if (l < nums.length) {
            node.left = nums[l] == null ? null : new TreeNode(nums[l]);
        }
        int r = index * 2 + 2;
        if (r < nums.length) {
            node.right = nums[r] == null ? null : new TreeNode(nums[r]);
        }

        generate(node.left, nums, l);
        generate(node.right, nums, r);
    }

    public static void printTree(TreeNode node) {
        if (node == null) {
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            TreeNode cur = q.remove();
            System.out.println(cur.val);
            if (cur.left != null) {
                q.add(node.left);
            }
            if (cur.right != null) {
                q.add(node.right);
            }
        }
    }

    public static void printTree(Integer[] nums) {
        System.out.println();
        for (int i = 1; i < nums.length; i++) {

        }
    }

    public static void main(String[] args) {
//        Integer[] nums = new Integer[2];
        Integer[] nums = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1};
        System.out.println(Arrays.toString(nums));
        TreeNode root = BinaryTreeUtil.generate(nums);
//        BinaryTreeUtil.printTree(root);
        List<List<Integer>> list = new LevelOrder().levelOrder(root);
        System.out.println(Arrays.toString(list.toArray()));
    }

}
