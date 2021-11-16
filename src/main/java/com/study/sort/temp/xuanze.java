package com.study.sort.temp;

import java.util.Arrays;

/**
 * 选择排序
 * 1. 先从未排序的序列中找出最小的，放在序列最前面
 * 2. 接着从剩余的序列中找出最小的，放在之前找出的最小的数字的后面
 * 3. 循环1，2直到所有元素排序完毕
 * <p>
 * 原始序列：3, 2, 5, 8, 1, 4
 * 第一次：1，| 3，2，5，8，4
 * 第二次：1，2，| 3，5，8，4
 * 第三次：1，2，3，| 5，8，4
 * 第四次：1，2，3，4，| 5，8
 * 第五次：1，2，3，4，5，| 8
 * <p>
 * 总结：6个数字只需要排序5轮
 *
 * @Author cuiyubao
 * @Date 2021/10/14 6:13 下午
 */
public class xuanze {


    public static void main(String[] args) {

        int[] ints = {3, 2, 5, 8, 1, 4};
        Arrays.stream(new maopao().sort(ints)).forEach(e -> System.out.println(e));

    }

    public int[] sort(int[] array) {
        // 总共要经过 N-1 轮比较
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            // 每轮需要比较的次数 N-i
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            // 将找到的最小值和i位置所在的值进行交换
            if (minIndex != i) {
                swap(array, i, minIndex);
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
