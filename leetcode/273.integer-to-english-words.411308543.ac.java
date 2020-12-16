/*
 * @lc app=leetcode id=273 lang=java
 *
 * [273] Integer to English Words
 *
 * https://leetcode.com/problems/integer-to-english-words/description/
 *
 * algorithms
 * Hard (27.77%)
 * Total Accepted:    207K
 * Total Submissions: 745.5K
 * Testcase Example:  '123'
 *
 * Convert a non-negative integer num to its English words representation.
 * 
 * 
 * Example 1:
 * Input: num = 123
 * Output: "One Hundred Twenty Three"
 * Example 2:
 * Input: num = 12345
 * Output: "Twelve Thousand Three Hundred Forty Five"
 * Example 3:
 * Input: num = 1234567
 * Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty
 * Seven"
 * Example 4:
 * Input: num = 1234567891
 * Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty
 * Seven Thousand Eight Hundred Ninety One"
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= num <= 2^31 - 1
 * 
 * 
 */
class Solution {
    String[] str = { "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
                    "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty"};
    String[] tens = { "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    int bil = 1000000000;
    int mil = 1000000;
    int tho = 1000;
    public String numberToWords(int num) {
        if (num < 21)
            return str[num];
        StringBuilder sb = new StringBuilder();
        if (num >= bil) {
            sb.append(str[num/bil] + " Billion ");
            num %= bil;
        }
        if (num >= mil) {
            thousand(sb, num/mil);
            sb.append("Million ");
            num %= mil;
        }
        if (num >= tho) {
            thousand(sb, num/tho);
            sb.append("Thousand ");
            num %= tho;
        }
        thousand(sb, num);
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
    
    void thousand(StringBuilder sb, int x) {
        if (x == 0)
            return;
        if (x >= 100) {
            sb.append(str[x/100] + " Hundred ");
            x %= 100;
        }
        if (x < 21) {
            if (x > 0)
                sb.append(str[x] + " ");
        } else {
            sb.append(tens[x/10] + " ");
            x %= 10;
            if (x > 0)
                sb.append(str[x] + " ");
        }
    }
}
