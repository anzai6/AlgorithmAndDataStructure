package com.example.lib.course61_exercise.solution;

/**
 * ��������������
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */

public class MaximumDepthOfBinaryTreeSolution {

    /**
     *
     ����һ�����������ҳ��������ȡ�

     �����������Ϊ���ڵ㵽��ԶҶ�ӽڵ���·���ϵĽڵ�����

     ˵��:?Ҷ�ӽڵ���ָû���ӽڵ�Ľڵ㡣

     ʾ����
     ���������� [3,9,20,null,null,15,7]��

       3
      / \
     9  20
       /  \
     15   7
     ��������������?3 ��

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
