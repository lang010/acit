/*
 * @lc app=leetcode id=130 lang=java
 *
 * [130] Surrounded Regions
 *
 * https://leetcode.com/problems/surrounded-regions/description/
 *
 * algorithms
 * Medium (28.95%)
 * Total Accepted:    270.6K
 * Total Submissions: 934.7K
 * Testcase Example:  '[["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]'
 *
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions
 * surrounded by 'X'.
 * 
 * A region is captured by flipping all 'O's into 'X's in that surrounded
 * region.
 * 
 * Example:
 * 
 * 
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 
 * 
 * After running your function, the board should be:
 * 
 * 
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 
 * 
 * Explanation:
 * 
 * Surrounded regions shouldn’t be on the border, which means that any 'O' on
 * the border of the board are not flipped to 'X'. Any 'O' that is not on the
 * border and it is not connected to an 'O' on the border will be flipped to
 * 'X'. Two cells are connected if they are adjacent cells connected
 * horizontally or vertically.
 * 
 */
class Solution {
    int[][] next = { {0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public void solve(char[][] board) {
        int n = board.length;
        if (n == 0)
            return;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            dfs(board, i, 0);
            dfs(board, i, m-1);
        }
        for (int i = 0; i < m; i++) {
            dfs(board, 0, i);
            dfs(board, n-1, i);
        }
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == '.')
                    board[i][j] = 'O';
    }
    
    void dfs(char[][] board, int x, int y) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] != 'O')
            return;
        board[x][y] = '.';
        for (int[] d : next) {
            dfs(board, x+d[0], y+d[1]);
        }
    }
}
