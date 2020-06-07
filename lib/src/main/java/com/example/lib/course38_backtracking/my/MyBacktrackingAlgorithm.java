package com.example.lib.course38_backtracking.my;

/**
 * 回溯算法
 * Created by qinshunan on 2019/5/7.
 */

public class MyBacktrackingAlgorithm {


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

    /**
     * 通过findEightQueens(0)开始一列一行的遍历找到合适摆放棋子的位置，不合适则回溯
     *
     * @param row 行
     */
    public void findEightQueens(int row) {
        if (row == 0)
            isComplete = false;

        if (row == 8) { // 摆放完成
            isComplete = true;
            printQueens(result);
            return;
        }

        for (int column = 0; column < len; column++) {
//            if (isComplete) // 摆放完成后关掉所有循环,即找到一个解即可
//                return;
            if (isOk(row, column)) { // 表示能够摆放
                result[row] = column; // 摆放
                findEightQueens(row + 1); // 摆放下一行的棋子
            }
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
        int leftUpDiagonalAngle = column - 1; // 左上对角线的值
        int rightUpDiagonalAngle = column + 1; // 右上对角线的值

        for (int i = row - 1; i >= 0; i--) { // 列数递减，依次与前面已摆放好的棋子判断新摆放的位置row是否合适
            if (result[i] == column) // 同一行的不合适
                return false;

            if (leftUpDiagonalAngle >= 0 && result[i] == leftUpDiagonalAngle) // 在左上对角线上也不合适
                return false;

            if (rightUpDiagonalAngle < 8 && result[i] == rightUpDiagonalAngle) // 在左下对角线上也不合适
                return false;

            --leftUpDiagonalAngle;
            ++rightUpDiagonalAngle;
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
        if (i == 0) {
            maxW = -1;
        }

        if (i == n || cw == maxPackW) { // 所有物体已经选择完毕或者背包已经装满
            if (cw > maxW) {
                maxW = cw;
                for (int j = 0; j < n; j++) {
                    maxResult[j] = packResult[j];
                }
            }
            return;
        }
        packResult[i] = 0;
        pretendPack(i + 1, cw); // 当前物体没有装进去，直接进入下一个物体
        if (cw + packW[i] <= maxPackW) { // 当前物体装进去不会超重
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
        MyBacktrackingAlgorithm myBacktrackingAlgorithm = new MyBacktrackingAlgorithm();
//        myBacktrackingAlgorithm.findEightQueens(0);

        myBacktrackingAlgorithm.pretendPack(0, 0);
        myBacktrackingAlgorithm.printPackResult();
        System.out.println("maxW: " + myBacktrackingAlgorithm.maxW);
    }
}
