/*
 * @lc app=leetcode id=1189 lang=java
 *
 * [1189] Maximum Number of Balloons
 *
 * https://leetcode.com/problems/maximum-number-of-balloons/description/
 *
 * algorithms
 * Easy (61.76%)
 * Total Accepted:    49.4K
 * Total Submissions: 80K
 * Testcase Example:  '"nlaebolko"'
 *
 * Given a string text, you want to use the characters of text to form as many
 * instances of the word "balloon" as possible.
 * 
 * You can use each character in text at most once. Return the maximum number
 * of instances that can be formed.
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input: text = "nlaebolko"
 * Output: 1
 * 
 * 
 * Example 2:
 * 
 * 
 * 
 * 
 * Input: text = "loonbalxballpoon"
 * Output: 2
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: text = "leetcode"
 * Output: 0
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= text.length <= 10^4
 * text consists of lower case English letters only.
 * 
 */
class Solution {
    public int maxNumberOfBalloons(String text) {
        int b, a, l, o, n;
        b = a = l = o = n = 0;
        for (char c : text.toCharArray()) {
            if (c == 'a')
                a++;
            else if (c == 'b')
                b++;
            else if (c == 'l')
                l++;
            else if (c == 'o')
                o++;
            else if (c == 'n')
                n++;
        }
        return
            Math.min(Math.min(
                Math.min(a, b), n), Math.min(l, o)/2);
    }
}
