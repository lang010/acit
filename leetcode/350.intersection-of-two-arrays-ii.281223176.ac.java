/*
 * @lc app=leetcode id=350 lang=java
 *
 * [350] Intersection of Two Arrays II
 *
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
 *
 * algorithms
 * Easy (51.82%)
 * Total Accepted:    431.4K
 * Total Submissions: 832.5K
 * Testcase Example:  '[1,2,2,1]\n[2,2]'
 *
 * Given two arrays, write a function to compute their intersection.
 * 
 * Example 1:
 * 
 * 
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * 
 * 
 * Note:
 * 
 * 
 * Each element in the result should appear as many times as it shows in both
 * arrays.
 * The result can be in any order.
 * 
 * 
 * Follow up:
 * 
 * 
 * What if the given array is already sorted? How would you optimize your
 * algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is
 * better?
 * What if elements of nums2 are stored on disk, and the memory is limited such
 * that you cannot load all elements into the memory at once?
 * 
 * 
 */
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> maps = new HashMap<Integer, Integer>();
        for (int x : nums1) {
            int cnt = maps.getOrDefault(x, 0);
            maps.put(x, cnt+1);
        }
        
        List<Integer> ls = new ArrayList<>();
        for (int x : nums2) {
            int cnt = maps.getOrDefault(x, 0);
            if (cnt > 0) {
                maps.put(x, cnt-1);
                ls.add(x);
            }
        }
        int[] ret = new int[ls.size()];
        for (int i = 0; i < ls.size(); i++) {
            ret[i] = ls.get(i);
        }
        return ret;
    }
}
