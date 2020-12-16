/*
 * @lc app=leetcode id=324 lang=java
 *
 * [324] Wiggle Sort II
 *
 * https://leetcode.com/problems/wiggle-sort-ii/description/
 *
 * algorithms
 * Medium (30.42%)
 * Total Accepted:    91.3K
 * Total Submissions: 300.1K
 * Testcase Example:  '[1,5,1,1,6,4]'
 *
 * Given an unsorted array nums, reorder it such that nums[0] < nums[1] >
 * nums[2] < nums[3]....
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1, 5, 1, 1, 6, 4]
 * Output: One possible answer is [1, 4, 1, 5, 1, 6].
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1, 3, 2, 2, 3, 1]
 * Output: One possible answer is [2, 3, 1, 3, 1, 2].
 * 
 * Note:
 * You may assume all input has valid answer.
 * 
 * Follow Up:
 * Can you do it in O(n) time and/or in-place with O(1) extra space?
 * 
 */
class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int[] arr = Arrays.copyOf(nums, nums.length);
        Arrays.sort(arr);
        int cur = 0;
        int r = n - 1;
        int l = r/2;
        while (l >= 0 || r > (n-1)/2) {
            if (l >= 0)
                nums[cur++] = arr[l--];
            if (r > (n-1)/2)
                nums[cur++] = arr[r--];
        }
    }
    
    int getK(int[] nums, int k) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int s = l+1;
            int b = r;
            while (s < b) {
                while (s < b && nums[s] <= nums[l])
                    s++;
                while (s < b && nums[b] > nums[l])
                    b--;
                swap(nums, s, b);
            }
            swap(nums, l, --s);
            if (s == k) {
                return nums[s];
            }
            if (s > k) {
                r = s-1;
            } else {
                l = s+1;
            }
        }
        return nums[l];
    }
    
    void swap(int[] nums, int l, int r) {
        if (l != r) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
        }
    }
}
