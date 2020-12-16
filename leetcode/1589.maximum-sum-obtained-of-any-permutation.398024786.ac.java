/*
 * @lc app=leetcode id=1589 lang=java
 *
 * [1589] Maximum Sum Obtained of Any Permutation
 *
 * https://leetcode.com/problems/maximum-sum-obtained-of-any-permutation/description/
 *
 * algorithms
 * Medium (34.54%)
 * Total Accepted:    6.5K
 * Total Submissions: 18.8K
 * Testcase Example:  '[1,2,3,4,5]\n[[1,3],[0,1]]'
 *
 * We have an array of integers, nums, and an array of requests where
 * requests[i] = [starti, endi]. The i^th request asks for the sum of
 * nums[starti] + nums[starti + 1] + ... + nums[endi - 1] + nums[endi]. Both
 * starti and endi are 0-indexed.
 * 
 * Return the maximum total sum of all requests among all permutations of
 * nums.
 * 
 * Since the answer may be too large, return it modulo 10^9 + 7.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,2,3,4,5], requests = [[1,3],[0,1]]
 * Output: 19
 * Explanation: One permutation of nums is [2,1,3,4,5] with the following
 * result: 
 * requests[0] -> nums[1] + nums[2] + nums[3] = 1 + 3 + 4 = 8
 * requests[1] -> nums[0] + nums[1] = 2 + 1 = 3
 * Total sum: 8 + 3 = 11.
 * A permutation with a higher total sum is [3,5,4,2,1] with the following
 * result:
 * requests[0] -> nums[1] + nums[2] + nums[3] = 5 + 4 + 2 = 11
 * requests[1] -> nums[0] + nums[1] = 3 + 5  = 8
 * Total sum: 11 + 8 = 19, which is the best that you can do.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1,2,3,4,5,6], requests = [[0,1]]
 * Output: 11
 * Explanation: A permutation with the max total sum is [6,5,4,3,2,1] with
 * request sums [11].
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [1,2,3,4,5,10], requests = [[0,2],[1,3],[1,1]]
 * Output: 47
 * Explanation: A permutation with the max total sum is [4,10,5,3,2,1] with
 * request sums [19,18,10].
 * 
 * 
 * Constraints:
 * 
 * 
 * n == nums.length
 * 1 <= n <= 10^5
 * 0 <= nums[i] <= 10^5
 * 1 <= requests.length <= 10^5
 * requests[i].length == 2
 * 0 <= starti <= endi < n
 * 
 * 
 */
class Solution {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int n = nums.length;
        int[] cnt = new int[n+1];
        for (int[] r : requests) {
            cnt[r[0]]++;
            cnt[r[1]+1]--;
        }
        
        for (int i = 1; i < n; i++)
            cnt[i] += cnt[i-1];
        Arrays.sort(cnt);
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < n; i++)
            ans = (ans + cnt[i+1]*nums[i])% 1000000007;
        
        return ans;
    }
}
