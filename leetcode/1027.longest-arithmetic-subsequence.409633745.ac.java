/*
 * @lc app=leetcode id=1027 lang=java
 *
 * [1027] Longest Arithmetic Subsequence
 *
 * https://leetcode.com/problems/longest-arithmetic-subsequence/description/
 *
 * algorithms
 * Medium (50.11%)
 * Total Accepted:    50.9K
 * Total Submissions: 101.5K
 * Testcase Example:  '[3,6,9,12]'
 *
 * Given an array A of integers, return the length of the longest arithmetic
 * subsequence in A.
 * 
 * Recall that a subsequence of A is a list A[i_1], A[i_2], ..., A[i_k] with 0
 * <= i_1 < i_2 < ... < i_k <= A.length - 1, and that a sequence B is
 * arithmetic if B[i+1] - B[i] are all the same value (for 0 <= i < B.length -
 * 1).
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: A = [3,6,9,12]
 * Output: 4
 * Explanation: 
 * The whole array is an arithmetic sequence with steps of length = 3.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: A = [9,4,7,2,10]
 * Output: 3
 * Explanation: 
 * The longest arithmetic subsequence is [4,7,10].
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: A = [20,1,15,3,10,5,8]
 * Output: 4
 * Explanation: 
 * The longest arithmetic subsequence is [20,15,10,5].
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 2 <= A.length <= 1000
 * 0 <= A[i] <= 500
 * 
 * 
 */
class Solution {
    public int longestArithSeqLength(int[] A) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        int ans = 1;
        for (int i = 0; i < A.length; i++) {
            map.put(i, new HashMap<>());
            for (int j = 0; j < i; j++) {
                int v = A[i]-A[j];
                int cnt = map.get(j).getOrDefault(v, 1) + 1;
                map.get(i).put(v, cnt);
                ans = Math.max(ans, cnt);
            }
        }
        return ans;
    }
}
