/*
 * @lc app=leetcode id=953 lang=java
 *
 * [953] Verifying an Alien Dictionary
 *
 * https://leetcode.com/problems/verifying-an-alien-dictionary/description/
 *
 * algorithms
 * Easy (52.77%)
 * Total Accepted:    169.7K
 * Total Submissions: 321.5K
 * Testcase Example:  '["hello","leetcode"]\n"hlabcdefgijkmnopqrstuvwxyz"'
 *
 * In an alien language, surprisingly they also use english lowercase letters,
 * but possibly in a different order. The order of the alphabet is some
 * permutation of lowercase letters.
 * 
 * Given a sequence of words written in the alien language, and the order of
 * the alphabet, return true if and only if the given words are sorted
 * lexicographicaly in this alien language.
 * 
 * Example 1:
 * 
 * 
 * Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * Output: true
 * Explanation: As 'h' comes before 'l' in this language, then the sequence is
 * sorted.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * Output: false
 * Explanation: As 'd' comes after 'l' in this language, then words[0] >
 * words[1], hence the sequence is unsorted.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * Output: false
 * Explanation: The first three characters "app" match, and the second string
 * is shorter (in size.) According to lexicographical rules "apple" > "app",
 * because 'l' > '∅', where '∅' is defined as the blank character which is less
 * than any other character (More info).
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 20
 * order.length == 26
 * All characters in words[i] and order are English lowercase letters.
 * 
 * 
 */
class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] map = new int[26];
        for (int i = 0; i < order.length(); i++) {
            map[order.charAt(i) - 'a'] = i;
        }
        for (int i = 1; i < words.length; i++) {
            int n = Math.min(words[i-1].length(), words[i].length());
            int j;
            for (j = 0; j < n; j++) {
                int val = map[words[i-1].charAt(j) - 'a'] - map[words[i].charAt(j) - 'a'];
                if (val > 0)
                    return false;
                else if (val < 0)
                    break;
            }
            if (j == n && words[i-1].length() > words[i].length())
                return false;
        }
        return true;
    }
}
