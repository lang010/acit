/*
 * @lc app=leetcode id=171 lang=java
 *
 * [171] Excel Sheet Column Number
 *
 * https://leetcode.com/problems/excel-sheet-column-number/description/
 *
 * algorithms
 * Easy (56.61%)
 * Total Accepted:    350.2K
 * Total Submissions: 618.7K
 * Testcase Example:  '"A"'
 *
 * Given a column title as appear in an Excel sheet, return its corresponding
 * column number.
 * 
 * For example:
 * 
 * 
 * ⁠   A -> 1
 * ⁠   B -> 2
 * ⁠   C -> 3
 * ⁠   ...
 * ⁠   Z -> 26
 * ⁠   AA -> 27
 * ⁠   AB -> 28 
 * ⁠   ...
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: "A"
 * Output: 1
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "AB"
 * Output: 28
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "ZY"
 * Output: 701
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 7
 * s consists only of uppercase English letters.
 * s is between "A" and "FXSHRXW".
 * 
 * 
 */
class Solution {
    public int titleToNumber(String s) {
        int sum = 0;
        for (char c : s.toCharArray()) {
            sum = sum * 26 + c -'A' + 1;
        }
        return sum;
    }
}
