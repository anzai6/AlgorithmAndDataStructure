package com.leetcode.anzai.subject_21_40;

/**
 * 报数
 * https://leetcode-cn.com/problems/count-and-say/
 */
public class Subject38 {

    /**
     *
     报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：

     1.     1
     2.     11
     3.     21
     4.     1211
     5.     111221
     6.     312211
     7.     13112221
     1?被读作??"one 1"??("一个一") , 即?11。
     11 被读作?"two 1s"?("两个一"）, 即?21。
     21 被读作?"one 2", ?"one 1"?（"一个二"?,??"一个一")?, 即?1211。

     给定一个正整数 n（1 ≤?n?≤ 30），输出报数序列的第 n 项。

     注意：整数顺序将表示为一个字符串。

     ?

     示例?1:

     输入: 1
     输出: "1"
     示例 2:

     输入: 4
     输出: "1211"
     *
     */

    /**
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        return countAndSayInternal(1, n, "1");
    }

    /**
     * 调用 countAndSayInternal(1, n, "1");
     *
     * @param i     已经执行了第 i 项
     * @param n     一共要执行多少项
     * @param value 已经执行了第 i 项的序列
     * @return
     */
    private String countAndSayInternal(int i, int n, String value) {
        if (i >= n)
            return value;

        StringBuilder sb = new StringBuilder();
        char lastChar = value.charAt(0);
        int count = 1;
        for (int j = 1; j < value.length(); j++) {
            char currentChar = value.charAt(j);
            if (lastChar == currentChar) {
                count++;
            } else {
                sb.append(count).append(lastChar);
                lastChar = currentChar;
                count = 1;
            }
        }
        sb.append(count).append(lastChar);

        return countAndSayInternal(i + 1, n, sb.toString());
    }

    public static void main(String[] args) {
        Subject38 subject = new Subject38();
        System.out.println(subject.countAndSay(7));
    }

}
