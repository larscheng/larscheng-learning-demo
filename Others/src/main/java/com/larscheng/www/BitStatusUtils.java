package com.larscheng.www;

/**
 * 描述:
 * 位运算处理状态工具类
 *
 * @author zhengql
 * @date 2019/9/25 09:38
 */
public class BitStatusUtils {

    /**
     * 二进制表示 0001 没交任何作业
     */
    public static final int NONE = 1;
    /**
     * 语文   0001左移1位--->00010=2
     */
    public static final int CHINESE = NONE << 1;
    /**
     * 数学   0001左移2位--->000100=4
     */
    public static final int MATH = NONE << 2;
    /**
     * 英语   0001左移3位--->0001000=8
     */
    public static final int ENGLISH = NONE << 3;
    /**
     * 物理   0001左移4位--->00010000=16
     */
    public static final int PHYSICS = NONE << 4;
    /**
     * 历史   0001左移5位--->000100000=32
     */
    public static final int HISTORY = NONE << 5;

    /**
     * A|B ：位或，A和B对应的二进制数位都为0时，结果才为0,其他情况为1.
     * 所有作业都交的情况
     * 000100000
     * 000010000
     * 000001000
     * 000000100
     * 000000010
     * 000000001
     * 000111111--->64
     */
    public static final int ALL = NONE | CHINESE | MATH | ENGLISH | PHYSICS | HISTORY;


    /**
     * 判断状态是否存在
     * @param status 当前状态
     * @param val 待判断状态
     * @return 是否存在
     */
    public static boolean hasStatus(long status, long val) {
        /***
         * A&B:位与， A和B对应的二进制数位都为1时,结果才为1,其他情况为0.
         * 000000111--->语数外已交
         * 000100000--->历史交否
         * 000000000--->语文没交 0!=0 false
         *
         *
         * 000111111--->全交
         * 000001000--->英语交否
         * 000001000--->英语已交 8!=0 true
         */
        return (status & val) != 0;
    }


    /***
     * 添加新状态
     * @param status 当前状态
     * @param val 待添加状态
     * @return 最新状态
     */
    public static long addStatus(long status, long val){
        //已存在无需添加
        if (hasStatus(status,val)){
            return status;
        }
        //位或
        return (status|val);
    }

    /**
     * 删除状态
     * @param status 当前状态
     * @param val  需要删除状态值
     * @return 最新状态
     */
    public static long removeStatus(long status, long val) {
        //不存在无需删除
        if (!hasStatus(status, val)) {
            return status;
        }
        /***
         * 异或：A^B,A和B对应的二进制数位相同时,结果才为1,其他情况为0.
         * 000111111--->全交
         * 000000010--->语文拿回
         * 000111101--->语文拿回
         */
        return status ^ val;
    }


    /**
     * 是否已经完成全部作业
     * @param status 当前状态
     * @return
     */
    public static boolean hasAllStatus(long status) {
        //位与：全为1则为1，自身位与值不变
        return (status & ALL) == ALL;
    }

    public static void main(String[] args) {

        long status = addStatus(NONE, CHINESE);
        System.out.println("小明交了语文作业:" + status);

        status = addStatus(status, PHYSICS);
        System.out.println("小明又交了物理作业:" + status);

        status = addStatus(status, HISTORY);
        System.out.println("小明还交了历史作业:" + status);

        status = removeStatus(status, HISTORY);
        System.out.println("小明撤销了历史作业:" + status);

        System.out.println("小明是否交了语文作业:" + hasStatus(status, CHINESE));
        System.out.println("小明是否交了历史作业:" + hasStatus(status, HISTORY));
        System.out.println("小明是否交了全部作业:" + hasAllStatus(status));

        int a = 0xffff;
        long aa = 0xffff;
        System.out.println(a);
        System.out.println(aa);


        /***
         * A和B对应的二进制数位都为1时,结果才为1,其他情况为0.
         * 1&0xFFFF
         *
         * 0000000000000001
         * 0111111111111111
         * 0000000000000001
         *
         * -1&0xFFFF
         *
         * 1000000000000001
         * 1111111111111111
         * 1000000000000001
         */

        System.out.println(-1&0xffff);
    }


}
