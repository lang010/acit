/*
 * @lc app=leetcode id=14 lang=java
 *
 * [14] Longest Common Prefix
 *
 * https://leetcode.com/problems/longest-common-prefix/description/
 *
 * algorithms
 * Easy (35.89%)
 * Total Accepted:    889.5K
 * Total Submissions: 2.5M
 * Testcase Example:  '["flower","flow","flight"]'
 *
 * Write a function to find the longest common prefix string amongst an array
 * of strings.
 * 
 * If there is no common prefix, return an empty string "".
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lower-case English letters.
 * 
 * 
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        if (strs == null || strs.length == 0) {
            return sb.toString();
        }
        int id = 0;
        while (true) {
            if (id >= strs[0].length())
                break;
            char c = strs[0].charAt(id);
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].length() <= id || strs[i].charAt(id) != c) {
                    return sb.toString();
                }
            }
            sb.append(c);
            id++;
        }
        return sb.toString();
    }
}
