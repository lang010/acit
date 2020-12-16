/*
 * @lc app=leetcode id=30 lang=java
 *
 * [30] Substring with Concatenation of All Words
 *
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/description/
 *
 * algorithms
 * Hard (25.90%)
 * Total Accepted:    192.3K
 * Total Submissions: 742.3K
 * Testcase Example:  '"barfoothefoobarman"\n["foo","bar"]'
 *
 * You are given a string s and an array of strings words of the same length.
 * Return all starting indices of substring(s) in s that is a concatenation of
 * each word in words exactly once, in any order, and without any intervening
 * characters.
 * 
 * You can return the answer in any order.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "barfoothefoobarman", words = ["foo","bar"]
 * Output: [0,9]
 * Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar"
 * respectively.
 * The output order does not matter, returning [9,0] is fine too.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
 * Output: []
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
 * Output: [6,9,12]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 10^4
 * s consists of lower-case English letters.
 * 1 <= words.length <= 5000
 * 1 <= words[i].length <= 30
 * words[i] consists of lower-case English letters.
 * 
 * 
 */
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        int n = s.length();
        int m = words[0].length();
        if (n < m*words.length)
            return ans;
        String[] arr = new String[n-m+1];
        Map<String, Integer> map = new HashMap<>();
        for (String w : words) {
            map.put(w, map.getOrDefault(w, 0)+1);
        }
        for (int i = m; i <= n; i++) {
            arr[i-m] = s.substring(i-m, i);
        }
        for (int i = 0; i < m; i++) {
            int l = i;
            for (int j = i; j < n-m+1; j += m) {
                int v = map.getOrDefault(arr[j], 0);
                v--;
                if (v >= 0) {
                    map.put(arr[j], v);
                    if (v == 0 && (j-l)/m == words.length-1) {
                        ans.add(l);
                        map.put(arr[l], map.get(arr[l])+1);
                        l += m;
                    }
                    continue;
                }
                while (v < 0) {
                    if (arr[l].equals(arr[j]))
                        v++;
                    else if (map.containsKey(arr[l]))
                        map.put(arr[l], map.get(arr[l])+1);
                    l += m;
                }
            }
            while (l < n-m+1) {
                if (map.containsKey(arr[l]))
                    map.put(arr[l], map.get(arr[l])+1);
                l += m;
            }
        }
        return ans;
    }
}
