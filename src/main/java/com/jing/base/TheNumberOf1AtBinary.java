package com.jing.base;

/**
 * 一个数对应的二进制中1的个数
 *
 * &操作
 * @author GuoJingyuan
 * @date 2019/10/22
 */
public class TheNumberOf1AtBinary {

    public static void main(String[] args) {
        System.out.println(new TheNumberOf1AtBinary().theNumber(20));
    }
    public int theNumber(int n) {
        int cnt = 0;
        while (n != 0) {
            cnt++;
            n &= (n-1);
        }
        return cnt;
    }
}
