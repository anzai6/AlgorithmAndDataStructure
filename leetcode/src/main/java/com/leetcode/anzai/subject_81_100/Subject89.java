package com.leetcode.anzai.subject_81_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 格雷编码
 * https://leetcode-cn.com/problems/gray-code/
 */
public class Subject89 {

    /**
     *
     格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。

     给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。格雷编码序列必须以 0 开头。

     示例 1:

     输入: 2
     输出: [0,1,3,2]
     解释:
     00 - 0
     01 - 1
     11 - 3
     10 - 2


     对于给定的 n，其格雷编码序列并不唯一。
     例如，[0,2,3,1] 也是一个有效的格雷编码序列。

     00 - 0
     10 - 2
     11 - 3
     01 - 1
     示例 2:



     000 0
     001 1
     011 3
     010 2
     110 6
     111 7
     101 5
     100 4


     输入: 0
     输出: [0]
     解释: 我们定义格雷编码序列必须以 0 开头。
     给定编码总位数为 n 的格雷编码序列，其长度为 2^n。当 n = 0 时，长度为 2^0 = 1。
     因此，当 n = 0 时，其格雷编码序列为 [0]。
     *
     */

    /**
     * 一位一位取反进行回溯 比如，000：依次回溯 100,010,001；100：依次回溯 000,110,101
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
     * 一位一位取反进行回溯 比如，000：依次回溯 100,010,001；100：依次回溯 000,110,101
     *
     * @param key     当前需要回溯的值
     * @param n       位数
     * @param size    一共有多少个数组
     * @param hashMap 备忘录
     * @param list    结果
     */
    public void grayCodeInteval(int key, int n, int size, HashMap<Integer, Integer> hashMap, List<Integer> list) {
        if (hashMap.size() == size) {
            return;
        }
        // 遍历每一位进行取反
        for (int i = 0; i < n; i++) {
            // 先位移再异或就可以让第i位取反了
            int newKey = (1 << i) ^ key;
            if (hashMap.containsKey(newKey)) {
                continue;
            } else {
                hashMap.put(newKey, 1);
                list.add(newKey);
                grayCodeInteval(newKey, n, size, hashMap, list);
                if (hashMap.size() == size) {
                    return;
                } else { // 还原值进行回溯
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
