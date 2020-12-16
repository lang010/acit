/*
 * @lc app=leetcode id=394 lang=java
 *
 * [394] Decode String
 *
 * https://leetcode.com/problems/decode-string/description/
 *
 * algorithms
 * Medium (52.00%)
 * Total Accepted:    278.9K
 * Total Submissions: 536.3K
 * Testcase Example:  '"3[a]2[bc]"'
 *
 * Given an encoded string, return its decoded string.
 * 
 * The encoding rule is: k[encoded_string], where the encoded_string inside the
 * square brackets is being repeated exactly k times. Note that k is guaranteed
 * to be a positive integer.
 * 
 * You may assume that the input string is always valid; No extra white spaces,
 * square brackets are well-formed, etc.
 * 
 * Furthermore, you may assume that the original data does not contain any
 * digits and that digits are only for those repeat numbers, k. For example,
 * there won't be input like 3a or 2[4].
 * 
 * 
 * Example 1:
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 * Example 2:
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 * Example 3:
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 * Example 4:
 * Input: s = "abc3[cd]xyz"
 * Output: "abccdcdcdxyz"
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 30
 * s consists of lowercase English letters, digits, and square brackets
 * '[]'.
 * s is guaranteed to be a valid input.
 * All the integers in s are in the range [1, 300].
 * 
 * 
 */
class Solution {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int l = 0;
        while (l < s.length()) {
            char c = s.charAt(l);
            if (c >= 'a' && c <= 'z') {
                sb.append(c);
                l++;
            } else {
                StringBuilder str = new StringBuilder();
                l = encode(s, l, str);
                sb.append(str.toString());
            }
        }
        return sb.toString();
    }
    
    int encode(String s, int l, StringBuilder ret) {
        int cnt = 0;
        while (true) {
            char c = s.charAt(l++);
            if (c == '[')
                break;
            cnt = cnt * 10 + c - '0';
        }
        while (true) {
            char c = s.charAt(l++);
            if (c == ']')
                break;
            if (c >= '0' && c <= '9') {
                StringBuilder sb = new StringBuilder();
                l = encode(s, l-1, sb);
                ret.append(sb.toString());
            } else {
                ret.append(c);
            }
        }
        String t = ret.toString();
        for (int i = 1; i < cnt; i++)
            ret.append(t);
        
        return l;
    }
}
