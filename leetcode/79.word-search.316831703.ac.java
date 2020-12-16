/*
 * @lc app=leetcode id=79 lang=java
 *
 * [79] Word Search
 *
 * https://leetcode.com/problems/word-search/description/
 *
 * algorithms
 * Medium (36.38%)
 * Total Accepted:    574.6K
 * Total Submissions: 1.6M
 * Testcase Example:  '[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"ABCCED"'
 *
 * Given an m x n board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cells,
 * where "adjacent" cells are horizontally or vertically neighboring. The same
 * letter cell may not be used more than once.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word
 * = "ABCCED"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word
 * = "SEE"
 * Output: true
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word
 * = "ABCB"
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 200
 * 1 <= word.length <= 10^3
 * board and word consists only of lowercase and uppercase English letters.
 * 
 * 
 */
class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length < 1)
            return false;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                if (dfs(board, visited, word, 0, i, j))
                    return true;
        return false;
    }
    
    boolean dfs(char[][] board, boolean[][] visited, String word, int cur, int x, int y) {
        if (cur == word.length())
            return true;
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length)
            return false;
        if (visited[x][y])
            return false;
        if (board[x][y] != word.charAt(cur))
            return false;
        visited[x][y] = true;
        if (dfs(board, visited, word, cur+1, x+1, y)
           || dfs(board, visited, word, cur+1, x-1, y)
           || dfs(board, visited, word, cur+1, x, y+1)
           || dfs(board, visited, word, cur+1, x, y-1))
            return true;
        visited[x][y] = false;
        return false;
    }
}
