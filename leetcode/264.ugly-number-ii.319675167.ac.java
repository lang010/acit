/*
 * @lc app=leetcode id=264 lang=java
 *
 * [264] Ugly Number II
 *
 * https://leetcode.com/problems/ugly-number-ii/description/
 *
 * algorithms
 * Medium (42.61%)
 * Total Accepted:    193.5K
 * Total Submissions: 454.1K
 * Testcase Example:  '10'
 *
 * Write a program to find the n-th ugly number.
 * 
 * Ugly numbers are positive numbers whose prime factors only include 2, 3,
 * 5. 
 * 
 * Example:
 * 
 * 
 * Input: n = 10
 * Output: 12
 * Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10
 * ugly numbers.
 * 
 * Note:  
 * 
 * 
 * 1 is typically treated as an ugly number.
 * n does not exceed 1690.
 * 
 */
class Solution {
    
    static List<Integer> ans = new ArrayList<>(2000);
    
    public Solution() {
        int n = 1691;
        int f2, f3, f5;
        f2 = f3 = f5 = 0;
        int v2 = 2;
        int v3 = 3;
        int v5 = 5;
        ans.add(1);
        while (ans.size() < n) {
            int last = ans.get(ans.size()-1);
            while (v2 <= last) {
                v2 = 2 * ans.get(++f2);
            }
            while (v3 <= last) {
                v3 = 3 * ans.get(++f3);
            }
            while (v5 <= last) {
                v5 = 5 * ans.get(++f5);
            }
            if (v2 <= v3 && v2 <= v5) {
                ans.add(v2);
            } else if (v3 <= v2 && v3 <= v5) {
                ans.add(v3);
            } else {
                ans.add(v5);
            }
        }
    }
    
    public int nthUglyNumber(int n) {
        return ans.get(n-1);
    }

}
