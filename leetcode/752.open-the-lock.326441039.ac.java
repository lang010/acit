/*
 * @lc app=leetcode id=752 lang=java
 *
 * [752] Open the Lock
 *
 * https://leetcode.com/problems/open-the-lock/description/
 *
 * algorithms
 * Medium (52.38%)
 * Total Accepted:    79K
 * Total Submissions: 150.7K
 * Testcase Example:  '["0201","0101","0102","1212","2002"]\n"0202"'
 *
 * You have a lock in front of you with 4 circular wheels. Each wheel has 10
 * slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can
 * rotate freely and wrap around: for example we can turn '9' to be '0', or '0'
 * to be '9'. Each move consists of turning one wheel one slot.
 * 
 * The lock initially starts at '0000', a string representing the state of the
 * 4 wheels.
 * 
 * You are given a list of deadends dead ends, meaning if the lock displays any
 * of these codes, the wheels of the lock will stop turning and you will be
 * unable to open it.
 * 
 * Given a target representing the value of the wheels that will unlock the
 * lock, return the minimum total number of turns required to open the lock, or
 * -1 if it is impossible.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * Output: 6
 * Explanation:
 * A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" ->
 * "1201" -> "1202" -> "0202".
 * Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202"
 * would be invalid,
 * because the wheels of the lock become stuck after the display becomes the
 * dead end "0102".
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: deadends = ["8888"], target = "0009"
 * Output: 1
 * Explanation:
 * We can turn the last wheel in reverse to move from "0000" -> "0009".
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"],
 * target = "8888"
 * Output: -1
 * Explanation:
 * We can't reach the target without getting stuck.
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: deadends = ["0000"], target = "8888"
 * Output: -1
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= deadends.length <= 500
 * deadends[i].length == 4
 * target.length == 4
 * target will not be in the list deadends.
 * target and deadends[i] consist of digits only.
 * 
 * 
 */
class Solution {
    public int openLock(String[] deadends, String target) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (String s : deadends) {
            set.add(convert(s));
        }
        if (set.contains(0))
            return -1;
        int tar = convert(target);
        if (tar == 0)
            return 0;
        Deque<Integer> queue = new ArrayDeque<>();
        map.put(0, 0);
        queue.offer(0);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int turn = map.get(cur) + 1;
            for (int i = 0; i < 8; i++) {
                int next = next(cur, i);
                if (next == tar)
                    return turn;
                if (!set.contains(next) && !map.containsKey(next)) {
                    map.put(next, turn);
                    queue.offer(next);
                }
            }
        }
        return -1;
    }
    
    int convert(String s) {
        int ans = 0;
        for (char c : s.toCharArray()) {
            ans = ans*10 + c - '0';
        }
        return ans;
    }
    
    int next(int cur, int turn) {
        int p = turn/2;
        int dx = (int) Math.pow(10, p);
        int val = cur/dx % 10;
        if (turn%2 == 0) {
            if (val == 9) {
                return cur - 9 * dx;
            } else
                return cur + dx;
        } else {
            if (val == 0)
                return cur + 9 * dx;
            else
                return cur - dx;
        }
    }
}
