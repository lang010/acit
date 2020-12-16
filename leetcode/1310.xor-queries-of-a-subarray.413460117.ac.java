/*
 * @lc app=leetcode id=1310 lang=java
 *
 * [1310] XOR Queries of a Subarray
 *
 * https://leetcode.com/problems/xor-queries-of-a-subarray/description/
 *
 * algorithms
 * Medium (69.00%)
 * Total Accepted:    19.4K
 * Total Submissions: 28.2K
 * Testcase Example:  '[1,3,4,8]\n[[0,1],[1,2],[0,3],[3,3]]'
 *
 * Given the array arr of positive integers and the array queries where
 * queries[i] = [Li, Ri], for each query i compute the XOR of elements from Li
 * to Ri (that is, arr[Li] xor arr[Li+1] xor ... xor arr[Ri] ). Return an array
 * containing the result for the given queries.
 * 
 * Example 1:
 * 
 * 
 * Input: arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
 * Output: [2,7,14,8] 
 * Explanation: 
 * The binary representation of the elements in the array are:
 * 1 = 0001 
 * 3 = 0011 
 * 4 = 0100 
 * 8 = 1000 
 * The XOR values for queries are:
 * [0,1] = 1 xor 3 = 2 
 * [1,2] = 3 xor 4 = 7 
 * [0,3] = 1 xor 3 xor 4 xor 8 = 14 
 * [3,3] = 8
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: arr = [4,8,2,10], queries = [[2,3],[1,3],[0,0],[0,3]]
 * Output: [8,0,4,4]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= arr.length <= 3 * 10^4
 * 1 <= arr[i] <= 10^9
 * 1 <= queries.length <= 3 * 10^4
 * queries[i].length == 2
 * 0 <= queries[i][0] <= queries[i][1] < arr.length
 * 
 */
class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] xor = new int[n+1];
        for (int i = 0; i < n; i++)
            xor[i+1] = xor[i] ^ arr[i];
        int[] ans = new int[queries.length];
        int t = 0;
        for (int[] q : queries)
            ans[t++] = xor[q[0]] ^ xor[q[1]+1];
        return ans;
    }
}
