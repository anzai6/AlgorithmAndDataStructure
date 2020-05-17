package com.leetcode.anzai.subject_21_40;

/**
 * �Ƴ�Ԫ��
 * https://leetcode-cn.com/problems/remove-element/
 */
public class Subject27 {

    /**
     *
     ����һ������ nums?��һ��ֵ val������Ҫԭ���Ƴ�������ֵ����?val?��Ԫ�أ������Ƴ���������³��ȡ�

     ��Ҫʹ�ö��������ռ䣬�������ԭ���޸��������鲢��ʹ�� O(1) ����ռ����������ɡ�

     Ԫ�ص�˳����Ըı䡣�㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�

     ʾ�� 1:

     ���� nums = [3,2,2,3], val = 3,

     ����Ӧ�÷����µĳ��� 2, ���� nums �е�ǰ����Ԫ�ؾ�Ϊ 2��

     �㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�
     ʾ��?2:

     ���� nums = [0,1,2,2,3,0,4,2], val = 2,

     ����Ӧ�÷����µĳ��� 5, ���� nums �е�ǰ���Ԫ��Ϊ 0, 1, 3, 0, 4��

     ע�������Ԫ�ؿ�Ϊ����˳��

     �㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�
     ˵��:

     Ϊʲô������ֵ��������������Ĵ���������?

     ��ע�⣬�����������ԡ����á���ʽ���ݵģ�����ζ���ں������޸�����������ڵ������ǿɼ��ġ�

     ����������ڲ���������:

     // nums ���ԡ����á���ʽ���ݵġ�Ҳ����˵������ʵ�����κο���
     int len = removeElement(nums, val);

     // �ں������޸�����������ڵ������ǿɼ��ġ�
     // ������ĺ������صĳ���, �����ӡ�������иó��ȷ�Χ�ڵ�����Ԫ�ء�
     for (int i = 0; i < len; i++) {
     ? ? print(nums[i]);
     }
     *
     */

    /**
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0)
            return 0;
        int index = 0; // �洢�Ѿ��ƶ��õ�������±�
        for (int i = 0; i < nums.length; i++) {
            int currentValue = nums[i];
            if (currentValue != val) {
                if (i != index)
                    nums[index] = currentValue;
                index++;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,2,3};
        Subject27 subject = new Subject27();
        int len = subject.removeElement(nums, 1);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
