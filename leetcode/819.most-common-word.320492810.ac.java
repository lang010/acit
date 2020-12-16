/*
 * @lc app=leetcode id=819 lang=java
 *
 * [819] Most Common Word
 *
 * https://leetcode.com/problems/most-common-word/description/
 *
 * algorithms
 * Easy (45.29%)
 * Total Accepted:    198.9K
 * Total Submissions: 439.1K
 * Testcase Example:  '"Bob hit a ball, the hit BALL flew far after it was hit."\n["hit"]'
 *
 * Given a paragraph and a list of banned words, return the most frequent word
 * that is not in the list of banned words.  It is guaranteed there is at least
 * one word that isn't banned, and that the answer is unique.
 * 
 * Words in the list of banned words are given in lowercase, and free of
 * punctuation.  Words in the paragraph are not case sensitive.  The answer is
 * in lowercase.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: 
 * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned = ["hit"]
 * Output: "ball"
 * Explanation: 
 * "hit" occurs 3 times, but it is a banned word.
 * "ball" occurs twice (and no other word does), so it is the most frequent
 * non-banned word in the paragraph. 
 * Note that words in the paragraph are not case sensitive,
 * that punctuation is ignored (even if adjacent to words, such as "ball,"), 
 * and that "hit" isn't the answer even though it occurs more because it is
 * banned.
 * 
 * 
 * 
 * 
 * Note: 
 * 
 * 
 * 1 <= paragraph.length <= 1000.
 * 0 <= banned.length <= 100.
 * 1 <= banned[i].length <= 10.
 * The answer is unique, and written in lowercase (even if its occurrences in
 * paragraph may have uppercase symbols, and even if it is a proper noun.)
 * paragraph only consists of letters, spaces, or the punctuation symbols
 * !?',;.
 * There are no hyphens or hyphenated words.
 * Words only consist of letters, never apostrophes or other punctuation
 * symbols.
 * 
 * 
 */
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> set = new HashSet<>();
        for (String s : banned)
            set.add(s.toLowerCase());
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        for (char c : paragraph.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                sb.append(c);
            } else if (c >= 'A' && c <= 'Z') {
                sb.append((char) (c - 'A' + 'a'));
            } else {
                String s = sb.toString();
                if (!"".equals(s) && !set.contains(s)) {
                    map.put(s, map.getOrDefault(s, 0)+1);
                }
                sb = new StringBuilder();
            }
        }
        String str = sb.toString();
        if (!"".equals(str) && !set.contains(str)) {
            map.put(str, map.getOrDefault(str, 0)+1);
        }
        
        int max = 0;
        String ans = "";
        for (String s : map.keySet()) {
            if (max < map.get(s)) {
                max = map.get(s);
                ans = s;
            }
        }
        return ans;
    }
}
