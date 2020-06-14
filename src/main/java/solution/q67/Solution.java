package solution.q67;

/**
 * 机器人的运动范围
 */
public class Solution {

    public int movingCount(int rows, int cols, int threshold) {
        int[][] visited = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                visited[i][j] = 0;
            }
        }
        return movingCount(threshold, rows, cols, 0, 0, visited);
    }

    private int movingCount(int threshold, int rows, int cols, int row, int col, int[][] visited) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || numSum(row) + numSum(col) > threshold || visited[row][col] == 1) {
            return 0;
        }
        visited[row][col] = 1;
        return 1 + movingCount(threshold, rows, cols, row + 1, col, visited)
                + movingCount(threshold, rows, cols, row - 1, col, visited)
                + movingCount(threshold, rows, cols, row, col + 1, visited)
                + movingCount(threshold, rows, cols, row, col - 1, visited);
    }

    private int numSum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.movingCount(10, 10, 5));
    }
}
