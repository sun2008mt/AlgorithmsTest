package com.whu.sun;

/**
 * Created by Administrator on 2018/1/12.
 */
public class NumberPro {

    public static void main(String[] args) {
        NumberPro np = new NumberPro();
        int res = np.reverseInteger(123);
        System.out.println(res);

        String str = reverse("123");
        System.out.println(str);

        res = np.reverseInteger2(-134);
        System.out.println(res);

        res = np.reverseInteger3(-12546);
        System.out.println(res);
    }

    /**
     * 反转字符串
     *
     * @param s 待反转字符串
     * @return 反转字符串
     */
    public static String reverse(final String s) {
        if (s == null || s.length() <= 1) return s;

        char[] chars = s.trim().toCharArray();
        char temp;
        for (int i = 0; i < chars.length >> 1; i++) {
            temp = chars[i];
            chars[i] = chars[chars.length - i - 1];
            chars[chars.length - i - 1] = temp;
        }

        return String.valueOf(chars);
    }

    /*
     * 将一个整数中的数字进行颠倒，当颠倒后的整数溢出时，返回 0 (标记为 32 位整数)。
     * 给定 x = 123，返回 321; 给定 x = -123，返回 -321
     * @param n: the integer to be reversed
     * @return: the reversed integer
     */
    public int reverseInteger(int n) {
        // write your code here
        if (n >= -9 && n <= 9) {
            return n;
        }

        int res = -1;
        if (n > 0) {
            res = reverseIntegerPositive(n);
        } else {
            res = -reverseIntegerPositive(-n);
        }

        return res;
    }

    public int reverseIntegerPositive(int n) {
        if (n <= 9) return n;

        String reverseStr = reverse(String.valueOf(n));
        long res = Long.valueOf(reverseStr);
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return 0;
        }

        return (int) res;
    }

    public int reverseInteger2(int n) {
        // write your code here
        if (n >= -9 && n <= 9) return n;

        int length = String.valueOf(n).length();;
        boolean isPositive = true;

        if (n < 0) {
            isPositive = false;    //负数
            length -= 1;
        }

        int[] nums = new int[length];
        int num = Math.abs(n), count = 0;
        while (num > 0) {
            int code = num % 10;   //从个位数开始的每一位
            nums[count] = code;
            num /= 10;            //去掉最低位

            count++;
        }

        long res = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            res += nums[i] * Math.pow(10, nums.length - i - 1);
        }

        res = (isPositive ? res : -res);

        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return 0;
        }

        return (int) res;
    }

    public int reverseInteger3(int n) {
        int reversed_n = 0;

        while (n != 0) {
            int temp = reversed_n * 10 + n % 10;
            n = n / 10;
            if (temp / 10 != reversed_n) {
                reversed_n = 0;
                break;
            }
            reversed_n = temp;
        }
        return reversed_n;
    }
}
