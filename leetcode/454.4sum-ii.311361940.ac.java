/*
 * @lc app=leetcode id=454 lang=java
 *
 * [454] 4Sum II
 *
 * https://leetcode.com/problems/4sum-ii/description/
 *
 * algorithms
 * Medium (53.83%)
 * Total Accepted:    129.4K
 * Total Submissions: 240.3K
 * Testcase Example:  '[1,2]\n[-2,-1]\n[-1,2]\n[0,2]'
 *
 * Given four lists A, B, C, D of integer values, compute how many tuples (i,
 * j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.
 * 
 * To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤
 * N ≤ 500. All integers are in the range of -2^28 to 2^28 - 1 and the result
 * is guaranteed to be at most 2^31 - 1.
 * 
 * Example:
 * 
 * 
 * Input:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 * 
 * Output:
 * 2
 * 
 * Explanation:
 * The two tuples are:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 * 
 * 
 * 
 * 
 */
class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Long, Integer> map = new HashMap<>();
        int ans = 0;
        Arrays.sort(D);
        for (int i = 0; i < A.length; i++)
            for (int j = 0; j < B.length; j++) {
                long x= 0l + A[i] + B[j];
                map.put(x, map.getOrDefault(x, 0) + 1);
            }
        
        for (int i = 0; i < C.length; i++)
            for (int j = 0; j < D.length; j++) {
                long x = 0l + C[i] + D[j];
                ans += map.getOrDefault(-x, 0);
            }
        
        return ans;
    }
}
