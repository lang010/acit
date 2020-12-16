/*
 * @lc app=leetcode id=89 lang=java
 *
 * [89] Gray Code
 *
 * https://leetcode.com/problems/gray-code/description/
 *
 * algorithms
 * Medium (49.86%)
 * Total Accepted:    171.4K
 * Total Submissions: 343.8K
 * Testcase Example:  '2'
 *
 * The gray code is a binary numeral system where two successive values differ
 * in only one bit.
 * 
 * Given a non-negative integer n representing the total number of bits in the
 * code, print the sequence of gray code. A gray code sequence must begin with
 * 0.
 * 
 * Example 1:
 * 
 * 
 * Input: 2
 * Output: [0,1,3,2]
 * Explanation:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * 
 * For a given n, a gray code sequence may not be uniquely defined.
 * For example, [0,2,3,1] is also a valid gray code sequence.
 * 
 * 00 - 0
 * 10 - 2
 * 11 - 3
 * 01 - 1
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 0
 * Output: [0]
 * Explanation: We define the gray code sequence to begin with 0.
 * A gray code sequence of n has size = 2^n, which for n = 0 the size is 2^0 =
 * 1.
 * Therefore, for n = 0 the gray code sequence is [0].
 * 
 * 
 */
class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        if (n == 0)
            return ans;
        ans.add(1);
        for (int i = 1; i < n; i++) {
            helper(ans, i);
        }
        return ans;
    }
    
    void helper(List<Integer> ans, int n) {
        int k = 1<<n;
        for (int i = ans.size()-1; i >= 0; i--)
            ans.add(ans.get(i) + k);
    }
}
