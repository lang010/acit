/*
 * @lc app=leetcode id=6 lang=java
 *
 * [6] ZigZag Conversion
 *
 * https://leetcode.com/problems/zigzag-conversion/description/
 *
 * algorithms
 * Medium (37.36%)
 * Total Accepted:    518K
 * Total Submissions: 1.4M
 * Testcase Example:  '"PAYPALISHIRING"\n3'
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
 * of rows like this: (you may want to display this pattern in a fixed font for
 * better legibility)
 * 
 * 
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 
 * 
 * And then read line by line: "PAHNAPLSIIGYIR"
 * 
 * Write the code that will take a string and make this conversion given a
 * number of rows:
 * 
 * 
 * string convert(string s, int numRows);
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "A", numRows = 1
 * Output: "A"
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 1000
 * s consists of English letters (lower-case and upper-case), ',' and '.'.
 * 1 <= numRows <= 1000
 * 
 * 
 */
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        StringBuilder sb = new StringBuilder();
        int n = numRows - 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j*n <= s.length(); j++) {
                if (j%2 == 0 && j*n + i < s.length()) {
                    sb.append(s.charAt(j*n + i));
                } else if (j%2 == 1 && j*n + n - i < s.length()) {
                    sb.append(s.charAt(j*n + n - i));
                }
            }
        }
        String beg = "";
        for (int i = 0; i*n < s.length(); i++) {
            if (i%2 == 0)
                beg = beg + s.charAt(i*n);
            else
                sb.append(s.charAt(i*n));
        }
        return beg + sb.toString();
    }
}
