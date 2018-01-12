package com.whu.sun;

import java.util.LinkedList;

/**
 * Created by Administrator on 2018/1/12.
 */
public class ArrayPro {

    public static void main(String[] args) {
        ArrayPro ap = new ArrayPro();

        int[] A = {1, 2, 3, 4}, B = {2, 4, 5, 6};
        int[] res = ap.mergeSortedArray(A, B);

        for (int num: res) {
            System.out.println(num);
        }
    }

    /*
     * 合并两个排序的整数数组A和B变成一个新的数组
     * 给出A=[1,2,3,4]，B=[2,4,5,6]，返回 [1,2,2,3,4,4,5,6]
     * @param A: sorted integer array A
     * @param B: sorted integer array B
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        // write your code here

        LinkedList<Integer> numsMerged = new LinkedList<>();
        for (int i = 0; i < A.length; i++) {
            numsMerged.add(A[i]);
        }

        int[] insertIndexes = new int[B.length];
        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < A.length - 1; j++) {
                if ((B[i] >= A[j] && B[i] <= A[j + 1]) || B[i] > A[A.length - 1]) {
                    insertIndexes[i] = j + 1;
                    break;
                }
            }
        }

        int offset = 0;
        for (int i = 0; i < insertIndexes.length; i++) {
            numsMerged.add(B[i], i + offset);
            offset++;
        }

        int[] res = new int[numsMerged.size()];
        for (int i = 0; i < numsMerged.size(); i++) {
            res[i] = numsMerged.get(i);
        }

        return res;
    }
}
