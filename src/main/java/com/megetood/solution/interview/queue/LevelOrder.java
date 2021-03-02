package com.megetood.solution.interview.queue;

import com.megetood.solution.interview.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/09/15 11:20
 */
public class LevelOrder {
    private class TreeNodeE {
        TreeNode node;
        int level;

        public TreeNodeE(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return null;
        }

        LinkedBlockingQueue<TreeNodeE> queue = new LinkedBlockingQueue<>();
        try {
            queue.put(new TreeNodeE(root, 0));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (!queue.isEmpty()) {
            TreeNodeE result = queue.poll();

            int level = result.level;
            if (level == res.size()) {
                res.add(new ArrayList<>());
            }
            List<Integer> list = res.get(level);
            list.add(result.node.val);

            if (result.node.left != null) {
                queue.add(new TreeNodeE(result.node.left, level + 1));
            }
            if (result.node.right != null) {
                queue.add(new TreeNodeE(result.node.right, level + 1));
            }
        }
        return res;
    }



    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        res.add(list);
        levelOrder(root, res, 1);
        return res;
    }

    private void levelOrder(TreeNode node, List<List<Integer>> list, int level) {
        if (node.left == null && node.right == null) {
            return;
        }
        if (level == list.size()) {
            List<Integer> newList = new ArrayList<>();
            list.add(newList);
        }

        List<Integer> levelList = list.get(level);
        if (node.left != null) {
            levelList.add(node.left.val);
        }
        if (node.right != null) {
            levelList.add(node.right.val);
        }

        list.add(levelList);
        levelOrder(node.left, list, level + 1);
        levelOrder(node.right, list, level + 1);
    }

    public static void main(String[] args) {
        int[] arr = new int[0];
        System.out.println(arr[0]);
    }
}
