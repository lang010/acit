/*
 * @lc app=leetcode id=767 lang=java
 *
 * [767] Reorganize String
 *
 * https://leetcode.com/problems/reorganize-string/description/
 *
 * algorithms
 * Medium (49.69%)
 * Total Accepted:    112.6K
 * Total Submissions: 226.6K
 * Testcase Example:  '"aab"'
 *
 * Given a string S, check if the letters can be rearranged so that two
 * characters that are adjacent to each other are not the same.
 * 
 * If possible, output any possible result.  If not possible, return the empty
 * string.
 * 
 * Example 1:
 * 
 * 
 * Input: S = "aab"
 * Output: "aba"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: S = "aaab"
 * Output: ""
 * 
 * 
 * Note:
 * 
 * 
 * S will consist of lowercase letters and have length in range [1, 500].
 * 
 * 
 * 
 * 
 */
class Solution {
    public String reorganizeString(String S) {
        int[] chCnt = new int[26];
        for (char c : S.toCharArray()) {
            chCnt[c-'a']++;
        }
        int n = S.length();
        int maxId = 0;
        for (int i = 1; i < 26; i++) {
            if (chCnt[i] > chCnt[maxId])
                maxId = i;
        }
        if (chCnt[maxId] > (n+1)/2)
            return "";
        char[] cs = new char[n];
        int id = 0;
        while (chCnt[maxId] > 0) {
            cs[id] = (char)('a' + maxId);
            chCnt[maxId]--;
            id += 2;
        }
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < chCnt[i]; j++) {
                if (id >= n)
                    id = 1;
                cs[id] = (char) ('a' + i);
                id += 2;
            }
        }
        return new String(cs);
    }
}
