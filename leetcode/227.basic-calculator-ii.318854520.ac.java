/*
 * @lc app=leetcode id=227 lang=java
 *
 * [227] Basic Calculator II
 *
 * https://leetcode.com/problems/basic-calculator-ii/description/
 *
 * algorithms
 * Medium (38.10%)
 * Total Accepted:    233.9K
 * Total Submissions: 614K
 * Testcase Example:  '"3+2*2"'
 *
 * Given a string s which represents an expression, evaluate this expression
 * and return its value. 
 * 
 * The integer division should truncate toward zero.
 * 
 * 
 * Example 1:
 * Input: s = "3+2*2"
 * Output: 7
 * Example 2:
 * Input: s = " 3/2 "
 * Output: 1
 * Example 3:
 * Input: s = " 3+5 / 2 "
 * Output: 5
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 3 * 10^5
 * s consists of integers and operators ('+', '-', '*', '/') separated by some
 * number of spaces.
 * s represents a valid expression.
 * All the integers in the expression are non-negative integers in the range
 * [0, 2^31 - 1].
 * The answer is guaranteed to fit in a 32-bit integer.
 * 
 * 
 */
class Solution {
    public int calculate(String s) {
        int pre0, pre1, cur, id;
        char preOp, op;
        preOp = op = '#';
        pre0 = pre1 = cur = 0;
        id = 0;
        while (id < s.length()) {
            char c = s.charAt(id++);
            if (c == ' ')
                continue;
            // Key part is to check the operators.
            if (c == '-' || c == '+') {
                if (preOp != '#')
                    pre0 = calc(pre0, pre1, preOp);
                preOp = c;
            } else if (c == '*' || c == '/') {
                if (preOp == '#')
                    preOp = c;
                else
                    op = c;
            } else if (c >= '0' && c <= '9') {
                cur = c - '0';
                while (id < s.length()) {
                    c = s.charAt(id++);
                    if (c >= '0' && c <= '9')
                        cur = cur*10 + c - '0';
                    else {
                        id--;
                        break;
                    }
                }
                if (op != '#') {
                    pre1 = calc(pre1, cur, op);
                    op = '#';
                } else if (preOp == '/' || preOp == '*') {
                    pre0 = calc(pre0, cur, preOp);
                    preOp = '#';
                } else if (preOp == '-' || preOp == '+') {
                    pre1 = cur;
                } else {
                    pre0  = cur;
                }
            }
        }
        if (preOp != '#')
            return calc(pre0, pre1, preOp);
        return pre0;
    }
    
    int calc(int x, int y, char op) {
        switch (op) {
            case '+':
                return x+y;
            case '-':
                return x-y;
            case '*':
                return x*y;
            case '/':
                return x/y;
        }
        return 0;
    }
}
