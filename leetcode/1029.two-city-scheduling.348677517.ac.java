/*
 * @lc app=leetcode id=1029 lang=java
 *
 * [1029] Two City Scheduling
 *
 * https://leetcode.com/problems/two-city-scheduling/description/
 *
 * algorithms
 * Medium (57.35%)
 * Total Accepted:    102.6K
 * Total Submissions: 178.8K
 * Testcase Example:  '[[10,20],[30,200],[400,50],[30,20]]'
 *
 * A company is planning to interview 2n people. Given the array costs where
 * costs[i] = [aCosti, bCosti], the cost of flying the i^th person to city a is
 * aCosti, and the cost of flying the i^th person to city b is bCosti.
 * 
 * Return the minimum cost to fly every person to a city such that exactly n
 * people arrive in each city.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: costs = [[10,20],[30,200],[400,50],[30,20]]
 * Output: 110
 * Explanation: 
 * The first person goes to city A for a cost of 10.
 * The second person goes to city A for a cost of 30.
 * The third person goes to city B for a cost of 50.
 * The fourth person goes to city B for a cost of 20.
 * 
 * The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people
 * interviewing in each city.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: costs = [[259,770],[448,54],[926,667],[184,139],[840,118],[577,469]]
 * Output: 1859
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: costs =
 * [[515,563],[451,713],[537,709],[343,819],[855,779],[457,60],[650,359],[631,42]]
 * Output: 3086
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 2 * n == costs.length
 * 2 <= costs.length <= 100
 * costs.length is even.
 * 1 <= aCosti, bCosti <= 1000
 * 
 * 
 */
class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length/2;
        int l = 0, r = n+n-1;
        while (l < r) {
            int ll = l+1;
            int rr = r;
            int val = costs[l][0]-costs[l][1];
            while (ll <= rr) {
                while (ll <= rr && costs[ll][0]-costs[ll][1] <= val)
                    ll++;
                while (ll <= rr && costs[rr][0]-costs[rr][1] >= val)
                    rr--;
                if (ll < rr) {
                    int[] tmp = costs[ll];
                    costs[ll] = costs[rr];
                    costs[rr] = tmp;
                }
            }
            if (l < rr) {
                int[] tmp = costs[l];
                costs[l] = costs[rr];
                costs[rr] = tmp;
            }
            if (rr == n || rr == n-1)
                break;
            if (rr > n)
                r = rr-1;
            else
                l = rr+1;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += costs[i][0];
            ans += costs[i+n][1];
        }
        return ans;
    }
}
