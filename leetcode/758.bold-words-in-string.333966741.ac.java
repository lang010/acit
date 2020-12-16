/*
 * @lc app=leetcode id=758 lang=java
 *
 * [758] Bold Words in String
 *
 * https://leetcode.com/problems/bold-words-in-string/description/
 *
 * algorithms
 * Easy (46.90%)
 * Total Accepted:    12K
 * Total Submissions: 25.6K
 * Testcase Example:  '["ab","bc"]\n"aabcd"'
 *
 * Given a set of keywords words and a string S, make all appearances of all
 * keywords in S bold. Any letters between <b> and </b> tags become bold.
 * 
 * The returned string should use the least number of tags possible, and of
 * course the tags should form a valid combination.
 * 
 * For example, given that words = ["ab", "bc"] and S = "aabcd", we should
 * return "a<b>abc</b>d". Note that returning "a<b>a<b>b</b>c</b>d" would use
 * more tags, so it is incorrect.
 * 
 * Constraints:
 * 
 * 
 * words has length in range [0, 50].
 * words[i] has length in range [1, 10].
 * S has length in range [0, 500].
 * All characters in words[i] and S are lowercase letters.
 * 
 * 
 * Note: This question is the same as 616:
 * https://leetcode.com/problems/add-bold-tag-in-string/
 * 
 */
class Solution {
    public String boldWords(String[] words, String S) {
        int n = S.length();
        boolean[] bd = new boolean[n];
        for (String s : words) {
            int st = -1;
            while (true) {
                st = S.indexOf(s, st+1);
                if (st < 0)
                    break;
                for (int i = 0; i < s.length(); i++)
                    bd[st+i] = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        boolean isBold = false;
        for (int i = 0; i < n; i++) {
            if (bd[i]) {
                if (!isBold) {
                    sb.append("<b>");
                    isBold = true;
                }
            } else {
                if (isBold) {
                    sb.append("</b>");
                    isBold = false;
                }
            }
            char c = S.charAt(i);
            sb.append(c);
        }
        if (isBold)
            sb.append("</b>");
        return sb.toString();
    }
}
