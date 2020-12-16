/*
 * @lc app=leetcode id=506 lang=java
 *
 * [506] Relative Ranks
 *
 * https://leetcode.com/problems/relative-ranks/description/
 *
 * algorithms
 * Easy (50.92%)
 * Total Accepted:    58.4K
 * Total Submissions: 114.7K
 * Testcase Example:  '[5,4,3,2,1]'
 *
 * 
 * Given scores of N athletes, find their relative ranks and the people with
 * the top three highest scores, who will be awarded medals: "Gold Medal",
 * "Silver Medal" and "Bronze Medal".
 * 
 * Example 1:
 * 
 * Input: [5, 4, 3, 2, 1]
 * Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 * Explanation: The first three athletes got the top three highest scores, so
 * they got "Gold Medal", "Silver Medal" and "Bronze Medal". For the left two
 * athletes, you just need to output their relative ranks according to their
 * scores.
 * 
 * 
 * 
 * Note:
 * 
 * N is a positive integer and won't exceed 10,000.
 * All the scores of athletes are guaranteed to be unique.
 * 
 * 
 * 
 */
class Solution {
    public String[] findRelativeRanks(int[] nums) {
        int n = nums.length;
        String[] ans = new String[n];
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>((a, b) -> b-a);
        for (int i = 0; i < n; i++)
            map.put(nums[i], i);
        int r = 1;
        for (int i : map.keySet()) {
            int id = map.get(i);
            if (r == 1)
                ans[id] = "Gold Medal";
            else if (r == 2)
                ans[id] = "Silver Medal";
            else if (r == 3)
                ans[id] = "Bronze Medal";
            else
                ans[id] = String.valueOf(r);
            r++;
        }
        return ans;
    }
}
