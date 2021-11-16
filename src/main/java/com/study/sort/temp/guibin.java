package com.study.sort.temp;

import java.util.Arrays;

/**
 * 归并排序
 *
 * @Author cuiyubao
 * @Date 2021/10/15 2:22 下午
 */
public class guibin {

    public static void main(String[] args) {
        int[] ints = {3, 2, 5, 8, 1, 4};
        new guibin().sort(ints, 0, ints.length);
        Arrays.stream(ints).forEach(value -> System.out.println(value));
    }


    public void sort(int[] array, int left, int right) {
        if (right - left <= 1) {
            return;
        }
        int mid = (left + right) / 2;
        sort(array, left, mid);
        sort(array, mid, right);
        merge(array, left, mid, right);
    }

    public void merge(int[] array, int left, int mid, int right) {
        int[] B = Arrays.copyOfRange(array, left, mid + 1);
        int[] C = Arrays.copyOfRange(array, mid, right + 1);
        //设置哨兵
        B[B.length - 1] = Integer.MAX_VALUE;
        C[C.length - 1] = Integer.MAX_VALUE;
        //B,C的位置
        int i = 0, j = 0;
        for (int k = left; k < right; k++) {
            if (B[i] < C[j]) {
                array[k] = B[i];
                i++;
            } else {
                array[k] = C[j];
                j++;
            }
        }
    }


}
