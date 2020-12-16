/*
 * @lc app=leetcode id=357 lang=java
 *
 * [357] Count Numbers with Unique Digits
 *
 * https://leetcode.com/problems/count-numbers-with-unique-digits/description/
 *
 * algorithms
 * Medium (48.68%)
 * Total Accepted:    83.3K
 * Total Submissions: 171.2K
 * Testcase Example:  '2'
 *
 * Given a non-negative integer n, count all numbers with unique digits, x,
 * where 0 ≤ x < 10^n.
 * 
 * 
 * Example:
 * 
 * 
 * Input: 2
 * Output: 91 
 * Explanation: The answer should be the total numbers in the range of 0 ≤ x <
 * 100, 
 * excluding 11,22,33,44,55,66,77,88,99
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= n <= 8
 * 
 * 
 */
class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0)
            return 1;
        n = Math.min(10, n);
        int[] ans = new int[n];
        ans[0] = 10;
        for (int i = 1; i < n; i++) {
            int v = 9;
            for (int j = 9; 9-j < i; j--) {
                v *= j;
            }
            ans[i] = ans[i-1] + v;
        }
        
        return ans[n-1];
    }
}
