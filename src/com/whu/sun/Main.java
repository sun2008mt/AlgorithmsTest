package com.whu.sun;

public class Main {

    public static void main(String[] args) {
        Main executor = new Main();

        int result = executor.oujilideAlgorithm(3, 2);
        System.out.println(result);

        result = executor.oujilideAlgorithm(5, 3);
        System.out.println(result);

        result = executor.oujilideAlgorithm(5, 0);
        System.out.println(result);

        result = executor.oujilideAlgorithm(20, 5);
        System.out.println(result);

        result = executor.oujilideAlgorithm(36, 24);
        System.out.println(result);

        result = executor.oujilideAlgorithm(-4, -6);
        System.out.println(result);
    }

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
}
