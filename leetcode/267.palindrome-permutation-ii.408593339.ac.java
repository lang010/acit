/*
 * @lc app=leetcode id=267 lang=java
 *
 * [267] Palindrome Permutation II
 *
 * https://leetcode.com/problems/palindrome-permutation-ii/description/
 *
 * algorithms
 * Medium (37.06%)
 * Total Accepted:    41.4K
 * Total Submissions: 111.6K
 * Testcase Example:  '"aabb"'
 *
 * Given a string s, return all the palindromic permutations (without
 * duplicates) of it. Return an empty list if no palindromic permutation could
 * be form.
 * 
 * Example 1:
 * 
 * 
 * Input: "aabb"
 * Output: ["abba", "baab"]
 * 
 * Example 2:
 * 
 * 
 * Input: "abc"
 * Output: []
 * 
 */
class Solution {
    List<String> ans = new ArrayList<>();
    char ch = 0;
    int[] cnt = new int[258];
    public List<String> generatePalindromes(String s) {
        for (char c : s.toCharArray())
            cnt[c]++;
        for (char c = 1; c <= 257; c++)
            if (cnt[c]%2 == 1) {
                if (ch != 0)
                    return ans;
                ch = c;
            }
        dfs(new StringBuilder(), s.length()/2);
        return ans;
    }
    
    void dfs(StringBuilder sb, int len) {
        if (len == 0) {
            if (ch != 0)
                ans.add(sb.toString() + ch + sb.reverse().toString());
            else
                ans.add(sb.toString() + sb.reverse().toString());
            sb.reverse();
            return;
        }
        for (char c = 1; c <= 257; c++)
            if (cnt[c] > 1) {
                cnt[c] -= 2;
                sb.append(c);
                dfs(sb, len-1);
                cnt[c] += 2;
                sb.deleteCharAt(sb.length()-1);
            }
    }
}
