/*
 * @lc app=leetcode id=1023 lang=java
 *
 * [1023] Camelcase Matching
 *
 * https://leetcode.com/problems/camelcase-matching/description/
 *
 * algorithms
 * Medium (57.22%)
 * Total Accepted:    20.5K
 * Total Submissions: 35.9K
 * Testcase Example:  '["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"]\n"FB"'
 *
 * A query word matches a given pattern if we can insert lowercase letters to
 * the pattern word so that it equals the query. (We may insert each character
 * at any position, and may insert 0 characters.)
 * 
 * Given a list of queries, and a pattern, return an answer list of booleans,
 * where answer[i] is true if and only if queries[i] matches the pattern.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: queries =
 * ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern =
 * "FB"
 * Output: [true,false,true,true,false]
 * Explanation: 
 * "FooBar" can be generated like this "F" + "oo" + "B" + "ar".
 * "FootBall" can be generated like this "F" + "oot" + "B" + "all".
 * "FrameBuffer" can be generated like this "F" + "rame" + "B" + "uffer".
 * 
 * Example 2:
 * 
 * 
 * Input: queries =
 * ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern =
 * "FoBa"
 * Output: [true,false,true,false,false]
 * Explanation: 
 * "FooBar" can be generated like this "Fo" + "o" + "Ba" + "r".
 * "FootBall" can be generated like this "Fo" + "ot" + "Ba" + "ll".
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: queries =
 * ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern =
 * "FoBaT"
 * Output: [false,true,false,false,false]
 * Explanation: 
 * "FooBarTest" can be generated like this "Fo" + "o" + "Ba" + "r" + "T" +
 * "est".
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= queries.length <= 100
 * 1 <= queries[i].length <= 100
 * 1 <= pattern.length <= 100
 * All strings consists only of lower and upper case English letters.
 * 
 * 
 */
class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        char[] pat = pattern.toCharArray();
        int n = pat.length;
        List<Boolean> ans = new ArrayList<>();
        for (String s : queries) {
            int p = 0;
            int i = 0;
            while (i < s.length()) {
                char c = s.charAt(i);
                if (p < n) {
                    if (c == pat[p])
                        p++;
                    else if (c >= 'A' && c <= 'Z')
                        break;
                } else {
                    if (c >= 'A' && c <= 'Z')
                        break;
                }
                i++;
            }
            ans.add(i == s.length() && p == n);
        }
        return ans;
    }
}
