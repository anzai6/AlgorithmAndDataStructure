package com.example.lib.course41_dynamicplanning3.teacher;

/**
 * 莱文斯坦距离：比较两个字符串之间的编辑距离，比如：从"matcmu"到"mtacnu"需要多少步操作，允许增加、删除、替换字符，一共是3步
 * 常用于拼写纠错，比如用户输入一个字符串单词，拿去跟词库单词比较，找到编辑距离最小的单词，用于纠正用户输入的错误单词
 */

public class LevensteinDistance {

    private char[] a = "mitcmu".toCharArray();
    private char[] b = "mtacnu".toCharArray();
    private int n = a.length;
    private int m = b.length;
    private int minDist = Integer.MAX_VALUE; // 存储结果

    public int getDistance(String str1, String str2) {
        if (str1 == null || str1.length() == 0)
            return str2.length();
        if (str2 == null || str2.length() == 0)
            return str1.length();
        a = str1.toCharArray();
        b = str2.toCharArray();
        n = str1.length();
        m = str2.length();
//        minDist = Integer.MAX_VALUE;
//        lwstBT(0, 0, 0);
        return lwstDP(a, n, b, m);
    }

    // 回溯算法：调用方式 lwstBT(0, 0, 0);
    public void lwstBT(int i, int j, int edist) {
        if (i == n || j == m) {
            if (i < n) edist += (n - i);
            if (j < m) edist += (m - j);
            if (edist < minDist) minDist = edist;
            return;
        }
        if (a[i] == b[j]) { // 两个字符匹配
            lwstBT(i + 1, j + 1, edist);
        } else { // 两个字符不匹配
            lwstBT(i + 1, j, edist + 1); // 删除 a[i] 或者 b[j] 前添加一个字符
            lwstBT(i, j + 1, edist + 1); // 删除 b[j] 或者 a[i] 前添加一个字符
            lwstBT(i + 1, j + 1, edist + 1); // 将 a[i] 和 b[j] 替换为相同字符
        }
    }

    // 根据回溯算法画出递归树，看是否存在重复子问题，如果存在则考虑动态规划算法，不存在则回溯算法就是最好的解决办法


    // 根据递归树和重复子问题思考分析列出状态转移方程如下，1.可以根据状态转移方程画出一个二维状态表并翻译成代码
    // 2.可以通过递归加备忘录实现代码
    /*
        如果：a[i]!=b[j]，那么：min_edist(i, j) 就等于：
        min(min_edist(i-1,j)+1, min_edist(i,j-1)+1, min_edist(i-1,j-1)+1)

        如果：a[i]==b[j]，那么：min_edist(i, j) 就等于：
        min(min_edist(i-1,j)+1, min_edist(i,j-1)+1，min_edist(i-1,j-1))

        其中，min 表示求三数中的最小值。
    */

    /**
     * 动态规划的代码
     *
     * @param a
     * @param n
     * @param b
     * @param m
     * @return
     */
    public int lwstDP(char[] a, int n, char[] b, int m) {
        int[][] minDist = new int[n][m];
        for (int j = 0; j < m; ++j) { // 初始化第 0 行:a[0..0] 与 b[0..j] 的编辑距离
            if (a[0] == b[j]) minDist[0][j] = j;
            else if (j != 0) minDist[0][j] = minDist[0][j - 1] + 1;
            else minDist[0][j] = 1;
        }
        for (int i = 0; i < n; ++i) { // 初始化第 0 列:a[0..i] 与 b[0..0] 的编辑距离
            if (a[i] == b[0]) minDist[i][0] = i;
            else if (i != 0) minDist[i][0] = minDist[i - 1][0] + 1;
            else minDist[i][0] = 1;
        }
        for (int i = 1; i < n; ++i) { // 按行填表
            for (int j = 1; j < m; ++j) {
                if (a[i] == b[j]) minDist[i][j] = min(
                        minDist[i - 1][j] + 1, minDist[i][j - 1] + 1, minDist[i - 1][j - 1]);
                else minDist[i][j] = min(
                        minDist[i - 1][j] + 1, minDist[i][j - 1] + 1, minDist[i - 1][j - 1] + 1);
            }
        }
        return minDist[n - 1][m - 1];
    }

    private int min(int x, int y, int z) {
        int minv = Integer.MAX_VALUE;
        if (x < minv) minv = x;
        if (y < minv) minv = y;
        if (z < minv) minv = z;
        return minv;
    }


    public static void main(String[] args) {
        LevensteinDistance levensteinDistance = new LevensteinDistance();
        System.out.println("距离：" + levensteinDistance.getDistance("mitcmu", "mtacnu"));
    }
}
