import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * 矩阵中的路径,查询矩阵中是否有一条路径为给定的字符串
 * 回溯法
 * @author GuoJingyuan
 * @date 2019/10/21
 */
public class MatrixPath {

    public static void main(String[] args) {
        char[][] matrix = {{'a', 'b', 't', 'g'}, {'c', 'f', 'c', 's'}, {'j', 'd', 'e', 'h'}};
        char[] targetStr = {'b', 'f', 'c', 'e'};
        System.out.println(new MatrixPath().havePath(matrix, targetStr));
    }
    /**
     * r,c,下，右，上，左
     */
    private int[][] next = {{0,1}, {-1, 0}, {1,0}, {0, -1}};

    private int rowLength;
    private int columnLength;
    public boolean havePath(char[][] matrix, char[] targetStr) {
        rowLength = matrix.length;
        if (rowLength < 1) {
            return false;
        }
        columnLength = matrix[0].length;
        if (columnLength < 1) {
            return false;
        }
        boolean[][] marked = new boolean[rowLength][columnLength];
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength; j++) {
                if (recursiveJudge(matrix, targetStr, i, j, 0, marked)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean recursiveJudge(char[][] matrix, char[] target, int row, int column, int index, boolean[][] marked) {
        if (index == target.length-1) {
            return true;
        }
        if (row < 0 || row >= rowLength || column < 0 || column >= columnLength
                || matrix[row][column] != target[index] || marked[row][column]) {
            return false;
        }
        marked[row][column] = true;
        for (int[] n : next) {
            if (recursiveJudge(matrix, target, row+n[0], column+n[1], index+1, marked)) {
                return true;
            }
        }
        //回退
        marked[row][column] = false;
        return false;
    }
}
