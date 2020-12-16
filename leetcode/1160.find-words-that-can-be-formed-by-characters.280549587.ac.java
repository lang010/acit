/*
 * @lc app=leetcode id=1160 lang=java
 *
 * [1160] Find Words That Can Be Formed by Characters
 *
 * https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/description/
 *
 * algorithms
 * Easy (67.44%)
 * Total Accepted:    63.6K
 * Total Submissions: 94.3K
 * Testcase Example:  '["cat","bt","hat","tree"]\n"atach"'
 *
 * You are given an array of strings words and a string chars.
 * 
 * A string is good if it can be formed by characters from chars (each
 * character can only be used once).
 * 
 * Return the sum of lengths of all good strings in words.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: words = ["cat","bt","hat","tree"], chars = "atach"
 * Output: 6
 * Explanation: 
 * The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 =
 * 6.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 * Output: 10
 * Explanation: 
 * The strings that can be formed are "hello" and "world" so the answer is 5 +
 * 5 = 10.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= words.length <= 1000
 * 1 <= words[i].length, chars.length <= 100
 * All strings contain lowercase English letters only.
 * 
 */
class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] cnt = new int[26];
        for (char c : chars.toCharArray()) {
            cnt[c-'a']++;
        }
        int sum = 0;
        for (String s : words) {
            int[] tmp = new int[26];
            boolean t = true;
            for (char c : s.toCharArray()) {
                int id = c - 'a';
                if (++tmp[id] > cnt[id]) {
                    t = false;
                    break;
                }
            }
            if (t) {
                sum += s.length();
            }
        }
        return sum;
    }
}
