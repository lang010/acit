/*
 * @lc app=leetcode id=825 lang=java
 *
 * [825] Friends Of Appropriate Ages
 *
 * https://leetcode.com/problems/friends-of-appropriate-ages/description/
 *
 * algorithms
 * Medium (43.66%)
 * Total Accepted:    42.7K
 * Total Submissions: 97.7K
 * Testcase Example:  '[16,16]'
 *
 * Some people will make friend requests. The list of their ages is given and
 * ages[i] is the age of the ith person. 
 * 
 * Person A will NOT friend request person B (B != A) if any of the following
 * conditions are true:
 * 
 * 
 * age[B] <= 0.5 * age[A] + 7
 * age[B] > age[A]
 * age[B] > 100 && age[A] < 100
 * 
 * 
 * Otherwise, A will friend request B.
 * 
 * Note that if A requests B, B does not necessarily request A.  Also, people
 * will not friend request themselves.
 * 
 * How many total friend requests are made?
 * 
 * Example 1:
 * 
 * 
 * Input: [16,16]
 * Output: 2
 * Explanation: 2 people friend request each other.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [16,17,18]
 * Output: 2
 * Explanation: Friend requests are made 17 -> 16, 18 -> 17.
 * 
 * Example 3:
 * 
 * 
 * Input: [20,30,100,110,120]
 * Output: 3
 * Explanation: Friend requests are made 110 -> 100, 120 -> 110, 120 ->
 * 100.
 * 
 * 
 * 
 * 
 * Notes:
 * 
 * 
 * 1 <= ages.length <= 20000.
 * 1 <= ages[i] <= 120.
 * 
 * 
 */
class Solution {
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int ans = 0;
        int l = 0, r = 1;
        int cnt = 0;
        while (r < ages.length) {
            while (l < r && ages[l] <= ages[r]/2 + 7)
                l++;
            ans += r-l;
            if (ages[r-1] == ages[r] && !(ages[r] <= ages[r]/2 + 7))
                cnt++;
            else
                cnt = 0;
            ans += cnt;
            r++;
        }
        return ans;
    }
}
