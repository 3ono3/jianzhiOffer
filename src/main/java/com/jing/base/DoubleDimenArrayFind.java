package com.jing.base;

/**
 * 二维数组中的查找
 * !!从左到右递增，从上到下递增
 * 从右上角开始找
 * @author GuoJingyuan
 * @date 2019/10/17
 */
public class DoubleDimenArrayFind {

    public static void main(String[] args) {
        int[][] tf = {{1,2,3,4,5}, {6,7,9,10,11}, {12,13,14,15,16}};
        System.out.println(new DoubleDimenArrayFind().hasNumber(tf, 17));

    }
    public boolean hasNumber(int[][] tf, int findNum) {

        int rowNum = tf.length;
        if (rowNum < 1) {
            return false;
        }
        int columnNum = tf[0].length;
        if (columnNum < 1) {
            return false;
        }
        int r = 0;
        int c = columnNum-1;

        while (r < rowNum && c >= 0) {

            if (findNum == tf[r][c]) {
                return true;
            }
            if (findNum > tf[r][c]) {
                r++;
            } else if (findNum < tf[r][c]) {
                c--;
            }
        }
        return false;
    }
}
