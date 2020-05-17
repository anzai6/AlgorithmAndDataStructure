package com.example.lib.course61_exercise.solution;

/**
 * 二叉树的最大深度
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */

public class MaximumDepthOfBinaryTreeSolution {

    /**
     *
     给定一个二叉树，找出其最大深度。

     二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

     说明: 叶子节点是指没有子节点的节点。

     示例：
     给定二叉树 [3,9,20,null,null,15,7]，

       3
      / \
     9  20
       /  \
     15   7
     返回它的最大深度 3 。

     *
     */

    /**
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null)
            return -1;
        int leftDepth = 0;
        int rightDepth = 0;
        if (root.left != null)
            leftDepth = maxDepth(root.left);
        if (root.right != null)
            rightDepth = maxDepth(root.right);
        return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
    }
}
