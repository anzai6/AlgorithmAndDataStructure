package com.leetcode.anzai.subject_61_80;

/**
 * ��������
 * https://leetcode-cn.com/problems/word-search/
 */
public class Subject79 {

    /**
     *
     ����һ����ά�����һ�����ʣ��ҳ��õ����Ƿ�����������С�

     ���ʱ��밴����ĸ˳��ͨ�����ڵĵ�Ԫ���ڵ���ĸ���ɣ����С����ڡ���Ԫ������Щˮƽ���ڻ�ֱ���ڵĵ�Ԫ��ͬһ����Ԫ���ڵ���ĸ�������ظ�ʹ�á�

     ʾ��:

     board =
     [
     ['A','B','C','E'],
     ['S','F','C','S'],
     ['A','D','E','E']
     ]

     ���� word = "ABCCED", ���� true.
     ���� word = "SEE", ���� true.
     ���� word = "ABCB", ���� false.
     *
     */

    /**
     * �����㷨��������һ������Ϊ��㣬�����������ĸ�������������������������ͬʱ��ϱ���¼��֦
     * �������Ի�Ϊƫ������д����private int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
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
     * �����㷨��������һ������Ϊ��㣬�����������ĸ�������������������������ͬʱ��ϱ���¼��֦
     *
     * @param board
     * @param row    ��ǰ�Ƚϵ� board �����±�
     * @param column ��ǰ�Ƚϵ� board �����±�
     * @param word
     * @param index  ��ǰ�Ƚϵ� word ���±�
     * @return
     */
    public void existBacktracking(char[][] board, int row, int column, String word, int index, boolean[][] result) {
        // ����Խ����Ѿ�����
        if (isExist) {
            return;
        }
        if (board[row][column] == word.charAt(index) && !result[row][column]) {
            // ƥ�����һ���ַ��ɹ�����ֹ�����㷨
            if (index == word.length() - 1) {
                isExist = true;
                return;
            }

            result[row][column] = true;

            // ����
            if (row >= 1) {
                existBacktracking(board, row - 1, column, word, index + 1, result);
            }

            // ����
            if (!isExist && row < board.length - 1) {
                existBacktracking(board, row + 1, column, word, index + 1, result);
            }

            // ����
            if (!isExist && column >= 1) {
                existBacktracking(board, row, column - 1, word, index + 1, result);
            }

            // ����
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
