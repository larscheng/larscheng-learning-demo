package com.larscheng.www.bubblesort;

import java.util.Arrays;

/**
 * 描述:
 * 冒泡排序
 *
 * @author lars
 * @date 2019/9/9 15:41
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {49, 38, 65, 97, 26, 13, 27, 49, 55, 4};
        System.out.println("排序前:" + Arrays.toString(arr));

        Bubble(Arrays.copyOf(arr, arr.length));
        //优化版本
        BubbleDemo(Arrays.copyOf(arr, arr.length));
    }

    /***
     * 若序列原本有序，会有多余的遍历和比较
     * @param arr
     */
    private static void Bubble(int[] arr) {
        //控制外层比较轮数
        for (int i = 1; i < arr.length; i++) {
            //控制内层需要参与比较的序列大小
            for (int j = 0; j < arr.length - i; j++) {
                //相邻元素比较
                if (arr[j] > arr[j + 1]) {
                    //交换
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("排序后:" + Arrays.toString(arr));
    }

    /***
     * 优化版本，若序列有序，1次遍历后直接结束
     * @param arr
     */
    private static void BubbleDemo(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            // 设定一个标记
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
                //若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已经完成。
                break;
            }
        }
    }
}
