package com.example.lib.course41_dynamicplanning3.my;

/**
 * 莱文斯坦距离：比较两个字符串之间的编辑距离，比如：从"matcmu"到"mtacnu"需要多少步操作，允许增加、删除、替换字符，一共是3步
 * 常用于拼写纠错，比如用户输入一个字符串单词，拿去跟词库单词比较，找到编辑距离最小的单词，用于纠正用户输入的错误单词
 */

public class MyLevensteinDistance {

    char[] a;
    char[] b;
    int n;
    int m;
    int minDistance = Integer.MAX_VALUE;

    // 动态规划第一步：列出回溯算法代码

    public int getDistance(String str1, String str2) {
        a = str1.toCharArray();
        n = str1.length();
        b = str2.toCharArray();
        m = str2.length();
        distanceList = new int[n][m];
//        getDistanceByBa(0, 0, 0); // 回溯
        getDistanceByRe(n - 1, m - 1); // 递归加备忘录
        return distanceList[n - 1][m - 1];
//        return getDistanceByDp(); // 动态规划
    }

    /**
     * 回溯算法：getDistanceByBa(0,0,0)
     *
     * @param i        字符数组a移动到第几位
     * @param j        字符数组b移动到第几位
     * @param distance 已计算出的编辑距离
     */
    public void getDistanceByBa(int i, int j, int distance) {
        if (i == n || j == m) {
            if (i < n) distance = distance + n - i; // 数组a没遍历完所有字符
            if (j < m) distance = distance + m - j; // 数组b没遍历完所有字符
            if (minDistance > distance) // 求最小值
                minDistance = distance;
            return;
        }

        if (a[i] == b[j]) {
            getDistanceByBa(i + 1, j + 1, distance);
        } else {
            getDistanceByBa(i + 1, j, distance + 1); // 数组a向前一位
            getDistanceByBa(i, j + 1, distance + 1); // 数组b向前一位
            getDistanceByBa(i + 1, j + 1, distance + 1); // 数组a和b分别向前一位
        }
    }


    // 根据回溯算法画出递归树，看是否存在重复子问题，如果存在则考虑动态规划算法，不存在则回溯算法就是最好的解决办法

    // 递归树自己画，这里重复子问题是：getDistanceByBa(2, 3, 2)getDistanceByBa(2, 3, 3)，取getDistanceByBa(2, 3, 2)即可，因为要求最小距离

    // 根据递归树和重复子问题思考分析列出状态转移方程如下，1.可以根据状态转移方程画出一个二维状态表并翻译成代码
    // 2.可以通过递归加备忘录实现代码

    // 状态转移方程：
    // if (a[i] == b[j]) minDistance(i,j) = min(minDistance(i-1,j)+1, minDistance(i,j-1)+1, minDistance(i-1,j-1))
    // if (a[i] != b[j]) minDistance(i,j) = min(minDistance(i-1,j)+1, minDistance(i,j-1)+1, minDistance(i-1,j-1)+1)

    // 方程解释：首先分大前提是a[i] 和 b[j]能不能比较，
    // 如果不能比较（无论a[i] 与 b[j]等不等），无论是从哪一步上来的，都要+1,即 minDistance(i,j) = min(minDistance(i-1,j)+1, minDistance(i,j-1)+1)；
    // 如果能比较，若a[i] == b[j] 则 minDistance(i,j) = minDistance(i-1,j-1)； 若a[i] != b[j] 则 minDistance(i,j) = minDistance(i-1,j-1)+1
    // 所以当a[i] == b[j]时，从不能比较的min(minDistance(i-1,j)+1, minDistance(i,j-1)+1) 加上能比较的 minDistance(i-1,j-1) j
    // 就是: minDistance(i,j) = min(minDistance(i-1,j)+1, minDistance(i,j-1)+1, minDistance(i-1,j-1));
    // 同理可以算 a[i] ！= b[j]

    // 1.根据状态转移方程,通过递归加备忘录实现代码
    int[][] distanceList; // 备忘录

    /**
     * 递归加备忘录：调用getDistanceByRe(n-1,m-1);
     *
     * @param i
     * @param j
     * @return
     */
    public int getDistanceByRe(int i, int j) {
        if (i == 0 || j == 0) {
            if (j > 0) {
                distanceList[0][j] = j;
                return j;
            } else if (i > 0) {
                distanceList[i][0] = i;
                return i;
            } else {
                if (a[i] == b[j]) {
                    distanceList[0][0] = 0;
                    return 0;
                } else {
                    distanceList[0][0] = 1;
                    return 1;
                }
            }
        }

        if (distanceList[i][j] > 0) { // 备忘录有值
            return distanceList[i][j];
        }

        int lowI = getDistanceByRe(i - 1, j) + 1;
        int lowJ = getDistanceByRe(i, j - 1) + 1;
        int last = getDistanceByRe(i - 1, j - 1);
        int currentDistance;

        if (a[i] == b[j]) {
            currentDistance = min(lowI, lowJ, last);
        } else {
            currentDistance = min(lowI, lowJ, last + 1);
        }
        distanceList[i][j] = currentDistance;
        return currentDistance;
    }

    // 2.根据状态转移方程画出二维数组状态表，然后就可以翻译成动态规划代码了,这里可以参照老师的自己花

    /**
     * 动态规划方程
     *
     * @return
     */
    public int getDistanceByDp() {
        int[][] minDistances = new int[n][m];

        // 初始化第一行
        for (int i = 0; i < m; i++) {
            if (a[0] == b[0]) // 第一个相等就从0开始
                minDistances[0][i] = i;
            else minDistances[0][i] = i + 1; // 不相等则从1开始
        }

        // 初始化第一列
        for (int i = 0; i < n; i++) {
            if (a[0] == b[0]) // 第一个相等就从0开始
                minDistances[i][0] = i;
            else minDistances[i][0] = i + 1;  // 不相等则从1开始
        }

        // 根据下列方程，动态规划处其它的值
        // if (a[i] == b[j]) minDistance(i,j) = min(minDistance(i-1,j)+1, minDistance(i,j-1)+1, minDistance(i-1,j-1))
        // if (a[i] != b[j]) minDistance(i,j) = min(minDistance(i-1,j)+1, minDistance(i,j-1)+1, minDistance(i-1,j-1)+1)
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                int lowI = minDistances[i - 1][j] + 1;
                int lowJ = minDistances[i][j - 1] + 1;
                int last = minDistances[i - 1][j - 1];
                if (a[i] == b[j]) {
                    minDistances[i][j] = min(lowI, lowJ, last);
                } else {
                    minDistances[i][j] = min(lowI, lowJ, last + 1);
                }
            }
        }


        return minDistances[n - 1][m - 1];
    }

    public int min(int a, int j, int h) {
        if (a > j)
            return h > j ? j : h;
        else
            return a > h ? h : a;
    }


    public static void main(String[] args) {
        MyLevensteinDistance levensteinDistance = new MyLevensteinDistance();
        System.out.println("距离：" + levensteinDistance.getDistance("mitcmu", "mtacnu"));
    }
}
