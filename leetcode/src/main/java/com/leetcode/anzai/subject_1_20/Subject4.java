package com.leetcode.anzai.subject_1_20;

/**
 * 寻找两个有序数组的中位数
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 */
public class Subject4 {

    /**
     *
     给定两个大小为 m 和 n 的有序数组  nums1 和  nums2。

     请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为  O(log(m + n))。

     你可以假设  nums1  和  nums2  不会同时为空。

     示例 1:

     nums1 = [1, 3]
     nums2 = [2]

     则中位数是 2.0
     示例 2:

     nums1 = [1, 2]
     nums2 = [3, 4]

     则中位数是 (2 + 3)/2 = 2.5

     选择一个数组的中位数进行二分插入另一个数组
     二分插入
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
