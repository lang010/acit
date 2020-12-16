/*
 * @lc app=leetcode id=439 lang=java
 *
 * [439] Ternary Expression Parser
 *
 * https://leetcode.com/problems/ternary-expression-parser/description/
 *
 * algorithms
 * Medium (56.47%)
 * Total Accepted:    20.7K
 * Total Submissions: 36.6K
 * Testcase Example:  '"T?2:3"'
 *
 * Given a string representing arbitrarily nested ternary expressions,
 * calculate the result of the expression. You can always assume that the given
 * expression is valid and only consists of digits 0-9, ?, :, T and F (T and F
 * represent True and False respectively).
 * 
 * Note:
 * 
 * The length of the given string is ≤ 10000.
 * Each number will contain only one digit.
 * The conditional expressions group right-to-left (as usual in most
 * languages).
 * The condition will always be either T or F. That is, the condition will
 * never be a digit.
 * The result of the expression will always evaluate to either a digit 0-9, T
 * or F.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: "T?2:3"
 * 
 * Output: "2"
 * 
 * Explanation: If true, then result is 2; otherwise result is 3.
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: "F?1:T?4:5"
 * 
 * Output: "4"
 * 
 * Explanation: The conditional expressions group right-to-left. Using
 * parenthesis, it is read/evaluated as:
 * 
 * ⁠            "(F ? 1 : (T ? 4 : 5))"                   "(F ? 1 : (T ? 4 :
 * 5))"
 * ⁠         -> "(F ? 1 : 4)"                 or       -> "(T ? 4 : 5)"
 * ⁠         -> "4"                                    -> "4"
 * 
 * 
 * 
 * 
 * Example 3:
 * 
 * Input: "T?T?F:5:3"
 * 
 * Output: "F"
 * 
 * Explanation: The conditional expressions group right-to-left. Using
 * parenthesis, it is read/evaluated as:
 * 
 * ⁠            "(T ? (T ? F : 5) : 3)"                   "(T ? (T ? F : 5) :
 * 3)"
 * ⁠         -> "(T ? F : 3)"                 or       -> "(T ? F : 5)"
 * ⁠         -> "F"                                    -> "F"
 * 
 * 
 */
class Solution {
    public String parseTernary(String exp) {
        while (true) {
            int last = exp.lastIndexOf("?");
            if (last < 0)
                return exp;
            char ch = exp.charAt(last-1);
            int first = exp.indexOf(":", last);
            int second = exp.indexOf(":", first+1);
            second = second < 0 ? exp.length() : second;
            String v;
            if (ch == 'T')
                v = exp.substring(last+1, first);
            else
                v = exp.substring(first+1, second);
            exp = exp.substring(0, last-1) + v + exp.substring(second);
        }
    }
}
