import java.util.logging.SocketHandler;

/**
 * 机器人运动范围
 * 不能进入行坐标和列坐标的数位之和大于 k 的格子
 * 例如：当 k 为 18 时，机器人能够进入方格 (35,37)，因为 3+5+3+7=18。但是，它不能进入方格 (35,38)，因为 3+5+3+8=19。
 * 机器人能够达到多少个格子？
 * @author GuoJingyuan
 * @date 2019/10/21
 */
public class RobotRange {

    private int[][] next = {{0,1},{1,0},{0,-1},{-1,0}};
    private int total = 0;
    private boolean[][] marked;
    public static void main(String[] args) {
        System.out.println(new RobotRange().solution(18, 20, 20));
    }

    private int solution(int k, int rowLimit, int columnLimit){
        marked = new boolean[rowLimit][columnLimit];
        canIn(0, 0, k, rowLimit, columnLimit, marked);
        return total;
    }

    private void canIn(int row, int column, int k, int rowLimit, int columnLimit, boolean[][] marked) {
        if (row < 0 || row >= rowLimit || column < 0 || column >= columnLimit || marked[row][column]) {
            return;
        }
        if (sum(row, column) > k) {
            return ;
        }
        marked[row][column] = true;
        total++;
        for (int[] n : next) {
           canIn(row+n[0], column+n[1], k, rowLimit, columnLimit, marked);
        }
    }

    private int sum(int rowIndex, int columnIndex) {
        try {
            int sum = 0;
            while (rowIndex > 0) {
                sum += rowIndex % 10;
                rowIndex /= 10;
            }
            while (columnIndex > 0) {
                sum += columnIndex % 10;
                columnIndex /= 10;
            }
            return sum;
        } catch (Exception e) {
            int ss = 0;
            while (rowIndex > 0) {
                ss += rowIndex % 10;
                rowIndex /= 10;
            }
            while (columnIndex > 0) {
                ss += columnIndex % 10;
                columnIndex /= 10;
            }
            e.printStackTrace();
        }
        return 0;
    }
}
