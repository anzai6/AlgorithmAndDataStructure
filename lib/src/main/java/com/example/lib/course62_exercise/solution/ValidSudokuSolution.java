package com.example.lib.course62_exercise.solution;

/**
 * ��Ч������
 * https://leetcode-cn.com/problems/valid-sudoku/
 */

public class ValidSudokuSolution {

    /**
     *
     �ж�һ��?9x9 �������Ƿ���Ч��ֻ��Ҫ�������¹�����֤�Ѿ�����������Ƿ���Ч���ɡ�

     ����?1-9?��ÿһ��ֻ�ܳ���һ�Ρ�
     ����?1-9?��ÿһ��ֻ�ܳ���һ�Ρ�
     ����?1-9?��ÿһ���Դ�ʵ�߷ָ���?3x3?����ֻ�ܳ���һ�Ρ�

     ͼƬ��ValidSudoku.svg.png

     ��ͼ��һ������������Ч��������

     �������ֿո��������������֣��հ׸���?'.'?��ʾ��

     ʾ��?1:

     ����:
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
     ���: true
     ʾ��?2:

     ����:
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
     ���: false
     ����: ���˵�һ�еĵ�һ�����ִ� 5 ��Ϊ 8 ���⣬�ո����������־��� ʾ��1 ��ͬ��
     ������λ�����Ͻǵ� 3x3 ���������� 8 ����, ��������������Ч�ġ�
     ˵��:

     һ����Ч�������������ѱ���䣩��һ���ǿɽ�ġ�
     ֻ��Ҫ�������Ϲ�����֤�Ѿ�����������Ƿ���Ч���ɡ�
     ������������ֻ��������?1-9?���ַ�?'.'?��
     ����������Զ��?9x9?��ʽ�ġ�

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

        char[] validChars = new char[9]; // У������1-9�Ƿ��ظ�

        for (int i = 0; i < 9; i++) {
            // һ��һ��У��
            if (!validRowChars(board, i, validChars))
                return false;
            initValidChars(validChars);

            // һ��һ��У��
            if (!validColumnChars(board, i, validChars))
                return false;
            initValidChars(validChars);
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // ������У��
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
     * У��ĳһ���Ƿ���������
     *
     * @param board
     * @param row        ����
     * @param validChars
     * @return
     */
    private boolean validRowChars(char[][] board, int row, char[] validChars) {
        for (int i = 0; i < 9; i++) {
            char item = board[row][i];
            if ('.' == item)
                continue;
            int index = item - '1';
            if (validChars[index] == '1') // ���ظ�������
                return false;
            else validChars[index] = '1';
        }
        return true;
    }

    /**
     * У��ĳһ���Ƿ���������
     *
     * @param board
     * @param column     ����
     * @param validChars
     * @return
     */
    private boolean validColumnChars(char[][] board, int column, char[] validChars) {
        for (int i = 0; i < 9; i++) {
            char item = board[i][column];
            if ('.' == item)
                continue;
            int index = item - '1';
            if (validChars[index] == '1') // ���ظ�������
                return false;
            else validChars[index] = '1';
        }
        return true;
    }

    /**
     * У��ĳһ��3x3�����Ƿ���������
     *
     * @param board
     * @param column     ����
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
                if (validChars[index] == '1') // ���ظ�������
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
