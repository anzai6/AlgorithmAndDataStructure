package com.leetcode.anzai.subject_61_80;

/**
 * 编辑距离
 * https://leetcode-cn.com/problems/edit-distance/
 */
public class Subject72 {

    /**
     *
     给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。

     你可以对一个单词进行如下三种操作：

     插入一个字符
     删除一个字符
     替换一个字符
     示例 1:

     输入: word1 = "horse", word2 = "ros"
     输出: 3
     解释:
     horse -> rorse (将 'h' 替换为 'r')
     rorse -> rose (删除 'r')
     rose -> ros (删除 'e')
     示例 2:

     输入: word1 = "intention", word2 = "execution"
     输出: 5
     解释:
     intention -> inention (删除 't')
     inention -> enention (将 'i' 替换为 'e')
     enention -> exention (将 'n' 替换为 'x')
     exention -> exection (将 'n' 替换为 'c')
     exection -> execution (插入 'u')
     *
     */

    /**
     * 借助回溯算法找出了动态转移方程，实施动态规划解法
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return -1;
        }

        int len1 = word1.length();
        int len2 = word2.length();

//        if (len1 == 0) {
//            return len2;
//        }
//        if (len2 == 0) {
//            return len1;
//        }
        // 官方的写法，比上面我的好多了
        if (len1 * len2 == 0) {
            return len1 + len2;
        }

        int[][] result = new int[len1][len2];

        boolean hasSameChar = false;
        // 初始化第一行
        for (int i = 0; i < len2; i++) {
            if (!hasSameChar && word1.charAt(0) == word2.charAt(i)) {
                hasSameChar = true;
            }
            if (hasSameChar) {
                result[0][i] = i;
            } else {
                result[0][i] = i + 1;
            }
        }
        hasSameChar = false;
        // 初始化第一列
        for (int i = 0; i < len1; i++) {
            if (!hasSameChar && word2.charAt(0) == word1.charAt(i)) {
                hasSameChar = true;
            }
            if (hasSameChar) {
                result[i][0] = i;
            } else {
                result[i][0] = i + 1;
            }
        }

        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    result[i][j] = minNum(result[i - 1][j] + 1, result[i][j - 1] + 1, result[i - 1][j - 1]);
                } else {
                    result[i][j] = minNum(result[i - 1][j] + 1, result[i][j - 1] + 1, result[i - 1][j - 1] + 1);
                }
            }
        }

        return result[len1 - 1][len2 - 1];
    }

    /**
     * 回溯算法实现,没加备忘录妥妥超时，添加备忘录
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance1(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return -1;
        }

        int len1 = word1.length();
        int len2 = word2.length();

        if (len1 == 0) {
            return len2;
        }
        if (len2 == 0) {
            return len1;
        }

        int[][] result = new int[len1][len2];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                result[i][j] = -1;
            }
        }
        minDistanceInterval(word1, len1 - 1, word2, len2 - 1, result);
        return result[len1 - 1][len2 - 1];
    }

    /**
     * 回溯的递归调用,初始调用方式： minDistanceInterval(word1,word1.length()-1,word2,word2.length()-1);
     * <p>
     * 通过比较最后一个字符是否相等，分成两种情况：
     * f(i,j) = min(f(i-1,j) + 1,f(i,j-1) + 1,f(i-1,j-1) + 1) 和 f(i,j) = min(f(i-1,j) + 1,f(i,j-1) + 1,f(i-1,j-1))
     * 这里 i 和 j 代表两个字符串比较编辑距离的下标
     *
     * @param word1
     * @param index1 word1的下标，相当于取0~index1的字符来比较
     * @param word2
     * @param index2 word2的下标，相当于取0~index2的字符来比较
     * @param result 记录结果
     * @return
     */
    public void minDistanceInterval(String word1, int index1, String word2, int index2, int[][] result) {

        if (result[index1][index2] != -1) {
            return;
        }

        if (index1 == 0) {
            boolean hasSameChar = false;
            for (int i = 0; i <= index2; i++) {
                if (word1.charAt(0) == word2.charAt(i)) {
                    hasSameChar = true;
                    break;
                }
            }
            if (hasSameChar) {
                result[index1][index2] = index2;
            } else {
                result[index1][index2] = index2 + 1;
            }
            return;
        }

        if (index2 == 0) {
            boolean hasSameChar = false;
            for (int i = 0; i <= index1; i++) {
                if (word2.charAt(0) == word1.charAt(i)) {
                    hasSameChar = true;
                    break;
                }
            }
            if (hasSameChar) {
                result[index1][index2] = index1;
            } else {
                result[index1][index2] = index1 + 1;
            }
            return;
        }

        minDistanceInterval(word1, index1 - 1, word2, index2, result);
        minDistanceInterval(word1, index1, word2, index2 - 1, result);
        minDistanceInterval(word1, index1 - 1, word2, index2 - 1, result);
        int num1 = result[index1 - 1][index2] + 1;
        int num2 = result[index1][index2 - 1] + 1;
        int num3 = result[index1 - 1][index2 - 1];

        if (word1.charAt(index1) != word2.charAt(index2)) { // 两个字符串的最后一个字符不相同
            num3 += 1;
        }

        result[index1][index2] = minNum(num1, num2, num3);
    }

    private int minNum(int num1, int num2, int num3) {
        if (num1 > num2) {
            return num2 > num3 ? num3 : num2;
        } else {
            return num1 > num3 ? num3 : num1;
        }
    }

    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        word1 = "intention";
        word2 = "execution";
        word1 = "dinitrophenylhydrazine";
        word2 = "acetylphenylhydrazine";
        Subject72 subject = new Subject72();
        System.out.println(subject.minDistance(word1, word2));
    }

}
