/*
 * @lc app=leetcode id=1239 lang=java
 *
 * [1239] Maximum Length of a Concatenated String with Unique Characters
 *
 * https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/description/
 *
 * algorithms
 * Medium (48.93%)
 * Total Accepted:    40.9K
 * Total Submissions: 83.6K
 * Testcase Example:  '["un","iq","ue"]'
 *
 * Given an array of strings arr. String s is a concatenation of a sub-sequence
 * of arr which have unique characters.
 * 
 * Return the maximum possible length of s.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: arr = ["un","iq","ue"]
 * Output: 4
 * Explanation: All possible concatenations are "","un","iq","ue","uniq" and
 * "ique".
 * Maximum length is 4.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: arr = ["cha","r","act","ers"]
 * Output: 6
 * Explanation: Possible solutions are "chaers" and "acters".
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
 * Output: 26
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= arr.length <= 16
 * 1 <= arr[i].length <= 26
 * arr[i] contains only lower case English letters.
 * 
 * 
 */
class Solution {
    int[] vals;
    List<String> ls;
    public int maxLength(List<String> arr) {
        int n = arr.size();
        int ans = 0;
        vals = new int[n];
        ls = arr;
        for (int i = 0; i < n; i++)
            for (char c : arr.get(i).toCharArray()) {
                if ((vals[i]>>(c-'a') & 1) == 1) {
                    vals[i] = 0;
                    break;
                }
                vals[i] = vals[i] | (1<<(c-'a'));
            }
        for (int i = 1; i < (1<<n); i++)
            ans = Math.max(ans, cnt(i));
        return ans;
    }
    
    int cnt(int x) {
        int ans = 0;
        int cur = 0;
        for (int i = 0; i < vals.length; i++)
            if ((x >> i & 1) == 1) {
                if (vals[i] == 0)
                    continue;
                if ((cur & vals[i]) > 0)
                    return 0;
                ans += ls.get(i).length();
                cur |= vals[i];
            }
        return ans;
    }
}
