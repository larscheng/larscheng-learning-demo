> [❤查看排序算法动态演示❤查看排序算法动态演示❤查看排序算法动态演示](https://www.larscheng.com/others/allsort/)

# 希尔排序 （Shell Sort）

希尔排序 也称做`递减增量排序算法`，1959年`Shell`发明，是插入排序的一种`高速而稳定`的改进版本

# 基本思想


希尔排序是先将整个待排序的记录序列分割成若干个子序列分别进行直接插入排序，待整个序列中的记录“基本有序”时，在对全体记录进行依次直接排序



![](https://cdn.jsdelivr.net/gh/larscheng/myImg/blogImg/sort/20190906110507.png)


例如上图中的待排序数组：[49,38,65,97,76,13,27,49,55,4]

1. 将数组按`5个间隔`为一组划分成`5组子序列`,每个子序列进行插入排序后，各个子序列就变成了有序的了（整体不一定有序）
1. 将上一步得到的数组按`2个间隔`为一组划分成`3组子序列`，各个子序列进行插入排序
1. 将上一步得到的数组按正常插入排序，此时序列基本有序，所以效率较高
e
上面提到的间隔可以称作增量, 一般初始增量取数组的一半长度, 每轮排序后，增量减半，直至增量为1(存在多种增量序列)

# 算法描述

1. 选择一个增量序列t1，t2，…，tk，其中t1>t2，tk=1；（一般初次取数组半长，之后每次再减半，直到增量为1）
1. 按增量序列个数k，对序列进行k 趟排序；
1. 每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。

如下图，其中H表示增量

![希尔排序动图--来源[崔显龙](https://blog.csdn.net/cuixianlong/article/details/77929142)](https://cdn.jsdelivr.net/gh/larscheng/myImg/blogImg/sort/shellsort.gif)

# Java代码实现

```java

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

```

# 复杂度

希尔排序的复杂度与增量有关，不同的增量会产生不同的复杂度

像我们思路分析中的数组对半取值为增量5，直至为1，其实并不是最优增量序列。


| 平均时间复杂度 | 最好情况  | 最坏情况  | 空间复杂度 |
| ------- | ----- | ----- | ----- |
| O(n^1.25)  | O(n) | O(n²) | O(1)  |
