package com.megetood.solution.nowcoder.bytecode;

import java.util.Scanner;

/**
 * todo
 *
 * @author Lei Chengdong
 * @date 2020/11/17
 */
public class StrCode {
    /*
        1. 三个同样的字母连在一起，一定是拼写错误，去掉一个的就好啦：比如 helllo -> hello
        2. 两对一样的字母（AABB型）连在一起，一定是拼写错误，去掉第二对的一个字母就好啦：比如 helloo -> hello
        3. 上面的规则优先“从左到右”匹配，即如果是AABBCC，虽然AABB和BBCC都是错误拼写，应该优先考虑修复AABB，结果为AABCC

        输入：
        第一行包括一个数字N，表示本次用例包括多少个待校验的字符串。
        后面跟随N行，每行为一个待校验的字符串。

        输出：
        N行，每行包括一个被修复后的字符串。

        2
        helloo
        wooooooow

        hello
        woow
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Scanner scanner = new Scanner(System.in);
        int times = 0;
        while (scanner.hasNextLine()) {
            if (times++ >= n) {
                return;
            }
            String curStr = scanner.nextLine();
            System.out.println(repair(curStr));
        }
    }

    private static String repair(String str) {
        if (str == null || str.length() < 3) {
            return str;
        }

        char lstore = str.charAt(0);
        char cstore = str.charAt(0);
        int lfreq = 0;
        int cfreq = 1;
        StringBuilder builder = new StringBuilder();
        builder.append(cstore);
        for (int i = 1; i < str.length(); i++) {
            char cur = str.charAt(i);
            if (cur == cstore) {
                cfreq++;
                if (lfreq == 2 && cfreq == 2) {
                    continue;
                } else if (cfreq > 2) {
                    continue;
                }

                builder.append(cur);

            } else {
                lfreq = cfreq;
                lstore = cstore;
                cfreq = 1;
                cstore = cur;

                builder.append(cur);
            }

        }

        return builder.toString();
    }
}
