/*
 * @lc app=leetcode id=131 lang=java
 *
 * [131] Palindrome Partitioning
 *
 * https://leetcode.com/problems/palindrome-partitioning/description/
 *
 * algorithms
 * Medium (50.68%)
 * Total Accepted:    276.2K
 * Total Submissions: 544.7K
 * Testcase Example:  '"aab"'
 *
 * Given a string s, partition s such that every substring of the partition is
 * a palindrome. Return all possible palindrome partitioning of s.
 * 
 * A palindrome string is a string that reads the same backward as forward.
 * 
 * 
 * Example 1:
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 * Example 2:
 * Input: s = "a"
 * Output: [["a"]]
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 16
 * s contains only lowercase English letters.
 * 
 * 
 */
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> ls = new ArrayList<>();
        backtracking(s, 0, ls, ans);
        return ans;
    }
    
    void backtracking(String s, int st, List<String> ls, List<List<String>> ans) {
        if (st == s.length()) {
            ans.add(new ArrayList<>(ls));
            return;
        }
        for (int i = st+1; i <= s.length(); i++) {
            if (check(s, st, i-1)) {
                ls.add(s.substring(st, i));
                backtracking(s, i, ls, ans);
                ls.remove(ls.size()-1);
            }
        }
    }
    
    boolean check(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}
