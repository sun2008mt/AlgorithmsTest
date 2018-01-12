package com.whu.sun;

/**
 * Created by Administrator on 2018/1/11.
 */
public class StringPro {

    /*
    * 对于一个给定的 source 字符串和一个 target 字符串，你应该在 source 字符串中找出 target 字符串出现的第一个位置(从0开始)。如果不存在，则返回 -1。
    * */

    public static void main(String[] args) {
        StringPro sp = new StringPro();
        int res = sp.strStr("abfadfefasdf", "fa");
        System.out.println(res == 2);

        System.out.println(sp.reverseStr("abcedfg"));
    }

    /*
     * @param source: source string to be scanned.
     * @param target: target string containing the sequence of characters to match
     * @return: a index to the first occurrence of target in source, or -1  if target is not part of source.
     */
    public int strStr(String source, String target) {
        // write your code here
        if (source == null || target == null) {
            return -1;
        }

        for (int i = 0; i < source.length() - target.length() + 1; i++) {
            int j = 0;

            //需要每个字符都匹配
            for (j = 0; j < target.length(); j++) {
                if (source.charAt(i + j) != target.charAt(j)) {
                    break;             //如果有字符不匹配，则跳出子循环
                }
            }

            if (j == target.length()) {
                return i;
            }
        }

        return -1;
//        return source.indexOf(target);
    }

    public int strStrKMP(String source, String target) {

        return  -1;
    }

    /*
     * 反转字符串
     * @param s: A string
     * @return: A string
     */
    public String reverseStr(String s) {
        if (s == null || s.length() <= 1) return s;

        char[] chars = s.toCharArray();
        char temp;
        for (int i = 0; i < chars.length >> 1; i++) {
            temp = chars[i];
            chars[i] = chars[chars.length - i - 1];
            chars[chars.length - i - 1] = temp;
        }

        return String.valueOf(chars);
    }
}
