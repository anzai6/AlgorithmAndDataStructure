package com.example.lib.course40_dynamicplanning2.my;

/**
 * Created by qinshunan on 2019/5/13.
 */

public class Test {

    // �в�ͬ���ֵ�Ӳ��v1,v2,v3,...,vn��Ҫ��֧��WԪ��������Ҫ���ٸ�Ӳ�ң�������
    int[] currencyValue = {3, 5, 7,}; // Ӳ����ֵ
    int totalW = 26;

    public void getMinCurrency() {
        getMinCurrency(currencyValue, totalW);
    }

    // ״̬ת�Ʊ�
    private void getMinCurrency(int[] values, int w) {
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        // �ҳ����ֵ����Сֵ
        for (int j = 0; j < values.length; j++) {
            if (minValue > values[j])
                minValue = values[j];
            if (maxValue < values[j])
                maxValue = values[j];
        }
        if (w < minValue)
            return;

        int n = w / minValue; // �����Ҫ��Ӳ��ö��
        boolean[][] statues = new boolean[n][maxValue * n + 1]; // n������Ҫ����öӲ�ң�maxValue * n + 1ָӲ�������ֵ

        int i = 0;
        int newValue = -1;
        for (int j = 0; j < values.length; j++) {
            newValue = values[j];
            statues[0][newValue] = true;
            if (newValue == w) { // �ҵ�
                System.out.println("ʹ��һöӲ����ֵΪ��" + newValue + "Ԫ");
                return;
            }
        }


        for (i = 1; i < n; i++) {
            for (int j = w; j >= 0; j--) {
                if (statues[i - 1][j]) {
                    for (int k = 0; k < values.length; k++) {
                        newValue = j + values[k];
                        statues[i][newValue] = true;
                        if (newValue == w) { // ��һ���������Ϊw����ֹͣѭ��
                            break;
                        }
                    }
                }
                if (newValue == w) {
                    break;
                }
            }
            if (newValue == w) {
                break;
            }
        }

        if (newValue != w) {
            return;
        }

        System.out.println("ʹ��Ӳ����ֵΪ��");
        for (int j = i; j >= 0; j--) {

            for (int k = 0; k < values.length; k++) {
                if (j == 0) {
                    if (newValue == values[k]) {
                        System.out.println(values[k] + "Ԫ");
                        return;
                    }
                } else if (statues[j - 1][newValue - values[k]]) {
                    newValue = newValue - values[k];
                    System.out.println(values[k] + "Ԫ");
                    break;
                }
            }

        }

    }

    // ״̬ת�Ʒ���
    // f(w) = min(f(w),f(w-vn))

    int minCount = Integer.MAX_VALUE;

    public void getMinCurrency2() {
        getMinCurrency2(0, totalW);
        System.out.println("ʹ��Ӳ��ö��Ϊ��" + minCount);
    }

    /**
     * getMinCurrency2(0,11)����,����ͨ������¼����״̬ת�Ʒ��̱���ɶ�̬�滮����
     *
     * @param n �ڼ�öӲ��
     * @param w ʣ����Ҫ֧��Ӳ�ҵ���ֵ
     */
    private void getMinCurrency2(int n, int w) {
        if (w == 0) {
            if (minCount > n)
                minCount = n;
            return;
        } else if (w < 0) {
            return;
        }

        for (int i = 0; i < currencyValue.length; i++) {
            getMinCurrency2(n + 1, w - currencyValue[i]);
        }
    }


    public static void main(String[] args) {
        Test test = new Test();
        test.getMinCurrency();
        test.getMinCurrency2();
    }

}
