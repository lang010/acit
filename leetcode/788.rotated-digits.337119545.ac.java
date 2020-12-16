/*
 * @lc app=leetcode id=788 lang=java
 *
 * [788] Rotated Digits
 *
 * https://leetcode.com/problems/rotated-digits/description/
 *
 * algorithms
 * Easy (57.24%)
 * Total Accepted:    57.9K
 * Total Submissions: 101.1K
 * Testcase Example:  '10'
 *
 * X is a good number if after rotating each digit individually by 180 degrees,
 * we get a valid number that is different from X.  Each digit must be rotated
 * - we cannot choose to leave it alone.
 * 
 * A number is valid if each digit remains a digit after rotation. 0, 1, and 8
 * rotate to themselves; 2 and 5 rotate to each other (on this case they are
 * rotated in a different direction, in other words 2 or 5 gets mirrored); 6
 * and 9 rotate to each other, and the rest of the numbers do not rotate to any
 * other number and become invalid.
 * 
 * Now given a positive number N, how many numbers X from 1 to N are good?
 * 
 * 
 * Example:
 * Input: 10
 * Output: 4
 * Explanation: 
 * There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
 * Note that 1 and 10 are not good numbers, since they remain unchanged after
 * rotating.
 * 
 * 
 * Note:
 * 
 * 
 * N  will be in range [1, 10000].
 * 
 * 
 */
class Solution {
    int[] fg = { 0, 0, 1, -1, -1, 1, 1, -1, 0, 1};
    public int rotatedDigits(int N) {
        int ans = 0;
        for (int i = 2; i <= N; i++)
            ans += check(i);
        return ans;
    }
    
    int check(int x) {
        int ans = 0;
        while (x > 0) {
            int t = x%10;
            x /= 10;
            if (fg[t] < 0)
                return 0;
            ans += fg[t];
        }
        return ans > 0 ? 1 : 0;
    }
}
