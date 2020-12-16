/*
 * @lc app=leetcode id=792 lang=java
 *
 * [792] Number of Matching Subsequences
 *
 * https://leetcode.com/problems/number-of-matching-subsequences/description/
 *
 * algorithms
 * Medium (47.91%)
 * Total Accepted:    49.1K
 * Total Submissions: 102.6K
 * Testcase Example:  '"abcde"\n["a","bb","acd","ace"]'
 *
 * Given string S and a dictionary of words words, find the number of words[i]
 * that is a subsequence of S.
 * 
 * 
 * Example :
 * Input: 
 * S = "abcde"
 * words = ["a", "bb", "acd", "ace"]
 * Output: 3
 * Explanation: There are three words in words that are a subsequence of S:
 * "a", "acd", "ace".
 * 
 * 
 * Note:
 * 
 * 
 * All words in words and S will only consists of lowercase letters.
 * The length of S will be in the range of [1, 50000].
 * The length of words will be in the range of [1, 5000].
 * The length of words[i] will be in the range of [1, 50].
 * 
 * 
 */
class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        List<Integer>[] ls = new List[26];
        for (int i = 0; i < 26; i++)
            ls[i] = new ArrayList<>();
        for (int i = 0; i < S.length(); i++)
            ls[S.charAt(i)-'a'].add(i);
        int ans = 0;
        for (String s : words) {
            int l = -1;
            for (char c : s.toCharArray()) {
                l = find(ls[c-'a'], l);
                if (l < 0) {
                    ans--;
                    break;
                }
            }
            ans++;
        }
        return ans;
    }
    
    int find(List<Integer> ls, int val) {
        int r = ls.size()-1;
        int l = 0;
        if (r < 0 || ls.get(r) <= val)
            return -1;
        while (l < r) {
            int m = l + (r-l)/2;
            if (ls.get(m) <= val)
                l = m+1;
            else
                r = m;
        }
        return ls.get(l);
    }
}
