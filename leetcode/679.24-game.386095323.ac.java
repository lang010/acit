/*
 * @lc app=leetcode id=679 lang=java
 *
 * [679] 24 Game
 *
 * https://leetcode.com/problems/24-game/description/
 *
 * algorithms
 * Hard (46.98%)
 * Total Accepted:    45.4K
 * Total Submissions: 96.7K
 * Testcase Example:  '[4,1,8,7]'
 *
 * 
 * You have 4 cards each containing a number from 1 to 9.  You need to judge
 * whether they could operated through *, /, +, -, (, ) to get the value of
 * 24.
 * 
 * 
 * Example 1:
 * 
 * Input: [4, 1, 8, 7]
 * Output: True
 * Explanation: (8-4) * (7-1) = 24
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: [1, 2, 1, 2]
 * Output: False
 * 
 * 
 * 
 * Note:
 * 
 * The division operator / represents real division, not integer division.  For
 * example, 4 / (1 - 2/3) = 12.
 * Every operation done is between two numbers.  In particular, we cannot use -
 * as a unary operator.  For example, with [1, 1, 1, 1] as input, the
 * expression -1 - 1 - 1 - 1 is not allowed.
 * You cannot concatenate numbers together.  For example, if the input is [1,
 * 2, 1, 2], we cannot write this as 12 + 12.
 * 
 * 
 * 
 */
class Solution {
    public boolean judgePoint24(int[] nums) {
        List<Double> ls = new ArrayList<>();
        for (int x : nums)
            ls.add((double)x);
        return dfs(ls);
    }
    
    boolean dfs(List<Double> ls) {
        if (ls.size() == 1)
            return Math.abs(ls.get(0)-24) < 1e-6;
        for (int i = 0; i < ls.size(); i++)
            for (int j = i+1; j < ls.size(); j++) {
                double x = ls.get(i);
                double y = ls.get(j);
                ls.remove(j);
                ls.remove(i);
                for (Double z : next(x, y)) {
                    ls.add(z);
                    if (dfs(ls))
                        return true;
                    ls.remove(ls.size()-1);
                }
                ls.add(i, x);
                ls.add(j, y);
            }
        
        return false;
    }
    
    List<Double> next(double x, double y) {
        List<Double> ls = new ArrayList<>();
        ls.add(x+y);
        ls.add(x*y);
        ls.add(x-y);
        ls.add(y-x);
        if (Math.abs(x) > 1e-6)
            ls.add(y/x);
        if (Math.abs(y) > 1e-6)
            ls.add(x/y);
        return ls;
    }
}
