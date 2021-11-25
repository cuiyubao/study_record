package com.study.sort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 快速排序
 *

 1. 从数列中挑出一个元素，称为 “基准”（pivot）
 2. 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作
 3. 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序

 示例：
   数组：[47,29,71,99,78,19,24,45]
   1. 选出基准值47,重排序完后[45, 29, 24, 19, |47|, 78, 99, 71]
   2. 接下来排序47前的【45, 29, 24, 19,|47|,78, 99, 71] 以及后面的，基准值47就不动了
   3. 选中基准值45，重新排序完后[19,29,24,|45|,|47|,78, 99, 71],基准值45就不动了
   4. 选中基准值19, 重新排序完后[|19|,29,24,|45|,|47|,78, 99, 71],基准值19就不动了
   5. 选中基准值29, 重新排序完后[|19|,24,|29|,|45|,|47|,78, 99, 71],基准值29就不动了
   6. 选中基准值24, 重新排序完后[|19|,|24|,|29|,|45|,|47|,78, 99, 71],基准值29就不动了
   7. 至此,47前面的排序完成.同理排序47后面的
 *
 *
 *
 * @author cuiyubao
 * @date 2021/3/19/019 下午 11:51
 */
public class QuickSort {
    private int[] array;

    public QuickSort(int[] array) {
        this.array = array;
    }
    public QuickSort() {

    }

    public void sort() {
        quickSort(array, 0, array.length - 1);
    }

    public void print() {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    /**
     * 用java8的的语法来处理
     *
     * @param list
     */
    private List<Integer> quickSort(List<Integer> list) {
        if (list.size() <= 1) {
            return list;
        }
        Integer flag = list.get(0);
        List<Integer> left = list.stream().filter(m -> m < flag).collect(Collectors.toList());
        List<Integer> mid = list.stream().filter(m -> m == flag).collect(Collectors.toList());
        List<Integer> right = list.stream().filter(m -> m > flag).collect(Collectors.toList());

        left = quickSort(left);
        right = quickSort(right);
        left.addAll(mid);
        left.addAll(right);
        return left;

    }


    /**
     *
     *
     * @param src
     * @param begin
     * @param end
     */
    private void quickSort(int[] src, int begin, int end) {
        if (begin < end) {
            //选第一个数座位基准值
            int key = src[begin];
            //左指针
            int i = begin;
            //右指针
            int j = end;
            //只要左右指针不相遇
            while (i < j) {
                //右边的数大于基准值直接跳过
                while (i < j && src[j] > key) {
                    j--;
                }
                //到了这一步说明右边遇到了不大于基准值的数
                if (i < j) {
                    //如果左右指针还没有相遇的话,将右指针所指向的数赋值给左指针指向的位置
                    src[i] = src[j];
                    //因为现在左指针指向的数已经小于等于基准值了，所以左指针向右移动一个位置
                    i++;
                }
                //左边的数小于基准值直接跳过
                while (i < j && src[i] < key) {
                    i++;
                }
                //到了这一步说明左边边遇到了大于基准值的数
                if (i < j) {
                    //如果左右指针还没有相遇的话,将左指针所指向的数赋值给右指针指向的位置
                    src[j] = src[i];
                    //因为现在右指针指向的数已经大于等于基准值了，所以右指针左移一个位置
                    j--;
                }
            }
            //将基准值放在指针相遇的位置，接下来这个基准值就不动了，这个基准值的左边都小于等于它，右边都大于等于它
            src[i] = key;
            //接下来递归排序基准值左边的数
            quickSort(src, begin, i - 1);
            //接下来递归排序基准值右边的数
            quickSort(src, i + 1, end);
        }
    }

    public static void main(String[] args) {
        List<Integer> strings = Arrays.asList(47,29,71,99,78,19,24,47);
        List<Integer> integers = new QuickSort().quickSort(strings);
        System.out.println(integers);
    }


}