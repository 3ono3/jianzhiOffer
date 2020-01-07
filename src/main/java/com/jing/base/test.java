package com.jing.base;

/**
 * @author GuoJingyuan
 * @date 2019/12/8
 */
public class test {
    public static void main(String[] args) {
        new test().subtractProductAndSum(234);
    }
    public int subtractProductAndSum(int n) {
        int sum = 0;
        int ji = 1;
        if (n >= 10) {
            int m = n % 10;
            n = n/10;
            sum += m;
            ji *= m;
        }
        sum += n;
        ji *= n;
        return ji-sum;
    }
}
