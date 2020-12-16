/*
 * @lc app=leetcode id=403 lang=java
 *
 * [403] Frog Jump
 *
 * https://leetcode.com/problems/frog-jump/description/
 *
 * algorithms
 * Hard (40.86%)
 * Total Accepted:    106.7K
 * Total Submissions: 261.2K
 * Testcase Example:  '[0,1,3,4,5,7,9,10,12]'
 *
 * A frog is crossing a river. The river is divided into x units and at each
 * unit there may or may not exist a stone. The frog can jump on a stone, but
 * it must not jump into the water.
 * 
 * Given a list of stones' positions (in units) in sorted ascending order,
 * determine if the frog is able to cross the river by landing on the last
 * stone. Initially, the frog is on the first stone and assume the first jump
 * must be 1 unit.
 * 
 * 
 * If the frog's last jump was k units, then its next jump must be either k -
 * 1, k, or k + 1 units. Note that the frog can only jump in the forward
 * direction.
 * 
 * Note:
 * 
 * The number of stones is ≥ 2 and is < 1,100.
 * Each stone's position will be a non-negative integer < 2^31.
 * The first stone's position is always 0.
 * 
 * 
 * 
 * Example 1:
 * 
 * [0,1,3,5,6,8,12,17]
 * 
 * There are a total of 8 stones.
 * The first stone at the 0th unit, second stone at the 1st unit,
 * third stone at the 3rd unit, and so on...
 * The last stone at the 17th unit.
 * 
 * Return true. The frog can jump to the last stone by jumping 
 * 1 unit to the 2nd stone, then 2 units to the 3rd stone, then 
 * 2 units to the 4th stone, then 3 units to the 6th stone, 
 * 4 units to the 7th stone, and 5 units to the 8th stone.
 * 
 * 
 * 
 * Example 2:
 * 
 * [0,1,2,3,4,8,9,11]
 * 
 * Return false. There is no way to jump to the last stone as 
 * the gap between the 5th and 6th stone is too large.
 * 
 * 
 */
class Solution {
    public boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int x : stones)
            map.put(x, new HashSet<>());
        if (map.containsKey(1))
            map.get(1).add(1);
        
        int n = stones.length;
        for (int x : stones) {
            for (int d : map.get(x)) {
                for (int i = d-1; i <= d+1; i++)
                    if (i > 0 && map.containsKey(x+i))
                        map.get(x+i).add(i);
            }
        }
        
        return map.get(stones[n-1]).size() > 0;
    }
}
