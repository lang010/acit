/*
 * @lc app=leetcode id=360 lang=java
 *
 * [360] Sort Transformed Array
 *
 * https://leetcode.com/problems/sort-transformed-array/description/
 *
 * algorithms
 * Medium (49.40%)
 * Total Accepted:    37.3K
 * Total Submissions: 75.5K
 * Testcase Example:  '[-4,-2,2,4]\n1\n3\n5'
 *
 * Given a sorted array of integers nums and integer values a, b and c. Apply a
 * quadratic function of the form f(x) = ax^2 + bx + c to each element x in the
 * array.
 * 
 * The returned array must be in sorted order.
 * 
 * Expected time complexity: O(n)
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [-4,-2,2,4], a = 1, b = 3, c = 5
 * Output: [3,9,15,33]
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [-4,-2,2,4], a = -1, b = 3, c = 5
 * Output: [-23,-5,1,7]
 * 
 * 
 * 
 */
class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int l = 0, r = nums.length-1;
        int x = fun(a, b, c, nums[l]);
        int y = fun(a, b, c, nums[r]);
        int i = 0;
        int[] ans = new int[r+1];
        while (l <= r) {
            if (x < y) {
                ans[i++] = x;
                if (++l < nums.length)
                    x = fun(a, b, c, nums[l]);
            } else {
                ans[i++] = y;
                if (--r >= 0)
                    y = fun(a, b, c, nums[r]);
            }
        }
        if (a > 0) {
            l = 0;
            r = nums.length-1;
            while (l <= r) {
                int t = ans[l];
                ans[l] = -ans[r];
                ans[r] = -t;
                l++;
                r--;
            }
        }
        return ans;
    }
    
    int fun(int a, int b, int c, int x) {
        int v = a*x*x + b*x + c;
        return a > 0 ? -v : v;
    }
}
