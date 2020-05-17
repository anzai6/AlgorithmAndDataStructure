package com.example.lib.course41_dynamicplanning3.my;

/**
 * 最长公共子串长度，比较两个字符串之间的编辑距离最长公共子串长度，比如：从"matcmu"到"mtacnu"的最长公共子串是"mtcu"，允许增加、删除,不许替换字符
 * 常用于拼写纠错，比如用户输入一个字符串单词，拿去跟词库单词比较，找到最长公共子串长度最长的单词，用于纠正用户输入的错误单词
 */
public class MyLongestCommonSubstring {

    char[] a;
    char[] b;
    int n;
    int m;
    int maxLength = Integer.MIN_VALUE;

    // 动态规划第一步：列出回溯算法代码

    public int getLength(String str1, String str2) {
        a = str1.toCharArray();
        n = str1.length();
        b = str2.toCharArray();
        m = str2.length();
        lengthList = new int[n][m];
//        getLengthByBa(0, 0, 0); // 回溯
//        return maxLength;
//        getLengthByRe(n - 1, m - 1); // 递归加备忘录
//        return lengthList[n - 1][m - 1];
        return getLengthByDp(); // 动态规划
    }

    /**
     * 回溯算法：getLengthByBa(0,0,0)
     *
     * @param i      字符数组a移动到第几位
     * @param j      字符数组b移动到第几位
     * @param length 已计算出的最长公共子串长度
     */
    public void getLengthByBa(int i, int j, int length) {
        if (i == n || j == m) {
            if (maxLength < length) // 求最大值
                maxLength = length;
            return;
        }

        if (a[i] == b[j]) {
            getLengthByBa(i + 1, j + 1, length + 1);
        } else {
            getLengthByBa(i + 1, j, length); // 数组a向前一位
            getLengthByBa(i, j + 1, length); // 数组b向前一位
            getLengthByBa(i + 1, j + 1, length); // 数组a和b分别向前一位
        }
    }

    // 根据回溯算法画出递归树，看是否存在重复子问题，如果存在则考虑动态规划算法，不存在则回溯算法就是最好的解决办法

    // 递归树自己画，这里重复子问题是：getLengthByBa(2, 3, 2)getLengthByBa(2, 3, 1)，取getLengthByBa(2, 3, 2)即可，因为要求最长公共子串长度

    // 根据递归树和重复子问题思考分析列出状态转移方程如下，1.可以根据状态转移方程画出一个二维状态表并翻译成代码
    // 2.可以通过递归加备忘录实现代码

    // 状态转移方程：
    // if (a[i] == b[j]) maxLength(i,j) = max(maxLength(i-1,j), maxLength(i,j-1), maxLength(i-1,j-1)+1)
    // if (a[i] != b[j]) maxLength(i,j) = max(maxLength(i-1,j), maxLength(i,j-1), maxLength(i-1,j-1))

    // 方程解释：首先分大前提是a[i] 和 b[j]能不能比较，
    // 如果不能比较（无论a[i] 与 b[j]等不等），无论是从哪一步上来的，长度都没有变化,即 maxLength(i,j) = min(maxLength(i-1,j), maxLength(i,j-1))；
    // 如果能比较，若a[i] == b[j] 则 maxLength(i,j) = maxLength(i-1,j-1)+1； 若a[i] != b[j] 则 maxLength(i,j) = maxLength(i-1,j-1)
    // 所以当a[i] == b[j]时，从不能比较的 max(maxLength(i-1,j), maxLength(i,j-1)) 加上能比较的 maxLength(i-1,j-1)
    // 就是: maxLength(i,j) = max(maxLength(i-1,j), maxLength(i,j-1), maxLength(i-1,j-1)+1);
    // 同理可以算 a[i] ！= b[j]

    // 1.根据状态转移方程,通过递归加备忘录实现代码
    int[][] lengthList; // 备忘录

    /**
     * 递归加备忘录：调用getLengthByRe(n-1,m-1);
     *
     * @param i
     * @param j
     * @return
     */
    public int getLengthByRe(int i, int j) {
        if (i == 0 || j == 0) {
            if (j > 0) {
                lengthList[0][j] = 0;
                return 0;
            } else if (i > 0) {
                lengthList[i][0] = 0;
                return 0;
            } else {
                if (a[i] == b[j]) {
                    lengthList[0][0] = 1;
                    return 1;
                } else {
                    lengthList[0][0] = 0;
                    return 0;
                }
            }
        }

        if (lengthList[i][j] > 0) { // 备忘录有值
            return lengthList[i][j];
        }

        int lowI = getLengthByRe(i - 1, j);
        int lowJ = getLengthByRe(i, j - 1);
        int last = getLengthByRe(i - 1, j - 1);
        int currentLength;

        if (a[i] == b[j]) {
            currentLength = max(lowI, lowJ, last + 1);
        } else {
            currentLength = max(lowI, lowJ, last);
        }
        lengthList[i][j] = currentLength;
        return currentLength;
    }

    // 2.根据状态转移方程画出二维数组状态表，然后就可以翻译成动态规划代码了,这里可以参照老师的自己花

    /**
     * 动态规划方程
     *
     * @return
     */
    public int getLengthByDp() {
        int[][] maxLength = new int[n][m];

        // 初始化第一行
        for (int i = 0; i < m; i++) {
            if (a[0] == b[0]) // 第一个相等，则都是1
                maxLength[0][i] = 1;
            else maxLength[0][i] = 0; // 不相等则都是0
        }

        // 初始化第一列
        for (int i = 0; i < n; i++) {
            if (a[0] == b[0]) // 第一个相等，则都是1
                maxLength[i][0] = 1;
            else maxLength[i][0] = 0; // 不相等则都是0
        }

        // 根据下列方程，动态规划处其它的值
        // if (a[i] == b[j]) maxLength(i,j) = max(maxLength(i-1,j), maxLength(i,j-1), maxLength(i-1,j-1)+1)
        // if (a[i] != b[j]) maxLength(i,j) = max(maxLength(i-1,j), maxLength(i,j-1), maxLength(i-1,j-1))
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                int lowI = maxLength[i - 1][j];
                int lowJ = maxLength[i][j - 1];
                int last = maxLength[i - 1][j - 1];
                if (a[i] == b[j]) {
                    maxLength[i][j] = max(lowI, lowJ, last + 1);
                } else {
                    maxLength[i][j] = max(lowI, lowJ, last);
                }
            }
        }


        return maxLength[n - 1][m - 1];
    }

    public int max(int a, int j, int h) {
        if (a > j)
            return a > h ? a : h;
        else
            return j > h ? j : h;
    }

    public static void main(String[] args) {
        MyLongestCommonSubstring myLongestCommonSubstring = new MyLongestCommonSubstring();
        System.out.println("最长公共子串的长度：" + myLongestCommonSubstring.getLength("mitcmu", "mtacnu"));
    }
}
