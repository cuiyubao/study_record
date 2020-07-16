package com.study.DataStructure.xiaomage.bubble;

/**
 * 冒泡排序
 *
 * ■执行流程（本课程统一以升序为例子）
 * （1）从头开始比较每一对相邻元素，如果第1个比第2个大，就交换它们的位置
 *  执行完一轮后，最未尾那个元素就是最大的元素
 * （2）忽略（1）中曾经找到的最大元素，重复执行步骤①，直到全部元素有序
 *
 * @author cuiyubao
 * @date 2020/7/19 上午 10:51
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {7, 6, 4, 5, 8, 2, 3};

        bubbleSort3(array);


        for (int i : array) {
            System.out.print(i+",");
        }

    }

    public static void bubbleSort0(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int begin = 1; begin < array.length; begin++) {
                if (array[begin] > array[begin - 1]) {
                    int temp = array[begin];
                    array[begin] = array[begin - 1];
                    array[begin - 1] = temp;
                }
            }
        }
    }

    public static void bubbleSort1(int[] array) {
        //外面的for循环负责移动结束的位置，里面的for循环每执行一次，将会选出当前最大的数，下一次比较则可以不用管后面最大的数
        for (int end = array.length; end > 1; end--) {
            //里面的for循环负责比较相邻两个元素的大小,把最大的移动到最后面
            for (int begin = 1; begin < end; begin++) {
                if (array[begin] < array[begin - 1]) {
                    int temp = array[begin];
                    array[begin] = array[begin - 1];
                    array[begin - 1] = temp;
                }
            }
        }
    }

    /**
     * 优化1
     * @param array
     */
    public static void bubbleSort2(int[] array) {
        //外面的for循环负责移动结束的位置，里面的for循环每执行一次，将会选出当前最大的数，下一次比较则可以不用管后面最大的数
        for (int end = array.length; end > 1; end--) {
            //里面的for循环负责比较相邻两个元素的大小,把最大的移动到最后面
            //sorted用于判断当前元素是否已经是拍好序的
            boolean sorted = true;
            for (int begin = 1; begin < end; begin++) {
                if (array[begin] < array[begin - 1]) {
                    int temp = array[begin];
                    array[begin] = array[begin - 1];
                    array[begin - 1] = temp;
                    sorted = false;
                }
            }
            if (sorted) {
                break;
            }
        }
    }

    /**
     * 优化2  减少扫描次数
     * @param array
     */
    public static void bubbleSort3(int[] array) {
        //外面的for循环负责移动结束的位置，里面的for循环每执行一次，将会选出当前最大的数，下一次比较则可以不用管后面最大的数
        for (int end = array.length; end > 1; end--) {
            //里面的for循环负责比较相邻两个元素的大小,把最大的移动到最后面
            //sortedIndex的初始值在数组完全有序的时候有用  sortedIndex只要小于等于1就可以
            int sortedIndex=1;
            for (int begin = 1; begin < end; begin++) {
                if (array[begin] < array[begin - 1]) {
                    int temp = array[begin];
                    array[begin] = array[begin - 1];
                    array[begin - 1] = temp;
                    sortedIndex=begin;
                }
            }
            end=sortedIndex+1;
        }
    }




}
