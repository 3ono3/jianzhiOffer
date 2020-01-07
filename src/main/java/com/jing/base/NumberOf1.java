package com.jing.base;

/**
 * 数字中1的个数
 * @author GuoJingyuan
 * @date 2019/12/18
 */
public class NumberOf1 {
    public static void main(String[] args) {
        System.out.println(new NumberOf1().num(-13));
        System.out.println(new NumberOf1().numBook(-13));
        System.out.println(Integer.toBinaryString(-13));
        System.out.println(Integer.toBinaryString(13));
    }

    int num(int digital) {
        int times = 0;
        if (digital < 0) {
            digital = -digital;
        }
        while (digital >= 2) {
            if (digital % 2 == 1) {
                times++;
            }
            digital = digital / 2;
        }
        if (digital == 1) {
            times++;
        }
        return times;
    }
    int numBook(int digital) {
        int count = 0;

        while (digital != 0) {
            count++;
            digital = digital & (digital-1);
        }
        return count;
    }
}
