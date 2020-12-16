/*
 * @lc app=leetcode id=1593 lang=java
 *
 * [1593] Split a String Into the Max Number of Unique Substrings
 *
 * https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings/description/
 *
 * algorithms
 * Medium (47.46%)
 * Total Accepted:    10K
 * Total Submissions: 21K
 * Testcase Example:  '"ababccc"'
 *
 * Given a string s, return the maximum number of unique substrings that the
 * given string can be split into.
 * 
 * You can split string s into any list of non-empty substrings, where the
 * concatenation of the substrings forms the original string. However, you must
 * split the substrings such that all of them are unique.
 * 
 * A substring is a contiguous sequence of characters within a string.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "ababccc"
 * Output: 5
 * Explanation: One way to split maximally is ['a', 'b', 'ab', 'c', 'cc'].
 * Splitting like ['a', 'b', 'a', 'b', 'c', 'cc'] is not valid as you have 'a'
 * and 'b' multiple times.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "aba"
 * Output: 2
 * Explanation: One way to split maximally is ['a', 'ba'].
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "aa"
 * Output: 1
 * Explanation: It is impossible to split the string any further.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 
 * 1 <= s.length <= 16
 * 
 * 
 * s contains only lower case English letters.
 * 
 * 
 * 
 */
class Solution {
    
    Set<String> set = new HashSet<>();
    int max = 0;
    public int maxUniqueSplit(String s) {
        dfs(s, 0);
        return max;
    }
    
    void dfs(String s, int b) {
        if (b == s.length()) {
            max = Math.max(max, set.size());
            return;
        }
        
        String pre = "";
        for (int i = b; i < s.length(); i++) {
            pre += s.charAt(i);
            if (set.contains(pre))
                continue;
            set.add(pre);
            dfs(s, i+1);
            set.remove(pre);
        }
    }
}
