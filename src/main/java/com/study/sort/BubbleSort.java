package com.study.sort;

import java.util.Arrays;

/**
 * User: cuiyubao
 * Date: 2019/5/7
 * Time: 下午 05:45
 */
public class BubbleSort {
    public static void main(String[] args) {
        System.out.println(bubbleSort(new int[]{3, 2, 5, 8, 1, 4}).toString());
    }

    /**
     * 冒泡排序两个for循环，第一个控制一共要排序多少趟
     * 第二个for循环不断的对 （1和2）（2和3）（3和4）（4和5）...进行比较，之后就得到了最大或最小的数
     * <p>
     * 跑完第一趟，最大的数字放在了最后一个，最后一个数字就不用排了，接下来就是对前面剩下的几个排，
     * <p>
     * 跑第二趟，因为最后一个最大的数字已经找到了，所以循环len-1-i趟就可以找到剩下的里面得的最大的一个数字了
     * <p>
     * 接下来重复上面的操作.....
     * <p>
     * 初始：[3,2,5,8,1,4]
     * 第一趟：[2,3,5,1,4,8]
     * 第二趟：[2,3,1,4,5,8]
     * 第三趟：[2,1,3,4,5,8]
     * 第四趟：[1,2,3,4,5,8]
     * <p>
     * <p>
     * ==========================
     * <p>
     * 初始：[6,5,4,3,2,1]  i    j     len：6
     * 第一趟：[5,4,3,2,1,6]  --找到最大的数字6
     * 第二趟：[4,3,2,1,5,6]  --找到剩余最大数字5
     * 第三趟：[3,2,1,4,5,6]  --找到剩余最大数字4
     * 第四趟：[2,1,3,4,5,6]  --找到剩余最大数字2
     * 第五趟：[1,2,3,4,5,6]  --找到剩余最大数字1
     *
     * @param arr
     * @return
     */
    public static int[] bubbleSort(int[] arr) {
        int i, j, temp;
        int len = arr.length;
        for (i = 0; i < len - 1; i++) /* 外循环为排序趟数，len个数进行len-1趟 */
            for (j = 0; j < len - 1 - i; j++) { /* 内循环为每趟比较的次数，第i趟比较len-i次 */
                if (arr[j] < arr[j + 1]) { /* 相邻元素比较，若逆序则交换（升序为左大于右，逆序反之） */
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        return arr;
    }

    /**
     * 优化后的冒泡排序
     * @param sourceArray
     * @return
     */
    public static int[] bubbleSort1(int[] sourceArray) {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        for (int i = 1; i < arr.length; i++) {
            // 设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已经完成。
            boolean flag = true;

            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;

                    flag = false;
                }
            }

            if (flag) {
                break;
            }
        }
        return arr;
    }


}
