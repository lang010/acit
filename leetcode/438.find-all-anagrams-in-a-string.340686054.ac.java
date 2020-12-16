/*
 * @lc app=leetcode id=438 lang=java
 *
 * [438] Find All Anagrams in a String
 *
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
 *
 * algorithms
 * Medium (44.44%)
 * Total Accepted:    320.8K
 * Total Submissions: 721.8K
 * Testcase Example:  '"cbaebabacd"\n"abc"'
 *
 * Given a string s and a non-empty string p, find all the start indices of p's
 * anagrams in s.
 * 
 * Strings consists of lowercase English letters only and the length of both
 * strings s and p will not be larger than 20,100.
 * 
 * The order of output does not matter.
 * 
 * Example 1:
 * 
 * Input:
 * s: "cbaebabacd" p: "abc"
 * 
 * Output:
 * [0, 6]
 * 
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of
 * "abc".
 * 
 * 
 * 
 * Example 2:
 * 
 * Input:
 * s: "abab" p: "ab"
 * 
 * Output:
 * [0, 1, 2]
 * 
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 * 
 * 
 */
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] map = new int[26];
        int l = 0;
        int r = 0;
        List<Integer> ans = new ArrayList<>();
        int len = p.length();
        for (char c : p.toCharArray()) {
            map[c-'a']++;
        }
        while (r < s.length()) {
            char c = s.charAt(r++);
            int id = c-'a';
            map[id]--;
            while (map[id] < 0) {
                map[s.charAt(l++)-'a']++;
            }
            if (r-l == len)
                ans.add(l);
        }
        
        return ans;
    }
}
