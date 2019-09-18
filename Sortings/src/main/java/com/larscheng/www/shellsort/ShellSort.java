package com.larscheng.www.shellsort;

import java.util.Arrays;

/**
 * 描述:
 *
 * @author lars
 * @date 2019/9/6 11:35
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {49, 38, 65, 97, 76, 13, 27, 49, 55, 4};
        System.out.println("排序前:"+Arrays.toString(arr));

        int[] a = Arrays.copyOf(arr,arr.length);
        shellsort1(a);

        int[] b = Arrays.copyOf(arr,arr.length);

        shellsort2(arr);


    }

    /**
     * 希尔排序（Wiki官方版）
     *
     * 1. 选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；（注意此算法的gap取值）
     * 2. 按增量序列个数k，对序列进行k 趟排序；
     * 3. 每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。
     *    仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
     * @param arr  待排序数组
     */
    private static void shellsort2(int[] arr) {
        int gap = 1, i, j, len = arr.length;
        int temp;
        while (gap < len / 3){
            // <O(n^(3/2)) by Knuth,1973>: 1, 4, 13, 40, 121, ...
            gap = gap * 3 + 1;
        }
        for (; gap > 0; gap /= 3) {
            for (i = gap; i < len; i++) {
                temp = arr[i];
                for (j = i - gap; j >= 0 && arr[j] > temp; j -= gap){
                    arr[j + gap] = arr[j];
                }
                arr[j + gap] = temp;
            }
        }

        System.out.println("排序后:"+Arrays.toString(arr));
    }


    /***
     * 个人实现
     * @param arr
     */
    private static void shellsort1(int[] arr) {
        //根据增量g进行分组,g初始状态为数组长度一半
        for (int g = arr.length / 2; g > 0; g /= 2) {
            for (int i = g; i < arr.length; i++) {
                //待插入数为arr[i]
                int inserted = arr[i];
                int j;
                //待插入数，与当前组内的序列进行依次比较
                for (j = i - g; j >= 0 && inserted < arr[j]; j -= g) {
                    //待插入数小于他前面的数，进行交换
                    arr[j + g] = arr[j];
                }
                arr[j + g] = inserted;
            }
        }
        System.out.println("排序后:"+Arrays.toString(arr));
    }
}
