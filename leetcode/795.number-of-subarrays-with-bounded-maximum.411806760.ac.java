/*
 * @lc app=leetcode id=795 lang=java
 *
 * [795] Number of Subarrays with Bounded Maximum
 *
 * https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/description/
 *
 * algorithms
 * Medium (47.08%)
 * Total Accepted:    21.3K
 * Total Submissions: 45.3K
 * Testcase Example:  '[2,1,4,3]\n2\n3'
 *
 * We are given an array A of positive integers, and two positive integers L
 * and R (L <= R).
 * 
 * Return the number of (contiguous, non-empty) subarrays such that the value
 * of the maximum array element in that subarray is at least L and at most R.
 * 
 * 
 * Example :
 * Input: 
 * A = [2, 1, 4, 3]
 * L = 2
 * R = 3
 * Output: 3
 * Explanation: There are three subarrays that meet the requirements: [2], [2,
 * 1], [3].
 * 
 * 
 * Note:
 * 
 * 
 * L, R  and A[i] will be an integer in the range [0, 10^9].
 * The length of A will be in the range of [1, 50000].
 * 
 * 
 */
class Solution {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int l = 0, r = 0;
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > R) {
                l = r = i+1;
            } else if (A[i] < L) {
                ans += r-l;
            } else {
                r = i+1;
                ans += r-l;
            }
        }
        return ans;
    }
}
