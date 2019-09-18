package com.larscheng.www.headsort;

import java.util.Arrays;

/**
 * 描述:
 * 堆排序
 *
 * @author lars
 * @date 2019/9/8 15:48
 */
public class HeadSort {
    public static void main(String[] args) {
        int[] arr = {49, 38, 65, 97, 26, 13, 27, 49, 55, 4};
        System.out.println("排序前:" + Arrays.toString(arr));

        HeadSort1(Arrays.copyOf(arr, arr.length));
        HeadSort2(Arrays.copyOf(arr, arr.length));

    }


    private static void HeadSort2(int[] arr) {


        int len = arr.length;
        while (len > 0) {
            //1.建堆
            buidHead(arr, len);

            //2.取出堆顶（把堆顶与数组最后一个元素进行交换）
            int temp = arr[0];
            arr[0] = arr[len - 1];
            arr[len - 1] = temp;

            //3.重新建堆
            len = len - 1;
        }

        System.out.println("排序后:" + Arrays.toString(arr));
    }

    private static void buidHead(int[] arr, int len) {
        for (int i = len / 2; i >= 0; i--) {
            int leftIndex = 2 * i + 1;
            int rightIndex = leftIndex + 1;
            //默认父节点最大
            int maxIndex = i;
            if (leftIndex < len && arr[leftIndex] > arr[maxIndex]) {
                maxIndex = leftIndex;
            }
            if (rightIndex < len && arr[rightIndex] > arr[maxIndex]) {
                maxIndex = rightIndex;
            }
            //最大值确认，如果父节点不是最大则交换
            if (maxIndex != i) {
                int temp = arr[i];
                arr[i] = arr[maxIndex];
                arr[maxIndex] = temp;
            }
        }
    }


    private static void HeadSort1(int[] arr) {

        //每次循环数组长度缩小1，相当于取出堆顶元素
        for (int i = arr.length; i > 0; i--) {
            //建堆
            buildMaxHead(arr, i);

            //堆顶元素与Kn交换,下次循环开始前取出Kn(数组长度减1)
            int temp = arr[0];
            arr[0] = arr[i - 1];
            arr[i - 1] = temp;
        }
        System.out.println("排序后:" + Arrays.toString(arr));
    }

    private static void buildMaxHead(int[] arr, int limit) {
        if (arr.length <= 0 || arr.length < limit) {
            return;
        }
        //从最后一个非叶子节点开始比较，进行建堆
        int parentIdx = limit / 2;
        for (; parentIdx >= 0; parentIdx--) {
            if (parentIdx * 2 + 1 >= limit) {
                continue;
            }
            //左子节点位置
            int left = parentIdx * 2 + 1;
            //右子节点位置，如果没有右节点，默认为左节点位置
            int right = (left + 1) >= limit ? left : (left + 1);

            int maxChildId = arr[left] >= arr[right] ? left : right;

            //交换父节点与左右子节点中的最大值
            if (arr[maxChildId] > arr[parentIdx]) {
                int temp = arr[parentIdx];
                arr[parentIdx] = arr[maxChildId];
                arr[maxChildId] = temp;
            }
        }
    }


}
