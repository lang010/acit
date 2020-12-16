/*
 * @lc app=leetcode id=166 lang=java
 *
 * [166] Fraction to Recurring Decimal
 *
 * https://leetcode.com/problems/fraction-to-recurring-decimal/description/
 *
 * algorithms
 * Medium (22.07%)
 * Total Accepted:    139.9K
 * Total Submissions: 634K
 * Testcase Example:  '1\n2'
 *
 * Given two integers representing the numerator and denominator of a fraction,
 * return the fraction in string format.
 * 
 * If the fractional part is repeating, enclose the repeating part in
 * parentheses.
 * 
 * If multiple answers are possible, return any of them.
 * 
 * It is guaranteed that the length of the answer string is less than 10^4 for
 * all the given inputs.
 * 
 * 
 * Example 1:
 * Input: numerator = 1, denominator = 2
 * Output: "0.5"
 * Example 2:
 * Input: numerator = 2, denominator = 1
 * Output: "2"
 * Example 3:
 * Input: numerator = 2, denominator = 3
 * Output: "0.(6)"
 * Example 4:
 * Input: numerator = 4, denominator = 333
 * Output: "0.(012)"
 * Example 5:
 * Input: numerator = 1, denominator = 5
 * Output: "0.2"
 * 
 * 
 * Constraints:
 * 
 * 
 * -2^31 <= numerator, denominator <= 2^31 - 1
 * denominator != 0
 * 
 * 
 */
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        long x = numerator;
        long y = denominator;
        if (x % y == 0)
            return String.valueOf(x/y);
        
        String prefix = "";

        if (x * y < 0) {
            prefix = "-";
        }
        x = Math.abs(x);
        y = Math.abs(y);
        StringBuilder ans = new StringBuilder(prefix + (x/y) + ".");
        
        long left = x % y;
        Map<Long, Long> map = new HashMap<>();
        List<Long> ls = new ArrayList<>();
        while (left > 0) {
            left *= 10;
            if (map.containsKey(left)) {
                left = map.get(left);
                break;
            }
            map.put(left, ls.size() + 1l);
            if (left > y) {
                ls.add(left/y);
                left %= y;
            } else {
                ls.add(0l);
            }
        }
        if (left == 0) {
            for (Long i : ls) {
                ans.append(i);
            }
        } else {
            for (long i = 0; i < left-1; i++) {
                ans.append(ls.get((int)i));
            }
            ans.append("(");
            for (long i = left-1; i < ls.size(); i++) {
                ans.append(ls.get((int)i));
            }
            ans.append(")");
        }
        
        return ans.toString();
    }
}
