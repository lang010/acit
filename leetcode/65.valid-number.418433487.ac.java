/*
 * @lc app=leetcode id=65 lang=java
 *
 * [65] Valid Number
 *
 * https://leetcode.com/problems/valid-number/description/
 *
 * algorithms
 * Hard (15.64%)
 * Total Accepted:    186.8K
 * Total Submissions: 1.2M
 * Testcase Example:  '"0"'
 *
 * Validate if a given string can be interpreted as a decimal number.
 * 
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * " -90e3   " => true
 * " 1e" => false
 * "e3" => false
 * " 6e-1" => true
 * " 99e2.5 " => false
 * "53.5e93" => true
 * " --6 " => false
 * "-+3" => false
 * "95a54e53" => false
 * 
 * Note: It is intended for the problem statement to be ambiguous. It would be
 * best if you gathered all requirements up front before implementing one.
 * However, here is a list of characters that can be in a valid decimal
 * number:
 * 
 * 
 * Numbers 0-9
 * Exponent - "e"
 * Positive/negative sign - "+"/"-"
 * Decimal point - "."
 * 
 * 
 * Of course, the context of these characters also matters in the input.
 * 
 * 
 * Example 1:
 * Input: s = "0"
 * Output: true
 * Example 2:
 * Input: s = "3"
 * Output: true
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 20
 * s consists of only English letters, digits, space ' ', plus '+', minus '-',
 * or dot '.'.
 * 
 * 
 */
class Solution {
    public boolean isNumber(String s) {
        char c = s.charAt(s.length()-1);
        if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z')
            return false;
        try {
            Float.valueOf(s);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
