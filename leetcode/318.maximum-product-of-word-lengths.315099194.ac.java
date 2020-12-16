/*
 * @lc app=leetcode id=318 lang=java
 *
 * [318] Maximum Product of Word Lengths
 *
 * https://leetcode.com/problems/maximum-product-of-word-lengths/description/
 *
 * algorithms
 * Medium (51.87%)
 * Total Accepted:    103.5K
 * Total Submissions: 199.6K
 * Testcase Example:  '["abcw","baz","foo","bar","xtfn","abcdef"]'
 *
 * Given a string array words, find the maximum value of length(word[i]) *
 * length(word[j]) where the two words do not share common letters. You may
 * assume that each word will contain only lower case letters. If no such two
 * words exist, return 0.
 * 
 * Example 1:
 * 
 * 
 * Input: ["abcw","baz","foo","bar","xtfn","abcdef"]
 * Output: 16 
 * Explanation: The two words can be "abcw", "xtfn".
 * 
 * Example 2:
 * 
 * 
 * Input: ["a","ab","abc","d","cd","bcd","abcd"]
 * Output: 4 
 * Explanation: The two words can be "ab", "cd".
 * 
 * Example 3:
 * 
 * 
 * Input: ["a","aa","aaa","aaaa"]
 * Output: 0 
 * Explanation: No such pair of words.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= words.length <= 10^3
 * 0 <= words[i].length <= 10^3
 * words[i] consists only of lowercase English letters.
 * 
 * 
 */
class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] bits = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            int v = 0;
            for (char c : words[i].toCharArray()) {
                v |= 1 << (c - 'a');
            }
            bits[i] = v;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++)
                if ((bits[i] & bits[j]) == 0)
                    max = Math.max(max, words[i].length() * words[j].length());
        }
        return max;
    }
}
