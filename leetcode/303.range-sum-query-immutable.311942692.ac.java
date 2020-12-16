/*
 * @lc app=leetcode id=303 lang=java
 *
 * [303] Range Sum Query - Immutable
 *
 * https://leetcode.com/problems/range-sum-query-immutable/description/
 *
 * algorithms
 * Easy (46.60%)
 * Total Accepted:    229.8K
 * Total Submissions: 493K
 * Testcase Example:  '["NumArray","sumRange","sumRange","sumRange"]\n' +
  '[[[-2,0,3,-5,2,-1]],[0,2],[2,5],[0,5]]'
 *
 * Given an integer array nums, find the sum of the elements between indices i
 * and j (i ≤ j), inclusive.
 * 
 * Implement the NumArray class:
 * 
 * 
 * NumArray(int[] nums) Initializes the object with the integer array nums.
 * int sumRange(int i, int j) Return the sum of the elements of the nums array
 * in the range [i, j] inclusive (i.e., sum(nums[i], nums[i + 1], ... ,
 * nums[j]))
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input
 * ["NumArray", "sumRange", "sumRange", "sumRange"]
 * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
 * Output
 * [null, 1, -1, -3]
 * 
 * Explanation
 * NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
 * numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
 * numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1)) 
 * numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= nums.length <= 10^4
 * -10^5 <= nums[i] <= 10^5
 * 0 <= i <= j < nums.length
 * At most 10^4 calls will be made to sumRange.
 * 
 * 
 */
class NumArray {
    int[] ls;

    public NumArray(int[] nums) {
        int n = nums.length;
        if (n < 1)
            return;
        ls = new int[n];
        ls[0] = nums[0];
        for (int i = 1; i < n; i++)
            ls[i] = ls[i-1] + nums[i];
    }
    
    public int sumRange(int i, int j) {
        if (ls == null)
            return 0;
        
        if (j >= ls.length)
            j = ls.length - 1;
        if (i <= 0)
            return ls[j];
        return ls[j] - ls[i-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
