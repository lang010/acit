/*
 * @lc app=leetcode id=294 lang=java
 *
 * [294] Flip Game II
 *
 * https://leetcode.com/problems/flip-game-ii/description/
 *
 * algorithms
 * Medium (50.46%)
 * Total Accepted:    55.5K
 * Total Submissions: 110K
 * Testcase Example:  '"++++"'
 *
 * You are playing the following Flip Game with your friend: Given a string
 * that contains only these two characters: + and -, you and your friend take
 * turns to flip two consecutive "++" into "--". The game ends when a person
 * can no longer make a move and therefore the other person will be the
 * winner.
 * 
 * Write a function to determine if the starting player can guarantee a win.
 * 
 * Example:
 * 
 * 
 * Input: s = "++++"
 * Output: true 
 * Explanation: The starting player can guarantee a win by flipping the middle
 * "++" to become "+--+".
 * 
 * 
 * Follow up:
 * Derive your algorithm's runtime complexity.
 */
class Solution {
    public boolean canWin(String s) {
        char[] chs = s.toCharArray();
        return minMax(chs);
    }
    
    boolean minMax(char[] chs) {
        for (int i = 1; i < chs.length; i++)
            if (chs[i-1] == '+' && chs[i] == '+') {
                chs[i-1] = chs[i] = '-';
                boolean win = !minMax(chs);
                chs[i-1] = chs[i] = '+';
                if (win)
                    return true;
            }
        return false;
    }
}
