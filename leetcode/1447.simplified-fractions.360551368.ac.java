/*
 * @lc app=leetcode id=1447 lang=java
 *
 * [1447] Simplified Fractions
 *
 * https://leetcode.com/problems/simplified-fractions/description/
 *
 * algorithms
 * Medium (61.68%)
 * Total Accepted:    13.2K
 * Total Submissions: 21.4K
 * Testcase Example:  '2\r'
 *
 * Given an integer n, return a list of all simplified fractions between 0 and
 * 1 (exclusive) such that the denominator is less-than-or-equal-to n. The
 * fractions can be in any order.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 2
 * Output: ["1/2"]
 * Explanation: "1/2" is the only unique fraction with a denominator
 * less-than-or-equal-to 2.
 * 
 * Example 2:
 * 
 * 
 * Input: n = 3
 * Output: ["1/2","1/3","2/3"]
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: n = 4
 * Output: ["1/2","1/3","1/4","2/3","3/4"]
 * Explanation: "2/4" is not a simplified fraction because it can be simplified
 * to "1/2".
 * 
 * Example 4:
 * 
 * 
 * Input: n = 1
 * Output: []
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 100
 * 
 */
class Solution {
    int[] f = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 57, 59, 61, 67, 71, 73, 79, 83, 89, 91, 97, 101 };
    public List<String> simplifiedFractions(int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 1; i < n; i++)
            for (int j = i+1; j <= n; j++)
                if (check(i, j))
                    ans.add(build(i, j));
        return ans;
    }
    
    boolean check(int x, int y) {
        for (int i = 0; f[i] <= x; i++)
            if (x%f[i] == 0 && y%f[i] == 0)
                return false;
        return true;
    }
    
    String build(int x, int y) {
        return String.format("%d/%d", x, y);
    }
}
