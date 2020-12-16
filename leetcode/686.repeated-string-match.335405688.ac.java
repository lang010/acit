/*
 * @lc app=leetcode id=686 lang=java
 *
 * [686] Repeated String Match
 *
 * https://leetcode.com/problems/repeated-string-match/description/
 *
 * algorithms
 * Medium (32.68%)
 * Total Accepted:    100.6K
 * Total Submissions: 307.8K
 * Testcase Example:  '"abcd"\n"cdabcdab"'
 *
 * Given two strings a and b, return the minimum number of times you should
 * repeat string a so that string b is a substring of it. If it is impossible
 * for b​​​​​​ to be a substring of a after repeating it, return -1.
 * 
 * Notice: string "abc" repeated 0 times is "",  repeated 1 time is "abc" and
 * repeated 2 times is "abcabc".
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: a = "abcd", b = "cdabcdab"
 * Output: 3
 * Explanation: We return 3 because by repeating a three times "abcdabcdabcd",
 * b is a substring of it.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: a = "a", b = "aa"
 * Output: 2
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: a = "a", b = "a"
 * Output: 1
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: a = "abc", b = "wxyz"
 * Output: -1
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= a.length <= 10^4
 * 1 <= b.length <= 10^4
 * a and b consist of lower-case English letters.
 * 
 * 
 */
class Solution {
    public int repeatedStringMatch(String A, String B) {
        int n = B.length();
        String s;
        StringBuilder sb = new StringBuilder();
        int ans = 0;
        while (sb.length() < n) {
            sb.append(A);
            ans++;
        }
        s = sb.toString();
        if (s.indexOf(B) >= 0)
            return ans;
        
        sb.append(A);
        s = sb.toString();
        if (s.indexOf(B) >= 0)
            return ++ans;
        return -1;
    }
}
