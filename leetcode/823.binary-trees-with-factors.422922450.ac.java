/*
 * @lc app=leetcode id=823 lang=java
 *
 * [823] Binary Trees With Factors
 *
 * https://leetcode.com/problems/binary-trees-with-factors/description/
 *
 * algorithms
 * Medium (36.17%)
 * Total Accepted:    12.6K
 * Total Submissions: 34.9K
 * Testcase Example:  '[2,4]'
 *
 * Given an array of unique integers, arr, where each integer arr[i] is
 * strictly greater than 1.
 * 
 * We make a binary tree using these integers, and each number may be used for
 * any number of times. Each non-leaf node's value should be equal to the
 * product of the values of its children.
 * 
 * Return the number of binary trees we can make. The answer may be too large
 * so return the answer modulo 10^9 + 7.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: arr = [2,4]
 * Output: 3
 * Explanation: We can make these trees: [2], [4], [4, 2, 2]
 * 
 * Example 2:
 * 
 * 
 * Input: arr = [2,4,5,10]
 * Output: 7
 * Explanation: We can make these trees: [2], [4], [5], [10], [4, 2, 2], [10,
 * 2, 5], [10, 5, 2].
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= arr.length <= 1000
 * 2 <= arr[i] <= 10^9
 * 
 * 
 */
class Solution {
    long mod = 1000000007l;
    public int numFactoredBinaryTrees(int[] A) {
        Arrays.sort(A);
        Map<Integer, Long> map = new HashMap<>();
        for (int x : A)
            map.put(x, 1l);
        int n = A.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i]%A[j] == 0 && map.containsKey(A[i]/A[j]))
                    map.put(A[i], (map.get(A[i]) + map.get(A[j])*map.get(A[i]/A[j]))%mod);
            }
        }
        long ans = 0;
        for (long x : map.values())
            ans += x;
        return (int) (ans % mod);
    }
}
