/*
 * @lc app=leetcode id=135 lang=java
 *
 * [135] Candy
 *
 * https://leetcode.com/problems/candy/description/
 *
 * algorithms
 * Hard (32.51%)
 * Total Accepted:    143.6K
 * Total Submissions: 441.7K
 * Testcase Example:  '[1,0,2]'
 *
 * There are N children standing in a line. Each child is assigned a rating
 * value.
 * 
 * You are giving candies to these children subjected to the following
 * requirements:
 * 
 * 
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * 
 * 
 * What is the minimum candies you must give?
 * 
 * Example 1:
 * 
 * 
 * Input: [1,0,2]
 * Output: 5
 * Explanation: You can allocate to the first, second and third child with 2,
 * 1, 2 candies respectively.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [1,2,2]
 * Output: 4
 * Explanation: You can allocate to the first, second and third child with 1,
 * 2, 1 candies respectively.
 * ⁠            The third child gets 1 candy because it satisfies the above two
 * conditions.
 * 
 * 
 */
class Solution {
    public int candy(int[] ratings) {
        int ans = 0;
        int n = ratings.length;
        int[] cnt = new int[n];
        for (int i = 0; i < n; i++)
            if (cnt[i] == 0)
                ans += set(ratings, cnt, i);
        return ans;
    }
    
    int set(int[] rate, int[] cnt, int x) {
        int ans = 0;
        cnt[x] = 1;
        if (x > 0 && rate[x-1] < rate[x]) {
            if (cnt[x-1] == 0)
                ans += set(rate, cnt, x-1);
            cnt[x] = Math.max(cnt[x-1]+1, cnt[x]);
        }
        if (x < rate.length-1 && rate[x+1] < rate[x]) {
            if (cnt[x+1] == 0)
                ans += set(rate, cnt, x+1);
            cnt[x] = Math.max(cnt[x+1]+1, cnt[x]);
        }
        return ans + cnt[x];
    }
}
