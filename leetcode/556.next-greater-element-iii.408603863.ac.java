/*
 * @lc app=leetcode id=556 lang=java
 *
 * [556] Next Greater Element III
 *
 * https://leetcode.com/problems/next-greater-element-iii/description/
 *
 * algorithms
 * Medium (32.00%)
 * Total Accepted:    48.8K
 * Total Submissions: 152.4K
 * Testcase Example:  '12'
 *
 * Given a positive integer n, find the smallest integer which has exactly the
 * same digits existing in the integer n and is greater in value than n. If no
 * such positive integer exists, return -1.
 * 
 * Note that the returned integer should fit in 32-bit integer, if there is a
 * valid answer but it does not fit in 32-bit integer, return -1.
 * 
 * 
 * Example 1:
 * Input: n = 12
 * Output: 21
 * Example 2:
 * Input: n = 21
 * Output: -1
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 2^31 - 1
 * 
 * 
 */
class Solution {
    public int nextGreaterElement(int n) {
        int x = n;
        List<Integer> ls = new ArrayList<>();
        while (x > 0) {
            int v = x%10;
            x /= 10;
            if (ls.size() > 0 && v < ls.get(ls.size()-1)) {
                for (int i = 0; i < ls.size(); i++)
                    if (v < ls.get(i)) {
                        x = x*10 + ls.get(i);
                        ls.set(i, v);
                        break;
                    }
                for (int t : ls)
                    x = x*10+t;
                return x > n ? x : -1;
            }
            ls.add(v);
        }
        return -1;
    }
}
