/*
 * @lc app=leetcode id=846 lang=java
 *
 * [846] Hand of Straights
 *
 * https://leetcode.com/problems/hand-of-straights/description/
 *
 * algorithms
 * Medium (55.10%)
 * Total Accepted:    60.8K
 * Total Submissions: 110.4K
 * Testcase Example:  '[1,2,3,6,2,3,4,7,8]\n3'
 *
 * Alice has a hand of cards, given as an array of integers.
 * 
 * Now she wants to rearrange the cards into groups so that each group is size
 * W, and consists of W consecutive cards.
 * 
 * Return true if and only if she can.
 * 
 * Note: This question is the same as 1296:
 * https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: hand = [1,2,3,6,2,3,4,7,8], W = 3
 * Output: true
 * Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: hand = [1,2,3,4,5], W = 4
 * Output: false
 * Explanation: Alice's hand can't be rearranged into groups of 4.
 * 
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= hand.length <= 10000
 * 0 <= hand[i] <= 10^9
 * 1 <= W <= hand.length
 * 
 * 
 */
class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : hand) {
            map.put(x, map.getOrDefault(x, 0)+1);
        }
        while (!map.isEmpty()) {
            int st = map.keySet().iterator().next();
            while (map.containsKey(st-1))
                st--;
            while (map.containsKey(st)) {
                int cnt = map.get(st);
                int pre = -1;
                int w = W;
                while (w-- > 0) {
                    int curCnt = map.getOrDefault(st, 0);
                    if (curCnt < cnt)
                        return false;
                    if (curCnt == cnt) {
                        map.remove(st);
                    } else {
                        map.put(st, curCnt-cnt);
                        if (pre < 0)
                            pre = st;
                    }
                    st++;
                }
                if (pre >= 0) {
                    st = pre;
                }
            }
        }
        
        return true;
    }
}
