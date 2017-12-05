package com.whu.sun;

import java.util.Arrays;

public class BinarySearch {

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

    public static void main(String[] args) {
        System.out.println("测试...");
        BinarySearch binarySearch = new BinarySearch();

        int result = binarySearch.binarySearch(3, new int[] {1,6,9,4,5,2,7,0});
        assert result == -1;

        result = binarySearch.binarySearch(3, new int[] {1,6,9,4,5,2,7,0, 3});
        assert result == 3;

        result = binarySearch.binarySearch(3, new int[]{});
        assert result == -1;
    }
}
