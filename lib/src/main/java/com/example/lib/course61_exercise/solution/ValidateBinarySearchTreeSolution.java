package com.example.lib.course61_exercise.solution;

/**
 * ��֤���������
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 */

public class ValidateBinarySearchTreeSolution {

    /**
     *
     ����һ�����������ж����Ƿ���һ����Ч�Ķ�����������

     ����һ��������������������������

     �ڵ��������ֻ����С�ڵ�ǰ�ڵ������
     �ڵ��������ֻ�������ڵ�ǰ�ڵ������
     �������������������������Ҳ�Ƕ�����������
     ʾ��?1:

     ����:
       2
      / \
     1   3
     ���: true
     ʾ��?2:

     ����:
       5
      / \
     1   4
     ?  / \
     ? 3   6

             3
          /    \
         1     5
           ?  / \
           ? 2   6
     ���: false
     ����: ����Ϊ: [5,1,4,null,null,3,6]��
     ?    ���ڵ��ֵΪ 5 �����������ӽڵ�ֵΪ 4 ��

     *
     */

    double last = -Double.MAX_VALUE;
    /**
     * ����ⷨ������������е�����������,
     * �����Ϊ����������Խ��������������������������룺��last�����ǵ�ǰ�����������֣�����ÿһ����������ֶ����������
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (!isValidBST) // ��������Ч���������еݹ�,�����Ҽӵ��Ż�
            return false;
        if (root == null) {
            return true;
        }
        if (isValidBST(root.left)) {
            if (last < root.val) {
                last = root.val;
                return isValidBST(root.right);
            }
        }
        isValidBST = false;
        return false;
    }

    /**
     *
     * @param root
     * @return
     */
    public boolean isValidBST1(TreeNode root) {
        return isValidBSTIn(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean isValidBST = true;

    /**
     * �ҵĳ���ⷨ
     * @param treeNode
     * @param parentMax ��ǰ�ڵ������ڸ��ڵ��ϵ�ĳ��ֵ
     * @param parentMin ��ǰ�ڵ����С�ڸ��ڵ��ϵ�ĳ��ֵ
     * @return
     */
    public boolean isValidBSTIn(TreeNode treeNode, long parentMax, long parentMin) {
        if (!isValidBST) // ��������Ч���������еݹ�
            return false;
        if (treeNode == null)
            return true;
        boolean isLeftValidBST = true;
        boolean isRightValidBST = true;
        int val; // �ӽڵ��ֵ
        int valF = treeNode.val;

        // ���ӽڵ�
        if (treeNode.left != null) {
            val = treeNode.left.val;
            if (val >= valF || val >= parentMin || val <= parentMax) {
                isValidBST = false;
                return false;
            } else {
                isLeftValidBST = isValidBSTIn(treeNode.left, parentMax, valF < parentMin ? valF : parentMin);
            }
        }

        // ���ӽڵ�
        if (treeNode.right != null) {
            val = treeNode.right.val;
            if (val <= valF || val >= parentMin || val <= parentMax) {
                isValidBST = false;
                return false;
            } else {
                isLeftValidBST = isValidBSTIn(treeNode.right, valF > parentMax ? valF : parentMax, parentMin);
            }
        }
        return isLeftValidBST && isRightValidBST;
    }

    public static void main(String[] args) {
        ValidateBinarySearchTreeSolution solution = new ValidateBinarySearchTreeSolution();
//        [3,1,5,0,2,4,6]
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(5);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(6);
        TreeNode left2 = new TreeNode(0);
        TreeNode right2 = new TreeNode(2);
        root.left = left;
        root.right = right;
        right.left = left1;
        right.right = right1;
//        left.left = left2;
//        left.right = right2;
        System.out.println(solution.isValidBST(root));
    }
}
