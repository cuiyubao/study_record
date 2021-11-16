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
        int[] ints = {3, 2, 5, 8, 1, 4};
        List<Integer> collect = Arrays.stream(ints).boxed().collect(Collectors.toList());
        System.out.println(sort(collect));
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


}
