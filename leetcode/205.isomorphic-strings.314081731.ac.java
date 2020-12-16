/*
 * @lc app=leetcode id=205 lang=java
 *
 * [205] Isomorphic Strings
 *
 * https://leetcode.com/problems/isomorphic-strings/description/
 *
 * algorithms
 * Easy (40.22%)
 * Total Accepted:    329K
 * Total Submissions: 817.9K
 * Testcase Example:  '"egg"\n"add"'
 *
 * Given two strings s and t, determine if they are isomorphic.
 * 
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * 
 * All occurrences of a character must be replaced with another character while
 * preserving the order of characters. No two characters may map to the same
 * character but a character may map to itself.
 * 
 * Example 1:
 * 
 * 
 * Input: s = "egg", t = "add"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "foo", t = "bar"
 * Output: false
 * 
 * Example 3:
 * 
 * 
 * Input: s = "paper", t = "title"
 * Output: true
 * 
 * Note:
 * You may assume both s and t have the same length.
 * 
 */
class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        if (n != t.length())
            return false;
        Map<Character, Character> mapST = new HashMap<>();
        Map<Character, Character> mapTS = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if (!mapST.containsKey(a) && !mapTS.containsKey(b)) {
                mapST.put(a, b);
                mapTS.put(b, a);
                continue;
            } else if (mapST.containsKey(a) && mapTS.containsKey(b)
                      && mapST.get(a) == b && mapTS.get(b) == a) {
                continue;
            }
            return false;
        }
        return true;
    }
}
