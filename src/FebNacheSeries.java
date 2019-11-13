/**
 * 斐波那契数列
 * f(n) = f(n-1) + f(n-2)
 * n(0) = 0
 * n(1) = 1
 * @author GuoJingyuan
 * @date 2019/10/18
 */
public class FebNacheSeries {

    /**
     * n(2) = 1
     * n(3) = 2
     * n(4) = 3
     * n(5) = 5
     * n(6) = 8
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(new FebNacheSeries().dynamicProgramPlus(6));
    }

    /**
     * 递归重复计算
     * @param n
     * @return
     */
    public Integer num(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return num(n-1) + num(n - 2);
    }

    /**
     * 动态规划
     * @param n
     * @return
     */
    public Integer dynamicProgram(int n) {
        if (n <= 1) {
            return n;
        }
        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = 1;
        for(int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }

    /**
     * 动态规划降低空间复杂度由O(n) -> O(1)
     */
    public Integer dynamicProgramPlus(int n) {
        if (n <= 1) {
            return n;
        }
        int pami = 0;
        int pamj = 1;
        int t = 0;
        for (int i = 2; i <= n; i++) {
            t = pami + pamj;
            pami = pamj;
            pamj = t;
        }
        return t;
    }
}
