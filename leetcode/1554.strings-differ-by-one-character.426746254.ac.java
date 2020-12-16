/*
 * @lc app=leetcode id=1554 lang=java
 *
 * [1554] Strings Differ by One Character
 *
 * https://leetcode.com/problems/strings-differ-by-one-character/description/
 *
 * algorithms
 * Medium (63.70%)
 * Total Accepted:    1.9K
 * Total Submissions: 2.9K
 * Testcase Example:  '["abcd","acbd", "aacd"]'
 *
 * Given a list of strings dict where all the strings are of the same length.
 * 
 * Return True if there are 2 strings that only differ by 1 character in the
 * same index, otherwise return False.
 * 
 * Follow up: Could you solve this problem in O(n*m) where n is the length of
 * dict and m is the length of each string.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: dict = ["abcd","acbd", "aacd"]
 * Output: true
 * Explanation: Strings "abcd" and "aacd" differ only by one character in the
 * index 1.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: dict = ["ab","cd","yz"]
 * Output: false
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: dict = ["abcd","cccc","abyd","abab"]
 * Output: true
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * Number of characters in dict <= 10^5
 * dict[i].length == dict[j].length
 * dict[i] should be unique.
 * dict[i] contains only lowercase English letters.
 * 
 * 
 */
class Solution {
    public boolean differByOne(String[] dict) {
        Set<String> set = new HashSet<>();
        for (String s : dict) {
            StringBuilder sb = new StringBuilder(s);
            for (int i = 0; i < sb.length(); i++) {
                char c = sb.charAt(i);
                sb.setCharAt(i, '.');
                String str = sb.toString();
                if (set.contains(str))
                    return true;
                set.add(str);
                sb.setCharAt(i, c);
            }
        }
        return false;
    }
}
