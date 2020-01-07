package com.jing.base;

/**
 * 输入一个数，打印到这个位数的全部数字
 * 例如输入3：打印1,2，。。。999
 * @author GuoJingyuan
 * @date 2019/12/25
 */
public class PrintToMaxNumWithCharAry {

    public static void main(String[] args) {
        new PrintToMaxNumWithCharAry().print(4);
    }
    void print(int num) {
        char[] number = new char[num];
        for (int i = 0; i < num; i++) {
            number[i] = '0';
        }
        while (!Increment(number)) {
            printBook(number);
            System.out.println();
        }
    }
    boolean maxOver(char[] number) {
        boolean over = false;
        int i = 0;
        for (i = 0; i < number.length; i++) {
            int sub = number[i] - '0';
            if (sub < 9) {
                number[i] +=1;
                break;
            } else {
                number[i] = '0';
            }
        }
        if (i == number.length && number[i-1] == '0') {
            over = true;
        }
        return over;
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
    }

    boolean Increment(char[] number) {
        boolean isOverflow = false;
        int nTackOver = 0;
        int nLength = number.length;
        for (int i = nLength - 1; i >= 0; i--) {
            int nSum = number[i] - '0' + nTackOver;
            if (i == nLength - 1) {
                nSum++;
            }
            if(nSum >= 10) {
                if (i == 0) {
                    isOverflow = true;
                } else {
                    nSum -= 10;
                    nTackOver = 1;
                    number[i] = (char) ('0' + nSum);
                }
            } else {
                number[i] = (char) ('0' + nSum);
                break;
            }
        }
        return isOverflow;
    }
    void printBook(char[] number) {
        boolean isBeginning = true;
        int nLength = number.length;
        for (int i = 0; i < number.length; i++){
            if (isBeginning && number[i] != '0') {
                isBeginning = false;
            }
            if (!isBeginning) {
                System.out.print(number[i]);
            }
        }
    }
}
