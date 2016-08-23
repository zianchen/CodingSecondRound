package com.anson.samsung.phoneandonsite;

/**
 * Created by chenzian on 8/15/16.
 */

class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int val;

    public TreeNode(int v) {
        val = v;
    }
}

public class LCABinaryTree {
    public static void main(String[] args) {

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }
}
