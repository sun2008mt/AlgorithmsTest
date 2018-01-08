package com.whu.sun;

/**
 * Created by Administrator on 2018/1/8.
 */
public class Operator {

    public static void main(String[] args) {
        Operator operator =  new Operator();
        int res = operator.aplusb_2(1, 3);
        System.out.println(res);

        int res2 = operator.aplusb_3(1, 3);
        System.out.println(res2);

        int res3 = operator.aminusb(1, 3);
        System.out.println(res3);

        long res4 = operator.jiecheng(11);
        System.out.println(res4);

        long res5 = operator.trailingZeros(105);
        System.out.println(res5);
    }

    //加法
    public int aplusb(int a, int b) {
        return a + b;
    }

    public int aplusb_2(int a, int b) {

        int carry = -1;           //进位
        while (carry != 0) {
            carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }

        return a;
    }

    public int aplusb_3(int a, int b) {

        if (0 == b) return a;
        else {
            int carry = (a & b) << 1;        //是否进位
            a = a ^ b;                        //不进位结果
            return aplusb_3(a, carry);
        }
    }

    //减法
    public int aminusb(int a, int b) {
        return aplusb_3(a, aplusb_3(~b, 1));
    }

    //阶乘
    private long jiecheng(long n) {
        if (n < 0) return -1;

        if (n == 0) return 1;

        return n * jiecheng(n - 1);
    }

    /*
     * 找出n的阶乘的结果尾部0的个数
     * @param n: An integer
     * @return: An integer, denote the number of trailing zeros in n!
     */
    public long trailingZeros(long n) {
        // write your code here, try to do it without arithmetic operators.

//        long res = jiecheng(n);
//
//        int count = 0;
//        while (res % 10 == 0) {
//            res = res / 10;
//            count++;
//        }
//
//        return count;

        long count = 0;
        long temp = n / 5;
        while (temp != 0) {
            count += temp;
            temp /= 5;
        }

        return count;
    }
}
