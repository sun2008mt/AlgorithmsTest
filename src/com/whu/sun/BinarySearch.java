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

    /**
     * 二分查找，数组已经排序，不过可能会有重复的元素
     *
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch2(int target, int[] nums) {
        //write your code here
        int low = 0, high = nums.length - 1;

        int res = -1;
        while(low <= high) {
            int mid = low + (high - low) / 2;

            if (target < nums[mid]) {
                high = mid - 1;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                res = mid;
                while (mid > 0) {
                    if (nums[mid] == nums[mid - 1]) {
                        res = mid - 1;
                    } else {
                        break;
                    }
                    mid--;
                }
                break;
            }
        }

        return res;
    }

    public static void main(String[] args) {

        BinarySearch binarySearch = new BinarySearch();

        int result = binarySearch.binarySearch(3, new int[] {1,6,9,4,5,2,7,0});
        System.out.println(result == -1);

        result = binarySearch.binarySearch(3, new int[] {1,6,9,4,5,2,7,0, 3});
        System.out.println(result == 3);

        result = binarySearch.binarySearch(3, new int[]{});
        System.out.println(result == -1);

        result = binarySearch.binarySearch2(17, new int[]{2,2,3,4,5,6,8,13,17,18});
        System.out.println(result == 8);
    }
}
