package com.larscheng.www;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * 描述:
 *
 * @author lars
 * @date 2019/9/4 19:48
 */
public class demo {

    public static class Node {
        public int value;
        public Node next;

        public Node() {}

        public Node(int value) {
            this.value = value;
        }
    }


        public static void main(String[] args) {
//            int[] num = { 1, 2, 4, 3, 2, 5, 2, 6 };
            int divideNum = 0;

            System.out.println("输入整数：");
            Scanner sc1 = new Scanner(System.in);
            divideNum = sc1.nextInt();  // 存储划分链表的数字
            System.out.println("输入序列：");

            Scanner sc2 = new Scanner(System.in);
            String str = sc2.nextLine();  // 存储划分链表的数字
            String[] num = str.split(" ");
            Node head = new Node();
            Node pre = head;

            for (int i = 0; i < num.length; i++) {
                Node node = new Node(Integer.parseInt(num[i]));
                pre.next = node;  // 构造待划分链表
                pre = node;
            }
            divideLink(head, divideNum);
            print(head.next);
        }

        /**
         * 数字 num 划分链表 head，大于num的在后，小于的在前
         * @param head 链表
         * @param num 数字
         */
        public static void divideLink(Node head, int num) {
            Node head_1 = new Node();  // 定义链表head_1
            Node pre_1 = head_1;       // 链表head_1的指针变量
            Node head_2 = new Node();  // 定义链表head_2
            Node pre_2 = head_2;       // 链表head_2的指针变量
            Node temp = head.next;     // 临时存储取出的待划分链表的结点
            while (temp != null) {     // 循环遍历待划分链表
                if (temp.value < num) { // 如果temp的结点值小于num，则添加到head_1的尾部
                    pre_1.next = temp;
                    pre_1 = temp;
                } else {                // 如果temp的结点值大于等于num，则添加到head_2的尾部
                    pre_2.next = temp;
                    pre_2 = temp;
                }
                temp = temp.next;
            }
            pre_1.next = head_2.next;   // 链表head_1的next域指向链表head_2的next
            pre_2.next = null;          // head_2的next为null，否则出错
            head.next = head_1.next;    // 链表head的next域指向链表head_1的next域
        }

        /**
         * 打印输出链表的结点值
         * @param head 链表头结点的下一个结点
         */
        public static void print(Node head) {
            List<String> strings = new ArrayList<>();
            while (head != null) {
                strings.add(String.valueOf(head.value));
                head = head.next;
            }
            System.out.println(String.join(",", strings));
        }

}
