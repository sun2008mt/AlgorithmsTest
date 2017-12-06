package com.whu.sun;

public class Oujilide {

    //欧几里德算法
    private int oujilideAlgorithm(int p, int q) {
        int res = -1;

        if (p >= 0 && q >= 0) {
            if (q == 0) {
                res = p;
            } else {
                res = oujilideAlgorithm(q, p % q);
            }
        }

        return res;
    }

    public static void main(String[] args) {

        Oujilide oujilide = new Oujilide();

        int result = oujilide.oujilideAlgorithm(3, 2);
        assert result == 1;

        result = oujilide.oujilideAlgorithm(5, 3);
        assert result == 1;

        result = oujilide.oujilideAlgorithm(5, 0);
        assert result == 5;

        result = oujilide.oujilideAlgorithm(20, 5);
        assert result == 5;

        result = oujilide.oujilideAlgorithm(36, 24);
        assert result == 12;

        result = oujilide.oujilideAlgorithm(-4, -6);
        assert result == -1;

        System.out.println("测试通过...");
    }
}
