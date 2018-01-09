package com.whu.sun;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2018/1/9.
 */
public class AppearTimes {

    /*
    * 计算数字k在0到n中的出现的次数，k可能是0~9的一个值
    * 例如n=12，k=1，在 [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]，我们发现1出现了5次 (1, 10, 11, 12)
    * */

    public static void main(String[] args) {
        AppearTimes at = new AppearTimes();
        int res = at.digitCounts(1, 123);

        System.out.println(res);
    }

    /*
     * @param : An integer
     * @param : An integer
     * @return: An integer denote the count of digit k in 1..n
     */
    public int digitCounts(int k, int n) {
        // write your code here

        String num1 = String.valueOf(k);

        int res = 0;

        for (int i = k; i <= n; i++) {
            String num2 = String.valueOf(i);

            int count = countInnerStr(num2, num1);

            res += count;
        }

        return res;
    }

    /*
    * 计算字符串中包含同一个子字符串的个数
    * */
    private int countInnerStr(String str, String patternStr) {
        int count = 0;

        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(str);

        while (matcher.find()) {
            count++;
        }

        return count;
    }
}
