package solution.q66;

/**
 * 判断在一个矩阵中是否存在一条包含某字符串
 * 所有字符的路径。 路径可以从矩阵中的任意一个格子开始， 每一步可以在矩阵中
 * 向左， 向右， 向上， 向下移动一个格子
 */
public class Solution {

    public boolean hasPath(char[][] matrix, int rows, int cols, char[] word) {
        if (matrix == null || rows <= 0 || cols <= 0 || word == null || word.length == 0) {
            throw new RuntimeException("illegal arguments");
        }
        // 先标记为未访问过
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                visited[i][j] = false;
            }
        }
        // 从所有可能的起点开始尝试
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (hasPath(matrix, rows, cols, i, j, word, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasPath(char[][] matrix, int rows, int cols, int x, int y, char[] word, int index, boolean[][] visited) {
        // 参数检查 & 是否访问
        if (x < 0 || x >= rows || y < 0 || y >= cols || visited[x][y] || matrix[x][y] != word[index]) {
            return false;
        }

        // 找到了
        if (index == word.length - 1) {
            return true;
        }

        // 没找到的情况
        visited[x][y] = true;

        if (hasPath(matrix, rows, cols, x + 1, y, word, index + 1, visited)
                || hasPath(matrix, rows, cols, x - 1, y, word, index + 1, visited)
                || hasPath(matrix, rows, cols, x, y + 1, word, index + 1, visited)
                || hasPath(matrix, rows, cols, x, y - 1, word, index + 1, visited)) {
            return true;
        }
        visited[x][y] = false;
        return false;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'a', 'b', 'c', 'd', 'e'}, {'b', 'c', 'd', 'f', 'g'}, {'h', 'i', 'j', 'k', 'l'}, {'m', 'o', 'p', 'r', 'e'}};
        Solution solution = new Solution();
        System.out.println(solution.hasPath(matrix, 4, 5, new char[]{'f', 'd', 'c', 'b', 'h', 'm', 'o', 'i', 'j', 'k'}));
        System.out.println(solution.hasPath(matrix, 4, 5, new char[]{'b', 'c', 'i', 'o'}));
        System.out.println(solution.hasPath(matrix, 4, 5, new char[]{'b', 'c', 'd'}));
        System.out.println(solution.hasPath(matrix, 4, 5, new char[]{'e', 'l', 'g', 'f', 'd', 'c', 'b', 'a', 'b', 'c'}));
        System.out.println(solution.hasPath(matrix, 4, 5, new char[]{'a', 'c', 'i', 'o'}));
        System.out.println(solution.hasPath(matrix, 4, 5, new char[]{'b', 'a', 'd'}));
    }
}
