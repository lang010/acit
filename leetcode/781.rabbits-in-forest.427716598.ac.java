/*
 * @lc app=leetcode id=781 lang=java
 *
 * [781] Rabbits in Forest
 *
 * https://leetcode.com/problems/rabbits-in-forest/description/
 *
 * algorithms
 * Medium (55.21%)
 * Total Accepted:    23.5K
 * Total Submissions: 42.5K
 * Testcase Example:  '[1,0,1,0,0]'
 *
 * In a forest, each rabbit has some color. Some subset of rabbits (possibly
 * all of them) tell you how many other rabbits have the same color as them.
 * Those answers are placed in an array.
 * 
 * Return the minimum number of rabbits that could be in the forest.
 * 
 * 
 * Examples:
 * Input: answers = [1, 1, 2]
 * Output: 5
 * Explanation:
 * The two rabbits that answered "1" could both be the same color, say red.
 * The rabbit than answered "2" can't be red or the answers would be
 * inconsistent.
 * Say the rabbit that answered "2" was blue.
 * Then there should be 2 other blue rabbits in the forest that didn't answer
 * into the array.
 * The smallest possible number of rabbits in the forest is therefore 5: 3 that
 * answered plus 2 that didn't.
 * 
 * Input: answers = [10, 10, 10]
 * Output: 11
 * 
 * Input: answers = []
 * Output: 0
 * 
 * 
 * Note:
 * 
 * 
 * answers will have length at most 1000.
 * Each answers[i] will be an integer in the range [0, 999].
 * 
 * 
 */
class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : answers)
            map.put(x, map.getOrDefault(x, 0)+1);
        int ans = 0;
        for (int k : map.keySet()) {
            int v = map.get(k);
            k++;
            ans += (v+k-1)/k * k;
        }
        return ans;
    }
}
