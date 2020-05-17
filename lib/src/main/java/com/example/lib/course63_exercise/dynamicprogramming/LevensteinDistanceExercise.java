package com.example.lib.course63_exercise.dynamicprogramming;

/**
 * 莱文斯坦距离：比较两个字符串之间的编辑距离，比如：从"matcmu"到"mtacnu"需要多少步操作，允许增加、删除、替换字符，一共是3步
 * 常用于拼写纠错，比如用户输入一个字符串单词，拿去跟词库单词比较，找到编辑距离最小的单词，用于纠正用户输入的错误单词
 */
public class LevensteinDistanceExercise {

    private char[] a = "mitcmu".toCharArray();
    private char[] b = "mtacnu".toCharArray();
    private int n = a.length;
    private int m = b.length;
    private int minDist = Integer.MAX_VALUE; // 存储结果

    public int getLevensteinDistance(String str1, String str2) {
        a = str1.toCharArray();
        b = str2.toCharArray();
        n = a.length;
        m = b.length;
//        lwstBT(0, 0, 0);
//        return minDist;

        return lwstDP();
    }

    /**
     * 计算莱文斯坦距离的回溯算法
     *
     * @param i    数组a的下标
     * @param j    数组b的下标
     * @param dist 当前的莱文斯坦距离
     */
    private void lwstBT(int i, int j, int dist) {
        if (i == n || j == m) {
            if (i == n)
                dist += m - j;
            else dist += n - i;
            if (minDist > dist)
                minDist = dist;
            return;
        }

        if (a[i] == b[j]) {
            lwstBT(i + 1, j + 1, dist);
        } else {
            lwstBT(i + 1, j, dist + 1); // 数组a进一位
            lwstBT(i, j + 1, dist + 1); // 数组b进一位
            lwstBT(i + 1, j + 1, dist + 1); // 数组a和b都进一位
        }
    }

    // 回溯公式：f(i,j): 当a[i] == b[j] -> f(i,j) = min( f(i-1,j-1), f(i-1,j)+1, f(i,j-1)+1 )
    // 当a[i] != b[j] -> f(i,j) = min( f(i-1,j-1)+1, f(i-1,j)+1, f(i,j-1)+1 )

    /**
     * 动态规划算法
     *
     * @return
     */
    private int lwstDP() {
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

    /**
     * 求三个数最小值
     *
     * @param i
     * @param j
     * @param f
     * @return
     */
    private int min(int i, int j, int f) {
        if (i > j) {
            return j > f ? f : j;
        } else {
            return i > f ? f : i;
        }
    }

    public static void main(String[] args) {
        LevensteinDistanceExercise levensteinDistance = new LevensteinDistanceExercise();
        System.out.println("距离：" + levensteinDistance.getLevensteinDistance("mitcmu", "mtacnu"));
    }

}
