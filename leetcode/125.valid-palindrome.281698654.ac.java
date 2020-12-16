/*
 * @lc app=leetcode id=125 lang=java
 *
 * [125] Valid Palindrome
 *
 * https://leetcode.com/problems/valid-palindrome/description/
 *
 * algorithms
 * Easy (37.68%)
 * Total Accepted:    744K
 * Total Submissions: 2M
 * Testcase Example:  '"A man, a plan, a canal: Panama"'
 *
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * Note: For the purpose of this problem, we define empty string as valid
 * palindrome.
 * 
 * Example 1:
 * 
 * 
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "race a car"
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * s consists only of printable ASCII characters.
 * 
 * 
 */
class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            char lc = 'a';
            char rc = 'a';
            while (l < r) {
                lc = s.charAt(l);
                if (lc >= 'a' && lc <= 'z' || lc >= '0' && lc <= '9') {
                    break;
                }
                if (lc >= 'A' && lc <= 'Z') {
                    lc = (char) (lc - 'A' + 'a');
                    break;
                }
                l++;
            }
            while (l < r) {
                rc = s.charAt(r);
                if (rc >= 'a' && rc <= 'z' || rc >= '0' && rc <= '9') {
                    break;
                }
                if (rc >= 'A' && rc <= 'Z') {
                    rc = (char) (rc - 'A' + 'a');
                    break;
                }
                r--;
            }
            if (l < r && lc != rc) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
