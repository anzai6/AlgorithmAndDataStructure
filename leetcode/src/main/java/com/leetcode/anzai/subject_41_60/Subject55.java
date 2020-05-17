package com.leetcode.anzai.subject_41_60;

/**
 * ��Ծ��Ϸ
 * https://leetcode-cn.com/problems/jump-game/
 */
public class Subject55 {

    /**
     *
     ����һ���Ǹ��������飬�����λ������ĵ�һ��λ�á�

     �����е�ÿ��Ԫ�ش������ڸ�λ�ÿ�����Ծ����󳤶ȡ�

     �ж����Ƿ��ܹ��������һ��λ�á�

     ʾ��?1:

     ����: [2,3,1,1,4]
     ���: true
     ����: ���ǿ������� 1 ������λ�� 0 ���� λ�� 1, Ȼ���ٴ�λ�� 1 �� 3 ���������һ��λ�á�
     ʾ��?2:

     ����: [3,2,1,0,4]
     ���: false
     ����: �������������ܻᵽ������Ϊ 3 ��λ�á�����λ�õ������Ծ������ 0 �� ��������Զ�����ܵ������һ��λ�á�
     *
     */

    /**
     * ̰���㷨��һ�������������Զ��Ծλ��
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int fastPos = 0; // ��Զλ��
        for (int i = 0; i < nums.length; i++) {
            if (fastPos < i) { // ���治�ñ�����
                return false;
            }
            int pos = i + nums[i];
            if (fastPos < pos) {
                fastPos = pos;
            }
            if (fastPos >= nums.length - 1) { // �����յ�
                return true;
            }
        }
        System.out.println(fastPos);
        return true;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{3, 2, 1, 0, 4};
        int[] nums = new int[]{1, 0, 0, 0, 4};
        Subject55 subject = new Subject55();
        System.out.print(subject.canJump(nums));
    }

}
