/*
 * @lc app=leetcode id=777 lang=java
 *
 * [777] Swap Adjacent in LR String
 *
 * https://leetcode.com/problems/swap-adjacent-in-lr-string/description/
 *
 * algorithms
 * Medium (35.30%)
 * Total Accepted:    33.1K
 * Total Submissions: 93.8K
 * Testcase Example:  '"RXXLRXRXL"\n"XRLXXRRLX"'
 *
 * In a string composed of 'L', 'R', and 'X' characters, like "RXXLRXRXL", a
 * move consists of either replacing one occurrence of "XL" with "LX", or
 * replacing one occurrence of "RX" with "XR". Given the starting string start
 * and the ending string end, return True if and only if there exists a
 * sequence of moves to transform one string to the other.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: start = "RXXLRXRXL", end = "XRLXXRRLX"
 * Output: true
 * Explanation: We can transform start to end following these steps:
 * RXXLRXRXL ->
 * XRXLRXRXL ->
 * XRLXRXRXL ->
 * XRLXXRRXL ->
 * XRLXXRRLX
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: start = "X", end = "L"
 * Output: false
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: start = "LLR", end = "RRL"
 * Output: false
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: start = "XL", end = "LX"
 * Output: true
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: start = "XLLR", end = "LXLX"
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= start.length <= 10^4
 * start.length == end.length
 * Both start and end will only consist of characters in 'L', 'R', and 'X'.
 * 
 * 
 */
class Solution {
    public boolean canTransform(String start, String end) {
        if (start.length() != end.length())
            return false;
        int n = start.length();
        int i = 0;
        int j = 0;
        while (i < n || j < n) {
            while (i < n && start.charAt(i) == 'X')
                i++;
            while (j < n && end.charAt(j) == 'X')
                j++;
            if (i == n && j == n)
                break;
            if (i < n && j < n && start.charAt(i) == end.charAt(j)) {
                if (start.charAt(i) == 'L' && i >= j
                   || start.charAt(i) == 'R' && i <= j) {
                    i++;
                    j++;
                } else
                    return false;
            } else
                return false;
        }
        return true;
    }
}
