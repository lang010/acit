/*
 * @lc app=leetcode id=480 lang=java
 *
 * [480] Sliding Window Median
 *
 * https://leetcode.com/problems/sliding-window-median/description/
 *
 * algorithms
 * Hard (38.30%)
 * Total Accepted:    64.6K
 * Total Submissions: 168.7K
 * Testcase Example:  '[1,3,-1,-3,5,3,6,7]\n3'
 *
 * Median is the middle value in an ordered integer list. If the size of the
 * list is even, there is no middle value. So the median is the mean of the two
 * middle value.
 * Examples:
 * 
 * [2,3,4] , the median is 3
 * 
 * [2,3], the median is (2 + 3) / 2 = 2.5
 * 
 * Given an array nums, there is a sliding window of size k which is moving
 * from the very left of the array to the very right. You can only see the k
 * numbers in the window. Each time the sliding window moves right by one
 * position. Your job is to output the median array for each window in the
 * original array.
 * 
 * For example,
 * Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 * 
 * 
 * Window position                Median
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       1
 * ⁠1 [3  -1  -3] 5  3  6  7       -1
 * ⁠1  3 [-1  -3  5] 3  6  7       -1
 * ⁠1  3  -1 [-3  5  3] 6  7       3
 * ⁠1  3  -1  -3 [5  3  6] 7       5
 * ⁠1  3  -1  -3  5 [3  6  7]      6
 * 
 * 
 * Therefore, return the median sliding window as [1,-1,-1,3,5,6].
 * 
 * Note: 
 * You may assume k is always valid, ie: k is always smaller than input array's
 * size for non-empty array.
 * Answers within 10^-5 of the actual value will be accepted as correct.
 * 
 */
class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        TreeMap<Integer, Integer> left = new TreeMap<>();
        TreeMap<Integer, Integer> right = new TreeMap<>();
        int n = nums.length;
        double[] ans = new double[n-k+1];
        if (k == 1) {
            for (int i = 0; i < n; i++)
                ans[i] = nums[i];
            return ans;
        }
        for (int i = 0; i < k/2; i++)
            left.put(nums[i], left.getOrDefault(nums[i], 0) + 1);
        for (int i = k/2; i < k; i++)
            right.put(nums[i], right.getOrDefault(nums[i], 0) + 1);
        int t = 0;
        ans[t++] = balance(left, right, k);
        for (int i = k; i < n; i++) {
            if (left.containsKey(nums[i-k])) {
                replace(left, nums[i-k], nums[i]);
            } else {
                replace(right, nums[i-k], nums[i]);
            }
            ans[t++] = balance(left, right, k);
        }
        return ans;
    }
    
    void replace(Map<Integer, Integer> map, int x, int y) {
        int c = map.get(x);
        if (c == 1)
            map.remove(x);
        else
            map.put(x, c-1);
        map.put(y, map.getOrDefault(y, 0)+1);
    }
    
    double balance(TreeMap<Integer, Integer> left, TreeMap<Integer, Integer> right, int k) {
        while (true) {
            int l = left.lastKey();
            int r = right.firstKey();
            if (l <= r) {
                if (k%2 == 0)
                    return ((double)l+r)/2.0;
                return r;
            }
            replace(left, l, r);
            replace(right, r, l);
        }
    }
}
