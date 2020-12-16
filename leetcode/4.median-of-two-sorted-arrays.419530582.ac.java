/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 *
 * algorithms
 * Hard (30.53%)
 * Total Accepted:    808.3K
 * Total Submissions: 2.6M
 * Testcase Example:  '[1,3]\n[2]'
 *
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return
 * the median of the two sorted arrays.
 * 
 * Follow up: The overall run time complexity should be O(log (m+n)).
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums1 = [0,0], nums2 = [0,0]
 * Output: 0.00000
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: nums1 = [], nums2 = [1]
 * Output: 1.00000
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: nums1 = [2], nums2 = []
 * Output: 2.00000
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -10^6 <= nums1[i], nums2[i] <= 10^6
 * 
 * 
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if (n < m)
            return findMedianSortedArrays(nums2, nums1);
        if (m == 0)
            return n%2 == 1 ? nums1[n/2] : (nums1[n/2-1] + nums1[n/2])/2.0;
        int v = (n+m-1)/2;
        int l = 0, r = n-1;
        while (l <= r) {
            int i = (l+r)/2;
            int j = v - i;
            if (j < 0 || (j < m && i > 0 && nums2[j] < nums1[i-1]))
                r = i-1;
            else if (j > m || (j > 0 && nums2[j-1] > nums1[i]))
                l = i+1;
            else {
                if ((m+n)%2 == 1) {
                    if (j >= 0 && j < m)
                        return Math.min(nums1[i], nums2[j]);
                    return nums1[i];
                }
                List<Integer> ls = new ArrayList<>();
                ls.add(nums1[i]);
                if (i+1 < n)
                    ls.add(nums1[i+1]);
                if (j >= 0 && j < m) {
                    ls.add(nums2[j]);
                    if (j+1 < m)
                        ls.add(nums2[j+1]);
                }
                Collections.sort(ls);
                return (ls.get(0) + ls.get(1))/2.0;
            }
        }
        return 0;
    }
    
    // O(n)
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if (n == 0) {
            return m%2 == 1 ? nums2[m/2] : (nums2[m/2] + nums2[m/2-1])/2.0;
        }
        if (m == 0)
            return n%2 == 1 ? nums1[n/2] : (nums1[n/2] + nums1[n/2-1])/2.0;
        int i = 0;
        int j = 0;
        int l = 0, r = 0;
        int cnt = (n+m)/2;
        while (cnt-- >= 0) {
            if (i < n && (j == m || nums1[i] <= nums2[j])) {
                l = r;
                r = nums1[i];
                i++;
            } else {
                l = r;
                r = nums2[j];
                j++;
            }
        }
        if ((n+m)%2 == 1)
            return r;
        return (l+r)/2.0;
    }
}
