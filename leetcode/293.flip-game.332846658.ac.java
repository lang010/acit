/*
 * @lc app=leetcode id=293 lang=java
 *
 * [293] Flip Game
 *
 * https://leetcode.com/problems/flip-game/description/
 *
 * algorithms
 * Easy (61.10%)
 * Total Accepted:    51.7K
 * Total Submissions: 84.6K
 * Testcase Example:  '"++++"'
 *
 * You are playing the following Flip Game with your friend: Given a string
 * that contains only these two characters: + and -, you and your friend take
 * turns to flip two consecutive "++" into "--". The game ends when a person
 * can no longer make a move and therefore the other person will be the
 * winner.
 * 
 * Write a function to compute all possible states of the string after one
 * valid move.
 * 
 * Example:
 * 
 * 
 * Input: s = "++++"
 * Output: 
 * [
 * ⁠ "--++",
 * ⁠ "+--+",
 * ⁠ "++--"
 * ]
 * 
 * 
 * Note: If there is no valid move, return an empty list [].
 * 
 */
class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> ans = new ArrayList<>();
        int st = s.indexOf("++");
        while (st >= 0) {
            ans.add(s.substring(0, st)+"--"+s.substring(st+2));
            st = s.indexOf("++", st+1);
        }
        return ans;
    }
}
