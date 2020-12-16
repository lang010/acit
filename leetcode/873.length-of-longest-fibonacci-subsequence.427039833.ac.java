/*
 * @lc app=leetcode id=873 lang=java
 *
 * [873] Length of Longest Fibonacci Subsequence
 *
 * https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/description/
 *
 * algorithms
 * Medium (47.98%)
 * Total Accepted:    34.6K
 * Total Submissions: 72.2K
 * Testcase Example:  '[1,2,3,4,5,6,7,8]'
 *
 * A sequence X_1, X_2, ..., X_n is fibonacci-like if:
 * 
 * 
 * n >= 3
 * X_i + X_{i+1} = X_{i+2} for all i + 2 <= n
 * 
 * 
 * Given a strictly increasing array A of positive integers forming a sequence,
 * find the length of the longest fibonacci-like subsequence of A.  If one does
 * not exist, return 0.
 * 
 * (Recall that a subsequence is derived from another sequence A by deleting
 * any number of elements (including none) from A, without changing the order
 * of the remaining elements.  For example, [3, 5, 8] is a subsequence of [3,
 * 4, 5, 6, 7, 8].)
 * 
 * 
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [1,2,3,4,5,6,7,8]
 * Output: 5
 * Explanation:
 * The longest subsequence that is fibonacci-like: [1,2,3,5,8].
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [1,3,7,11,12,14,18]
 * Output: 3
 * Explanation:
 * The longest subsequence that is fibonacci-like:
 * [1,11,12], [3,11,14] or [7,11,18].
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 3 <= A.length <= 1000
 * 1 <= A[0] < A[1] < ... < A[A.length - 1] <= 10^9
 * (The time limit has been reduced by 50% for submissions in Java, C, and
 * C++.)
 * 
 * 
 */
class Solution {
    public int lenLongestFibSubseq(int[] A) {
        int n = A.length;
        int[][] dp = new int[n][n];
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++)
            map.put(A[i], i);
        for (int i = 2; i < n; i++)
            for (int j = i-1; j >= 0 && A[i] < 2*A[j]; j--)
                if (map.containsKey(A[i] - A[j])) {
                    dp[j][i] = Math.max(dp[j][i], dp[map.get(A[i]-A[j])][j]+1);
                    max = Math.max(max, dp[j][i]);
                }
        return max == 0 ? 0 : max+2;
    }
}
