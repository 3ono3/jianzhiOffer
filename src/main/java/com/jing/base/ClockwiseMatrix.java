package com.jing.base;

/**
 * 顺时针打印矩阵
 * @author GuoJingyuan
 * @date 2020/1/13
 */
public class ClockwiseMatrix {
    private static final int[][] DIRECTION = {{0, 1},{1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) {
        int[][] target = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] target2 = {{1}};
        ClockwiseMatrix cwm = new ClockwiseMatrix();
        cwm.printMatrix(target);
    }

    private void printMatrix(int[][] target) {
        int rowNum = target.length;
        if (rowNum < 1) {
            return;
        }
        int colNum = target[0].length;
        if (colNum < 1) {
            return;
        }
        boolean[][] pass = new boolean[rowNum][colNum];
        int dir = 0;
        int tarNodeRow = 0;
        int tarNodeCol = 0;
        while (!(tarNodeRow >= rowNum || tarNodeRow < 0 || tarNodeCol >= colNum || tarNodeCol < 0
                || pass[tarNodeRow][tarNodeCol])) {
            System.out.println(target[tarNodeRow][tarNodeCol]);
            pass[tarNodeRow][tarNodeCol] = true;
            int nextRow = tarNodeRow + DIRECTION[dir][0];
            int nextCol = tarNodeCol + DIRECTION[dir][1];
            if (nextRow >= rowNum || nextRow < 0 || nextCol >= colNum || nextCol < 0
                    || pass[nextRow][nextCol]) {
                dir = dir + 1;
                dir = (dir + 4) % 4;
                tarNodeRow = tarNodeRow + DIRECTION[dir][0];
                tarNodeCol = tarNodeCol + DIRECTION[dir][1];
            } else {
                tarNodeRow = nextRow;
                tarNodeCol = nextCol;
            }
        }
    }
}
