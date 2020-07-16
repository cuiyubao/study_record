package com.study.DataStructure.xiaomage.selection;

/**
 * 选择排序
 *
 * @author cuiyubao
 * @date 2020/7/19 下午 04:39
 */
public class SelectionSort {


    public static void main(String[] args){

        int[] array = {7, 6, 4, 5, 8, 2, 3};


        for (int end = array.length-1; end > 0; end--) {
            int maxIndex=0;
            for (int begin = 1; begin <=end; begin++) {
                if(array[maxIndex]<=array[begin]){
                    maxIndex=begin;
                }
            }
            int tmp=array[maxIndex];
            array[maxIndex]=array[end];
            array[end]=tmp;
        }

        for (int i : array) {
            System.out.print(i+",");
        }
    }


}
