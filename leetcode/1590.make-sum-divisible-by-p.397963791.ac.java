/*
 * @lc app=leetcode id=1590 lang=java
 *
 * [1590] Make Sum Divisible by P
 *
 * https://leetcode.com/problems/make-sum-divisible-by-p/description/
 *
 * algorithms
 * Medium (27.31%)
 * Total Accepted:    6.4K
 * Total Submissions: 23.3K
 * Testcase Example:  '[3,1,4,2]\n6'
 *
 * Given an array of positive integers nums, remove the smallest subarray
 * (possibly empty) such that the sum of the remaining elements is divisible by
 * p. It is not allowed to remove the whole array.
 * 
 * Return the length of the smallest subarray that you need to remove, or -1 if
 * it's impossible.
 * 
 * A subarray is defined as a contiguous block of elements in the array.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [3,1,4,2], p = 6
 * Output: 1
 * Explanation: The sum of the elements in nums is 10, which is not divisible
 * by 6. We can remove the subarray [4], and the sum of the remaining elements
 * is 6, which is divisible by 6.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [6,3,5,2], p = 9
 * Output: 2
 * Explanation: We cannot remove a single element to get a sum divisible by 9.
 * The best way is to remove the subarray [5,2], leaving us with [6,3] with sum
 * 9.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [1,2,3], p = 3
 * Output: 0
 * Explanation: Here the sum is 6. which is already divisible by 3. Thus we do
 * not need to remove anything.
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: nums = [1,2,3], p = 7
 * Output: -1
 * Explanation: There is no way to remove a subarray in order to get a sum
 * divisible by 7.
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: nums = [1000000000,1000000000,1000000000], p = 3
 * Output: 0
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^9
 * 1 <= p <= 10^9
 * 
 */
class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        int[] l = new int[n];
        int[] r = new int[n];
        l[0] = nums[0]%p;
        r[n-1] = nums[n-1]%p;
        for (int i = 1; i < n; i++)
            l[i] = (l[i-1]+nums[i])%p;
        for (int i = n-2; i >= 0; i--)
            r[i] = (r[i+1]+nums[i])%p;
        int ans = n;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (r[i]%p == 0)
                ans = Math.min(ans, i);
            if (l[i]%p == 0)
                ans = Math.min(ans, n-i-1);
            if (map.containsKey(p-r[i]))
                ans = Math.min(ans, i-map.get(p-r[i])-1);
            map.put(l[i], i);
        }
        return ans == n ? -1 : ans;
    }
}
