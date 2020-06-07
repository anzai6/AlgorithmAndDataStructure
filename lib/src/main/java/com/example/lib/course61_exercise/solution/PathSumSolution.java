package com.example.lib.course61_exercise.solution;

/**
 * 路径总和
 * https://leetcode-cn.com/problems/path-sum/
 */

public class PathSumSolution {

    /**
     *
     给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。

     说明:?叶子节点是指没有子节点的节点。

     示例:?
     给定如下二叉树，以及目标和 sum = 22，

           5
          / \
         4   8
        /   / \
       11  13  4
      /  \      \
     7    2      1
     返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。

     *
     */

    /**
     *
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        hasPathSumIn(root, sum);
        return hasPathSum;
    }

    boolean hasPathSum = false;

    /**
     * @param treeNode
     * @param surplus  剩余的值
     * @return
     */
    public void hasPathSumIn(TreeNode treeNode, int surplus) {
        if (hasPathSum)
            return;
        if (treeNode != null) {
            if (treeNode.left == null && treeNode.right == null && treeNode.val == surplus) { // 根节点
                hasPathSum = true;
            } else {
                hasPathSumIn(treeNode.left, surplus - treeNode.val);
                hasPathSumIn(treeNode.right, surplus - treeNode.val);
            }
        }
    }
}
