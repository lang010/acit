/*
 * @lc app=leetcode id=500 lang=java
 *
 * [500] Keyboard Row
 *
 * https://leetcode.com/problems/keyboard-row/description/
 *
 * algorithms
 * Easy (65.36%)
 * Total Accepted:    119.2K
 * Total Submissions: 182.3K
 * Testcase Example:  '["Hello","Alaska","Dad","Peace"]'
 *
 * Given a List of words, return the words that can be typed using letters of
 * alphabet on only one row's of American keyboard like the image
 * below.
 * 
 * 
 * 
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: ["Hello", "Alaska", "Dad", "Peace"]
 * Output: ["Alaska", "Dad"]
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * You may use one character in the keyboard more than once.
 * You may assume the input string will only contain letters of alphabet.
 * 
 * 
 */
class Solution {
    public String[] findWords(String[] words) {
        List<String> ls = new ArrayList<>();
        String[] ab = {"qwertyuiopQWERTYUIOP", "asdfghjklASDFGHJKL", "zxcvbnmZXCVBNM"};
        for (String s : words) {
            char c = s.charAt(0);
            String key = "";
            for (String k : ab) {
                if (k.indexOf(c) >= 0) {
                    key = k;
                    break;
                }
            }
            boolean is = true;
            for (char ch : s.toCharArray()) {
                if (key.indexOf(ch) < 0) {
                    is = false;
                    break;
                }
            }
            if (is)
                ls.add(s);
        }
        return ls.toArray(new String[0]);
    }
}
