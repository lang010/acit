/*
 * @lc app=leetcode id=1047 lang=java
 *
 * [1047] Remove All Adjacent Duplicates In String
 *
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/description/
 *
 * algorithms
 * Easy (70.01%)
 * Total Accepted:    110.2K
 * Total Submissions: 157.4K
 * Testcase Example:  '"abbaca"'
 *
 * Given a string S of lowercase letters, a duplicate removal consists of
 * choosing two adjacent and equal letters, and removing them.
 * 
 * We repeatedly make duplicate removals on S until we no longer can.
 * 
 * Return the final string after all such duplicate removals have been made.
 * It is guaranteed the answer is unique.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: "abbaca"
 * Output: "ca"
 * Explanation: 
 * For example, in "abbaca" we could remove "bb" since the letters are adjacent
 * and equal, and this is the only possible move.  The result of this move is
 * that the string is "aaca", of which only "aa" is possible, so the final
 * string is "ca".
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= S.length <= 20000
 * S consists only of English lowercase letters.
 * 
 * 
 */
class Solution {
    public String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            int i = sb.length() - 1;
            if (i >= 0 && sb.charAt(i) == c) {
                sb.deleteCharAt(i);
            } else
                sb.append(c);
        }
        return sb.toString();
    }
}
