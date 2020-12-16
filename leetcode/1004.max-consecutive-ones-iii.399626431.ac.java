/*
 * @lc app=leetcode id=1004 lang=java
 *
 * [1004] Max Consecutive Ones III
 *
 * https://leetcode.com/problems/max-consecutive-ones-iii/description/
 *
 * algorithms
 * Medium (60.28%)
 * Total Accepted:    78.7K
 * Total Submissions: 130.5K
 * Testcase Example:  '[1,1,1,0,0,0,1,1,1,1,0]\n2'
 *
 * Given an array A of 0s and 1s, we may change up to K values from 0 to 1.
 * 
 * Return the length of the longest (contiguous) subarray that contains only
 * 1s. 
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * Output: 6
 * Explanation: 
 * [1,1,1,0,0,1,1,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1.  The longest subarray is
 * underlined.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * Output: 10
 * Explanation: 
 * [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1.  The longest subarray is
 * underlined.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= A.length <= 20000
 * 0 <= K <= A.length
 * A[i] is 0 or 1 
 * 
 * 
 * 
 */
class Solution {
    public int longestOnes(int[] A, int K) {
        int l = -1, r = -1;
        int n = A.length;
        int max = 0;
        while (r < n-1) {
            if (A[++r] == 0) {
                if (K-- <= 0) {
                    while (A[++l] != 0) {
                    }
                    K++;
                }
            }
            max = Math.max(max, r-l);
        }
        return max;
    }
}
