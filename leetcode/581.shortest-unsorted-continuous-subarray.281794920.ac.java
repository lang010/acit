/*
 * @lc app=leetcode id=581 lang=java
 *
 * [581] Shortest Unsorted Continuous Subarray
 *
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/description/
 *
 * algorithms
 * Medium (31.50%)
 * Total Accepted:    145.6K
 * Total Submissions: 462.2K
 * Testcase Example:  '[2,6,4,8,10,9,15]'
 *
 * Given an integer array nums, you need to find one continuous subarray that
 * if you only sort this subarray in ascending order, then the whole array will
 * be sorted in ascending order.
 * 
 * Return the shortest such subarray and output its length.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [2,6,4,8,10,9,15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make
 * the whole array sorted in ascending order.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1,2,3,4]
 * Output: 0
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [1]
 * Output: 0
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10^4
 * -10^5 <= nums[i] <= 10^5
 * 
 * 
 */
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int l = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[l]) {
                l = find(nums, l-1, nums[i]);
                if (l < 0)
                    break;
            } else if (l+1 == i) {
                l++;
            }
        }
        if (l == nums.length - 1) {
            return 0;
        }
        int r = nums.length -1;
        for (int i = nums.length -2; i >= 0; i--) {
            if (nums[i] > nums[r]) {
                r = findX(nums, r+1, nums[i]);
                if (r >= nums.length) {
                    break;
                }
            } else if (i+1 == r) {
                r--;
            }
        }
        return r - l - 1;
    }
    
    int find(int[] nums, int r, int x) {
        if (nums[0] > x) {
            return -1;
        }
        int l = 0;
        while (l < r) {
            int mid = (l+r)/2;
            if (nums[mid] > x) {
                r = mid - 1;
            } else if (l < mid) {
                l = mid;
            } else {
                if (nums[r] <= x) {
                    return r;
                } else {
                    break;
                }
            }
        }
        return l;
    }
    
    int findX(int[] nums, int l, int x) {
        if (nums[nums.length - 1] < x) {
            return nums.length;
        }
        int r = nums.length - 1;
        while (l < r) {
            int mid = (l+r)/2;
            if (nums[mid] < x) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return r;
    }
}
