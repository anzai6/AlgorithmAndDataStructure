package com.example.lib.course61_exercise.solution;

/**
 * 验证二叉查找树
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 */

public class ValidateBinarySearchTreeSolution {

    /**
     *
     给定一个二叉树，判断其是否是一个有效的二叉搜索树。

     假设一个二叉搜索树具有如下特征：

     节点的左子树只包含小于当前节点的数。
     节点的右子树只包含大于当前节点的数。
     所有左子树和右子树自身必须也是二叉搜索树。
     示例?1:

     输入:
       2
      / \
     1   3
     输出: true
     示例?2:

     输入:
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
     输出: false
     解释: 输入为: [5,1,4,null,null,3,6]。
     ?    根节点的值为 5 ，但是其右子节点值为 4 。

     *
     */

    double last = -Double.MAX_VALUE;
    /**
     * 大神解法：中序遍历，有点难理解和绕脑,
     * 简单理解为中序遍历可以将二叉查找树按排序输出，这样想：把last当作是当前遍历到的数字，所以每一个后面的数字都必须比它大
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (!isValidBST) // 当出现无效后，拦截所有递归,这是我加的优化
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
     * 我的常规解法
     * @param treeNode
     * @param parentMax 当前节点必须大于父节点上的某个值
     * @param parentMin 当前节点必须小于父节点上的某个值
     * @return
     */
    public boolean isValidBSTIn(TreeNode treeNode, long parentMax, long parentMin) {
        if (!isValidBST) // 当出现无效后，拦截所有递归
            return false;
        if (treeNode == null)
            return true;
        boolean isLeftValidBST = true;
        boolean isRightValidBST = true;
        int val; // 子节点的值
        int valF = treeNode.val;

        // 左子节点
        if (treeNode.left != null) {
            val = treeNode.left.val;
            if (val >= valF || val >= parentMin || val <= parentMax) {
                isValidBST = false;
                return false;
            } else {
                isLeftValidBST = isValidBSTIn(treeNode.left, parentMax, valF < parentMin ? valF : parentMin);
            }
        }

        // 右子节点
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
