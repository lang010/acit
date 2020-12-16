/*
 * @lc app=leetcode id=243 lang=java
 *
 * [243] Shortest Word Distance
 *
 * https://leetcode.com/problems/shortest-word-distance/description/
 *
 * algorithms
 * Easy (61.73%)
 * Total Accepted:    117.5K
 * Total Submissions: 190.3K
 * Testcase Example:  '["practice", "makes", "perfect", "coding", "makes"]\n"coding"\n"practice"'
 *
 * Given a list of words and two words word1 and word2, return the shortest
 * distance between these two words in the list.
 * 
 * Example:
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * 
 * 
 * Input: word1 = “coding”, word2 = “practice”
 * Output: 3
 * 
 * 
 * 
 * Input: word1 = "makes", word2 = "coding"
 * Output: 1
 * 
 * 
 * Note:
 * You may assume that word1 does not equal to word2, and word1 and word2 are
 * both in the list.
 * 
 */
class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int n = words.length;
        int p1 = -n, p2 = -n;
        int min = n;
        for (int i = 0; i < n; i++) {
            if (words[i].equals(word1)) {
                p1 = i;
                min = Math.min(min, p1-p2);
            } else if (words[i].equals(word2)) {
                p2 = i;
                min = Math.min(min, p2-p1);
            }
        }
        return min;
    }
}
