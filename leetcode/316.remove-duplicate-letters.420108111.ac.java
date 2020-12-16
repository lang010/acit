/*
 * @lc app=leetcode id=316 lang=java
 *
 * [316] Remove Duplicate Letters
 *
 * https://leetcode.com/problems/remove-duplicate-letters/description/
 *
 * algorithms
 * Medium (38.65%)
 * Total Accepted:    107.4K
 * Total Submissions: 278K
 * Testcase Example:  '"bcabc"'
 *
 * Given a string s, remove duplicate letters so that every letter appears once
 * and only once. You must make sure your result is the smallest in
 * lexicographical order among all possible results.
 * 
 * Note: This question is the same as 1081:
 * https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "bcabc"
 * Output: "abc"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "cbacdcbc"
 * Output: "acdb"
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 10^4
 * s consists of lowercase English letters.
 * 
 * 
 */
class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        int n = s.length();
        for (int i = 0; i < n; i++)
            map.put(s.charAt(i), i);
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (set.contains(c))
                continue;
            while (!stack.isEmpty() && stack.peek() > c && map.get(stack.peek()) > i) {
                set.remove(stack.pop());
            }
            stack.push(c);
            set.add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : stack)
            sb.append(c);
        return sb.toString();
    }
}
