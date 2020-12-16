/*
 * @lc app=leetcode id=1167 lang=java
 *
 * [1167] Minimum Cost to Connect Sticks
 *
 * https://leetcode.com/problems/minimum-cost-to-connect-sticks/description/
 *
 * algorithms
 * Medium (63.98%)
 * Total Accepted:    37.4K
 * Total Submissions: 58.5K
 * Testcase Example:  '[2,4,3]'
 *
 * You have some number of sticks with positive integer lengths. These lengths
 * are given as an array sticks, where sticks[i] is the length of the i^th
 * stick.
 * 
 * You can connect any two sticks of lengths x and y into one stick by paying a
 * cost of x + y. You must connect all the sticks until there is only one stick
 * remaining.
 * 
 * Return the minimum cost of connecting all the given sticks into one stick in
 * this way.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: sticks = [2,4,3]
 * Output: 14
 * Explanation: You start with sticks = [2,4,3].
 * 1. Combine sticks 2 and 3 for a cost of 2 + 3 = 5. Now you have sticks =
 * [5,4].
 * 2. Combine sticks 5 and 4 for a cost of 5 + 4 = 9. Now you have sticks =
 * [9].
 * There is only one stick left, so you are done. The total cost is 5 + 9 =
 * 14.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: sticks = [1,8,3,5]
 * Output: 30
 * Explanation: You start with sticks = [1,8,3,5].
 * 1. Combine sticks 1 and 3 for a cost of 1 + 3 = 4. Now you have sticks =
 * [4,8,5].
 * 2. Combine sticks 4 and 5 for a cost of 4 + 5 = 9. Now you have sticks =
 * [9,8].
 * 3. Combine sticks 9 and 8 for a cost of 9 + 8 = 17. Now you have sticks =
 * [17].
 * There is only one stick left, so you are done. The total cost is 4 + 9 + 17
 * = 30.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: sticks = [5]
 * Output: 0
 * Explanation: There is only one stick, so you don't need to do anything. The
 * total cost is 0.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= sticks.length <= 10^4
 * 1 <= sticks[i] <= 10^4
 * 
 * 
 */
class Solution {
    
    int[] ls;
    int l1, r1, l2, r2;
    
    public int connectSticks(int[] sticks) {
        if (sticks == null || sticks.length < 2)
            return 0;
        ls = sticks;
        Arrays.sort(ls);
        int ans = 0;
        l1 = 0; r1 = 0;
        l2 = 0; r2 = sticks.length;
        while (r2 != l2 || r1 - l1 != 1) {
            int first = getMin();
            int second = getMin();
            ans += first + second;
            ls[r1++] = first + second;
            
            if (r2 == l2 && r1 - l1 > 1) {
                l2 = l1;
                r2 = r1;
                l1 = 0;
                r1 = 0;
            }
        }

        return ans;
    }
    
    int getMin() {
        int ans = 0;
        if (r2 > l2 && r1 > l1) {
            if (ls[l1] < ls[l2]) {
                ans = ls[l1++];
            } else {
                ans = ls[l2++];
            }
        } else if (r1 > l1) {
            ans = ls[l1++];
        } else {
            ans = ls[l2++];
        }
        return ans;
    }
}
