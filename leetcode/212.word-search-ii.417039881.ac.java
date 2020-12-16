/*
 * @lc app=leetcode id=212 lang=java
 *
 * [212] Word Search II
 *
 * https://leetcode.com/problems/word-search-ii/description/
 *
 * algorithms
 * Hard (36.17%)
 * Total Accepted:    259K
 * Total Submissions: 715.9K
 * Testcase Example:  '[["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]]\n' +
  '["oath","pea","eat","rain"]'
 *
 * Given an m x n board of characters and a list of strings words, return all
 * words on the board.
 * 
 * Each word must be constructed from letters of sequentially adjacent cells,
 * where adjacent cells are horizontally or vertically neighboring. The same
 * letter cell may not be used more than once in a word.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: board =
 * [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]],
 * words = ["oath","pea","eat","rain"]
 * Output: ["eat","oath"]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: board = [["a","b"],["c","d"]], words = ["abcb"]
 * Output: []
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 12
 * board[i][j] is a lowercase English letter.
 * 1 <= words.length <= 3 * 10^4
 * 1 <= words[i].length <= 10
 * words[i] consists of lowercase English letters.
 * All the strings of words are unique.
 * 
 * 
 */
class Solution {
    int[][] dir = { {0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    int n = 0, m = 0;
    public List<String> findWords(char[][] board, String[] words) {
        n = board.length;
        m = board[0].length;
        List<String> ans = new ArrayList<>();
        for (String s : words) {
            char[] chs = s.toCharArray();
            boolean is = false;
            for (int i = 0; i < n && !is; i++)
                for (int j = 0; j < m && !is; j++)
                    if (board[i][j] == chs[0]) {
                        boolean[][] visited = new boolean[n][m];
                        if (dfs(i, j, 1, chs, board, visited)) {
                            ans.add(s);
                            is = true;
                        }
                    }
        }
        return ans;
    }
    
    boolean dfs(int x, int y, int t, char[] chs, char[][] board, boolean[][] visited) {
        visited[x][y] = true;
        if (t == chs.length)
            return true;
        for (int[] d : dir) {
            int xx = x+d[0];
            int yy = y+d[1];
            if (xx >= 0 && yy >= 0 && xx < n && yy < m && !visited[xx][yy] && board[xx][yy] == chs[t]
                && dfs(xx, yy, t+1, chs, board, visited))
                return true;
        }
        visited[x][y] = false;
        return false;
    }
}
