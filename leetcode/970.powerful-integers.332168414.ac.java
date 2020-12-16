/*
 * @lc app=leetcode id=970 lang=java
 *
 * [970] Powerful Integers
 *
 * https://leetcode.com/problems/powerful-integers/description/
 *
 * algorithms
 * Easy (39.92%)
 * Total Accepted:    25.3K
 * Total Submissions: 63.3K
 * Testcase Example:  '2\n3\n10'
 *
 * Given two positive integers x and y, an integer is powerful if it is equal
 * to x^i + y^j for some integers i >= 0 and j >= 0.
 * 
 * Return a list of all powerful integers that have value less than or equal to
 * bound.
 * 
 * You may return the answer in any order.  In your answer, each value should
 * occur at most once.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: x = 2, y = 3, bound = 10
 * Output: [2,3,4,5,7,9,10]
 * Explanation: 
 * 2 = 2^0 + 3^0
 * 3 = 2^1 + 3^0
 * 4 = 2^0 + 3^1
 * 5 = 2^1 + 3^1
 * 7 = 2^2 + 3^1
 * 9 = 2^3 + 3^0
 * 10 = 2^0 + 3^2
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: x = 3, y = 5, bound = 15
 * Output: [2,4,6,8,10,14]
 * 
 * 
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= x <= 100
 * 1 <= y <= 100
 * 0 <= bound <= 10^6
 * 
 */
class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        List<Integer> ans = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        List<Integer> xl = create(x, bound);
        List<Integer> yl = create(y, bound);
        for (int i : xl)
            for (int j : yl)
                if (i+j <= bound)
                    set.add(i+j);
                else
                    break;
        return new ArrayList<>(set);
    }
    
    List<Integer> create(int x, int bound) {
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        if (x == 1)
            return ans;
        int cur = x;
        while (cur < bound) {
            ans.add(cur);
            cur *= x;
        }
        return ans;
    }
}
