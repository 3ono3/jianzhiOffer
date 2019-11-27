package com.jing.base;
/**
 * 打印从1到最大的n位数
 * 如n=3 --999
 * 可能非常大用char数组
 * @author GuoJingyuan
 * @date 2019/10/23
 */
public class PrintMaxNumber {

    public static void main(String[] args) {
        new PrintMaxNumber().print1ToMaxOfNDigits(3);
    }
    public void print1ToMaxOfNDigits(int n) {
        if (n <= 0)
            return;
        char[] number = new char[n];
        print1ToMaxOfNDigits(number, 0);
    }

    private void print1ToMaxOfNDigits(char[] number, int digit) {
        if (digit == number.length) {
            printNumber(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[digit] = (char) (i + '0');
            print1ToMaxOfNDigits(number, digit + 1);
        }
    }

    private void printNumber(char[] number) {
        int index = 0;
        while (index < number.length && number[index] == '0')
            index++;
        while (index < number.length)
            System.out.print(number[index++]);
        System.out.println();
    }
}
