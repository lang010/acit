/*
 * @lc app=leetcode id=659 lang=java
 *
 * [659] Split Array into Consecutive Subsequences
 *
 * https://leetcode.com/problems/split-array-into-consecutive-subsequences/description/
 *
 * algorithms
 * Medium (44.13%)
 * Total Accepted:    53.3K
 * Total Submissions: 120.7K
 * Testcase Example:  '[1,2,3,3,4,5]'
 *
 * Given an array nums sorted in ascending order, return true if and only if
 * you can split it into 1 or more subsequences such that each subsequence
 * consists of consecutive integers and has length at least 3.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [1,2,3,3,4,5]
 * Output: True
 * Explanation:
 * You can split them into two consecutive subsequences : 
 * 1, 2, 3
 * 3, 4, 5
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [1,2,3,3,4,4,5,5]
 * Output: True
 * Explanation:
 * You can split them into two consecutive subsequences : 
 * 1, 2, 3, 4, 5
 * 3, 4, 5
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: [1,2,3,4,4,5]
 * Output: False
 * 
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10000
 * 
 * 
 * 
 * 
 */
class Solution {
    public boolean isPossible(int[] nums) {
        if (nums == null || nums.length < 3)
            return false;
        Deque<Integer> queue = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int cnt = 1;
        int preCnt = 0;
        for (int i = 0; i < n; i++) {
            if (i+1 < n && nums[i] == nums[i+1]) {
                cnt++;
                continue;
            }
            if (cnt < preCnt) {
                int dx = preCnt - cnt;
                while (dx > 0) {
                    int st = queue.peek();
                    if (nums[i]-st < 3)
                        return false;
                    dx -= map.get(st);
                    if (dx < 0) {
                        map.put(st, -dx);
                    } else {
                        map.remove(st);
                        queue.poll();
                    }
                }
            }
            if (i+1 < n && nums[i]+1 == nums[i+1]) {
                if (cnt > preCnt) {
                    queue.offer(nums[i]);
                    map.put(nums[i], cnt - preCnt);
                }
                preCnt = cnt;
                cnt = 1;
            } else {
                if (cnt > preCnt)
                    return false;
                while (cnt > 0 && !queue.isEmpty()) {
                    int st = queue.pop();
                    if (nums[i] - st < 2 || cnt < map.get(st))
                        return false;
                    cnt -= map.get(st);
                }
                if (cnt != 0 || !queue.isEmpty())
                    return false;
                preCnt = 0;
                cnt = 1;
            }
        }
        return true;
    }
}
