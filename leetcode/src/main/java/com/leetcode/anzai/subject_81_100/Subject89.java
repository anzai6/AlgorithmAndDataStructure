package com.leetcode.anzai.subject_81_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * ���ױ���
 * https://leetcode-cn.com/problems/gray-code/
 */
public class Subject89 {

    /**
     *
     ���ױ�����һ������������ϵͳ���ڸ�ϵͳ�У�������������ֵ����һ��λ���Ĳ��졣

     ����һ�����������λ���ķǸ����� n����ӡ����ױ������С����ױ������б����� 0 ��ͷ��

     ʾ�� 1:

     ����: 2
     ���: [0,1,3,2]
     ����:
     00 - 0
     01 - 1
     11 - 3
     10 - 2


     ���ڸ����� n������ױ������в���Ψһ��
     ���磬[0,2,3,1] Ҳ��һ����Ч�ĸ��ױ������С�

     00 - 0
     10 - 2
     11 - 3
     01 - 1
     ʾ�� 2:



     000 0
     001 1
     011 3
     010 2
     110 6
     111 7
     101 5
     100 4


     ����: 0
     ���: [0]
     ����: ���Ƕ�����ױ������б����� 0 ��ͷ��
     ����������λ��Ϊ n �ĸ��ױ������У��䳤��Ϊ 2^n���� n = 0 ʱ������Ϊ 2^0 = 1��
     ��ˣ��� n = 0 ʱ������ױ�������Ϊ [0]��
     *
     */

    /**
     * һλһλȡ�����л��� ���磬000�����λ��� 100,010,001��100�����λ��� 000,110,101
     *
     * @param n
     * @return
     */
    public List<Integer> grayCode(int n) {
        double size = Math.pow(2, n);
        if (size < 0 || size > Integer.MAX_VALUE) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);
        list.add(0);
        grayCodeInteval(0, n, (int) size, hashMap, list);
        return list;
    }

    /**
     * һλһλȡ�����л��� ���磬000�����λ��� 100,010,001��100�����λ��� 000,110,101
     *
     * @param key     ��ǰ��Ҫ���ݵ�ֵ
     * @param n       λ��
     * @param size    һ���ж��ٸ�����
     * @param hashMap ����¼
     * @param list    ���
     */
    public void grayCodeInteval(int key, int n, int size, HashMap<Integer, Integer> hashMap, List<Integer> list) {
        if (hashMap.size() == size) {
            return;
        }
        // ����ÿһλ����ȡ��
        for (int i = 0; i < n; i++) {
            // ��λ�������Ϳ����õ�iλȡ����
            int newKey = (1 << i) ^ key;
            if (hashMap.containsKey(newKey)) {
                continue;
            } else {
                hashMap.put(newKey, 1);
                list.add(newKey);
                grayCodeInteval(newKey, n, size, hashMap, list);
                if (hashMap.size() == size) {
                    return;
                } else { // ��ԭֵ���л���
                    list.remove(list.size() - 1);
                    hashMap.remove(newKey);
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 3;
        Subject89 subject = new Subject89();
        List<Integer> list = subject.grayCode(n);
        System.out.println(Arrays.toString(list.toArray(new Integer[0])));
    }

}
