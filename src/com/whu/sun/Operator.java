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

    /*
    * 给出两个整数a和b, 求他们的和, 但不能使用 + 等数学运算符
    *
    * */

    public int aplusb_2(int a, int b) {
        // 主要利用异或运算来完成
        // 异或运算有一个别名叫做：不进位加法
        // 那么a ^ b就是a和b相加之后，该进位的地方不进位的结果
        // 然后下面考虑哪些地方要进位，自然是a和b里都是1的地方
        // a & b就是a和b里都是1的那些位置，a & b << 1 就是进位
        // 之后的结果。所以：a + b = (a ^ b) + (a & b << 1)
        // 令a' = a ^ b, b' = (a & b) << 1
        // 可以知道，这个过程是在模拟加法的运算过程，进位不可能
        // 一直持续，所以b最终会变为0。因此重复做上述操作就可以
        // 求得a + b的值。

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
     * 计算出n阶乘中尾部零的个数
     * 11! = 39916800，因此应该返回 2
     *
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

        while (n != 0) {
            count += n / 5;
            n /= 5;
        }

        return count;
    }
}
