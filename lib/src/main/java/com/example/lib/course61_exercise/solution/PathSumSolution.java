package com.example.lib.course61_exercise.solution;

/**
 * ·���ܺ�
 * https://leetcode-cn.com/problems/path-sum/
 */

public class PathSumSolution {

    /**
     *
     ����һ����������һ��Ŀ��ͣ��жϸ������Ƿ���ڸ��ڵ㵽Ҷ�ӽڵ��·��������·�������нڵ�ֵ��ӵ���Ŀ��͡�

     ˵��:?Ҷ�ӽڵ���ָû���ӽڵ�Ľڵ㡣

     ʾ��:?
     �������¶��������Լ�Ŀ��� sum = 22��

           5
          / \
         4   8
        /   / \
       11  13  4
      /  \      \
     7    2      1
     ���� true, ��Ϊ����Ŀ���Ϊ 22 �ĸ��ڵ㵽Ҷ�ӽڵ��·�� 5->4->11->2��

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
     * @param surplus  ʣ���ֵ
     * @return
     */
    public void hasPathSumIn(TreeNode treeNode, int surplus) {
        if (hasPathSum)
            return;
        if (treeNode != null) {
            if (treeNode.left == null && treeNode.right == null && treeNode.val == surplus) { // ���ڵ�
                hasPathSum = true;
            } else {
                hasPathSumIn(treeNode.left, surplus - treeNode.val);
                hasPathSumIn(treeNode.right, surplus - treeNode.val);
            }
        }
    }
}
