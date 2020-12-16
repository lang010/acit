/*
 * @lc app=leetcode id=1100 lang=java
 *
 * [1100] Find K-Length Substrings With No Repeated Characters
 *
 * https://leetcode.com/problems/find-k-length-substrings-with-no-repeated-characters/description/
 *
 * algorithms
 * Medium (73.42%)
 * Total Accepted:    14.6K
 * Total Submissions: 19.9K
 * Testcase Example:  '"havefunonleetcode"\n5'
 *
 * Given a string S, return the number of substrings of length K with no
 * repeated characters.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: S = "havefunonleetcode", K = 5
 * Output: 6
 * Explanation: 
 * There are 6 substrings they are :
 * 'havef','avefu','vefun','efuno','etcod','tcode'.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: S = "home", K = 5
 * Output: 0
 * Explanation: 
 * Notice K can be larger than the length of S. In this case is not possible to
 * find any substring.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= S.length <= 10^4
 * All characters of S are lowercase English letters.
 * 1 <= K <= 10^4
 * 
 * 
 */
class Solution {
    int[] map = new int[26];
    int cnt = 0;
    public int numKLenSubstrNoRepeats(String S, int K) {
        if (K > S.length())
            return 0;
        if (K > 26)
            return 0;
        for (int i = 0; i < K; i++)
            add(S.charAt(i));
        int ans = cnt == 0 ? 1 : 0;
        for (int i = K; i < S.length(); i++) {
            add(S.charAt(i));
            remove(S.charAt(i-K));
            ans += cnt == 0 ? 1 : 0;
        }
        return ans;
    }
    
    void add(char c) {
        int i = c - 'a';
        map[i]++;
        if (map[i] == 2)
            cnt++;
    }
    
    void remove(char c) {
        int i = c - 'a';
        map[i]--;
        if (map[i] == 1)
            cnt--;
    }
}
