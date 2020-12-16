/*
 * @lc app=leetcode id=829 lang=java
 *
 * [829] Consecutive Numbers Sum
 *
 * https://leetcode.com/problems/consecutive-numbers-sum/description/
 *
 * algorithms
 * Hard (39.43%)
 * Total Accepted:    36.3K
 * Total Submissions: 92.2K
 * Testcase Example:  '5'
 *
 * Given a positive integer N, how many ways can we write it as a sum of
 * consecutive positive integers?
 * 
 * Example 1:
 * 
 * 
 * Input: 5
 * Output: 2
 * Explanation: 5 = 5 = 2 + 3
 * 
 * Example 2:
 * 
 * 
 * Input: 9
 * Output: 3
 * Explanation: 9 = 9 = 4 + 5 = 2 + 3 + 4
 * 
 * Example 3:
 * 
 * 
 * Input: 15
 * Output: 4
 * Explanation: 15 = 15 = 8 + 7 = 4 + 5 + 6 = 1 + 2 + 3 + 4 + 5
 * 
 * Note: 1 <= N <= 10 ^ 9.
 * 
 */
class Solution {
    public int consecutiveNumbersSum(int N) {
        int ans = 1;
        int k = 2;
        while (true) {
            int v = 2*N + k - k*k;
            if (v <= 0)
                break;
            if (v%(2*k) == 0)
                ans++;
            k++;
        }
        return ans;
    }
}
