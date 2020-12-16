/*
 * @lc app=leetcode id=592 lang=java
 *
 * [592] Fraction Addition and Subtraction
 *
 * https://leetcode.com/problems/fraction-addition-and-subtraction/description/
 *
 * algorithms
 * Medium (49.86%)
 * Total Accepted:    20.4K
 * Total Submissions: 40.9K
 * Testcase Example:  '"-1/2+1/2"'
 *
 * Given a string representing an expression of fraction addition and
 * subtraction, you need to return the calculation result in string format. The
 * final result should be irreducible fraction. If your final result is an
 * integer, say 2, you need to change it to the format of fraction that has
 * denominator 1. So in this case, 2 should be converted to 2/1.
 * 
 * Example 1:
 * 
 * Input:"-1/2+1/2"
 * Output: "0/1"
 * 
 * 
 * 
 * Example 2:
 * 
 * Input:"-1/2+1/2+1/3"
 * Output: "1/3"
 * 
 * 
 * 
 * Example 3:
 * 
 * Input:"1/3-1/2"
 * Output: "-1/6"
 * 
 * 
 * 
 * Example 4:
 * 
 * Input:"5/3+1/3"
 * Output: "2/1"
 * 
 * 
 * 
 * Note:
 * 
 * The input string only contains '0' to '9', '/', '+' and '-'. So does the
 * output.
 * Each fraction (input and output) has format ±numerator/denominator. If the
 * first input fraction or the output is positive, then '+' will be omitted.
 * The input only contains valid irreducible fractions, where the numerator and
 * denominator of each fraction will always be in the range [1,10]. If the
 * denominator is 1, it means this fraction is actually an integer in a
 * fraction format defined above. 
 * The number of given fractions will be in the range [1,10].
 * The numerator and denominator of the final result are guaranteed to be valid
 * and in the range of 32-bit int.
 * 
 * 
 */
class Solution {
    public String fractionAddition(String expression) {
        int a = 0, b = 1;
        int n = expression.length();
        for (int i = 0; i < n; i++) {
            int c = 0, d = 0;
            boolean neg = false;
            if (expression.charAt(i) == '-') {
                neg = true;
                i++;
            }
            while (expression.charAt(i) != '/')
                c = c * 10 + expression.charAt(i++) - '0';
            i++;
            while (i < n) {
                char ch = expression.charAt(i);
                if (ch == '+') {
                    break;
                }
                if (ch == '-') {
                    i--;
                    break;
                }
                d = d * 10 + ch - '0';
                i++;
            }
            if (neg)
                c = -c;
            a = a * d + c * b;
            b = b*d;
            int gc = gcd(a, b);
            a /= gc;
            b /= gc;
        }
        
        return a + "/" + b;
    }
    
    int gcd(int x, int y) {
        if (x < 0)
            x = -x;
        if (x%y == 0)
            return y;
        return gcd(y, x%y);
    }
}
