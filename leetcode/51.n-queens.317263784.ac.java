/*
 * @lc app=leetcode id=51 lang=java
 *
 * [51] N-Queens
 *
 * https://leetcode.com/problems/n-queens/description/
 *
 * algorithms
 * Hard (48.55%)
 * Total Accepted:    228.6K
 * Total Submissions: 470.8K
 * Testcase Example:  '4'
 *
 * The n-queens puzzle is the problem of placing n queens on an n x n
 * chessboard such that no two queens attack each other.
 * 
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * 
 * Each solution contains a distinct board configuration of the n-queens'
 * placement, where 'Q' and '.' both indicate a queen and an empty space,
 * respectively.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 4
 * Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as
 * shown above
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 1
 * Output: [["Q"]]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 9
 * 
 * 
 */
class Solution {
    int N;
    boolean[] fl2;
    boolean[] fl3;
    boolean[] fl4;
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        if (n == 0)
            return ans;
        
        fl2 = new boolean[n];
        fl3 = new boolean[n+n];
        fl4 = new boolean[n+n];
        N = n;
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(board[i], '.');
        
        backtracking(board, 0, ans);
        
        return ans;
    }
    
    void backtracking(char[][] board, int x, List<List<String>> ans) {
        if (x == N) {
            List<String> ls = new ArrayList<>();
            for (char[] str : board) {
                ls.add(new String(str));
            }
            ans.add(ls);
            return;
        }
        
        for (int y = 0; y < N; y++) {
            int dx = x-y+N;
            if (fl2[y] || fl3[x+y] || fl4[dx])
                continue;
            fl2[y] = fl3[x+y] = fl4[dx] = true;
            board[x][y] = 'Q';
            backtracking(board, x+1, ans);
            fl2[y] = fl3[x+y] = fl4[dx] = false;
            board[x][y] = '.';
        }
    }
}
