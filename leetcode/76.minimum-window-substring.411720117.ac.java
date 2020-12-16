/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 *
 * https://leetcode.com/problems/minimum-window-substring/description/
 *
 * algorithms
 * Hard (35.49%)
 * Total Accepted:    467.6K
 * Total Submissions: 1.3M
 * Testcase Example:  '"ADOBECODEBANC"\n"ABC"'
 *
 * Given two strings s and t, return the minimum window in s which will contain
 * all the characters in t. If there is no such window in s that covers all
 * characters in t, return the empty string "".
 * 
 * Note that If there is such a window, it is guaranteed that there will always
 * be only one unique minimum window in s.
 * 
 * 
 * Example 1:
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Example 2:
 * Input: s = "a", t = "a"
 * Output: "a"
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length, t.length <= 10^5
 * s and t consist of English letters.
 * 
 * 
 * 
 * Follow up: Could you find an algorithm that runs in O(n) time?
 */
class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray())
            map.put(c, map.getOrDefault(c, 0)-1);
        int cnt = map.size();
        int l, r, minl, minr;
        int n = s.length();
        l = r = minl = 0;
        minr = n+1;
        while (r < n) {
            char c = s.charAt(r++);
            if (map.containsKey(c)) {
                int v = map.get(c)+1;
                map.put(c, v);
                if (v == 0) {
                    cnt--;
                    while (cnt == 0) {
                        if (minr - minl > r-l) {
                            minl = l;
                            minr = r;
                        }
                        char ch = s.charAt(l++);
                        if (map.containsKey(ch)) {
                            map.put(ch, map.get(ch)-1);
                            if (map.get(ch) == -1)
                                cnt++;
                        }
                    }
                }
            }
        }
        return minr-minl > n ? "" : s.substring(minl, minr);
    }
}
