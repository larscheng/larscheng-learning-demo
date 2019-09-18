package com.larscheng.www.radixsort;

import java.util.Arrays;

/**
 * 描述:
 * 基数排序
 *
 * @author lars
 * @date 2019/9/12 13:35
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {49, 38, 65, 97, 26, 13, 27, 49, 55, 4};
        System.out.println("排序前:" + Arrays.toString(arr));

        radixsort(Arrays.copyOf(arr, arr.length));

    }

    /**
     * 基数排序（LSD 从低位开始）
     * @param arr 待排序数组
     */
    private static void radixsort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        //待排元素最大值
        int max = Arrays.stream(arr).max().getAsInt();
        int maxDight = String.valueOf(max).length();

        //申请一个桶空间
        int[][] buckets = new int[10][arr.length];
        //从个位开始
        int base = 10;

        for (int i = 0; i < maxDight; i++) {
            //各个桶中元素个数
            int[] temp = new int[10];


            //1.分配：将所有元素分配到桶中
            for (int j = 0; j < arr.length; j++) {
                //确定当前位的数字
                int num = (arr[j] % base) / (base / 10);
                buckets[num][temp[num]] = arr[j];
                //num桶中元素个数+1
                temp[num]++;

            }

            //收集：将不同桶里数据挨个捞出来,为下一轮高位排序做准备,
            // 由于靠近桶底的元素排名靠前,因此从桶底先捞
            int k = 0;
            for (int b = 0; b < buckets.length; b++) {
                //第b个桶中共有temp[b]个元素
                for (int p = 0; p < temp[b]; p++) {
                    arr[k++] = buckets[b][p];
                }
            }
            //本轮结束，开始下一位的分配收集
            base *= 10;

        }

        System.out.println("排序后:" + Arrays.toString(arr));
    }
}
