import com.sun.org.apache.regexp.internal.RE;

/**
 * 数组中的一个重复数字
 * !!长度为n切值为0~n-1
 * @author GuoJingyuan
 * @date 2019/10/17
 */
public class RepeatNumber {

    public static void main(String[] args) {
        RepeatNumber rn = new RepeatNumber();
        int[] tar = {2, 3, 1, 0, 2, 5};
        Integer t = new RepeatNumber().repeatNum(tar);
        System.out.println(t);
    }
    public Integer repeatNum (int[] tar) {
        int len = tar.length;
        Integer[] rrN = new Integer[len];
        for (int i = 0; i < len; i++) {
            int val = tar[i];
            if (rrN[val] != null) {
                return val;
            }
            rrN[val] = val;
        }
        return null;
    }
}
