package com.study.sort.temp;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @Author cuiyubao
 * @Date 2021/10/14 5:21 下午
 */
public class maopao {

    public static void main(String[] args) {

        int[] ints = {3, 2, 5, 8, 1, 4};
        Arrays.stream(new maopao().sort(ints)).forEach(e -> System.out.println(e));

    }

    public int[] sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
        return array;
    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


}
