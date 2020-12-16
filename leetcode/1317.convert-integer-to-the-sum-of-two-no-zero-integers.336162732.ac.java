/*
 * @lc app=leetcode id=1317 lang=java
 *
 * [1317] Convert Integer to the Sum of Two No-Zero Integers
 *
 * https://leetcode.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers/description/
 *
 * algorithms
 * Easy (56.84%)
 * Total Accepted:    19.6K
 * Total Submissions: 34.5K
 * Testcase Example:  '2'
 *
 * Given an integer n. No-Zero integer is a positive integer which doesn't
 * contain any 0 in its decimal representation.
 * 
 * Return a list of two integers [A, B] where:
 * 
 * 
 * A and B are No-Zero integers.
 * A + B = n
 * 
 * 
 * It's guarateed that there is at least one valid solution. If there are many
 * valid solutions you can return any of them.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 2
 * Output: [1,1]
 * Explanation: A = 1, B = 1. A + B = n and both A and B don't contain any 0 in
 * their decimal representation.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 11
 * Output: [2,9]
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: n = 10000
 * Output: [1,9999]
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: n = 69
 * Output: [1,68]
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: n = 1010
 * Output: [11,999]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 2 <= n <= 10^4
 * 
 */
class Solution {
    public int[] getNoZeroIntegers(int n) {
        int a, b, cnt;
        a = b = cnt = 0;
        while (n > 0) {
            int l = n%10;
            n /= 10;
            if (l < 2 && n > 0) {
                l += 10;
                n--;
            }
            int f1 = 1;
            if (l == 11) {
                f1 = 2;
            }
            a += Math.pow(10, cnt) * f1;
            b += Math.pow(10, cnt) * (l-f1);
            cnt++;
        }
        return new int[] {a, b};
    }
}
