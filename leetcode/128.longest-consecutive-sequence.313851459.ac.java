/*
 * @lc app=leetcode id=128 lang=java
 *
 * [128] Longest Consecutive Sequence
 *
 * https://leetcode.com/problems/longest-consecutive-sequence/description/
 *
 * algorithms
 * Hard (45.84%)
 * Total Accepted:    353.5K
 * Total Submissions: 771.2K
 * Testcase Example:  '[100,4,200,1,3,2]'
 *
 * Given an unsorted array of integers nums, return the length of the longest
 * consecutive elements sequence.
 * 
 * Follow up: Could you implement the O(n) solution? 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4].
 * Therefore its length is 4.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= nums.length <= 10^4
 * -10^9 <= nums[i] <= 10^9
 * 
 * 
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        for (int x : nums)
            set.add(x);
        int max = 0;
        for (int x : nums) {
            if (visited.contains(x))
                continue;
            int len = 1;
            int l = x - 1, r = x + 1;
            while (set.contains(l)) {
                len++;
                visited.add(l);
                l--;
            }
            while (set.contains(r)) {
                len++;
                visited.add(r);
                r++;
            }
            if (max < len)
                max = len;
        }
        return max;
    }
}
