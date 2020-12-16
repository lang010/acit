/*
 * @lc app=leetcode id=1271 lang=java
 *
 * [1271] Hexspeak
 *
 * https://leetcode.com/problems/hexspeak/description/
 *
 * algorithms
 * Easy (55.10%)
 * Total Accepted:    5.6K
 * Total Submissions: 10.2K
 * Testcase Example:  '"257"'
 *
 * A decimal number can be converted to its Hexspeak representation by first
 * converting it to an uppercase hexadecimal string, then replacing all
 * occurrences of the digit 0 with the letter O, and the digit 1 with the
 * letter I.  Such a representation is valid if and only if it consists only of
 * the letters in the set {"A", "B", "C", "D", "E", "F", "I", "O"}.
 * 
 * Given a string num representing a decimal integer N, return the Hexspeak
 * representation of N if it is valid, otherwise return "ERROR".
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: num = "257"
 * Output: "IOI"
 * Explanation:  257 is 101 in hexadecimal.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: num = "3"
 * Output: "ERROR"
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= N <= 10^12
 * There are no leading zeros in the given string.
 * All answers must be in uppercase letters.
 * 
 * 
 */
class Solution {
    public String toHexspeak(String num) {
        String s = Long.toString(Long.valueOf(num), 16);
        s = s.toUpperCase();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '0')
                sb.append('O');
            else if (c == '1')
                sb.append('I');
            else if (c >= 'A' && c <= 'F')
                sb.append(c);
            else
                return "ERROR";
        }
        return sb.toString();
    }
}
