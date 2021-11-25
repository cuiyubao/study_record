package com.study.sort.temp;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 快速排序
 *
 * @Author cuiyubao
 * @Date 2021/10/15 4:36 下午
 */
public class kuaisu {

    public static void main(String[] args) {
        int[] ints = {47,29,71,99,78,19,24,45};
//        List<Integer> collect = Arrays.stream(ints).boxed().collect(Collectors.toList());
//        System.out.println(sort(collect));
         quickSort(ints,0,7);
    }

    public static List<Integer> sort(List<Integer> list) {
        if (list.size() <= 1) {
            return list;
        }
        Integer x = list.get(0);
        List<Integer> left = list.stream().filter(a -> a < x).collect(Collectors.toList());
        List<Integer> mid = list.stream().filter(a -> a == x).collect(Collectors.toList());
        List<Integer> right = list.stream().filter(a -> a > x).collect(Collectors.toList());
        left = sort(left);
        right = sort(right);
        left.addAll(mid);
        left.addAll(right);
        return left;
    }


    private static void quickSort(int[] src, int begin, int end) {
        System.out.println(Arrays.stream(src).boxed().collect(Collectors.toList())+" begin:"+begin+" end:"+end);
        if (begin < end) {
            int flag = src[begin];
            int i = begin;
            int j = end;
            while (i < j) {
                while (i < j && flag < src[j]) {
                    j--;
                }
                if (i < j) {
                    src[i] = src[j];
                    i++;
                }
                while (i < j && flag > src[i]) {
                    i++;
                }
                if (i < j) {
                    src[j] = src[i];
                    j--;
                }
            }
            src[i] = flag;

            quickSort(src, begin, i - 1);
            quickSort(src, i + 1, end);
        }


    }


}
