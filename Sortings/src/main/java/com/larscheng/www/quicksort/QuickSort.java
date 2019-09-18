package com.larscheng.www.quicksort;

import java.util.Arrays;
import java.util.Stack;

/**
 * 描述:
 * 快速排序
 *
 * @author zhengql
 * @date 2019/9/10 15:08
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {49, 38, 65, 97, 26, 13, 27, 49, 55, 4};
        System.out.println("排序前:" + Arrays.toString(arr));

        int[] a = Arrays.copyOf(arr, arr.length);
        quicksort1(a, 0, a.length - 1);
        System.out.println("排序后:" + Arrays.toString(a));



        quickSortByStack(Arrays.copyOf(arr, arr.length));
    }


    private static void quicksort1(int[] arr, int low, int high) {
        if (arr.length <= 0 || low >= high) {
            return;
        }
        int leftIndex = low;
        int rightIndex = high;
        //挖坑1：保存基准的值
        int temp = arr[leftIndex];
        while (leftIndex < rightIndex) {
            //坑2：从后向前找到比基准小的元素，插入到基准位置坑1中
            while (leftIndex < rightIndex && arr[rightIndex] >= temp) {
                //不做交换
                rightIndex--;
            }
            //右侧数据小于基准，进行交换
            arr[leftIndex] = arr[rightIndex];


            //坑3：从前往后找到比基准大的元素，放到刚才挖的坑2中
            while (leftIndex < rightIndex && arr[leftIndex] <= temp) {
                leftIndex++;
            }
            //左侧数据大于基准，进行交换
            arr[rightIndex] = arr[leftIndex];

        }
        //基准值填补到坑3中，准备分治递归快排
        arr[leftIndex] = temp;

        quicksort1(arr, low, leftIndex - 1);
        quicksort1(arr, leftIndex + 1, high);
    }

    private static void quickSortByStack(int[] arr) {

        if (arr.length <= 0) {
            return;
        }

        Stack<Integer> stack = new Stack<Integer>();

        stack.push(0);
        stack.push(arr.length - 1);

        while (!stack.empty()) {
            int high = stack.pop();
            int low = stack.pop();
            int pivot = partition(arr, low, high);

            if (pivot > low) {
                stack.push(low);
                stack.push(pivot - 1);
            }
            if (pivot < high && pivot >= 0) {
                stack.push(pivot + 1);
                stack.push(high);
            }
        }
        System.out.println("排序后:" + Arrays.toString(arr));
    }

    private static int partition(int[] arr, int low, int high) {
        if (arr.length <= 0 || low >= high) {
            return -1;
        }
        int leftIndex = low;
        int rightIndex = high;
        //挖坑1：保存基准的值
        int pivot = arr[leftIndex];
        while (leftIndex < rightIndex) {
            //坑2：从后向前找到比基准小的元素，插入到基准位置坑1中
            while (leftIndex < rightIndex && arr[rightIndex] >= pivot) {
                //不做交换
                rightIndex--;
            }
            //右侧数据小于基准，进行交换
            arr[leftIndex] = arr[rightIndex];


            //坑3：从前往后找到比基准大的元素，放到刚才挖的坑2中
            while (leftIndex < rightIndex && arr[leftIndex] <= pivot) {
                leftIndex++;
            }
            //左侧数据大于基准，进行交换
            arr[rightIndex] = arr[leftIndex];

        }
        //基准值填补到坑3中，准备分治递归快排
        arr[leftIndex] = pivot;
        return leftIndex;

    }

}
