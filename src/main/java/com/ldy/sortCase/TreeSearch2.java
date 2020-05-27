package com.ldy.sortCase;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by liudongyang8 on 2020/5/27
 */
public class TreeSearch2 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);

        root.setLeft(node1);
        root.setRight(node4);

        node1.setLeft(node2);
        node1.setRight(node3);
        List<String> pathList = new ArrayList<>();
        helper(root, pathList);
        for (String path : pathList) {
            System.out.println(path);
        }
    }

    public static void helper(TreeNode node, List<String> paths) {
        if (node == null) {
            return;
        }
        if (node.getLeft() != null) {
            helper(node.getLeft(), paths);
        }
        if (node.getRight() != null) {
            helper(node.getRight(), paths);
        }
        paths.add(String.valueOf(node.getValue()));
    }

    public static class TreeNode {
        private int value;
        private TreeNode left;
        private TreeNode right;
        public int getValue() {
            return this.value;
        }
        public TreeNode(int value) {
            this.value = value;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getLeft() {
            return this.left;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }

        public TreeNode getRight() {
            return this.right;
        }
    }
}
