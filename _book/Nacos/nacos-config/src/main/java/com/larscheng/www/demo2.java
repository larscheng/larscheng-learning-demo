package com.larscheng.www;

/**
 * 描述:
 *
 * @author lars
 * @date 2019/9/4 20:41
 */
public class demo2 {

        //消除嵌套的括号
        public static String change_str(String s) {
            String result = "(";
            char[] ch = s.toCharArray();
            int bracket_num = 0;
            int i = 0;
            while(i<ch.length) {
                if(ch[i] =='(') {
                    bracket_num++;
                }else if(ch[i] == ')') {
                    if(bracket_num>0) {
                        bracket_num --;
                    }else {
                        System.out.println("Expression wrong!");
                        return null;
                    }
                }else if(ch[i] == ',') {
                    result +=ch[i++];
                    continue;
                }else if(ch[i] >='0' && ch[i]<='9') {
                    result +=ch[i];
                }else {
                    System.out.println("Expression wrong!");
                    return null;
                }
                i++;
            }
            if(bracket_num>0) {
                System.out.println("Expression wrong!");
                return null;
            }
            result += ")";
            return result;
        }

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            String s = "(1,(2,3),(4,(5,6),7))";
            String result = change_str(s);
            if(result !=null) {
                System.out.println(result);
            }
            s = "((1,(2,3),(4,(5,6),7))";
            result = change_str(s);
            if(result !=null) {
                System.out.println(result);
            }
        }


}
