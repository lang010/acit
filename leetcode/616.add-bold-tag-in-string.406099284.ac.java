/*
 * @lc app=leetcode id=616 lang=java
 *
 * [616] Add Bold Tag in String
 *
 * https://leetcode.com/problems/add-bold-tag-in-string/description/
 *
 * algorithms
 * Medium (44.27%)
 * Total Accepted:    43.8K
 * Total Submissions: 99K
 * Testcase Example:  '"abcxyz123"\n["abc","123"]'
 *
 * Given a string s and a list of strings dict, you need to add a closed pair
 * of bold tag <b> and </b> to wrap the substrings in s that exist in dict. If
 * two such substrings overlap, you need to wrap them together by only one pair
 * of closed bold tag. Also, if two substrings wrapped by bold tags are
 * consecutive, you need to combine them.
 * Example 1:
 * 
 * 
 * Input: 
 * s = "abcxyz123"
 * dict = ["abc","123"]
 * Output:
 * "<b>abc</b>xyz<b>123</b>"
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 
 * s = "aaabbcc"
 * dict = ["aaa","aab","bc"]
 * Output:
 * "<b>aaabbc</b>c"
 * 
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The given dict won't contain duplicates, and its length won't exceed
 * 100.
 * All the strings in input have length in range [1, 1000].
 * 
 * 
 * Note: This question is the same as 758:
 * https://leetcode.com/problems/bold-words-in-string/
 * 
 */
class Solution {
    public String addBoldTag(String s, String[] dict) {
        int n = s.length();
        boolean[] bs = new boolean[n];
        for (String b : dict) {
            int i = -1;
            while (true) {
                i = s.indexOf(b, i+1);
                if (i < 0)
                    break;
                for (int j = i; j < i+b.length(); j++)
                    bs[j] = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            while (i < n && !bs[i]) {
                sb.append(s.charAt(i));
                i++;
            }
            if (i < n) {
                sb.append("<b>");
                while (i < n && bs[i]) {
                    sb.append(s.charAt(i));
                    i++;
                }
                sb.append("</b>");
                i--;
            }
        }
        return sb.toString();
    }
}
