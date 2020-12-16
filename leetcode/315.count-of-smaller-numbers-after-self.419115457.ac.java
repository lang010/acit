/*
 * @lc app=leetcode id=315 lang=java
 *
 * [315] Count of Smaller Numbers After Self
 *
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/description/
 *
 * algorithms
 * Hard (42.40%)
 * Total Accepted:    151.7K
 * Total Submissions: 357.8K
 * Testcase Example:  '[5,2,6,1]'
 *
 * You are given an integer array nums and you have to return a new counts
 * array. The counts array has the property where counts[i] is the number of
 * smaller elements to the right of nums[i].
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [5,2,6,1]
 * Output: [2,1,1,0]
 * Explanation:
 * To the right of 5 there are 2 smaller elements (2 and 1).
 * To the right of 2 there is only 1 smaller element (1).
 * To the right of 6 there is 1 smaller element (1).
 * To the right of 1 there is 0 smaller element.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 
 * 
 */
class Solution {
    int[] c;
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        c = new int[20001];
        for (int i = n-1; i >= 0; i--) {
            ans.add(get(nums[i]-1+10000));
            update(nums[i]+10000);
        }
        int l = 0, r = n-1;
        while (l < r) {
            int t = ans.get(l);
            ans.set(l, ans.get(r));
            ans.set(r, t);
            l++;
            r--;
        }
        return ans;
    }
    
    int get(int x) {
        int ans = 0;
        while (x > 0) {
            ans += c[x];
            x -= x & -x;
        }
        return ans;
    }
    
    void update(int x) {
        while (x < 20001) {
            c[x] += 1;
            x += x & -x;
        }
    }
}
