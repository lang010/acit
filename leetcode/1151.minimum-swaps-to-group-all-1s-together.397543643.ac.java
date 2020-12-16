/*
 * @lc app=leetcode id=1151 lang=java
 *
 * [1151] Minimum Swaps to Group All 1's Together
 *
 * https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together/description/
 *
 * algorithms
 * Medium (58.27%)
 * Total Accepted:    7.9K
 * Total Submissions: 13.5K
 * Testcase Example:  '[1,0,1,0,1]'
 *
 * Given a binary array data, return the minimum number of swaps required to
 * group all 1’s present in the array together in any place in the array.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: data = [1,0,1,0,1]
 * Output: 1
 * Explanation: 
 * There are 3 ways to group all 1's together:
 * [1,1,1,0,0] using 1 swap.
 * [0,1,1,1,0] using 2 swaps.
 * [0,0,1,1,1] using 1 swap.
 * The minimum is 1.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: data = [0,0,0,1,0]
 * Output: 0
 * Explanation: 
 * Since there is only one 1 in the array, no swaps needed.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: data = [1,0,1,0,1,0,0,1,1,0,1]
 * Output: 3
 * Explanation: 
 * One possible solution that uses 3 swaps is [0,0,0,0,0,1,1,1,1,1,1].
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: data =
 * [1,0,1,0,1,0,1,1,1,0,1,0,0,1,1,1,0,0,1,1,1,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1]
 * Output: 8
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= data.length <= 10^5
 * data[i] is 0 or 1.
 * 
 * 
 */
class Solution {
    public int minSwaps(int[] data) {
        int n = data.length;
        for (int i = 1; i < n; i++)
            data[i] += data[i-1];
        int l = data[n-1];
        if (l == 0)
            return 0;
        int ans = l - data[l-1];
        for (int i = l; i < n; i++)
            ans = Math.min(ans, l - (data[i]-data[i-l]));
        return ans;
    }
}
