/*
 * @lc app=leetcode id=370 lang=java
 *
 * [370] Range Addition
 *
 * https://leetcode.com/problems/range-addition/description/
 *
 * algorithms
 * Medium (63.31%)
 * Total Accepted:    32.3K
 * Total Submissions: 51K
 * Testcase Example:  '5\n[[1,3,2],[2,4,3],[0,2,-2]]'
 *
 * Assume you have an array of length n initialized with all 0's and are given
 * k update operations.
 * 
 * Each operation is represented as a triplet: [startIndex, endIndex, inc]
 * which increments each element of subarray A[startIndex ... endIndex]
 * (startIndex and endIndex inclusive) with inc.
 * 
 * Return the modified array after all k operations were executed.
 * 
 * Example:
 * 
 * 
 * Input: length = 5, updates = [[1,3,2],[2,4,3],[0,2,-2]]
 * Output: [-2,0,3,5,3]
 * 
 * 
 * Explanation:
 * 
 * 
 * Initial state:
 * [0,0,0,0,0]
 * 
 * After applying operation [1,3,2]:
 * [0,2,2,2,0]
 * 
 * After applying operation [2,4,3]:
 * [0,2,5,5,3]
 * 
 * After applying operation [0,2,-2]:
 * [-2,0,3,5,3]
 * 
 */
class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] ans = new int[length];
        for (int[] u : updates) {
            ans[u[0]] += u[2];
            if (u[1]+1 < length)
                ans[u[1]+1] -= u[2];
        }
        for (int i = 1; i < length; i++)
            ans[i] += ans[i-1];
        return ans;
    }
}
