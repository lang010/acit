/*
 * @lc app=leetcode id=1408 lang=java
 *
 * [1408] String Matching in an Array
 *
 * https://leetcode.com/problems/string-matching-in-an-array/description/
 *
 * algorithms
 * Easy (62.62%)
 * Total Accepted:    30.8K
 * Total Submissions: 49.3K
 * Testcase Example:  '["mass","as","hero","superhero"]'
 *
 * Given an array of string words. Return all strings in words which is
 * substring of another word in any order. 
 * 
 * String words[i] is substring of words[j], if can be obtained removing some
 * characters to left and/or right side of words[j].
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: words = ["mass","as","hero","superhero"]
 * Output: ["as","hero"]
 * Explanation: "as" is substring of "mass" and "hero" is substring of
 * "superhero".
 * ["hero","as"] is also a valid answer.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: words = ["leetcode","et","code"]
 * Output: ["et","code"]
 * Explanation: "et", "code" are substring of "leetcode".
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: words = ["blue","green","bu"]
 * Output: []
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 30
 * words[i] contains only lowercase English letters.
 * It's guaranteed that words[i] will be unique.
 * 
 */
class Solution {
    public List<String> stringMatching(String[] words) {
        Set<String> set = new HashSet<>();
        int n = words.length;
        for (int i = 0; i < n; i++)
            for (int j = i+1; j < n; j++) {
                if (words[i].indexOf(words[j]) >= 0)
                    set.add(words[j]);
                if (words[j].indexOf(words[i]) >= 0)
                    set.add(words[i]);
            }
        return new ArrayList<>(set);
    }
}
