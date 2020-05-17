package com.leetcode.anzai.subject_61_80;

/**
 * 单词搜索
 * https://leetcode-cn.com/problems/word-search/
 */
public class Subject79 {

    /**
     *
     给定一个二维网格和一个单词，找出该单词是否存在于网格中。

     单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

     示例:

     board =
     [
     ['A','B','C','E'],
     ['S','F','C','S'],
     ['A','D','E','E']
     ]

     给定 word = "ABCCED", 返回 true.
     给定 word = "SEE", 返回 true.
     给定 word = "ABCB", 返回 false.
     *
     */

    /**
     * 回溯算法：以任意一个单词为起点，向上下左右四个方向延伸进行深度优先搜索，同时配合备忘录剪枝
     * 改天试试换为偏移量的写法：private int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null) {
            return false;
        }

        boolean[][] result = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (isExist) {
                    return isExist;
                }
                existBacktracking(board, i, j, word, 0, result);
            }
        }

        return isExist;
    }

    boolean isExist = false;

    /**
     * 回溯算法：以任意一个单词为起点，向上下左右四个方向延伸进行深度优先搜索，同时配合备忘录剪枝
     *
     * @param board
     * @param row    当前比较的 board 的行下标
     * @param column 当前比较的 board 的列下标
     * @param word
     * @param index  当前比较的 word 的下标
     * @return
     */
    public void existBacktracking(char[][] board, int row, int column, String word, int index, boolean[][] result) {
        // 数组越界或已经遍历
        if (isExist) {
            return;
        }
        if (board[row][column] == word.charAt(index) && !result[row][column]) {
            // 匹配最后一个字符成功则终止回溯算法
            if (index == word.length() - 1) {
                isExist = true;
                return;
            }

            result[row][column] = true;

            // 向左
            if (row >= 1) {
                existBacktracking(board, row - 1, column, word, index + 1, result);
            }

            // 向右
            if (!isExist && row < board.length - 1) {
                existBacktracking(board, row + 1, column, word, index + 1, result);
            }

            // 向上
            if (!isExist && column >= 1) {
                existBacktracking(board, row, column - 1, word, index + 1, result);
            }

            // 向下
            if (!isExist && column < board[row].length - 1) {
                existBacktracking(board, row, column + 1, word, index + 1, result);
            }

            result[row][column] = false;
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'a', 'a'},
        };
//        char[][] board = new char[][]{
//                {'A', 'B', 'C', 'E'},
//                {'S', 'F', 'C', 'S'},
//                {'A', 'D', 'E', 'E'}
//        };
        String word = "ABCCED";
        word = "SEE";
//        word = "ABCB";
        word = "aaa";
        Subject79 subject = new Subject79();
        System.out.println(subject.exist(board, word));
    }

}
