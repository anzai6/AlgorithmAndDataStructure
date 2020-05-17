package com.leetcode.anzai.subject_1_20;

/**
 * Z 字形变换
 * https://leetcode-cn.com/problems/zigzag-conversion/
 */
public class Subject6 {

    /**
     *
     将一个给定字符串根据给定的行数，以从上往下、从左到右进行?Z 字形排列。

     比如输入字符串为 "LEETCODEISHIRING"?行数为 3 时，排列如下：

     L   C   I   R
     E T O E S I I G
     E   D   H   N
     之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。

     请你实现这个将字符串进行指定行数变换的函数：

     string convert(string s, int numRows);
     示例?1:

     输入: s = "LEETCODEISHIRING", numRows = 3
     输出: "LCIRETOESIIGEDHN"
     示例?2:

     输入: s = "LEETCODEISHIRING", numRows =?4
     输出:?"LDREOEIIECIHNTSG"
     解释:

     L     D     R
     E   O E   I I
     E C   I H   N
     T     S     G

     L       D       R
     L     O D     R R
     E   O   E   I   I
     E C     I H     N
     T       S       G

     0       8         16
     1     7 9      15 17
     2   6   10   14   18
     3 5     11 13     19
     4       12        20
     *
     */


    /**
     * 根据上面字符下标规律找出了每一行的字符下标
     * 假设下标为：行数为i,最大行为n,则从左边第一列的字符下标可以推算出右边的字符下标，公式：
     * 第一个间隔数为： ,第二个间隔数为 2i-2
     * 假设n=5，当i=1,则 2n-2i = 8,2i-2=0, 所以坐标是 0-->8-->16 ...
     * 当i=2,则 2n-2i = 6,2i-2=2, 所以坐标是 1-->7-->9  9-->15-->17 ...
     * <p>
     * 0       8         16
     * 1     7 9      15 17
     * 2   6   10   14   18
     * 3 5     11 13     19
     * 4       12        20
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0)
            return s;
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int firstInterval = 2 * numRows - 2 * (i + 1); // 第一个间隔
            int secondInterval = 2 * i; // 第二个间隔
            int startIndex = i; // 左边第一列字符的初始下标

            while (startIndex < len) { // 添加一整行的数据
                sb.append(s.charAt(startIndex));

                // 只有一行的到单独处理
                if (firstInterval == 0 && secondInterval == 0) {
                    startIndex++;
                    continue;
                }

                if (firstInterval > 0) {
                    startIndex += firstInterval;

                    if (secondInterval == 0) // 第二个间隔为0就直接下循环
                        continue;


                    if (startIndex < len) {
                        sb.append(s.charAt(startIndex));
                        startIndex += secondInterval;
                    } else {
                        break;
                    }
                } else { // 第一个间隔是0就直接到第二个间隔
                    startIndex += secondInterval;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Subject6 subject = new Subject6();
        System.out.println(subject.convert("LEETCODEISHIRING", 1));
    }
}
