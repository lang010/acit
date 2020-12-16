/*
 * @lc app=leetcode id=1371 lang=java
 *
 * [1371] Find the Longest Substring Containing Vowels in Even Counts
 *
 * https://leetcode.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/description/
 *
 * algorithms
 * Medium (61.39%)
 * Total Accepted:    10.5K
 * Total Submissions: 17.1K
 * Testcase Example:  '"eleetminicoworoep"'
 *
 * Given the string s, return the size of the longest substring containing each
 * vowel an even number of times. That is, 'a', 'e', 'i', 'o', and 'u' must
 * appear an even number of times.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "eleetminicoworoep"
 * Output: 13
 * Explanation: The longest substring is "leetminicowor" which contains two
 * each of the vowels: e, i and o and zero of the vowels: a and u.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "leetcodeisgreat"
 * Output: 5
 * Explanation: The longest substring is "leetc" which contains two e's.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "bcbcbc"
 * Output: 6
 * Explanation: In this case, the given string "bcbcbc" is the longest because
 * all vowels: a, e, i, o and u appear zero times.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 5 x 10^5
 * s contains only lowercase English letters.
 * 
 * 
 */
class Solution {
    public int findTheLongestSubstring(String s) {
        int[] last = new int[32];
        int n = s.length();
        Arrays.fill(last, -2);
        int cur = 0;
        int ans = 0;
        last[0] = -1;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int t = -1;
            if (c == 'a')
                t = 0;
            else if (c == 'e')
                t = 1;
            else if (c == 'i')
                t = 2;
            else if (c == 'o')
                t = 3;
            else if (c == 'u')
                t = 4;
            if (t > -1)
                cur = cur ^ (1 << t);
            if (last[cur] > -2)
                ans = Math.max(ans, i-last[cur]);
            else
                last[cur] = i;
        }
        return ans;
    }
}
