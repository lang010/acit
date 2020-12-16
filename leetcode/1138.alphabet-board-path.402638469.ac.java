/*
 * @lc app=leetcode id=1138 lang=java
 *
 * [1138] Alphabet Board Path
 *
 * https://leetcode.com/problems/alphabet-board-path/description/
 *
 * algorithms
 * Medium (50.05%)
 * Total Accepted:    20.2K
 * Total Submissions: 40.4K
 * Testcase Example:  '"leet"'
 *
 * On an alphabet board, we start at position (0, 0), corresponding to
 * character board[0][0].
 * 
 * Here, board = ["abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"], as shown
 * in the diagram below.
 * 
 * 
 * 
 * We may make the following moves:
 * 
 * 
 * 'U' moves our position up one row, if the position exists on the board;
 * 'D' moves our position down one row, if the position exists on the
 * board;
 * 'L' moves our position left one column, if the position exists on the
 * board;
 * 'R' moves our position right one column, if the position exists on the
 * board;
 * '!' adds the character board[r][c] at our current position (r, c) to the
 * answer.
 * 
 * 
 * (Here, the only positions that exist on the board are positions with letters
 * on them.)
 * 
 * Return a sequence of moves that makes our answer equal to target in the
 * minimum number of moves.  You may return any path that does so.
 * 
 * 
 * Example 1:
 * Input: target = "leet"
 * Output: "DDR!UURRR!!DDD!"
 * Example 2:
 * Input: target = "code"
 * Output: "RR!DDRR!UUL!R!"
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= target.length <= 100
 * target consists only of English lowercase letters.
 * 
 */
class Solution {
    public String alphabetBoardPath(String target) {
        StringBuilder sb = new StringBuilder();
        char cur = 'a';
        for (char c : target.toCharArray()) {
            int i0 = (c-'a')%5 - (cur-'a')%5;
            int i1 = (c-'a')/5 - (cur-'a')/5;
            char r = i0 > 0 ? 'R' : 'L';
            char d = i1 > 0 ? 'D' : 'U';
            i0 = Math.abs(i0);
            i1 = Math.abs(i1);
            if (cur == 'z' && i1 > 0) {
                sb.append(d);
                i1--;
            }
            for (int i = 0; i < i0; i++)
                sb.append(r);
            for (int i = 0; i < i1; i++)
                sb.append(d);
            sb.append('!');
            cur = c;
        }
        return sb.toString();
    }
}
