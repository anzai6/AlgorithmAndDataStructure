package com.leetcode.anzai.subject_61_80;

/**
 * �༭����
 * https://leetcode-cn.com/problems/edit-distance/
 */
public class Subject72 {

    /**
     *
     ������������ word1 �� word2��������� word1 ת���� word2 ��ʹ�õ����ٲ����� ��

     ����Զ�һ�����ʽ����������ֲ�����

     ����һ���ַ�
     ɾ��һ���ַ�
     �滻һ���ַ�
     ʾ�� 1:

     ����: word1 = "horse", word2 = "ros"
     ���: 3
     ����:
     horse -> rorse (�� 'h' �滻Ϊ 'r')
     rorse -> rose (ɾ�� 'r')
     rose -> ros (ɾ�� 'e')
     ʾ�� 2:

     ����: word1 = "intention", word2 = "execution"
     ���: 5
     ����:
     intention -> inention (ɾ�� 't')
     inention -> enention (�� 'i' �滻Ϊ 'e')
     enention -> exention (�� 'n' �滻Ϊ 'x')
     exention -> exection (�� 'n' �滻Ϊ 'c')
     exection -> execution (���� 'u')
     *
     */

    /**
     * ���������㷨�ҳ��˶�̬ת�Ʒ��̣�ʵʩ��̬�滮�ⷨ
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return -1;
        }

        int len1 = word1.length();
        int len2 = word2.length();

//        if (len1 == 0) {
//            return len2;
//        }
//        if (len2 == 0) {
//            return len1;
//        }
        // �ٷ���д�����������ҵĺö���
        if (len1 * len2 == 0) {
            return len1 + len2;
        }

        int[][] result = new int[len1][len2];

        boolean hasSameChar = false;
        // ��ʼ����һ��
        for (int i = 0; i < len2; i++) {
            if (!hasSameChar && word1.charAt(0) == word2.charAt(i)) {
                hasSameChar = true;
            }
            if (hasSameChar) {
                result[0][i] = i;
            } else {
                result[0][i] = i + 1;
            }
        }
        hasSameChar = false;
        // ��ʼ����һ��
        for (int i = 0; i < len1; i++) {
            if (!hasSameChar && word2.charAt(0) == word1.charAt(i)) {
                hasSameChar = true;
            }
            if (hasSameChar) {
                result[i][0] = i;
            } else {
                result[i][0] = i + 1;
            }
        }

        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    result[i][j] = minNum(result[i - 1][j] + 1, result[i][j - 1] + 1, result[i - 1][j - 1]);
                } else {
                    result[i][j] = minNum(result[i - 1][j] + 1, result[i][j - 1] + 1, result[i - 1][j - 1] + 1);
                }
            }
        }

        return result[len1 - 1][len2 - 1];
    }

    /**
     * �����㷨ʵ��,û�ӱ���¼���׳�ʱ����ӱ���¼
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance1(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return -1;
        }

        int len1 = word1.length();
        int len2 = word2.length();

        if (len1 == 0) {
            return len2;
        }
        if (len2 == 0) {
            return len1;
        }

        int[][] result = new int[len1][len2];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                result[i][j] = -1;
            }
        }
        minDistanceInterval(word1, len1 - 1, word2, len2 - 1, result);
        return result[len1 - 1][len2 - 1];
    }

    /**
     * ���ݵĵݹ����,��ʼ���÷�ʽ�� minDistanceInterval(word1,word1.length()-1,word2,word2.length()-1);
     * <p>
     * ͨ���Ƚ����һ���ַ��Ƿ���ȣ��ֳ����������
     * f(i,j) = min(f(i-1,j) + 1,f(i,j-1) + 1,f(i-1,j-1) + 1) �� f(i,j) = min(f(i-1,j) + 1,f(i,j-1) + 1,f(i-1,j-1))
     * ���� i �� j ���������ַ����Ƚϱ༭������±�
     *
     * @param word1
     * @param index1 word1���±꣬�൱��ȡ0~index1���ַ����Ƚ�
     * @param word2
     * @param index2 word2���±꣬�൱��ȡ0~index2���ַ����Ƚ�
     * @param result ��¼���
     * @return
     */
    public void minDistanceInterval(String word1, int index1, String word2, int index2, int[][] result) {

        if (result[index1][index2] != -1) {
            return;
        }

        if (index1 == 0) {
            boolean hasSameChar = false;
            for (int i = 0; i <= index2; i++) {
                if (word1.charAt(0) == word2.charAt(i)) {
                    hasSameChar = true;
                    break;
                }
            }
            if (hasSameChar) {
                result[index1][index2] = index2;
            } else {
                result[index1][index2] = index2 + 1;
            }
            return;
        }

        if (index2 == 0) {
            boolean hasSameChar = false;
            for (int i = 0; i <= index1; i++) {
                if (word2.charAt(0) == word1.charAt(i)) {
                    hasSameChar = true;
                    break;
                }
            }
            if (hasSameChar) {
                result[index1][index2] = index1;
            } else {
                result[index1][index2] = index1 + 1;
            }
            return;
        }

        minDistanceInterval(word1, index1 - 1, word2, index2, result);
        minDistanceInterval(word1, index1, word2, index2 - 1, result);
        minDistanceInterval(word1, index1 - 1, word2, index2 - 1, result);
        int num1 = result[index1 - 1][index2] + 1;
        int num2 = result[index1][index2 - 1] + 1;
        int num3 = result[index1 - 1][index2 - 1];

        if (word1.charAt(index1) != word2.charAt(index2)) { // �����ַ��������һ���ַ�����ͬ
            num3 += 1;
        }

        result[index1][index2] = minNum(num1, num2, num3);
    }

    private int minNum(int num1, int num2, int num3) {
        if (num1 > num2) {
            return num2 > num3 ? num3 : num2;
        } else {
            return num1 > num3 ? num3 : num1;
        }
    }

    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        word1 = "intention";
        word2 = "execution";
        word1 = "dinitrophenylhydrazine";
        word2 = "acetylphenylhydrazine";
        Subject72 subject = new Subject72();
        System.out.println(subject.minDistance(word1, word2));
    }

}
