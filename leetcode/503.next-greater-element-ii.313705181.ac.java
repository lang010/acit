/*
 * @lc app=leetcode id=503 lang=java
 *
 * [503] Next Greater Element II
 *
 * https://leetcode.com/problems/next-greater-element-ii/description/
 *
 * algorithms
 * Medium (57.80%)
 * Total Accepted:    116K
 * Total Submissions: 200.7K
 * Testcase Example:  '[1,2,1]'
 *
 * 
 * Given a circular array (the next element of the last element is the first
 * element of the array), print the Next Greater Number for every element. The
 * Next Greater Number of a number x is the first greater number to its
 * traversing-order next in the array, which means you could search circularly
 * to find its next greater number. If it doesn't exist, output -1 for this
 * number.
 * 
 * 
 * Example 1:
 * 
 * Input: [1,2,1]
 * Output: [2,-1,2]
 * Explanation: The first 1's next greater number is 2; The number 2 can't find
 * next greater number; The second 1's next greater number needs to search
 * circularly, which is also 2.
 * 
 * 
 * 
 * Note:
 * The length of given array won't exceed 10000.
 * 
 */
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length < 1)
            return nums;
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        int maxI = 0;
        for (int i = 0; i < n; i++)
            if (nums[i] > nums[maxI])
                maxI = i;
        int id = maxI;
        int cnt = 0;
        while (cnt++ < n) {
            while (!stack.isEmpty() && nums[id] >= stack.peek()) {
                stack.pop();
            }
            if (stack.isEmpty())
                ans[id] = -1;
            else
                ans[id] = stack.peek();
            stack.push(nums[id]);
            if (--id < 0)
                id += n;
        }
        
        return ans;
    }
}
