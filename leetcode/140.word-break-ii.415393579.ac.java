/*
 * @lc app=leetcode id=140 lang=java
 *
 * [140] Word Break II
 *
 * https://leetcode.com/problems/word-break-ii/description/
 *
 * algorithms
 * Hard (33.95%)
 * Total Accepted:    287.8K
 * Total Submissions: 847.5K
 * Testcase Example:  '"catsanddog"\n["cat","cats","and","sand","dog"]'
 *
 * Given a non-empty string s and a dictionary wordDict containing a list of
 * non-empty words, add spaces in s to construct a sentence where each word is
 * a valid dictionary word. Return all such possible sentences.
 * 
 * Note:
 * 
 * 
 * The same word in the dictionary may be reused multiple times in the
 * segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * Output:
 * [
 * "cats and dog",
 * "cat sand dog"
 * ]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * Output:
 * [
 * "pine apple pen apple",
 * "pineapple pen apple",
 * "pine applepen apple"
 * ]
 * Explanation: Note that you are allowed to reuse a dictionary word.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output:
 * []
 * 
 */
class Solution {
    Map<String, List<String>> cache = new HashMap<>();
    Set<String> set = null;
    public List<String> wordBreak(String s, List<String> wordDict) {
        if (cache.containsKey(s))
            return cache.get(s);
        if (set == null) {
            set = new HashSet<>();
            wordDict.forEach(a -> set.add(a));
        }
        List<String> ans = new ArrayList<>();
        if (set.contains(s))
            ans.add(s);
        for (int i = 0; i < s.length(); i++) {
            String pre = s.substring(0, i+1);
            if (set.contains(pre)) {
                wordBreak(s.substring(i+1), wordDict)
                    .forEach(a -> ans.add(pre + " " + a));
            }
        }
        cache.put(s, ans);
        return ans;
    }
}
