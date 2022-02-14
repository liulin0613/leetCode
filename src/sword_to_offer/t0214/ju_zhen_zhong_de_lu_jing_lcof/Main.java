package sword_to_offer.t0214.ju_zhen_zhong_de_lu_jing_lcof;


/**
 * https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/
 *
 * 剑指 Offer 12. 矩阵中的路径
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
//        char[][] board = new char[][]{
//                {'A','B','C','E'},
//                {'S','F','C','S'},
//                {'A','D','E','E'}
//        };

        char[][] board = new char[][]{{'a','a'}};

        String word = "aaa";

        System.out.println(exist(board, word));
    }

    public static boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0].length == 0){
            return false;
        }

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean res = backtrack(i,j,board,word,new boolean[m][n],0);
                if(res){
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean backtrack(int i, int j, char[][] board, String word, boolean[][] used, int cur) {
        if(board[i][j] != word.charAt(cur)){
            return false;
        }else if(cur == word.length() - 1){
            return true;
        }

        used[i][j] = true;

        int[][] dist = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int[] ints : dist) {
            int newi = i + ints[0], newj = j + ints[1];
            if(newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length && !used[newi][newj]){
                boolean res = backtrack(newi,newj,board,word,used,cur+1);
                if(res){
                    return true;
                }
            }
        }

        used[i][j] = false;

        return false;
    }
}
