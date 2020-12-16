/*
 * @lc app=leetcode id=471 lang=java
 *
 * [471] Encode String with Shortest Length
 *
 * https://leetcode.com/problems/encode-string-with-shortest-length/description/
 *
 * algorithms
 * Hard (48.71%)
 * Total Accepted:    19.4K
 * Total Submissions: 39.9K
 * Testcase Example:  '"aaa"'
 *
 * Given a non-empty string, encode the string such that its encoded length is
 * the shortest.
 * 
 * The encoding rule is: k[encoded_string], where the encoded_string inside the
 * square brackets is being repeated exactly k times.
 * 
 * Note:
 * 
 * 
 * k will be a positive integer.
 * If an encoding process does not make the string shorter, then do not encode
 * it. If there are several solutions, return any of them.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "aaa"
 * Output: "aaa"
 * Explanation: There is no way to encode it such that it is shorter than the
 * input string, so we do not encode it.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "aaaaa"
 * Output: "5[a]"
 * Explanation: "5[a]" is shorter than "aaaaa" by 1 character.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "aaaaaaaaaa"
 * Output: "10[a]"
 * Explanation: "a9[a]" or "9[a]a" are also valid solutions, both of them have
 * the same length = 5, which is the same as "10[a]".
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: s = "aabcaabcd"
 * Output: "2[aabc]d"
 * Explanation: "aabc" occurs twice, so one answer can be "2[aabc]d".
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: s = "abbbabbbcabbbabbbc"
 * Output: "2[2[abbb]c]"
 * Explanation: "abbbabbbc" occurs twice, but "abbbabbbc" can also be encoded
 * to "2[abbb]c", so one answer can be "2[2[abbb]c]".
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 150
 * s consists of only lowercase English letters.
 * 
 * 
 */
class Solution {
    String[][] dp;
    int n;
    public String encode(String s) {
        n = s.length();
        dp = new String[n][n];
        return helper(s, 0, n-1);
    }
    
    String helper(String s, int l, int r) {
        if (dp[l][r] != null)
            return dp[l][r];
        if (l == r)
            return s.substring(l, l+1);
        int i = 1;
        boolean is = false;
        for (; l+i <= r; i++) {
            if ((r-l+1) % i == 0) {
                is = true;
                for (int j = i+l; j <= r; j++)
                    if (s.charAt(j) != s.charAt(j-i)) {
                        is = false;
                        break;
                    }
                if (is)
                    break;
            }
        }
        String ans = "";
        int d = (r-l+1)/i;
        if (is && d > 1) {
            ans = helper(s, l, l+i-1);
            ans = d + "[" + ans + "]";
            if (ans.length() >= r-l+1)
                ans = s.substring(l, r+1);
        } else
            ans = s.substring(l, r+1);
        for (i = l; i < r; i++) {
            String s1 = helper(s, l, i);
            String s2 = helper(s, i+1, r);
            if (s1.length() + s2.length() < ans.length())
                ans = s1+s2;
        }
        return dp[l][r] = ans;
    }
}
