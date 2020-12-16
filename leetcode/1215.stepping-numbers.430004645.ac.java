/*
 * @lc app=leetcode id=1215 lang=java
 *
 * [1215] Stepping Numbers
 *
 * https://leetcode.com/problems/stepping-numbers/description/
 *
 * algorithms
 * Medium (42.79%)
 * Total Accepted:    5.6K
 * Total Submissions: 13K
 * Testcase Example:  '0\n21'
 *
 * A Stepping Number is an integer such that all of its adjacent digits have an
 * absolute difference of exactly 1. For example, 321 is a Stepping Number
 * while 421 is not.
 * 
 * Given two integers low and high, find and return a sorted list of all the
 * Stepping Numbers in the range [low, high] inclusive.
 * 
 * 
 * Example 1:
 * Input: low = 0, high = 21
 * Output: [0,1,2,3,4,5,6,7,8,9,10,12,21]
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= low <= high <= 2 * 10^9
 * 
 * 
 */
class Solution {
    public List<Integer> countSteppingNumbers(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        if (low == 0)
            ans.add(0);
        for (int i = 1; i <= 9; i++)
            dfs(ans, i, low, high);
        Collections.sort(ans);
        return ans;
    }
    
    void dfs(List<Integer> ans, long cur, int low, int high) {
        if (cur > high)
            return;
        if (cur >= low)
            ans.add((int) cur);
        long l = cur % 10;
        if (l > 0)
            dfs(ans, cur*10 + l-1, low, high);
        if (l < 9)
            dfs(ans, cur*10 + l+1, low, high);
    }
}
