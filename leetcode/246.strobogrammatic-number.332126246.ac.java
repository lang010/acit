/*
 * @lc app=leetcode id=246 lang=java
 *
 * [246] Strobogrammatic Number
 *
 * https://leetcode.com/problems/strobogrammatic-number/description/
 *
 * algorithms
 * Easy (45.52%)
 * Total Accepted:    89.7K
 * Total Submissions: 197.1K
 * Testcase Example:  '"69"'
 *
 * A strobogrammatic number is a number that looks the same when rotated 180
 * degrees (looked at upside down).
 * 
 * Write a function to determine if a number is strobogrammatic. The number is
 * represented as a string.
 * 
 * 
 * Example 1:
 * Input: num = "69"
 * Output: true
 * Example 2:
 * Input: num = "88"
 * Output: true
 * Example 3:
 * Input: num = "962"
 * Output: false
 * Example 4:
 * Input: num = "1"
 * Output: true
 * 
 */
class Solution {
    public boolean isStrobogrammatic(String num) {
        StringBuilder sb = new StringBuilder();
        for (int i = num.length()-1; i >= 0; i--) {
            int t = num.charAt(i)-'0';
            switch (t) {
                case 0:
                case 1:
                case 8:
                    break;
                case 6:
                    t = 9;
                    break;
                case 9:
                    t = 6;
                    break;
                default:
                    return false;
            }
            sb.append(t);
        }
        return num.equals(sb.toString());
    }
}
