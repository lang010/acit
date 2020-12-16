/*
 * @lc app=leetcode id=387 lang=java
 *
 * [387] First Unique Character in a String
 *
 * https://leetcode.com/problems/first-unique-character-in-a-string/description/
 *
 * algorithms
 * Easy (53.65%)
 * Total Accepted:    640.7K
 * Total Submissions: 1.2M
 * Testcase Example:  '"leetcode"'
 *
 * Given a string, find the first non-repeating character in it and return its
 * index. If it doesn't exist, return -1.
 * 
 * Examples:
 * 
 * 
 * s = "leetcode"
 * return 0.
 * 
 * s = "loveleetcode"
 * return 2.
 * 
 * 
 * 
 * 
 * Note: You may assume the string contains only lowercase English letters.
 * 
 */
class Solution {
    public int firstUniqChar(String s) {
        int[] cnt = new int[1024];
        for (char c : s.toCharArray())
            cnt[c]++;
        for (int i = 0; i < s.length(); i++)
            if (cnt[s.charAt(i)] == 1)
                return i;
        return -1;
    }
}
