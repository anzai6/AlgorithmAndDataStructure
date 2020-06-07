package com.example.lib.course38_backtracking.teacher;

/**
 * �����㷨���˻ʺ�0-1������������ʽ
 */
public class BacktrackingAlgorithm {


    // �˻ʺ�Ļ����㷨���£�

    int[] result = new int[8];// ȫ�ֻ��Ա����, �±��ʾ��, ֵ��ʾ queen �洢����һ��

    public void cal8queens(int row) { // ���÷�ʽ��cal8queens(0);
        if (row == 8) { // 8 �����Ӷ����ú��ˣ���ӡ���
            printQueens(result);
            return; // 8 �����Ӷ��ź��ˣ��Ѿ�û�������µݹ��ˣ����Ծ� return
        }
        for (int column = 0; column < 8; ++column) { // ÿһ�ж��� 8 �зŷ�
            if (isOk(row, column)) { // ��Щ�ŷ�������Ҫ��
                result[row] = column; // �� row �е����ӷŵ��� column ��
                cal8queens(row + 1); // ������һ��
            }
        }
    }

    private boolean isOk(int row, int column) {// �ж� row �� column �з����Ƿ����
        int leftup = column - 1, rightup = column + 1;
        for (int i = row - 1; i >= 0; --i) { // �������Ͽ���ÿһ��
            if (result[i] == column) return false; // �� i �е� column ����������
            if (leftup >= 0) { // �������϶Խ��ߣ��� i �� leftup ����������
                if (result[i] == leftup) return false;
            }
            if (rightup < 8) { // �������϶Խ��ߣ��� i �� rightup ����������
                if (result[i] == rightup) return false;
            }
            --leftup;
            ++rightup;
        }
        return true;
    }

    private void printQueens(int[] result) { // ��ӡ��һ����ά����
        for (int row = 0; row < 8; ++row) {
            for (int column = 0; column < 8; ++column) {
                if (result[row] == column) System.out.print("Q ");
                else System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }


    // 0-1��������n��������ѡ������װ�뱳��������������W�����岻�ɷָ����װ������������������ֵ
    public int maxW = Integer.MIN_VALUE; // �洢��������Ʒ�����������ֵ

    // cw ��ʾ��ǰ�Ѿ�װ��ȥ����Ʒ�������ͣ�i ��ʾ���쵽�ĸ���Ʒ�ˣ�
    // w ����������items ��ʾÿ����Ʒ��������n ��ʾ��Ʒ����
    // ���豳���ɳ������� 100����Ʒ���� 10����Ʒ�����洢������ a �У��ǿ����������ú�����
    // f(0, 0, a, 10, 100)
    public void f(int i, int cw, int[] items, int n, int w) {
        if (cw == w || i == n) { // cw==w ��ʾװ���� ;i==n ��ʾ�Ѿ����������е���Ʒ
            if (cw > maxW) maxW = cw;
            return;
        }
        f(i + 1, cw, items, n, w);
        if (cw + items[i] <= w) {// �Ѿ��������Ա������ܵ�������ʱ�򣬾Ͳ�Ҫ��װ��
            f(i + 1, cw + items[i], items, n, w);
        }
    }

    public static void main(String[] args) {
        BacktrackingAlgorithm backtrackingAlgorithm = new BacktrackingAlgorithm();
        backtrackingAlgorithm.cal8queens(0);
    }

}
