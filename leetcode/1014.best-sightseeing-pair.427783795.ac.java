/*
 * @lc app=leetcode id=1014 lang=java
 *
 * [1014] Best Sightseeing Pair
 *
 * https://leetcode.com/problems/best-sightseeing-pair/description/
 *
 * algorithms
 * Medium (52.78%)
 * Total Accepted:    20.1K
 * Total Submissions: 38K
 * Testcase Example:  '[8,1,5,2,6]'
 *
 * Given an array A of positive integers, A[i] represents the value of the i-th
 * sightseeing spot, and two sightseeing spots i and j have distance j - i
 * between them.
 * 
 * The score of a pair (i < j) of sightseeing spots is (A[i] + A[j] + i - j) :
 * the sum of the values of the sightseeing spots, minus the distance between
 * them.
 * 
 * Return the maximum score of a pair of sightseeing spots.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [8,1,5,2,6]
 * Output: 11
 * Explanation: i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 2 <= A.length <= 50000
 * 1 <= A[i] <= 1000
 * 
 */
class Solution {
    public int maxScoreSightseeingPair(int[] A) {
        int pre = A[0];
        int n = A.length;
        int ans = 0;
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, pre + A[i] - i);
            pre = Math.max(pre, A[i]+i);
        }
        return ans;
    }
}
