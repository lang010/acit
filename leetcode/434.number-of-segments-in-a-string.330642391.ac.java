/*
 * @lc app=leetcode id=434 lang=java
 *
 * [434] Number of Segments in a String
 *
 * https://leetcode.com/problems/number-of-segments-in-a-string/description/
 *
 * algorithms
 * Easy (37.76%)
 * Total Accepted:    85K
 * Total Submissions: 225K
 * Testcase Example:  '"Hello, my name is John"'
 *
 * You are given a string s, return the number of segments in the string. 
 * 
 * A segment is defined to be a contiguous sequence of non-space characters.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "Hello, my name is John"
 * Output: 5
 * Explanation: The five segments are ["Hello,", "my", "name", "is", "John"]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "Hello"
 * Output: 1
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "love live! mu'sic forever"
 * Output: 4
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: s = ""
 * Output: 0
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= s.length <= 300
 * s consists of lower-case and upper-case English letters, digits or one of
 * the following characters "!@#$%^&*()_+-=',.:".
 * The only space character in s is ' '.
 * 
 * 
 */
class Solution {
    public int countSegments(String s) {
        int n = s.length();
        int ans = 0;
        if (n < 1)
            return 0;
        if (s.charAt(0) != ' ')
            ans++;
        for (int i = 1; i < n; i++)
            if (s.charAt(i) != ' ' && s.charAt(i-1) == ' ')
                ans++;
        return ans;
    }
}
