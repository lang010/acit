/*
 * @lc app=leetcode id=37 lang=java
 *
 * [37] Sudoku Solver
 *
 * https://leetcode.com/problems/sudoku-solver/description/
 *
 * algorithms
 * Hard (45.47%)
 * Total Accepted:    212.2K
 * Total Submissions: 466.5K
 * Testcase Example:  '[["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]'
 *
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * 
 * A sudoku solution must satisfy all of the following rules:
 * 
 * 
 * Each of the digits 1-9 must occur exactly once in each row.
 * Each of the digits 1-9 must occur exactly once in each column.
 * Each of the digits 1-9 must occur exactly once in each of the 9 3x3
 * sub-boxes of the grid.
 * 
 * 
 * The '.' character indicates empty cells.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: board =
 * [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
 * Output:
 * [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
 * Explanation: The input board is shown above and the only valid solution is
 * shown below:
 * 
 * 
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * board.length == 9
 * board[i].length == 9
 * board[i][j] is a digit or '.'.
 * It is guaranteed that the input board has only one solution.
 * 
 * 
 */
class Solution {
    int N = 9;
    boolean[][] hor = new boolean[N][N];
    boolean[][] ver = new boolean[N][N];
    boolean[][] sub = new boolean[N][N];
    
    public void solveSudoku(char[][] board) {
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (board[i][j] != '.') {
                    int id = board[i][j] - '1';
                    hor[i][id] = true;
                    ver[j][id] = true;
                    sub[i/3*3+j/3][id] = true;
                }
        backtracking(board, 0);
    }
    
    boolean backtracking(char[][] board, int st) {
        while (st < 81 && board[st/9][st%9] != '.') {
            st++;
        }
        if (st == 81)
            return true;
        int x = st/9;
        int y = st%9;
        for (int i = 0; i < N; i++) {
            if (hor[x][i] || ver[y][i] || sub[x/3*3+y/3][i])
                continue;
            hor[x][i] = true;
            ver[y][i] = true;
            sub[x/3*3+y/3][i] = true;
            board[x][y] = (char) ('1' + i);
            if (backtracking(board, st+1))
                return true;
            hor[x][i] = false;
            ver[y][i] = false;
            sub[x/3*3+y/3][i] = false;
            board[x][y] = '.';
        }
        
        return false;
    }
}
