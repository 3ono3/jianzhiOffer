package com.jing.base;

/**
 * 正则表达式匹配，'.'可以匹配任何，'*'零个或多个前一个字符
 *
 * '*' 非确定有限自动机
 * @author GuoJingyuan
 * @date 2019/12/27
 */
public class RegularExpression {
    public static void main(String[] args) {
        char[] regular = {'a','.','a','*'};
        char[] target = {'a','d','a','a','a'};
        boolean match = new RegularExpression().matchRegular(regular, target, 0, 0, regular.length, target.length);
        System.out.println(match);
    }
    boolean matchRegular(char[] regular, char[] target, int regIndex, int tarIndex, int regLen, int tarLen) {

        if (regIndex >= regLen && tarIndex >= tarLen) {
            return true;
        }
        if (regIndex >= regLen && tarIndex < tarLen) {
            return false;
        }
        if (tarIndex >= tarLen && regIndex < regLen) {
            return false;
        }
        if (regIndex + 1 < regLen && regular[regIndex + 1] == '*') {
            if (regular[regIndex] == target[tarIndex] || '.' == regular[regIndex]) {
                return matchRegular(regular, target, regIndex + 2, tarIndex, regLen, tarLen)
                        || matchRegular(regular, target, regIndex, tarIndex + 1, regLen, tarLen)
                        || matchRegular(regular, target, regIndex + 2, tarIndex + 1, regLen, tarLen);
            } else {
                return matchRegular(regular, target, regIndex + 2, tarIndex, regLen, tarLen);
            }
        }
        if (regular[regIndex] == target[tarIndex] || '.' == regular[regIndex]) {
            return matchRegular(regular, target, regIndex+1, tarIndex+1, regLen, tarLen);
        }


        return false;

    }
}
