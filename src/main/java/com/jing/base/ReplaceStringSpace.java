package com.jing.base;

/**
 * 替换字符串中的空格
 * !!在一个字符串内
 * @author GuoJingyuan
 * @date 2019/10/18
 */
public class ReplaceStringSpace {

    public static void main(String[] args) {
        System.out.println(new ReplaceStringSpace().replaceSpace(new StringBuffer("C A B DEF z")));
    }
    public String replaceSpace(StringBuffer original) {
        int P1 = original.length() - 1;
        for (int i = 0; i <= P1; i++) {
            if (original.charAt(i) == ' ') {
                original.append("  ");
            }
        }
        int P2 = original.length() - 1;
        while (P1 >= 0 && P2 > P1) {
            //获取P1位置的char，并将P1-1
            char p1Char = original.charAt(P1--);
            if (p1Char == ' ') {
                original.setCharAt(P2--, '0');
                original.setCharAt(P2--, '2');
                original.setCharAt(P2--, '%');
            } else {
                original.setCharAt(P2--, p1Char);
            }
        }
        return original.toString();
    }
}
