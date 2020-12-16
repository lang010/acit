/*
 * @lc app=leetcode id=475 lang=java
 *
 * [475] Heaters
 *
 * https://leetcode.com/problems/heaters/description/
 *
 * algorithms
 * Medium (33.44%)
 * Total Accepted:    70.3K
 * Total Submissions: 210.1K
 * Testcase Example:  '[1,2,3]\n[2]'
 *
 * Winter is coming! During the contest, your first job is to design a standard
 * heater with a fixed warm radius to warm all the houses.
 * 
 * Every house can be warmed, as long as the house is within the heater's warm
 * radius range. 
 * 
 * Given the positions of houses and heaters on a horizontal line, return the
 * minimum radius standard of heaters so that those heaters could cover all
 * houses.
 * 
 * Notice that all the heaters follow your radius standard, and the warm radius
 * will the same.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: houses = [1,2,3], heaters = [2]
 * Output: 1
 * Explanation: The only heater was placed in the position 2, and if we use the
 * radius 1 standard, then all the houses can be warmed.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: houses = [1,2,3,4], heaters = [1,4]
 * Output: 1
 * Explanation: The two heater was placed in the position 1 and 4. We need to
 * use radius 1 standard, then all the houses can be warmed.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: houses = [1,5], heaters = [2]
 * Output: 3
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= houses.length, heaters.length <= 3 * 10^4
 * 1 <= houses[i], heaters[i] <= 10^9
 * 
 * 
 */
class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        int ans = 0;
        int cur = 0;
        Arrays.sort(houses);
        Arrays.sort(heaters);
        for (int x : houses) {
            if (x <= heaters[cur])
                ans = Math.max(ans, heaters[cur] - x);
            else {
                while (cur+1 < heaters.length && heaters[cur+1] <= x)
                    cur++;
                if (cur+1 == heaters.length)
                    ans = Math.max(ans, x-heaters[cur]);
                else {
                    int t1 = x-heaters[cur];
                    int t2 = heaters[cur+1]-x;
                    if (t2 <= t1) {
                        ans = Math.max(ans, t2);
                        cur++;
                    } else
                        ans = Math.max(ans, t1);
                }
            }
        }
        return ans;
    }
}
