/*
 * @lc app=leetcode id=215 lang=java
 *
 * [215] Kth Largest Element in an Array
 *
 * https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 *
 * algorithms
 * Medium (57.15%)
 * Total Accepted:    759.2K
 * Total Submissions: 1.3M
 * Testcase Example:  '[3,2,1,5,6,4]\n2'
 *
 * Find the kth largest element in an unsorted array. Note that it is the kth
 * largest element in the sorted order, not the kth distinct element.
 * 
 * Example 1:
 * 
 * 
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * 
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 * 
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int l = 0, r = nums.length-1;
        k--;
        while (l <= r) {
            int m = partition(nums, l, r);
            if (m == k) {
                return nums[k];
            }
            if (m < k)
                l = m + 1;
            else
                r = m - 1;
        }
        return 0;
    }
    
    int partition(int[] nums, int l, int r) {
        if (l == r)
            return l;
        int b = l;
        int x = nums[b];
        l++;
        while (l <= r) {
            while (l <= r && nums[l] >= x)
                l++;
            while (l <= r && nums[r] <= x)
                r--;
            if (l < r)
                swap(nums, l, r);
        }
        swap(nums, b, --l);
        return l;
    }
    
    void swap(int[] nums, int x, int y) {
        int t = nums[x];
        nums[x] = nums[y];
        nums[y] = t;
    }
}
