package com.study.sort.temp;

import java.util.Arrays;

/**
 * 插入排序
 *
 * 1.从数组的第二个数据开始往前比较，即一开始用第二个数和他前面的一个比较，如果 符合条件（比前面的大或者小，自定义），则让他们交换位置。
 *
 * 2.然后再用第三个数和第二个比较，符合则交换，但是此处还得继续往前比较，比如有 5个数8，15，20，45, 17,17比45小，需要交换，但是17也比20小，也要交换，当不需 要和15交换以后，说明也不需要和15前面的数据比较了，肯定不需要交换，因为前 面的数据都是有序的。
 *
 * 3.重复步骤二，一直到数据全都排完。
 * https://www.cnblogs.com/coding-996/p/12275710.html
 *
 * 原始序列：3,2,5,8,1,4
 * 第一次：  2,3,|5,8,1,4      处理数字2，2插在3前面
 * 第二次：  2,3,5,|8,1,4      处理数字5，5插在3后面
 * 第三次：  2,3,5,8,|1,4      处理数字8，8插在5后面
 * 第四次：  1,2,3,5,8,|4      处理数字1，1插在2前面
 * 第五次：  1,2,3,4,5,8       处理数字4，4插在4后面
 *
 * @Author cuiyubao
 * @Date 2021/10/14 5:45 下午
 */
public class charu {
    public static void main(String[] args) {

        int[] ints = {3, 2, 5, 8, 1, 4};
        Arrays.stream(new charu().sort(ints)).forEach(e -> System.out.println(e));

    }

    public int[] sort(int[] array) {
        // 从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
        for (int i = 1; i < array.length; i++) {
            int j = i;
            for (; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    swap(array, j, j - 1);
                } else {
                    break;
                }
            }
            Arrays.stream(array).forEach(e -> System.out.print(e+","));
            System.out.println();
        }
        return array;
    }


    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


}
