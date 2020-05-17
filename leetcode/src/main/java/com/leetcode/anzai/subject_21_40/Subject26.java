package com.leetcode.anzai.subject_21_40;

/**
 * ɾ�����������е��ظ���
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */
public class Subject26 {

    /**
     *
     ����һ���������飬����Ҫ��ԭ��ɾ���ظ����ֵ�Ԫ�أ�ʹ��ÿ��Ԫ��ֻ����һ�Σ������Ƴ���������³��ȡ�

     ��Ҫʹ�ö��������ռ䣬�������ԭ���޸��������鲢��ʹ�� O(1) ����ռ����������ɡ�

     ʾ��?1:

     �������� nums = [1,1,2],

     ����Ӧ�÷����µĳ��� 2, ����ԭ���� nums ��ǰ����Ԫ�ر��޸�Ϊ 1, 2��

     �㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�
     ʾ��?2:

     ���� nums = [0,0,1,1,1,2,2,3,3,4],

     ����Ӧ�÷����µĳ��� 5, ����ԭ���� nums ��ǰ���Ԫ�ر��޸�Ϊ 0, 1, 2, 3, 4��

     �㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�
     ˵��:

     Ϊʲô������ֵ��������������Ĵ���������?

     ��ע�⣬�����������ԡ����á���ʽ���ݵģ�����ζ���ں������޸�����������ڵ������ǿɼ��ġ�

     ����������ڲ���������:

     // nums ���ԡ����á���ʽ���ݵġ�Ҳ����˵������ʵ�����κο���
     int len = removeDuplicates(nums);

     // �ں������޸�����������ڵ������ǿɼ��ġ�
     // ������ĺ������صĳ���, �����ӡ�������иó��ȷ�Χ�ڵ�����Ԫ�ء�
     for (int i = 0; i < len; i++) {
     ? ? print(nums[i]);
     }
     *
     */

    /**
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int lastValue = nums[0];
        int index = 0; // �洢�Ѿ��ƶ��õ�������±�
        for (int i = 1; i < nums.length; i++) {
            int currentValue = nums[i];
            if (currentValue == lastValue) {

            } else {
                index++;
                if (i != index)
                    nums[index] = currentValue;
                lastValue = currentValue;
            }
        }
        return index + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        Subject26 subject = new Subject26();
        int len = subject.removeDuplicates(nums);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
