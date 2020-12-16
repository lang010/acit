/*
 * @lc app=leetcode id=386 lang=java
 *
 * [386] Lexicographical Numbers
 *
 * https://leetcode.com/problems/lexicographical-numbers/description/
 *
 * algorithms
 * Medium (53.26%)
 * Total Accepted:    59.9K
 * Total Submissions: 112.5K
 * Testcase Example:  '13'
 *
 * Given an integer n, return 1 - n in lexicographical order.
 * 
 * For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].
 * 
 * Please optimize your algorithm to use less time and space. The input size
 * may be as large as 5,000,000.
 * 
 */
class Solution {
    List<Integer> ans = new ArrayList<>();
    public List<Integer> lexicalOrder(int n) {
        for (int i = 1; i < 10; i++)
            dfs(i, n);
        return ans;
    }
    
    void dfs(int cur, int n) {
        if (cur <= n) {
            ans.add(cur);
            for (int i = 0; i < 10; i++)
                dfs(cur*10+i, n);
        }
    } 
}
