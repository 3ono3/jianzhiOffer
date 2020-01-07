package com.jing.base;

import java.util.LinkedList;

/**
 * 矩阵中的路径_书中接法
 * 回溯法
 * @author GuoJingyuan
 * @date 2019/10/18
 */
public class RectanglePathBook {
    public static void main(String[] args) {
        char[][] data = {{'a', 'b', 't', 'g'}, {'c', 'f', 'c', 's'},
                {'j', 'd', 'e', 'h'}};
        LinkedList<String> match = new LinkedList<>();
        boolean x = new RectanglePathBook().havePath(data, "bfce", match);
        System.out.println(x);
        if (x) {
            for (String m : match) {
                System.out.print(m + "; ");
            }
        }

    }
    boolean havePath(char[][] data, String target, LinkedList<String> match) {
        int rowLen = data.length;
        if (rowLen < 1) {
            return false;
        }
        int colLen = data[0].length;
        if (colLen < 1) {
            return false;
        }
        boolean[][] through = new boolean[rowLen][colLen];
        char[] path = target.toCharArray();
        for (int r = 0; r < rowLen; r++) {
            for (int c = 0; c < colLen; c++) {
                if (havePathCore(data, r, c, 0, path, through, match)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 当前路径是否符合
     * @param data 坐标数组
     * @param row 行
     * @param col 列
     * @param pathLength 当前路径所在位置
     * @param path 路径数组
     * @param through 当前坐标是否经过过
     * @param match 符合的坐标
     * @return
     */
    boolean havePathCore(char[][] data, int row, int col, int pathLength, char[] path, boolean[][] through, LinkedList<String> match) {
        if (pathLength == path.length) {
            return true;
        }
        boolean hasPath = false;
        if (row >= 0 && row < data.length && col >= 0 && col < data[0].length
                && data[row][col] == path[pathLength] && !through[row][col]) {
            pathLength++;
            through[row][col] = true;
            match.add(row + "," + col);
            hasPath = havePathCore(data, row+1, col, pathLength, path, through, match)
                    ||havePathCore(data, row, col+1, pathLength, path, through, match)
                    ||havePathCore(data, row-1, col, pathLength, path, through, match)
                    ||havePathCore(data, row, col-1, pathLength, path, through, match);
            if (!hasPath) {
                pathLength--;
                through[row][col] = false;
                match.removeLast();
            }
        }

        return hasPath;

    }
}
