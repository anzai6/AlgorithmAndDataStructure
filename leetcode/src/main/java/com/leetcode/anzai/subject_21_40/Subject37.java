package com.leetcode.anzai.subject_21_40;

import java.util.HashMap;

/**
 * 解数独
 * https://leetcode-cn.com/problems/sudoku-solver/
 */
public class Subject37 {

    /**
     *
     编写一个程序，通过已填充的空格来解决数独问题。

     一个数独的解法需遵循如下规则：

     数字 1-9 在每一行只能出现一次。
     数字 1-9 在每一列只能出现一次。
     数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
     空白格用 '.' 表示。

     Subject37_1.png

     一个数独。

     Subject37_1.png

     答案被标成红色。

     Note:

     给定的数独序列只包含数字 1-9 和字符 '.' 。
     你可以假设给定的数独只有唯一解。
     给定数独永远是 9x9 形式的。
     *
     */

    /**
     * HashMap 改为 数组，类似布隆过滤器
     */
    public void solveSudoku(char[][] board) {

        boolean[][] rowList = new boolean[9][10]; // 行
        boolean[][] columnList = new boolean[9][10]; // 列
        boolean[][] subList = new boolean[9][10]; // 3x3

        // 遍历一遍把存在的数字放进相应的 HashMap 中
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char value = board[i][j];
                if (value != '.') {
                    int index = value - '0';
                    rowList[i][index] = true;
                    columnList[j][index] = true;

                    // 这里的下标计算参照下面的注释
                    int subRow = i / 3;
                    int subColumn = j / 3;
                    int suIndex = subRow * 3 + subColumn;
                    subList[suIndex][index] = true;

                    //        0,0  = 0   0,1  = 1   0,2  = 2
                    //        1,0  = 3   1,1  = 4   1,2  = 5
                    //        2,0  = 6   2,1  = 7   2,2  = 8
                    //
                    //                i*3+j
                }
            }
        }

        solveSudokuInterval(board, 0, rowList, columnList, subList);
    }

    public void solveSudokuInterval(char[][] board, int count, boolean[][] rowList,
                                    boolean[][] columnList, boolean[][] subList) {
        if (count == 81) {
            isComplete = true;
            return;
        }

        int row = count / 9;
        int column = count % 9;

        int subRow = row / 3;
        int subColumn = column / 3;
        int suIndex = subRow * 3 + subColumn;

        if (board[row][column] == '.') {
            // 依次填入九个数
            for (int i = 1; i <= 9; i++) {
                if (isComplete)
                    break;
                char value = (char) (i + '0');

                // 先排除重复
                if (rowList[row][i])
                    continue;
                if (columnList[column][i])
                    continue;
                if (subList[suIndex][i])
                    continue;

                // 赋值
                board[row][column] = value;
                rowList[row][i] = true;
                columnList[column][i] = true;
                subList[suIndex][i] = true;
                solveSudokuInterval(board, count + 1, rowList, columnList, subList);

                if (isComplete)
                    break;
                // 填入得不对，删除
                board[row][column] = '.';
                rowList[row][i] = false;
                columnList[column][i] = false;
                subList[suIndex][i] = false;
            }
        } else {
            solveSudokuInterval(board, count + 1, rowList, columnList, subList);
        }
    }

    /**
     * HashMap
     */
    public void solveSudoku1(char[][] board) {

        HashMap<Character, Integer>[] rowHashMap = new HashMap[9]; // 行
        HashMap<Character, Integer>[] columnHashMap = new HashMap[9]; // 列
        HashMap<Character, Integer>[][] subHashMap = new HashMap[3][3]; // 3x3

        // 初始化
        for (int i = 0; i < 9; i++) {
            rowHashMap[i] = new HashMap<>();
            columnHashMap[i] = new HashMap<>();
            subHashMap[i / 3][i % 3] = new HashMap<>();
        }

        // 遍历一遍把存在的数字放进相应的 HashMap 中
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char value = board[i][j];
                if (value != '.') {
                    rowHashMap[i].put(value, 1);
                    columnHashMap[j].put(value, 1);
                    subHashMap[i / 3][j / 3].put(value, 1);
                }
            }
        }

        solveSudokuInterval1(board, 0, rowHashMap, columnHashMap, subHashMap);
    }

    boolean isComplete = false;

    /**
     * HashMap
     */
    public void solveSudokuInterval1(char[][] board, int count, HashMap<Character, Integer>[] rowHashMap,
                                     HashMap<Character, Integer>[] columnHashMap, HashMap<Character, Integer>[][] subHashMap) {
        if (count == 81) {
            isComplete = true;
            return;
        }

        int row = count / 9;
        int column = count % 9;

        if (board[row][column] == '.') {
            // 依次填入九个数
            for (int i = 0; i < 9; i++) {
                if (isComplete)
                    break;
                char value = (char) (i + '0' + 1);

                // 先排除重复
                if (rowHashMap[row].containsKey(value))
                    continue;
                if (columnHashMap[column].containsKey(value))
                    continue;
                if (subHashMap[row / 3][column / 3].containsKey(value))
                    continue;

                // 赋值
                board[row][column] = value;
                rowHashMap[row].put(value, 1);
                columnHashMap[column].put(value, 1);
                subHashMap[row / 3][column / 3].put(value, 1);
                solveSudokuInterval1(board, count + 1, rowHashMap, columnHashMap, subHashMap);

                if (isComplete)
                    break;
                // 填入得不对，删除
                board[row][column] = '.';
                rowHashMap[row].remove(value);
                columnHashMap[column].remove(value);
                subHashMap[row / 3][column / 3].remove(value);
            }
        } else {
            solveSudokuInterval1(board, count + 1, rowHashMap, columnHashMap, subHashMap);
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},

                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},

                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        Subject37 subject = new Subject37();
        subject.solveSudoku(board);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + ",    ");
            }
            System.out.println();
        }
    }

}
