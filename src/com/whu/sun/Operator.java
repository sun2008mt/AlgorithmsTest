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
}
