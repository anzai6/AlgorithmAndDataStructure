package com.leetcode.anzai.subject_41_60;

import java.util.ArrayList;
import java.util.List;

/**
 * N皇后
 * https://leetcode-cn.com/problems/n-queens/
 */
public class Subject51 {

    /**
     *
     n?皇后问题研究的是如何将 n?个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。

     Subject51_8-queens.png

     上图为 8 皇后问题的一种解法。

     给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。

     每一种解法包含一个明确的?n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。

     注意：限制条件是每个棋子上下左右横竖直线不能有棋子，两条对角线也不能有棋子

     示例:

     输入: 4
     输出: [
     [".Q..",  // 解法 1
     "...Q",
     "Q...",
     "..Q."],

     ["..Q.",  // 解法 2
     "Q...",
     "...Q",
     ".Q.."]
     ]
     解释: 4 皇后问题存在两个不同的解法。
     *
     */

    /**
     * 初步分析可以使用回溯算法，
     * 动态规划呢？好像不行
     *
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        if (n <= 0) {
            return null;
        }

        List<List<String>> list = new ArrayList<>();
        int[] result = new int[n]; // 可以摆放的结果：下标表示行，值表示列
        for (int i = 0; i < n; i++) {
            result[i] = -1;
        }
        solveNQueensBtInternal(0, n, result, list);
        return list;
    }

    /**
     * 回溯算法：一行一行的遍历，然后根据竖轴和左上角右上角是否有值来判断是否满足
     *
     * @param row 当前处于第几行，一开始调用从0开始
     * @param n
     * @return
     */
    public void solveNQueensBtInternal(int row, int n, int[] result, List<List<String>> list) {
        if (n == row) { // 取result的值放进list
            List<String> subList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (result[i] == j) { // 摆放位置
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                subList.add(sb.toString());
            }
            list.add(subList);
            return;
        }

        // 遍历row行的所有位置
        for (int i = 0; i < n; i++) {
            if (canPut(row, i, result)) { // 能放棋子
                result[row] = i; // 赋值
                solveNQueensBtInternal(row + 1, n, result, list); // 走下一行
                result[row] = -1; // 还原
            } else { // 判断下一个位置
                continue;
            }
        }
    }

    /**
     * 判断该位置是否能防止棋子
     *
     * @param row
     * @param column
     * @return
     */
    private boolean canPut(int row, int column, int[] result) {
        // 左右上角代表对角线，因为下面的值还没确定，所以左右下角是不用判断的
        int leftUpRadiusValue = column - 1; // 左上角
        int rightUpRadiusValue = column + 1; // 右上角

        // 从 row-1 即上一行开始往上判断
        for (int i = row - 1; i >= 0; i--) {
            if (result[i] == column) { // 同一列
                return false;
            }
            if (leftUpRadiusValue == result[i]) {
                return false;
            }
            if (rightUpRadiusValue == result[i]) {
                return false;
            }
            leftUpRadiusValue--;
            rightUpRadiusValue++;
        }
        return true;
    }

    public static void main(String[] args) {
        Subject51 subject = new Subject51();
        List<List<String>> list = subject.solveNQueens(5);
        if (list == null) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            List<String> subList = list.get(i);
            for (int j = 0; j < subList.size(); j++) {
                System.out.print(subList.get(j));
                System.out.println();
            }
            System.out.println("------------------------------");
        }
    }

}
