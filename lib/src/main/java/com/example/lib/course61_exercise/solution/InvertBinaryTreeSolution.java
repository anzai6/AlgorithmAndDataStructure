package com.example.lib.course61_exercise.solution;

/**
 * 反转二叉树
 * https://leetcode-cn.com/problems/invert-binary-tree/
 */

public class InvertBinaryTreeSolution {


    /**
     *
     翻转一棵二叉树。

     示例：

     输入：

     4
     /   \
     2     7
     / \   / \
     1   3 6   9
     输出：

     4
     /    \
     7      2
     / \    / \
     9   6 3   1
     备注:
     这个问题是受到 Max Howell 的 原问题 启发的 ：

     谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。

     *
     */


    /**
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;
        invertTreeIn(root);
        return root;
    }

    /**
     * @param treeNode
     * @return
     */
    public void invertTreeIn(TreeNode treeNode) {
        if (treeNode == null)
            return;
        TreeNode item = treeNode.left;
        treeNode.left = treeNode.right;
        treeNode.right = item;
        invertTree(treeNode.left);
        invertTree(treeNode.right);
    }
}
