package com.leetcode.anzai.subject_1_20;

/**
 * Ѱ�����������������λ��
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 */
public class Subject4 {

    /**
     *
     ����������СΪ m �� n ����������  nums1 ��  nums2��

     �����ҳ������������������λ��������Ҫ���㷨��ʱ�临�Ӷ�Ϊ  O(log(m + n))��

     ����Լ���  nums1  ��  nums2  ����ͬʱΪ�ա�

     ʾ�� 1:

     nums1 = [1, 3]
     nums2 = [2]

     ����λ���� 2.0
     ʾ�� 2:

     nums1 = [1, 2]
     nums2 = [3, 4]

     ����λ���� (2 + 3)/2 = 2.5

     ѡ��һ���������λ�����ж��ֲ�����һ������
     ���ֲ���
     *
     */

    /**
     *
     * @param A
     * @param B
     * @return
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j-1] > A[i]){
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = i - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
//        -3, 4, 3, 90
        int[] nums1 = new int[]{1};
        int[] nums2 = new int[]{1};
//        int[] nums1 = new int[]{1,2,4,6,10,12,15,72,89,90,100,102};
//        int[] nums2 = new int[]{3,5,7,8,16,20,34,46,51,67};
        Subject4 subject = new Subject4();
        double result = subject.findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
    }
}
