package com.larscheng.www.insertionsort;

import java.util.Arrays;

/**
 * 描述:
 * 直接插入排序
 *
 * @author lars
 * @date 2019/9/5 16:30
 */
public class InsertionSort {


    public static void main(String[] args) {
        int[] a = {1, 4, 8, 2, 5};

        insertSort1(a);
        System.out.println(Arrays.toString(a));


        int[] aa = {1, 4, 8, 2, 5};
        insertSort2(aa);
        System.out.println(Arrays.toString(aa));
    }

    /***
     * 交换次数较多实现
     * @param a
     */
    private static void insertSort2(int[] a) {
        for (int i =0 ; i<a.length-1;i++){
            for(int j=i+1;j>0;j--){
                if (a[j-1]>a[j]){
                    //j为待排序元素，j-1为前一位元素，j-1>j交换
                    int temp = a[j];
                    a[j]=a[j-1];
                    a[j-1]=temp;
                }else {
                    //待排序元素大于他前1位元素，位置不变，循环结束
                    break;
                }
            }
        }
    }

    /***
     * 交换次数较少
     * @param a
     */
    private static void insertSort1(int[] a) {
        for (int i = 1; i < a.length; i++) {
            //直接取出第二个元素开始比较，第一个元素默认已完成排序
            int temp = a[i];
            // temp与他前面的有序元素依次比较，找到自己的位置
            for (int j = i; j >= 0; j--) {
                //temp小于他前一位的元素，交换位置，继续循环比较(j>0如果不成立，说明已经比较到0位置,说明temp属于当前最小，直接放当前位置)
                if (j > 0 && a[j - 1] > temp) {
                    a[j] = a[j - 1];
                    //相互交换（可以先不进行移动）
                    //a[j-1] = temp;
                } else {
                    //temp大于他前面的元素，temp就放置在当前位置
                    a[j] = temp;
                    //该元素位置确定，结束循环，到下一个
                    break;
                }
            }
        }

    }

}
