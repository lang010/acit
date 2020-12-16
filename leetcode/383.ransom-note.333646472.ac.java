/*
 * @lc app=leetcode id=383 lang=java
 *
 * [383] Ransom Note
 *
 * https://leetcode.com/problems/ransom-note/description/
 *
 * algorithms
 * Easy (53.20%)
 * Total Accepted:    243.3K
 * Total Submissions: 457.3K
 * Testcase Example:  '"a"\n"b"'
 *
 * Given an arbitrary ransom note string and another string containing letters
 * from all the magazines, write a function that will return true if the ransom
 * note can be constructed from the magazines ; otherwise, it will return
 * false.
 * 
 * Each letter in the magazine string can only be used once in your ransom
 * note.
 * 
 * 
 * Example 1:
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 * Example 2:
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 * Example 3:
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 * 
 * 
 * Constraints:
 * 
 * 
 * You may assume that both strings contain only lowercase letters.
 * 
 * 
 */
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] map = new int[26];
        for (char c : magazine.toCharArray())
            map[c-'a']++;
        for (char c : ransomNote.toCharArray())
            if (map[c-'a'] == 0)
                return false;
            else
                map[c-'a']--;
        return true;
    }
}
