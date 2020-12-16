/*
 * @lc app=leetcode id=301 lang=java
 *
 * [301] Remove Invalid Parentheses
 *
 * https://leetcode.com/problems/remove-invalid-parentheses/description/
 *
 * algorithms
 * Hard (44.20%)
 * Total Accepted:    239.3K
 * Total Submissions: 541.4K
 * Testcase Example:  '"()())()"'
 *
 * Remove the minimum number of invalid parentheses in order to make the input
 * string valid. Return all possible results.
 * 
 * Note: The input string may contain letters other than the parentheses ( and
 * ).
 * 
 * Example 1:
 * 
 * 
 * Input: "()())()"
 * Output: ["()()()", "(())()"]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "(a)())()"
 * Output: ["(a)()()", "(a())()"]
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: ")("
 * Output: [""]
 * 
 */
class Solution {
    char[] chs;
    int n;
    public List<String> removeInvalidParentheses(String s) {
        Set<String> set = new HashSet<>();
        int l = 0;
        chs = s.toCharArray();
        n = chs.length;
        int cnt = 0;
        for (char c : chs)
            if (c == '(')
                l++;
            else if (c == ')' && l > 0) {
                cnt++;
                l--;
            }
        StringBuilder sb = new StringBuilder();
        helper(set, sb, cnt, 0, 0, 0);
        
        List<String> ans = new ArrayList<>();
        ans.addAll(set);
        return ans;
    }
    
    void helper(Set<String> set, StringBuilder sb, int cnt, int cur, int l, int r) {
        if (cur == chs.length) {
            if (l == cnt && r == cnt)
                set.add(sb.toString());
            return;
        }
        if (chs[cur] == '(') {
            if (cnt > l) {
                sb.append(chs[cur]);
                helper(set, sb, cnt, cur+1, l+1, r);
                sb.deleteCharAt(sb.length()-1);
            }
            helper(set, sb, cnt, cur+1, l, r);
        } else if (chs[cur] == ')') {
            if (l > r && cnt > r) {
                sb.append(chs[cur]);
                helper(set, sb, cnt, cur+1, l, r+1);
                sb.deleteCharAt(sb.length()-1);
            }
            helper(set, sb, cnt, cur+1, l, r);
        } else {
            sb.append(chs[cur]);
            helper(set, sb, cnt, cur+1, l, r);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
