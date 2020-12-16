/*
 * @lc app=leetcode id=1243 lang=java
 *
 * [1243] Array Transformation
 *
 * https://leetcode.com/problems/array-transformation/description/
 *
 * algorithms
 * Easy (50.55%)
 * Total Accepted:    7.3K
 * Total Submissions: 14.5K
 * Testcase Example:  '[6,2,3,4]\r'
 *
 * Given an initial array arr, every day you produce a new array using the
 * array of the previous day.
 * 
 * On the i-th day, you do the following operations on the array of day i-1 to
 * produce the array of day i:
 * 
 * 
 * If an element is smaller than both its left neighbor and its right neighbor,
 * then this element is incremented.
 * If an element is bigger than both its left neighbor and its right neighbor,
 * then this element is decremented.
 * The first and last elements never change.
 * 
 * 
 * After some days, the array does not change. Return that final array.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: arr = [6,2,3,4]
 * Output: [6,3,3,4]
 * Explanation: 
 * On the first day, the array is changed from [6,2,3,4] to [6,3,3,4].
 * No more operations can be done to this array.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: arr = [1,6,3,4,3,5]
 * Output: [1,4,4,4,4,5]
 * Explanation: 
 * On the first day, the array is changed from [1,6,3,4,3,5] to [1,5,4,3,4,5].
 * On the second day, the array is changed from [1,5,4,3,4,5] to [1,4,4,4,4,5].
 * No more operations can be done to this array.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 3 <= arr.length <= 100
 * 1 <= arr[i] <= 100
 * 
 * 
 */
class Solution {
    public List<Integer> transformArray(int[] arr) {
        int cnt = 0;
        do {
            cnt = 0;
            int pre = arr[0];
            for (int i = 1; i < arr.length-1; i++) {
                int d = 0;
                if (pre < arr[i] && arr[i] > arr[i+1])
                    d = -1;
                else if (pre > arr[i] && arr[i] < arr[i+1])
                    d = 1;
                pre = arr[i];
                arr[i] += d;
                if (d != 0)
                    cnt++;
            }
        } while (cnt > 0);
        List<Integer> ans = new ArrayList<>();
        for (int x : arr)
            ans.add(x);
        return ans;
    }
}
