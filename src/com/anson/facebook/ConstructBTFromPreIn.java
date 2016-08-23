package com.anson.facebook;

import com.anson.util.TreeNode;

/**
 * Created by chenzian on 8/21/16.
 */
public class ConstructBTFromPreIn {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(0, 0, inorder.length - 1, preorder, inorder);
    }

    private TreeNode buildTreeHelper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        // find root index in inorder
        int rootIdx = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == preorder[preStart]) {
                rootIdx = i;
            }
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        root.left = buildTreeHelper(preStart + 1, inStart, rootIdx - 1, preorder, inorder);
        root.right = buildTreeHelper(preStart + inEnd - inStart + 1, rootIdx + 1, inEnd, preorder, inorder);
        return root;
    }
}
