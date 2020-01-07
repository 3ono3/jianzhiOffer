package com.jing.base;

import java.math.BigDecimal;

/**
 * 使用递归打印数字
 * @author GuoJingyuan
 * @date 2019/12/25
 */
public class PrintToMaxNumRecursive {

    public static void main(String[] args) {
        System.out.println(new BigDecimal(12).add(null));
//        new PrintToMaxNumRecursive().rec(new char[4],0, 4);
    }

    void rec(char[] number, int index, int length) {
        if (index == length) {
            printChar(number);
            return;
        }
        for (int i = 0; i < 10; i++ ) {
            number[index] = (char) ('0' + i);
            rec(number, index+1, length);
        }
    }

    void printChar(char[] number) {
        int str = number.length-1;
        for (int i = number.length-1; i >=0; i--){
            if (number[i] != '0') {
                str = i;
                break;
            }
        }
        for (int j = str; j >= 0; j--) {
            System.out.print(number[j]);
        }
        System.out.println();
    }
}
