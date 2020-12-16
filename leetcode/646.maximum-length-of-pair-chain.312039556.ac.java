/*
 * @lc app=leetcode id=646 lang=java
 *
 * [646] Maximum Length of Pair Chain
 *
 * https://leetcode.com/problems/maximum-length-of-pair-chain/description/
 *
 * algorithms
 * Medium (52.53%)
 * Total Accepted:    67.2K
 * Total Submissions: 127.9K
 * Testcase Example:  '[[1,2], [2,3], [3,4]]'
 *
 * 
 * You are given n pairs of numbers. In every pair, the first number is always
 * smaller than the second number.
 * 
 * 
 * 
 * Now, we define a pair (c, d) can follow another pair (a, b) if and only if b
 * < c. Chain of pairs can be formed in this fashion. 
 * 
 * 
 * 
 * Given a set of pairs, find the length longest chain which can be formed. You
 * needn't use up all the given pairs. You can select pairs in any order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: [[1,2], [2,3], [3,4]]
 * Output: 2
 * Explanation: The longest chain is [1,2] -> [3,4]
 * 
 * 
 * 
 * Note:
 * 
 * The number of given pairs will be in the range [1, 1000].
 * 
 * 
 */
class Solution {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        Arrays.sort(pairs, (a, b) -> (a[1] - b[1]));
        int curr = Integer.MIN_VALUE;
        int ans = 0;
        for (int i = 0; i < n; i++)
            if (curr < pairs[i][0]) {
                curr = pairs[i][1];
                ans++;
            }
        
        return ans;
    }
}
