/*
 * @lc app=leetcode id=869 lang=java
 *
 * [869] Reordered Power of 2
 *
 * https://leetcode.com/problems/reordered-power-of-2/description/
 *
 * algorithms
 * Medium (53.97%)
 * Total Accepted:    16.1K
 * Total Submissions: 29.8K
 * Testcase Example:  '1'
 *
 * Starting with a positive integer N, we reorder the digits in any order
 * (including the original order) such that the leading digit is not zero.
 * 
 * Return true if and only if we can do this in a way such that the resulting
 * number is a power of 2.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: 1
 * Output: true
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 10
 * Output: false
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: 16
 * Output: true
 * 
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: 24
 * Output: false
 * 
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: 46
 * Output: true
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= N <= 10^9
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
class Solution {
    public boolean reorderedPowerOf2(int N) {
        int[][] cnt = new int[31][10];
        for (int i = 0; i < 31; i++)
            set(1<<i, cnt[i]);
        int[] ns = new int[10];
        set(N, ns);
        for (int[] each : cnt) {
            boolean is = true;
            for (int i = 0; i < 10; i++)
                if (ns[i] != each[i]) {
                    is = false;
                    break;
                }
            if (is)
                return true;
        }
        return false;
    }
    
    void set(int x, int[] ns) {
        while (x > 0) {
            ns[x%10]++;
            x /= 10;
        }
    }
}
