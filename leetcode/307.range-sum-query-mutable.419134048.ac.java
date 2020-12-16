/*
 * @lc app=leetcode id=307 lang=java
 *
 * [307] Range Sum Query - Mutable
 *
 * https://leetcode.com/problems/range-sum-query-mutable/description/
 *
 * algorithms
 * Medium (36.19%)
 * Total Accepted:    123.3K
 * Total Submissions: 340.8K
 * Testcase Example:  '["NumArray","sumRange","update","sumRange"]\n[[[1,3,5]],[0,2],[1,2],[0,2]]'
 *
 * Given an integer array nums, find the sum of the elements between indices i
 * and j (i ≤ j), inclusive.
 * 
 * The update(i, val) function modifies nums by updating the element at index i
 * to val.
 * 
 * Example:
 * 
 * 
 * Given nums = [1, 3, 5]
 * 
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The array is only modifiable by the update function.
 * You may assume the number of calls to update and sumRange function is
 * distributed evenly.
 * 0 <= i <= j <= nums.length - 1
 * 
 * 
 */
class NumArray {

    int[] bit;
    int[] arr;
    public NumArray(int[] nums) {
        int n = nums.length;
        bit = new int[n+1];
        arr = new int[n];
        for (int i = 0; i < n; i++)
            update(i, nums[i]);
    }
    
    public void update(int i, int val) {
        int diff = val - arr[i];
        arr[i] = val;
        i++;
        while (i < bit.length) {
            bit[i] += diff;
            i += i & -i;
        }
    }
    
    public int sumRange(int i, int j) {
        return get(j+1) - get(i);
    }
    
    int get(int x) {
        int ans = 0;
        while (x > 0) {
            ans += bit[x];
            x -= x & -x;
        }
        return ans;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
