/*
 * @lc app=leetcode id=932 lang=java
 *
 * [932] Beautiful Array
 *
 * https://leetcode.com/problems/beautiful-array/description/
 *
 * algorithms
 * Medium (61.01%)
 * Total Accepted:    14.4K
 * Total Submissions: 23.5K
 * Testcase Example:  '4'
 *
 * For some fixed N, an array A is beautiful if it is a permutation of the
 * integers 1, 2, ..., N, such that:
 * 
 * For every i < j, there is no k with i < k < j such that A[k] * 2 = A[i] +
 * A[j].
 * 
 * Given N, return any beautiful array A.  (It is guaranteed that one
 * exists.)
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: 4
 * Output: [2,1,4,3]
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 5
 * Output: [3,1,2,5,4]
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= N <= 1000
 * 
 * 
 * 
 * 
 * 
 */
class Solution {
    Map<Integer, int[]> cache = new HashMap<>();
    public int[] beautifulArray(int N) {
        if (N == 1)
            return new int[] {1};
        if (cache.containsKey(N))
            return cache.get(N);
        int[] ans = new int[N];
        cache.put(N, ans);
        int t = 0;
        for (int x : beautifulArray((N+1)/2))
            ans[t++] = 2*x-1;
        for (int x : beautifulArray(N/2))
            ans[t++] = 2*x;
        return ans;
    }
}
