/*
 * @lc app=leetcode id=930 lang=java
 *
 * [930] Binary Subarrays With Sum
 *
 * https://leetcode.com/problems/binary-subarrays-with-sum/description/
 *
 * algorithms
 * Medium (44.00%)
 * Total Accepted:    26.5K
 * Total Submissions: 60.3K
 * Testcase Example:  '[1,0,1,0,1]\n2'
 *
 * In an array A of 0s and 1s, how many non-empty subarrays have sum S?
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: A = [1,0,1,0,1], S = 2
 * Output: 4
 * Explanation: 
 * The 4 subarrays are bolded below:
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * A.length <= 30000
 * 0 <= S <= A.length
 * A[i] is either 0 or 1.
 * 
 */
class Solution {
    public int numSubarraysWithSum(int[] A, int S) {
        int ans = 0;
        int n = A.length;
        int[] cnt = new int[n+1];
        cnt[0] = 1;
        int sum = 0;
        for (int x : A) {
            sum += x;
            if (sum >= S)
                ans += cnt[sum - S];
            cnt[sum]++;
        }
        return ans;
    }
}
