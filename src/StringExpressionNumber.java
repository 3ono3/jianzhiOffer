import com.sun.org.apache.xerces.internal.impl.xpath.regex.RegularExpression;

/**
 * 表示数值的字符串
 * true
 *
 * "+100"
 * "5e2"
 * "-123"
 * "3.1416"
 * "-1E-16"
 *
 * false
 *
 * "12e"
 * "1a3.14"
 * "1.2.3"
 * "+-5"
 * "12e+4.3"
 *
 * 使用正则表达式
 * []  ： 字符集合
 * ()  ： 分组
 * ?   ： 重复 0 ~ 1 次
 * +   ： 重复 1 ~ n 次
 * *   ： 重复 0 ~ n 次
 * .   ： 任意字符
 * \\. ： 转义后的 .
 * \\d ： 数字
 * @author GuoJingyuan
 * @date 2019/10/24
 */
public class StringExpressionNumber {

    public static void main(String[] args) {
        System.out.println(new StringExpressionNumber().isNum("12e+4.3"));
    }
    public boolean isNum(String str) {
        RegularExpression expression = new RegularExpression("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");
        return expression.matches(str);
    }
}
