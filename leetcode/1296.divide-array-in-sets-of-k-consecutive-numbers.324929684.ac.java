/*
 * @lc app=leetcode id=1296 lang=java
 *
 * [1296] Divide Array in Sets of K Consecutive Numbers
 *
 * https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/description/
 *
 * algorithms
 * Medium (55.15%)
 * Total Accepted:    35K
 * Total Submissions: 63.4K
 * Testcase Example:  '[1,2,3,3,4,4,5,6]\n4'
 *
 * Given an array of integers nums and a positive integer k, find whether it's
 * possible to divide this array into sets of k consecutive numbers
 * Return True if its possible otherwise return False.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,2,3,3,4,4,5,6], k = 4
 * Output: true
 * Explanation: Array can be divided into [1,2,3,4] and [3,4,5,6].
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [3,2,1,2,3,4,3,4,5,9,10,11], k = 3
 * Output: true
 * Explanation: Array can be divided into [1,2,3] , [2,3,4] , [3,4,5] and
 * [9,10,11].
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [3,3,2,2,1,1], k = 3
 * Output: true
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: nums = [1,2,3,4], k = 3
 * Output: false
 * Explanation: Each array should be divided in subarrays of size 3.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^9
 * 1 <= k <= nums.length
 * 
 * Note: This question is the same as 846:
 * https://leetcode.com/problems/hand-of-straights/
 */
class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums)
            map.put(x, map.getOrDefault(x, 0)+1);
        while (!map.isEmpty()) {
            int st = map.keySet().iterator().next();
            while (map.containsKey(st-1))
                st--;
            while (map.containsKey(st)) {
                int t = 0;
                int pre = -1;
                int cur = map.get(st);
                while (t++ < k) {
                    int v = map.getOrDefault(st, 0);
                    if (v == cur)
                        map.remove(st);
                    else if (v > cur) {
                        map.put(st, v-cur);
                        if (pre < 0)
                            pre = st;
                    } else
                        return false;
                    st++;
                }
                if (pre > 0)
                    st = pre;
            }
        }
        return true;
    }
}
