/*
 * @lc app=leetcode id=529 lang=java
 *
 * [529] Minesweeper
 *
 * https://leetcode.com/problems/minesweeper/description/
 *
 * algorithms
 * Medium (60.42%)
 * Total Accepted:    73.3K
 * Total Submissions: 121.3K
 * Testcase Example:  '[["E","E","E","E","E"],["E","E","M","E","E"],["E","E","E","E","E"],["E","E","E","E","E"]]\n' +
  '[3,0]'
 *
 * Let's play the minesweeper game (Wikipedia, online game)!
 * 
 * You are given a 2D char matrix representing the game board. 'M' represents
 * an unrevealed mine, 'E' represents an unrevealed empty square, 'B'
 * represents a revealed blank square that has no adjacent (above, below, left,
 * right, and all 4 diagonals) mines, digit ('1' to '8') represents how many
 * mines are adjacent to this revealed square, and finally 'X' represents a
 * revealed mine.
 * 
 * Now given the next click position (row and column indices) among all the
 * unrevealed squares ('M' or 'E'), return the board after revealing this
 * position according to the following rules:
 * 
 * 
 * If a mine ('M') is revealed, then the game is over - change it to 'X'.
 * If an empty square ('E') with no adjacent mines is revealed, then change it
 * to revealed blank ('B') and all of its adjacent unrevealed squares should be
 * revealed recursively.
 * If an empty square ('E') with at least one adjacent mine is revealed, then
 * change it to a digit ('1' to '8') representing the number of adjacent
 * mines.
 * Return the board when no more squares will be revealed.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: 
 * 
 * [['E', 'E', 'E', 'E', 'E'],
 * ⁠['E', 'E', 'M', 'E', 'E'],
 * ⁠['E', 'E', 'E', 'E', 'E'],
 * ⁠['E', 'E', 'E', 'E', 'E']]
 * 
 * Click : [3,0]
 * 
 * Output: 
 * 
 * [['B', '1', 'E', '1', 'B'],
 * ⁠['B', '1', 'M', '1', 'B'],
 * ⁠['B', '1', '1', '1', 'B'],
 * ⁠['B', 'B', 'B', 'B', 'B']]
 * 
 * Explanation:
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 
 * 
 * [['B', '1', 'E', '1', 'B'],
 * ⁠['B', '1', 'M', '1', 'B'],
 * ⁠['B', '1', '1', '1', 'B'],
 * ⁠['B', 'B', 'B', 'B', 'B']]
 * 
 * Click : [1,2]
 * 
 * Output: 
 * 
 * [['B', '1', 'E', '1', 'B'],
 * ⁠['B', '1', 'X', '1', 'B'],
 * ⁠['B', '1', '1', '1', 'B'],
 * ⁠['B', 'B', 'B', 'B', 'B']]
 * 
 * Explanation:
 * 
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * The range of the input matrix's height and width is [1,50].
 * The click position will only be an unrevealed square ('M' or 'E'), which
 * also means the input board contains at least one clickable square.
 * The input board won't be a stage when game is over (some mines have been
 * revealed).
 * For simplicity, not mentioned rules should be ignored in this problem. For
 * example, you don't need to reveal all the unrevealed mines when the game is
 * over, consider any cases that you will win the game or flag any squares.
 * 
 * 
 */
class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0];
        int y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }
        return check(board, x, y);
    }
    
    char[][] check(char[][] b, int x, int y) {
        if (!validate(b, x, y))
            return b;
        if (b[x][y] != 'E')
            return b;
        int cnt = countMines(b, x, y);
        if (cnt == 0) {
            b[x][y] = 'B';
            for (int i = -1; i < 2; i++) {
                check(b, x - 1, y + i);
                check(b, x + 1, y + i);
            }
            check(b, x, y - 1);
            check(b, x, y + 1);
        } else {
            b[x][y] = (char)('0' + cnt);
        }
        return b;
    }
    
    int countMines(char[][] b, int x, int y) {
        int ans = 0;
        for (int i = -1; i < 2; i++) {
            ans += isMine(b, x-1, y + i);
            ans += isMine(b, x+1, y + i);
        }
        ans += isMine(b, x, y - 1);
        ans += isMine(b, x, y + 1);
        return ans;
    }
    
    int isMine(char[][] b, int x, int y) {
        if (validate(b, x, y) && b[x][y] == 'M')
            return 1;
        return 0;
    }
    
    boolean validate(char[][] b, int x, int y) {
        return x >= 0 && x < b.length && y >= 0 && y < b[0].length;
    }
}
