package com.example.lib.course61_exercise.solution;

/**
 * ��ת������
 * https://leetcode-cn.com/problems/invert-binary-tree/
 */

public class InvertBinaryTreeSolution {


    /**
     *
     ��תһ�ö�������

     ʾ����

     ���룺

     4
     /   \
     2     7
     / \   / \
     1   3 6   9
     �����

     4
     /    \
     7      2
     / \    / \
     9   6 3   1
     ��ע:
     ����������ܵ� Max Howell �� ԭ���� ������ ��

     �ȸ裺����90���Ĺ���ʦʹ������д�����(Homebrew)��������ȴ�޷�������ʱ�ڰװ���д����ת����������⣬��̫����ˡ�

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
