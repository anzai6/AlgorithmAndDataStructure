package com.example.lib.course38_backtracking.finals;

/**
 * 回溯算法
 * Created by qinshunan on 2019/5/7.
 */

public class BacktrackingAlgorithm {


    //            * * * * * * * Q
    //            * Q * * * * * *
    //            * * * * Q * * *
    //            * * Q * * * * *
    //            Q * * * * * * *
    //            * * * * * * Q *
    //            * * * Q * * * *
    //            * * * * * Q * *
    // 八皇后：八行八列正方形棋盘，放入八个棋子，每个棋子上下左右横竖直线不能有棋子，两条对角线也不能有棋子
    // 回溯算法：从第一行到第八行依次摆放棋子，每一行每一列只能有一个棋子，对角线判断可以只判断已经摆放的棋子，即上对角线的棋子
    int len = 8;
    int[] result = new int[len]; // 下标表示行，值表示棋子放在哪一列
    boolean isComplete = false; // 终止条件

    public void findEightQueens() {
        for (int i = 0; i < len; i++) {
            result[i] = -1;
        }
        findEightQueens(0);
    }

    /**
     * 通过findEightQueens(0)开始一列一行的遍历找到合适摆放棋子的位置，不合适则回溯
     *
     * @param row 行
     */
    public void findEightQueens(int row) {
        if (row == 8) {
            isComplete = true;
            printQueens(result);
            return;
        }
        // 遍历每一列
        for (int i = 0; i < len; i++) {
            if (isComplete) {
                return;
            }
            if (!isOk(row, i)) {
                continue;
            }
            result[row] = i;
            findEightQueens(row + 1);
            // 回溯
            result[row] = -1;
        }
    }

    /**
     * 根据已摆放的棋子，判断在row行column列摆放棋子是否合适
     *
     * @param row    行
     * @param column 列
     * @return
     */
    private boolean isOk(int row, int column) {
        // 一行一行往上判断左上角和右上角以及当前列
        for (int i = row - 1; i >= 0; i--) {

            // 当前列是否放了棋子
            if (result[i] == column) {
                return false;
            }

            // 左上角
            if (result[row - i] == column - i) {
                return false;
            }
            // 右上角
            if (row + i < len && result[row + i] == column + i) {
                return false;
            }
        }

        return true;
    }


    private void printQueens(int[] result) {
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (j == result[i])
                    System.out.print("Q ");
                else
                    System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // 0-1背包：从n个物体中选择物体装入背包，背包最大承重W，物体不可分割，求能装入物体的总重量的最大值
    int maxW = -1; // 存储背包中物品总重量的最大值
    int maxPackW = 150; // 背包最大承重
    int n = 10; // 10个物体
    int[] packW = new int[]{4, 9, 45, 23, 43, 31, 18, 12, 27, 32}; // 下标对应物体，值是物体的重量
    int[] packResult = new int[n]; // 下标对应物体，值是代表物体是否装进去，0不装，1 装
    public int[] maxResult = new int[n]; // 对应最大重量的结果

    /**
     * pretendPack(0,0)启用
     *
     * @param i  当前是第几个物体
     * @param cw 已经装进背包的物体的总重量
     */
    public void pretendPack(int i, int cw) {
        if (i == n || cw == maxPackW) { // 所有物体已经选择完毕或者背包已经装满
            if (cw > maxW) {
                maxW = cw;
                for (int j = 0; j < n; j++) {
                    maxResult[j] = packResult[j];
                }
            }
            return;
        }

        // 不装进背包
        packResult[i] = 0;
        pretendPack(i + 1, cw);

        // 装进背包
        if (maxPackW >= cw + packW[i]) {
            packResult[i] = 1;
            pretendPack(i + 1, cw + packW[i]);
        }
    }

    private void printPackResult() {
        for (int i = 0; i < maxResult.length; i++) {
            System.out.print(maxResult[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // 八皇后问题
        BacktrackingAlgorithm myBacktrackingAlgorithm = new BacktrackingAlgorithm();
        myBacktrackingAlgorithm.findEightQueens();

        // 0-1 背包问题
        myBacktrackingAlgorithm.pretendPack(0, 0);
        myBacktrackingAlgorithm.printPackResult();
        System.out.println("maxW: " + myBacktrackingAlgorithm.maxW);
    }
}
