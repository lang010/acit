/*
 * @lc app=leetcode id=163 lang=java
 *
 * [163] Missing Ranges
 *
 * https://leetcode.com/problems/missing-ranges/description/
 *
 * algorithms
 * Easy (26.08%)
 * Total Accepted:    105.5K
 * Total Submissions: 404.6K
 * Testcase Example:  '[0,1,3,50,75]\n0\n99'
 *
 * You are given an inclusive range [lower, upper] and a sorted unique integer
 * array nums, where all elements are in the inclusive range.
 * 
 * A number x is considered missing if x is in the range [lower, upper] and x
 * is not in nums.
 * 
 * Return the smallest sorted list of ranges that cover every missing number
 * exactly. That is, no element of nums is in any of the ranges, and each
 * missing number is in one of the ranges.
 * 
 * Each range [a,b] in the list should be output as:
 * 
 * 
 * "a->b" if a != b
 * "a" if a == b
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [0,1,3,50,75], lower = 0, upper = 99
 * Output: ["2","4->49","51->74","76->99"]
 * Explanation: The ranges are:
 * [2,2] --> "2"
 * [4,49] --> "4->49"
 * [51,74] --> "51->74"
 * [76,99] --> "76->99"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [], lower = 1, upper = 1
 * Output: ["1"]
 * Explanation: The only missing range is [1,1], which becomes "1".
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [], lower = -3, upper = -1
 * Output: ["-3->-1"]
 * Explanation: The only missing range is [-3,-1], which becomes "-3->-1".
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: nums = [-1], lower = -1, upper = -1
 * Output: []
 * Explanation: There are no missing ranges since there are no missing
 * numbers.
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: nums = [-1], lower = -2, upper = -1
 * Output: ["-2"]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * -10^9 <= lower <= upper <= 10^9
 * 0 <= nums.length <= 100
 * lower <= nums[i] <= upper
 * All the values of nums are unique.
 * 
 * 
 */
class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ans = new ArrayList<>();
        long l = lower;
        long u = upper;
        for (int x : nums) {
            if (l > u)
                break;
            if (x >= u) {
                add(ans, l, Math.min(x-1, u));
                l = x+1l;
                break;
            }
            if (x <= l) {
                l = Math.max(l, x+1l);
            } else {
                add(ans, l, x-1);
                l = x+1l;
            }
        }
        add(ans, l, u);
        
        return ans;
    }
    
    void add(List<String> ans, long l, long u) {
        if (l == u)
            ans.add(String.valueOf(l));
        else if (l < u)
            ans.add(l + "->" + u);
    }
}
