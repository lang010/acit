/*
 * @lc app=leetcode id=1611 lang=java
 *
 * [1611] Minimum One Bit Operations to Make Integers Zero
 *
 * https://leetcode.com/problems/minimum-one-bit-operations-to-make-integers-zero/description/
 *
 * algorithms
 * Hard (56.87%)
 * Total Accepted:    3.1K
 * Total Submissions: 5.5K
 * Testcase Example:  '0'
 *
 * Given an integer n, you must transform it into 0 using the following
 * operations any number of times:
 * 
 * 
 * Change the rightmost (0^th) bit in the binary representation of n.
 * Change the i^th bit in the binary representation of n if the (i-1)^th bit is
 * set to 1 and the (i-2)^th through 0^th bits are set to 0.
 * 
 * 
 * Return the minimum number of operations to transform n into 0.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 0
 * Output: 0
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 3
 * Output: 2
 * Explanation: The binary representation of 3 is "11".
 * "11" -> "01" with the 2nd operation since the 0th bit is 1.
 * "01" -> "00" with the 1st operation.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: n = 6
 * Output: 4
 * Explanation: The binary representation of 6 is "110".
 * "110" -> "010" with the 2nd operation since the 1st bit is 1 and 0th through
 * 0th bits are 0.
 * "010" -> "011" with the 1st operation.
 * "011" -> "001" with the 2nd operation since the 0th bit is 1.
 * "001" -> "000" with the 1st operation.
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: n = 9
 * Output: 14
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: n = 333
 * Output: 393
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= n <= 10^9
 * 
 * 
 */
class Solution {
    Map<String, Integer> map = new HashMap<>();
    public int minimumOneBitOperations(int n) {
        return cnt(n, 0);
    }
    
    int cnt(int from, int to) {
        int d = from ^ to;
        if (d < 2)
            return d;
        String key = from + ":" + to;
        if (map.containsKey(key))
            return map.get(key);
        int ans = 1;
        int mask = 0;
        int m = 0;
        while (d > 1) {
            mask = mask*2+1;
            d /= 2;
            m++;
        }
        m = 1 << (m-1);
        ans += cnt(from & mask, m) + cnt(m, to & mask);
        map.put(key, ans);
        return ans;
    }
}
