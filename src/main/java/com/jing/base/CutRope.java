package com.jing.base;

/**
 * 剪绳子
 * 将一跟绳子剪成最小单位为1的段，求段的乘积最大的剪法
 *
 * 贪心：
 * 尽可能多剪长度为 3 的绳子，并且不允许有长度为 1 的绳子出现。
 * 如果出现了，就从已经切好长度为 3 的绳子中拿出一段与长度为 1 的绳子重新组合，把它们切成两段长度为 2 的绳子
 * @author GuoJingyuan
 * @date 2019/10/22
 */
public class CutRope {

    public static void main(String[] args) {
        System.out.println(new CutRope().integerBreak(17));
    }
    public double solution(int n) {
        if (n < 2) {
            return 1*0;
        }
        if (n == 2) {
            return 1*1;
        }
        if (n == 3) {
            return 2*1;
        }
        if (n == 4) {
            return 2*2;
        }
        int quantity = n/3;
        int remainder = n%3;
        if (remainder == 1) {
            quantity -= 1;
            return Math.pow(3, quantity) * 2 * 2;
        }
        if (remainder == 0) {
            return Math.pow(3, quantity);
        }
        return Math.pow(3, quantity) * remainder;
    }
    //官方
    public int integerBreak(int n) {
        if (n < 2)
            return 0;
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;
        int timesOf3 = n / 3;
        if (n - timesOf3 * 3 == 1)
            timesOf3--;
        int timesOf2 = (n - timesOf3 * 3) / 2;
        return (int) (Math.pow(3, timesOf3)) * (int) (Math.pow(2, timesOf2));
    }
}
