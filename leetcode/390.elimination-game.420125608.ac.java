/*
 * @lc app=leetcode id=390 lang=java
 *
 * [390] Elimination Game
 *
 * https://leetcode.com/problems/elimination-game/description/
 *
 * algorithms
 * Medium (44.76%)
 * Total Accepted:    35.1K
 * Total Submissions: 78.4K
 * Testcase Example:  '9'
 *
 * 
 * There is a list of sorted integers from 1 to n. Starting from left to right,
 * remove the first number and every other number afterward until you reach the
 * end of the list.
 * 
 * Repeat the previous step again, but this time from right to left, remove the
 * right most number and every other number from the remaining numbers.
 * 
 * We keep repeating the steps again, alternating left to right and right to
 * left, until a single number remains.
 * 
 * Find the last number that remains starting with a list of length n.
 * 
 * Example:
 * 
 * Input:
 * n = 9,
 * 1 2 3 4 5 6 7 8 9
 * 2 4 6 8
 * 2 6
 * 6
 * 
 * Output:
 * 6
 * 
 * 
 */
class Solution {
    public int lastRemaining(int n) {
        if (n < 3)
            return n;
        return 2 * (n/2+1-lastRemaining(n/2));
    }
}
