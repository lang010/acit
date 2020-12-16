/*
 * @lc app=leetcode id=245 lang=java
 *
 * [245] Shortest Word Distance III
 *
 * https://leetcode.com/problems/shortest-word-distance-iii/description/
 *
 * algorithms
 * Medium (55.71%)
 * Total Accepted:    52.4K
 * Total Submissions: 94.1K
 * Testcase Example:  '["practice", "makes", "perfect", "coding", "makes"]\n"makes"\n"coding"'
 *
 * Given a list of words and two words word1 and word2, return the shortest
 * distance between these two words in the list.
 * 
 * word1 and word2 may be the same and they represent two individual words in
 * the list.
 * 
 * Example:
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * 
 * 
 * Input: word1 = “makes”, word2 = “coding”
 * Output: 1
 * 
 * 
 * 
 * Input: word1 = "makes", word2 = "makes"
 * Output: 3
 * 
 * 
 * Note:
 * You may assume word1 and word2 are both in the list.
 * 
 */
class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int n = words.length;
        int ans = n;
        if (word1.equals(word2)) {
            int a = -n;
            for (int i = 0; i < n; i++)
                if (word1.equals(words[i])) {
                    ans = Math.min(ans, i-a);
                    a = i;
                }
            return ans;
        }
        int a = -n, b = -n-n;
        for (int i = 0; i < n; i++) {
            if (word1.equals(words[i])) {
                a = i;
                ans = Math.min(ans, a-b);
            } else if (word2.equals(words[i])) {
                b = i;
                ans = Math.min(ans, b-a);
            }
        }
        return ans;
    }
}
