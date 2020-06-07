package com.example.lib.course62_exercise.solution;

/**
 * 有效的数独
 * https://leetcode-cn.com/problems/valid-sudoku/
 */

public class ValidSudokuSolution {

    /**
     *
     判断一个?9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。

     数字?1-9?在每一行只能出现一次。
     数字?1-9?在每一列只能出现一次。
     数字?1-9?在每一个以粗实线分隔的?3x3?宫内只能出现一次。

     图片：ValidSudoku.svg.png

     上图是一个部分填充的有效的数独。

     数独部分空格内已填入了数字，空白格用?'.'?表示。

     示例?1:

     输入:
     [
     ["5","3",".",".","7",".",".",".","."],
     ["6",".",".","1","9","5",".",".","."],
     [".","9","8",".",".",".",".","6","."],
     ["8",".",".",".","6",".",".",".","3"],
     ["4",".",".","8",".","3",".",".","1"],
     ["7",".",".",".","2",".",".",".","6"],
     [".","6",".",".",".",".","2","8","."],
     [".",".",".","4","1","9",".",".","5"],
     [".",".",".",".","8",".",".","7","9"]
     ]
     输出: true
     示例?2:

     输入:
     [
     ? ["8","3",".",".","7",".",".",".","."],
     ? ["6",".",".","1","9","5",".",".","."],
     ? [".","9","8",".",".",".",".","6","."],
     ? ["8",".",".",".","6",".",".",".","3"],
     ? ["4",".",".","8",".","3",".",".","1"],
     ? ["7",".",".",".","2",".",".",".","6"],
     ? [".","6",".",".",".",".","2","8","."],
     ? [".",".",".","4","1","9",".",".","5"],
     ? [".",".",".",".","8",".",".","7","9"]
     ]
     输出: false
     解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
     但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
     说明:

     一个有效的数独（部分已被填充）不一定是可解的。
     只需要根据以上规则，验证已经填入的数字是否有效即可。
     给定数独序列只包含数字?1-9?和字符?'.'?。
     给定数独永远是?9x9?形式的。

     *
     */


    /**
     *
     */
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0)
            return false;
        if (board.length < 9 || board[0].length < 9)
            return false;

        char[] validChars = new char[9]; // 校验数字1-9是否重复

        for (int i = 0; i < 9; i++) {
            // 一行一行校验
            if (!validRowChars(board, i, validChars))
                return false;
            initValidChars(validChars);

            // 一列一列校验
            if (!validColumnChars(board, i, validChars))
                return false;
            initValidChars(validChars);
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // 三宫格校验
                if (!validThreePalace(board, i * 3, j * 3, validChars))
                    return false;
                initValidChars(validChars);
            }
        }

        return true;
    }

    private void initValidChars(char[] validChars) {
        for (int i = 0; i < validChars.length; i++) {
            validChars[i] = '0';
        }
    }

    /**
     * 校验某一行是否满足数独
     *
     * @param board
     * @param row        行数
     * @param validChars
     * @return
     */
    private boolean validRowChars(char[][] board, int row, char[] validChars) {
        for (int i = 0; i < 9; i++) {
            char item = board[row][i];
            if ('.' == item)
                continue;
            int index = item - '1';
            if (validChars[index] == '1') // 有重复的数字
                return false;
            else validChars[index] = '1';
        }
        return true;
    }

    /**
     * 校验某一列是否满足数独
     *
     * @param board
     * @param column     列数
     * @param validChars
     * @return
     */
    private boolean validColumnChars(char[][] board, int column, char[] validChars) {
        for (int i = 0; i < 9; i++) {
            char item = board[i][column];
            if ('.' == item)
                continue;
            int index = item - '1';
            if (validChars[index] == '1') // 有重复的数字
                return false;
            else validChars[index] = '1';
        }
        return true;
    }

    /**
     * 校验某一格3x3宫格是否满足数独
     *
     * @param board
     * @param column     列数
     * @param validChars
     * @return
     */
    private boolean validThreePalace(char[][] board, int row, int column, char[] validChars) {
        for (int i = row; i < row + 3; i++) {
            for (int j = column; j < column + 3; j++) {
                char item = board[i][j];
                if ('.' == item)
                    continue;
                int index = item - '1';
                if (validChars[index] == '1') // 有重复的数字
                    return false;
                else validChars[index] = '1';
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
/*
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
*/
        ValidSudokuSolution sudokuSolution = new ValidSudokuSolution();
        System.out.println(sudokuSolution.isValidSudoku(board));
    }
}
