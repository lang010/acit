/*
 * @lc app=leetcode id=306 lang=java
 *
 * [306] Additive Number
 *
 * https://leetcode.com/problems/additive-number/description/
 *
 * algorithms
 * Medium (29.50%)
 * Total Accepted:    55.2K
 * Total Submissions: 187.2K
 * Testcase Example:  '"112358"'
 *
 * Additive number is a string whose digits can form additive sequence.
 * 
 * A valid additive sequence should contain at least three numbers. Except for
 * the first two numbers, each subsequent number in the sequence must be the
 * sum of the preceding two.
 * 
 * Given a string containing only digits '0'-'9', write a function to determine
 * if it's an additive number.
 * 
 * Note: Numbers in the additive sequence cannot have leading zeros, so
 * sequence 1, 2, 03 or 1, 02, 3 is invalid.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: "112358"
 * Output: true
 * Explanation: The digits can form an additive sequence: 1, 1, 2, 3, 5,
 * 8. 
 * 1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "199100199"
 * Output: true
 * Explanation: The additive sequence is: 1, 99, 100, 199. 
 * 1 + 99 = 100, 99 + 100 = 199
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * num consists only of digits '0'-'9'.
 * 1 <= num.length <= 35
 * 
 * 
 * Follow up:
 * How would you handle overflow for very large input integers?
 * 
 */
class Solution {
    public boolean isAdditiveNumber(String num) {
        if (num.length() < 3)
            return false;
        long p1 = 0;
        for (int i = 0; i < num.length()/2; i++) {
            p1 = p1 * 10 + num.charAt(i) - '0';
            long p2 = 0;
            if (num.charAt(i+1) == '0') {
                if (helper(num, i+2, p1, 0))
                    return true;
                continue;
            }
            for (int j = i+1; j < num.length()-1; j++) {
                p2 = p2 * 10 + num.charAt(j) - '0';
                if (helper(num, j+1, p1, p2))
                    return true;
            }
            if (p1 == 0)
                break;
        }
        return false;
    }
    
    boolean helper(String s, int i, long p1, long p2) {
        if (i == s.length())
            return true;
        if (s.charAt(i) == '0') {
            if (p1 + p2 == 0)
                return helper(s, i+1, 0, 0);
            return false;
        }
        long val = 0;
        for (; i < s.length(); i++) {
            val = val * 10 + s.charAt(i) - '0';
            if (val > p1 + p2)
                return false;
            if (val == p1+p2)
                return helper(s, i+1, p2, val);
        }
        return false;
    }
}
