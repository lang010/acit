/*
 * @lc app=leetcode id=828 lang=java
 *
 * [828] Count Unique Characters of All Substrings of a Given String
 *
 * https://leetcode.com/problems/count-unique-characters-of-all-substrings-of-a-given-string/description/
 *
 * algorithms
 * Hard (46.66%)
 * Total Accepted:    13.1K
 * Total Submissions: 28.1K
 * Testcase Example:  '"ABC"'
 *
 * Let's define a function countUniqueChars(s) that returns the number of
 * unique characters on s, for example if s = "LEETCODE" then "L",
 * "T","C","O","D" are the unique characters since they appear only once in s,
 * therefore countUniqueChars(s) = 5.
 * 
 * On this problem given a string s we need to return the sum of
 * countUniqueChars(t) where t is a substring of s. Notice that some substrings
 * can be repeated so on this case you have to count the repeated ones too.
 * 
 * Since the answer can be very large, return the answer modulo 10 ^ 9 + 7.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "ABC"
 * Output: 10
 * Explanation: All possible substrings are: "A","B","C","AB","BC" and "ABC".
 * Evey substring is composed with only unique letters.
 * Sum of lengths of all substring is 1 + 1 + 1 + 2 + 2 + 3 = 10
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "ABA"
 * Output: 8
 * Explanation: The same as example 1, except countUniqueChars("ABA") = 1.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "LEETCODE"
 * Output: 92
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= s.length <= 10^4
 * s contain upper-case English letters only.
 * 
 * 
 */
class Solution {
    int mod = 1000000007;
    public int uniqueLetterString(String s) {
        char[] chs = s.toCharArray();
        int[] pre = new int[26];
        int[] mid = new int[26];
        Arrays.fill(mid, -1);
        int ans = 0;
        int n = chs.length;
        for (int i = 0; i < n; i++) {
            int cid = chs[i] - 'A';
            if (mid[cid] >= 0) {
                ans = (ans + (i-mid[cid])*(mid[cid]-pre[cid])) % mod;
            }
            pre[cid] = mid[cid];
            mid[cid] = i;
        }
        for (int i = 0; i < 26; i++)
            if (mid[i] > -1)
                ans = (ans + (n-mid[i])*(mid[i]-pre[i])) % mod;
        return ans;
    }
}
