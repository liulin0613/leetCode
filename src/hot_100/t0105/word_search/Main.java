package hot_100.t0105.word_search;

/**
 * https://leetcode-cn.com/problems/word-search/
 *
 * 79. 单词搜索
 * 中等
 *
 * @author liulin
 */
public class Main {

    public static void main(String[] args) {
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };

        String word = "ABCCED";

        System.out.println(exist(board, word));
    }

    public static boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        boolean[][] used = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                boolean flag = backtrack(board, used, i, j, word, 0);
                if (flag) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean backtrack(char[][] board, boolean[][] used, int i, int j, String word, int cur) {
        if (board[i][j] != word.charAt(cur)) {
            return false;
        } else if (cur == word.length() - 1) {
            return true;
        }

        used[i][j] = true;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        boolean result = false;

        for (int[] dir : directions) {
            int newi = i + dir[0], newj = j + dir[1];
            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
                if (!used[newi][newj]) {
                    boolean flag = backtrack(board, used, newi, newj, word, cur + 1);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
        }

        used[i][j] = false;
        return result;
    }


}
