/*
 * @lc app=leetcode id=1156 lang=java
 *
 * [1156] Swap For Longest Repeated Character Substring
 *
 * https://leetcode.com/problems/swap-for-longest-repeated-character-substring/description/
 *
 * algorithms
 * Medium (47.58%)
 * Total Accepted:    14.2K
 * Total Submissions: 29.8K
 * Testcase Example:  '"ababa"'
 *
 * Given a string text, we are allowed to swap two of the characters in the
 * string. Find the length of the longest substring with repeated
 * characters.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: text = "ababa"
 * Output: 3
 * Explanation: We can swap the first 'b' with the last 'a', or the last 'b'
 * with the first 'a'. Then, the longest repeated character substring is "aaa",
 * which its length is 3.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: text = "aaabaaa"
 * Output: 6
 * Explanation: Swap 'b' with the last 'a' (or the first 'a'), and we get
 * longest repeated character substring "aaaaaa", which its length is 6.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: text = "aaabbaaa"
 * Output: 4
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: text = "aaaaa"
 * Output: 5
 * Explanation: No need to swap, longest repeated character substring is
 * "aaaaa", length is 5.
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: text = "abcdef"
 * Output: 1
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= text.length <= 20000
 * text consist of lowercase English characters only.
 * 
 * 
 */
class Solution {
    public int maxRepOpt1(String text) {
        int[] cnts = new int[26];
        List<int[]> ls = new ArrayList<>();
        int[] cur = null;
        for (int i = 0; i < text.length(); i++) {
            int id = text.charAt(i) - 'a';
            cnts[id]++;
            if (i == 0 || text.charAt(i) != text.charAt(i-1)) {
                cur = new int[] {id, 1};
                ls.add(cur);
            } else
                cur[1]++;
        }
        int ans = 0;
        for (int i = 0; i < ls.size(); i++) {
            if (i > 0 && i+1 < ls.size() && ls.get(i)[1] == 1 && ls.get(i+1)[0] == ls.get(i-1)[0])
                ans = Math.max(ans, Math.min(ls.get(i-1)[1]+ls.get(i+1)[1]+1, cnts[ls.get(i-1)[0]]));
            else
                ans = Math.max(ans, Math.min(ls.get(i)[1]+1, cnts[ls.get(i)[0]]));
        }
        
        return ans;
    }
}
