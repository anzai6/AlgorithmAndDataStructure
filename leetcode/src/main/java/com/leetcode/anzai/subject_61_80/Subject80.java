package com.leetcode.anzai.subject_61_80;

/**
 * ɾ�����������е��ظ��� II
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
 */
public class Subject80 {

    /**
     *
     ����һ���������飬����Ҫ��ԭ��ɾ���ظ����ֵ�Ԫ�أ�ʹ��ÿ��Ԫ�����������Σ������Ƴ���������³��ȡ�

     ��Ҫʹ�ö��������ռ䣬�������ԭ���޸��������鲢��ʹ�� O(1) ����ռ����������ɡ�

     ʾ��  1:

     ���� nums = [1,1,1,2,2,3],

     ����Ӧ�����³��� length = 5, ����ԭ�����ǰ���Ԫ�ر��޸�Ϊ 1, 1, 2, 2, 3 ��

     �㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�
     ʾ��  2:

     ���� nums = [0,0,1,1,1,1,2,3,3],

     ����Ӧ�����³��� length = 7, ����ԭ�����ǰ���Ԫ�ر��޸�Ϊ  0, 0, 1, 1, 2, 3, 3 ��

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
     print(nums[i]);
     }
     *
     */

    /**
     * ����һ�鼴�ɽ�����ؼ������Ӽ�������������: ��������������һλԪ�أ���������������һλԪ�صĸ���������������ĳ���
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int newArrayLastItem = nums[0]; // ��������������һλԪ��
        int newArrayLastItemCount = 1; // ��������������һλԪ�صĸ���,�������
        int newArrayLen = 1; // ����������ĳ���

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != newArrayLastItem) { // ������ͬ��Ԫ�أ�����������
                newArrayLastItem = nums[i];
                newArrayLastItemCount = 1;
                nums[newArrayLen++] = newArrayLastItem;
            } else if (newArrayLastItemCount == 1) { // ������ͬ��Ԫ��ʱ��ԭ��ֻ��һ���ľ��ټ�һ��
                newArrayLastItemCount = 2;
                nums[newArrayLen++] = newArrayLastItem;
            }
        }
        return newArrayLen;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
//        nums = new int[]{0,0,1,1,1,1,2,3,3};
//        nums = new int[]{0,0,0,1,1,1,2,3,3,3};
        Subject80 subject = new Subject80();
        System.out.println(subject.removeDuplicates(nums));
    }

}
