/*
 * @lc app=leetcode id=658 lang=java
 *
 * [658] Find K Closest Elements
 *
 * https://leetcode.com/problems/find-k-closest-elements/description/
 *
 * algorithms
 * Medium (41.57%)
 * Total Accepted:    128.5K
 * Total Submissions: 309.2K
 * Testcase Example:  '[1,2,3,4,5]\n4\n3'
 *
 * Given a sorted integer array arr, two integers k and x, return the k closest
 * integers to x in the array. The result should also be sorted in ascending
 * order.
 * 
 * An integer a is closer to x than an integer b if:
 * 
 * 
 * |a - x| < |b - x|, or
 * |a - x| == |b - x| and a < b
 * 
 * 
 * 
 * Example 1:
 * Input: arr = [1,2,3,4,5], k = 4, x = 3
 * Output: [1,2,3,4]
 * Example 2:
 * Input: arr = [1,2,3,4,5], k = 4, x = -1
 * Output: [1,2,3,4]
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= k <= arr.length
 * 1 <= arr.length <= 10^4
 * Absolute value of elements in the array and x will not exceed 10^4
 * 
 * 
 */
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = search(arr, x);
        int r = l + 1;
        int n = 0;
        List<Integer> ans = new ArrayList<>();
        while (n < k) {
            if (l >= 0 && r < arr.length) {
                if (Math.abs(arr[l] - x) <= Math.abs(arr[r] - x))
                    l--;
                else
                    r++;
            } else if (l >= 0) {
                l--;
            } else {
                r++;
            }
            n++;
        }
        for (int i = l+1; i < r; i++)
            ans.add(arr[i]);
        
        return ans;
    }
    
    int search(int[] arr, int x) {
        int l = 0;
        int r = arr.length - 1;
        while (l < r - 1) {
            int m = (l+r)/2;
            if (arr[m] == x)
                return m;
            if (arr[m] < x) {
                l = m;
            } else {
                r = m;
            }
        }
        if (Math.abs(arr[r] - x) < Math.abs(arr[l] - x))
            return r;
        return l;
    }
}
