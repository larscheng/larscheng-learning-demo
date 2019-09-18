# 选择排序（Selection Sort）

从算法逻辑上看，选择排序是一种简单直观的排序算法，在简单选择排序过程中，所需移动记录的次数比较少。

# 基本思想

选择排序的基本思想：比较 + 交换。

在未排序序列中找到最小（大）元素，存放到未排序序列的起始位置。在所有的完全依靠交换去移动元素的排序方法中，选择排序属于非常好的一种。 



![选择排序动态演示--来源互联网](https://cdn.jsdelivr.net/gh/larscheng/myImg/blogImg/sort/slectsort.gif)


# 算法描述

1. 从待排序序列中，找到关键字最小的元素；
1. 如果最小元素不是待排序序列的第一个元素，将其和第一个元素互换；
1. 从余下的 N - 1 个元素中，找出关键字最小的元素，重复1、2步，直到排序结束。


# JAVA代码实现
```java

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

```

# 复杂度

| 平均时间复杂度 | 最好情况  | 最坏情况  | 空间复杂度 |
| ------- | ----- | ----- | ----- |
| O(n²)   |  O(n²) | O(n²) | O(1)  |

选择排序的简单和直观名副其实，这也造就了它”出了名的慢性子”，

无论是哪种情况，哪怕原数组已排序完成，它也将花费将近n²/2次遍历来确认一遍。

即便是这样，它的排序结果也还是不稳定的。 唯一值得高兴的是，它并不耗费额外的内存空间。


# 适应场景

当数据量不大，且对稳定性没有要求的时候，适用于选择排序。