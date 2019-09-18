# 堆排序 （Head Sort）

> 1991年的计算机先驱奖获得者、斯坦福大学计算机科学系教授罗伯特·弗洛伊德(Robert W．Floyd) 和威廉姆斯(J．Williams) 在1964年共同发明了著名的堆排序算法(Heap Sort).


堆的定义如下：n个元素的序列 {k1,k2,⋅⋅⋅,kn} 当且仅当满足下关系时，称之为堆。



$$
小顶堆：\begin{cases}k_i \leq k_{2i}\\\\k_i \leq k_{2i+1}\end{cases} 
大顶堆：\begin{cases}k_i \geq k_{2i}\\\\k_i \geq k_{2i+1}\end{cases} 
(i=1,2,...,\left \lfloor \frac{n}{2}   \right \rfloor)
$$

其中的两种情况又分为`小顶堆`和`大顶堆`

把此序列对应的二维数组看成一个完全二叉树。
那么堆的含义就是：`完全二叉树中任何一个非叶子节点的值均不大于（或不小于）其左，右孩子节点的值`。

由上述性质可知大顶堆的堆顶的关键字肯定是所有关键字中最大的，小顶堆的堆顶的关键字是所有关键字中最小的。

因此我们可使用大顶堆进行升序排序, 使用小顶堆进行降序排序。


# 基本思想

先将序列建立堆，然后输出堆顶元素，然后再将剩下的序列在建立新的堆，在输出堆顶元素，以此类推，直到所有元素均输出为止，此时输出的元素序列即为有序序列

动态演示如下图所示：


# 算法描述

1. 先将初始序列K[1..n]建成一个大顶堆, 那么此时第一个元素K1最大, 此堆为初始的无序区
1. 再将关键字最大的记录K1 (即堆顶, 第一个元素)和无序区的最后一个记录 Kn 交换,并将Kn取出， 由此得到新的无序区K[1..n-1]和有序区K[n]
1. 交换K1 和 Kn 后, K1在堆顶可能违反堆性质, 因此需将K[1..n-1]调整为堆. 然后重复步骤2, 直到无序区只有一个元素时停止.


简单总结可以分为三个部分操作
1. 建立堆(大顶堆or小顶堆)
1. 取出堆顶元素，将最后一个元素放在堆顶
1. 重建堆，重复步骤2

# Java实现

对于堆节点的访问：

- 父节点i的左子节点在位置：`(2*i+1)`;
- 父节点i的右子节点在位置：`(2*i+2)`;
- 子节点i的父节点在位置：`floor((i-1)/2)`;


```java


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

```

# 复杂度

以上,
1. 建立堆的过程, 从length/2 一直处理到0, 时间复杂度为O(n);
1. 调整堆的过程是沿着堆的父子节点进行调整, 执行次数为堆的深度, 时间复杂度为O(lgn);
1. 堆排序的过程由n次第2步完成, 时间复杂度为O(nlgn).


| 平均时间复杂度   | 最好情况      | 最坏情况      | 空间复杂度 |
| --------- | --------- | --------- | ----- |
| O(nlog2n) | O(nlog2n) | O(nlog2n) | O(1)  |

Tips: 由于多次任意下标相互交换位置, 相同元素之间原本相对的顺序被破坏了, 因此, 它是不稳定的排序.

# 适用场景

**由于堆排序中初始化堆的过程比较次数较多, 因此它不太适用于小序列.** 

在堆排序算法分析过程中可以发现，堆排序通过构建堆，率先将最大或者最小的元素找出来。

所以，堆排序往往适用于，`不需要对序列整体排序，只需要找到最大或者最小元素`的场景
