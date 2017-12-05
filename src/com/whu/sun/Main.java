package com.whu.sun;

import java.util.Arrays;

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

        result = executor.binarySearch(3, new int[] {1,6,9,4,5,2,7,0});
        System.out.println(result);

        result = executor.binarySearch(3, new int[] {1,6,9,4,5,2,7,0, 3});
        System.out.println(result);
    }

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

    //二分查找
    private int binarySearch(int key, int[] array) {
        int res = -1;

        if (array != null && array.length > 0) {

            boolean hasKey = false;
            for (int num: array) {
                if (key == num) {
                    hasKey = true;
                }
            }

            System.out.println(hasKey);

            if (hasKey) {
                Arrays.sort(array);

                int start = 0, end = array.length - 1;

                while (start <= end) {
                    int middle = start + (end - start) / 2;

                    if (key < array[middle]) {
                        end = middle - 1;
                    } else if (key > array[middle]) {
                        start = middle + 1;
                    } else {
                        res = middle;
                        break;
                    }
                }
            }
        }

        return res;
    }
}
