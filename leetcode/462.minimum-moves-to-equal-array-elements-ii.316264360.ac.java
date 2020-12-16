/*
 * @lc app=leetcode id=462 lang=java
 *
 * [462] Minimum Moves to Equal Array Elements II
 *
 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/description/
 *
 * algorithms
 * Medium (54.21%)
 * Total Accepted:    49.4K
 * Total Submissions: 91.1K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a non-empty integer array, find the minimum number of moves required
 * to make all array elements equal, where a move is incrementing a selected
 * element by 1 or decrementing a selected element by 1.
 * 
 * You may assume the array's length is at most 10,000.
 * 
 * Example:
 * 
 * Input:
 * [1,2,3]
 * 
 * Output:
 * 2
 * 
 * Explanation:
 * Only two moves are needed (remember each move increments or decrements one
 * element):
 * 
 * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 * 
 * 
 */
class Solution {
    public int minMoves2(int[] nums) {
        int m = median(nums);
        int ans = 0;
        for (int x : nums) {
            ans += Math.abs(x-m);
        }
        return ans;
    }
    
    int median(int[] nums) {
        int half = nums.length/2;
        int l = 0;
        int r = nums.length-1;
        while (l < r) {
            int t = l+1;
            for (int i = l+1; i <= r; i++) {
                if (nums[i] < nums[l]) {
                    int tmp = nums[t];
                    nums[t] = nums[i];
                    nums[i] = tmp;
                    t++;
                }
            }
            t--;
            int tmp = nums[t];
            nums[t] = nums[l];
            nums[l] = tmp;
            if (t == half) {
                return nums[t];
            } else if (t > half) {
                r = t-1;
            } else {
                l = t+1;
            }
        }
        return nums[l];
    }
}
