package com.leetcode.anzai.subject_21_40;

import java.util.HashMap;

/**
 * ������
 * https://leetcode-cn.com/problems/sudoku-solver/
 */
public class Subject37 {

    /**
     *
     ��дһ������ͨ�������Ŀո�������������⡣

     һ�������Ľⷨ����ѭ���¹���

     ���� 1-9 ��ÿһ��ֻ�ܳ���һ�Ρ�
     ���� 1-9 ��ÿһ��ֻ�ܳ���һ�Ρ�
     ���� 1-9 ��ÿһ���Դ�ʵ�߷ָ��� 3x3 ����ֻ�ܳ���һ�Ρ�
     �հ׸��� '.' ��ʾ��

     Subject37_1.png

     һ��������

     Subject37_1.png

     �𰸱���ɺ�ɫ��

     Note:

     ��������������ֻ�������� 1-9 ���ַ� '.' ��
     ����Լ������������ֻ��Ψһ�⡣
     ����������Զ�� 9x9 ��ʽ�ġ�
     *
     */

    /**
     * HashMap ��Ϊ ���飬���Ʋ�¡������
     */
    public void solveSudoku(char[][] board) {

        boolean[][] rowList = new boolean[9][10]; // ��
        boolean[][] columnList = new boolean[9][10]; // ��
        boolean[][] subList = new boolean[9][10]; // 3x3

        // ����һ��Ѵ��ڵ����ַŽ���Ӧ�� HashMap ��
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char value = board[i][j];
                if (value != '.') {
                    int index = value - '0';
                    rowList[i][index] = true;
                    columnList[j][index] = true;

                    // ������±������������ע��
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
            // ��������Ÿ���
            for (int i = 1; i <= 9; i++) {
                if (isComplete)
                    break;
                char value = (char) (i + '0');

                // ���ų��ظ�
                if (rowList[row][i])
                    continue;
                if (columnList[column][i])
                    continue;
                if (subList[suIndex][i])
                    continue;

                // ��ֵ
                board[row][column] = value;
                rowList[row][i] = true;
                columnList[column][i] = true;
                subList[suIndex][i] = true;
                solveSudokuInterval(board, count + 1, rowList, columnList, subList);

                if (isComplete)
                    break;
                // ����ò��ԣ�ɾ��
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

        HashMap<Character, Integer>[] rowHashMap = new HashMap[9]; // ��
        HashMap<Character, Integer>[] columnHashMap = new HashMap[9]; // ��
        HashMap<Character, Integer>[][] subHashMap = new HashMap[3][3]; // 3x3

        // ��ʼ��
        for (int i = 0; i < 9; i++) {
            rowHashMap[i] = new HashMap<>();
            columnHashMap[i] = new HashMap<>();
            subHashMap[i / 3][i % 3] = new HashMap<>();
        }

        // ����һ��Ѵ��ڵ����ַŽ���Ӧ�� HashMap ��
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
            // ��������Ÿ���
            for (int i = 0; i < 9; i++) {
                if (isComplete)
                    break;
                char value = (char) (i + '0' + 1);

                // ���ų��ظ�
                if (rowHashMap[row].containsKey(value))
                    continue;
                if (columnHashMap[column].containsKey(value))
                    continue;
                if (subHashMap[row / 3][column / 3].containsKey(value))
                    continue;

                // ��ֵ
                board[row][column] = value;
                rowHashMap[row].put(value, 1);
                columnHashMap[column].put(value, 1);
                subHashMap[row / 3][column / 3].put(value, 1);
                solveSudokuInterval1(board, count + 1, rowHashMap, columnHashMap, subHashMap);

                if (isComplete)
                    break;
                // ����ò��ԣ�ɾ��
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
