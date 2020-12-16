/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 *
 * https://leetcode.com/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (64.45%)
 * Total Accepted:    649K
 * Total Submissions: 1M
 * Testcase Example:  '3'
 *
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * 
 * Example 1:
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * Example 2:
 * Input: n = 1
 * Output: ["()"]
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 8
 * 
 * 
 */
class Solution {
    
    List<String> ans = new ArrayList<>();
    
    public List<String> generateParenthesis(int n) {
        generate(0, 0, n, "");
        return ans;
    }
    
    void generate(int l, int r, int n, String pre) {
        if (l == n && r == n) {
            ans.add(pre);
            return;
        }
        if (l < n) {
            generate(l+1, r, n, pre + "(");
        }
        if (r < n && l > r) {
            generate(l, r + 1, n, pre + ")");
        } 
    }
}
