/*
 * @lc app=leetcode id=526 lang=java
 *
 * [526] Beautiful Arrangement
 *
 * https://leetcode.com/problems/beautiful-arrangement/description/
 *
 * algorithms
 * Medium (59.50%)
 * Total Accepted:    59.4K
 * Total Submissions: 99.9K
 * Testcase Example:  '2'
 *
 * Suppose you have N integers from 1 to N. We define a beautiful arrangement
 * as an array that is constructed by these N numbers successfully if one of
 * the following is true for the ith position (1 <= i <= N) in this
 * array:
 * 
 * 
 * The number at the ith position is divisible by i.
 * i is divisible by the number at the ith position.
 * 
 * 
 * 
 * 
 * Now given N, how many beautiful arrangements can you construct?
 * 
 * Example 1:
 * 
 * 
 * Input: 2
 * Output: 2
 * Explanation: 
 * 
 * The first beautiful arrangement is [1, 2]:
 * 
 * Number at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).
 * 
 * Number at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).
 * 
 * The second beautiful arrangement is [2, 1]:
 * 
 * Number at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).
 * 
 * Number at the 2nd position (i=2) is 1, and i (i=2) is divisible by 1.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * N is a positive integer and will not exceed 15.
 * 
 * 
 * 
 * 
 */
class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public int countArrangement(int N) {
        return helper(N, 1, 0);
    }
    
    int helper(int n, int cur, int k) {
        if (n < cur)
            return 1;
        if (map.containsKey(k))
            return map.get(k);
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if ((k & (1<<i)) == 0 && (i%cur == 0 || cur%i == 0)) {
                ans += helper(n, cur+1, k | (1<<i));
            }
        }
        map.put(k, ans);
        return ans;
    }
}
