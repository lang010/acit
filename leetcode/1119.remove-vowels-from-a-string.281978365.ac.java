/*
 * @lc app=leetcode id=1119 lang=java
 *
 * [1119] Remove Vowels from a String
 *
 * https://leetcode.com/problems/remove-vowels-from-a-string/description/
 *
 * algorithms
 * Easy (90.22%)
 * Total Accepted:    52K
 * Total Submissions: 57.6K
 * Testcase Example:  '"leetcodeisacommunityforcoders"'
 *
 * Given a string s, remove the vowels 'a', 'e', 'i', 'o', and 'u' from it, and
 * return the new string.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "leetcodeisacommunityforcoders"
 * Output: "ltcdscmmntyfrcdrs"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "aeiou"
 * Output: ""
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 1000
 * s consists of only lowercase English letters.
 * 
 * 
 */
class Solution {
    public String removeVowels(String S) {
        StringBuilder sb = new StringBuilder();
        for (char x : S.toCharArray()) {
            if (x != 'a' && x != 'e' && x != 'i' && x != 'o' && x != 'u') {
                sb.append(x);
            }
        }
        return sb.toString();
    }
}
