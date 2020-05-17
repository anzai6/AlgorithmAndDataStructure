package com.example.lib.course63_exercise.backtracking;

/**
 * 八皇后
 */
public class EightQueensExercise {

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

    /**
     * 输出八皇后
     */
    private void getEightQueens() {
        int[] list = new int[8]; // 下标表示行，值表示列，如int[1] = 2 代表 第二行第三列放入棋子
        getEightQueensIn(list, 0);
    }

    private void getEightQueensIn(int[] list, int n) {
        if (n == 8) {
            print(list);
            return;
        }
        // 往n行放入棋子
        for (int i = 0; i < 8; i++) {
            list[n] = i; // 放入棋子
            if (volid(list, n)) // 放入的棋子合法
                getEightQueensIn(list, n + 1); // 下一行
        }
    }

    /**
     * 校验八皇后合法性
     *
     * @param list
     * @param n
     * @return
     */
    private boolean volid(int[] list, int n) {
        int current = list[n];
        int leftTop = current - 1; // 左上对角线的值
        int rightTop = current + 1; // 右上对角线的值
        for (int i = n - 1; i >= 0; i--, leftTop--, rightTop++) {
            if (list[i] == current) // 不能同一列
                return false;
            if (leftTop >= 0 && list[i] == leftTop) // 判断左上对角线
                return false;
            if (rightTop <= 7 && list[i] == rightTop) // 判断右上对角线
                return false;
        }
        return true;
    }

    private void print(int[] list) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (list[i] == j) {
                    System.out.print("Q ");
                } else
                    System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public static void main(String[] args) {
        EightQueensExercise exercise = new EightQueensExercise();
        exercise.getEightQueens();
    }
}
