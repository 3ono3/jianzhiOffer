/**
 * 正则表达式匹配
 * "."可匹配任意一个字符，"*"0或多个前一个字符
 * @author GuoJingyuan
 * @date 2019/10/24
 */
public class RegularExpressionMatching {
    public static void main(String[] args) {
        System.out.println(new RegularExpressionMatching().matchOfficial("abcd","a*b.d*"));
    }
    public boolean match(String targetStr, String regularStr) {
        char[] targetAry = targetStr.toCharArray();
        char[] regularAry = regularStr.toCharArray();
        int i;
        int p = 0;
        for (i = 0; i < targetAry.length && p < regularAry.length; ) {
            char targetC = targetAry[i];
            char regularC = regularAry[p];
            if (targetC == regularC || regularC == '.') {
                i++;
                p++;
                continue;
            }
            if (regularC == '*' && p-1 >= 0) {
                char lastReC = regularAry[p-1];
                if (lastReC == targetC) {
                    i++;
                    continue;
                }
                p++;
                continue;
            }
            break;
        }
        if (i < targetAry.length) {
            return false;
        }
        while (p < regularAry.length) {
            if (regularAry[p++] != '*') {
                return false;
            }
        }
        return true;
    }

    public boolean matchOfficial(String targetStr, String regularStr) {
        char[] str = targetStr.toCharArray();
        char[] pattern = regularStr.toCharArray();
        int m = str.length, n = pattern.length;
        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;
        for (int i = 1; i <= n; i++)
            if (pattern[i - 1] == '*')
                dp[0][i] = dp[0][i - 2];

        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                if (str[i - 1] == pattern[j - 1] || pattern[j - 1] == '.')
                    dp[i][j] = dp[i - 1][j - 1];
                else if (pattern[j - 1] == '*')
                    if (pattern[j - 2] == str[i - 1] || pattern[j - 2] == '.') {
                        dp[i][j] |= dp[i][j - 1]; // a* counts as single a
                        dp[i][j] |= dp[i - 1][j]; // a* counts as multiple a
                        dp[i][j] |= dp[i][j - 2]; // a* counts as empty
                    } else
                        dp[i][j] = dp[i][j - 2];   // a* only counts as empty

        return dp[m][n];
    }
}
