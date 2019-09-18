package com.larscheng.www.selectionsort;

import java.util.Arrays;

/**
 * 描述:
 * 选择排序
 *
 * @author lars
 * @date 2019/9/7 17:37
 */
public class SelectionSort {


    public static void main(String[] args) {

        int[] arr = {49, 38, 65, 97, 76, 13, 27, 49, 55, 4};
        System.out.println("排序前:"+Arrays.toString(arr));

        selectSort1(Arrays.copyOf(arr,arr.length));
    }

    /**
     * 选择排序
     *
     * 1. 从待排序序列中，找到关键字最小的元素；
     * 2. 如果最小元素不是待排序序列的第一个元素，将其和第一个元素互换；
     * 3. 从余下的 N - 1 个元素中，找出关键字最小的元素，重复①、②步，直到排序结束。
     *    仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
     * @param arr  待排序数组
     */
    private static void selectSort1(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            //待排序列第一个默认为最小
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                //依次与其他元素比较找出最小元素的下标
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            //最小元素下标不是i，则将i与最小下标所在元素交换位置
            if (min!=i){
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i]=temp;
            }
        }

        System.out.println("排序后:"+Arrays.toString(arr));
    }

}
