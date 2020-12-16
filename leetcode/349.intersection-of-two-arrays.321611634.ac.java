/*
 * @lc app=leetcode id=349 lang=java
 *
 * [349] Intersection of Two Arrays
 *
 * https://leetcode.com/problems/intersection-of-two-arrays/description/
 *
 * algorithms
 * Easy (64.05%)
 * Total Accepted:    423.9K
 * Total Submissions: 661.8K
 * Testcase Example:  '[1,2,2,1]\n[2,2]'
 *
 * Given two arrays, write a function to compute their intersection.
 * 
 * Example 1:
 * 
 * 
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * 
 * 
 * Note:
 * 
 * 
 * Each element in the result must be unique.
 * The result can be in any order.
 * 
 * 
 * 
 * 
 */
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> ans = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        for (int x : nums1)
            set.add(x);
        for (int x : nums2)
            if (set.contains(x))
                ans.add(x);
        int[] arr = new int[ans.size()];
        int i = 0;
        for (int x : ans)
            arr[i++] = x;
        return arr;
    }
}
