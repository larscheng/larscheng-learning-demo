package com.larscheng.www.mergingsort;

import java.util.Arrays;

/**
 * 描述:
 * 归并排序
 *
 * @author lars
 * @date 2019/9/11 11:46
 */
public class MergingSort {
    public static void main(String[] args) {
        int[] arr = {49, 38, 65, 97, 26, 13, 27, 49, 55, 4};
        System.out.println("排序前:" + Arrays.toString(arr));

        System.out.println(Arrays.toString(mergingSort(Arrays.copyOf(arr,arr.length))));
    }


    private static int[] mergingSort(int[] arr) {

        if (arr.length <= 1) {
            return arr;
        }
        int num = arr.length >> 1;
        int[] leftArr = Arrays.copyOfRange(arr, 0, num);
        int[] rightArr = Arrays.copyOfRange(arr, num, arr.length);

        System.out.println("split two array: " + Arrays.toString(leftArr) + " And " + Arrays.toString(rightArr));
        //递归：将序列拆分为若干个最小单元后进行合并
        return mergeTwoArray(mergingSort(leftArr), mergingSort(rightArr));

    }

    private static int[] mergeTwoArray(int[] arr1, int[] arr2) {
        int i = 0, j = 0, k = 0;

        //申请额外的空间存储合并之后的数组
        int[] result = new int[arr1.length + arr2.length];
        //选取两个序列中的较小值放入新数组
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }
        //序列1中多余的元素移入新数组
        while (i<arr1.length){
            result[k++]=arr1[i++];
        }
        //序列2中多余的元素移入新数组
        while (j<arr2.length){
            result[k++]=arr2[j++];
        }
//        System.out.println("Merging: " + Arrays.toString(result));
        return result;
    }
}
