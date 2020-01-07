package com.jing.base;

/**
 * 剪绳子
 * 将一跟绳子剪成最小单位为1的段，求段的乘积最大的剪法
 * 动态规划
 * @author GuoJingyuan
 * @date 2019/12/17
 */
public class CutRopeDynamic {

    public static void main(String[] args) {
        System.out.println(new CutRopeDynamic().cut(17));
    }

    int cut(int total) {
        if (total < 2) {
            return 0;
        }
        if (total == 2) {
            return 1;
        }
        if (total == 3) {
            return 2;
        }
        int[] pro = new int[total+1];
        pro[0] = 0;
        pro[1] = 1;
        pro[2] = 2;
        pro[3] = 3;
        int max;
        for (int i = 4; i <= total; i++) {
            max = 0;
            for (int j = 1; j <= i/2; j++) {
                max = Math.max(pro[j] * pro[i-j], max);
                pro[i] = max;
            }
        }
        return pro[total];
    }
}
