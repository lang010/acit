/*
 * @lc app=leetcode id=457 lang=java
 *
 * [457] Circular Array Loop
 *
 * https://leetcode.com/problems/circular-array-loop/description/
 *
 * algorithms
 * Medium (29.81%)
 * Total Accepted:    39.8K
 * Total Submissions: 133.6K
 * Testcase Example:  '[2,-1,1,2,2]'
 *
 * You are given a circular array nums of positive and negative integers. If a
 * number k at an index is positive, then move forward k steps. Conversely, if
 * it's negative (-k), move backward k steps. Since the array is circular, you
 * may assume that the last element's next element is the first element, and
 * the first element's previous element is the last element.
 * 
 * Determine if there is a loop (or a cycle) in nums. A cycle must start and
 * end at the same index and the cycle's length > 1. Furthermore, movements in
 * a cycle must all follow a single direction. In other words, a cycle must not
 * consist of both forward and backward movements.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [2,-1,1,2,2]
 * Output: true
 * Explanation: There is a cycle, from index 0 -> 2 -> 3 -> 0. The cycle's
 * length is 3.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [-1,2]
 * Output: false
 * Explanation: The movement from index 1 -> 1 -> 1 ... is not a cycle, because
 * the cycle's length is 1. By definition the cycle's length must be greater
 * than 1.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: [-2,1,-1,-2,-2]
 * Output: false
 * Explanation: The movement from index 1 -> 2 -> 1 -> ... is not a cycle,
 * because movement from index 1 -> 2 is a forward movement, but movement from
 * index 2 -> 1 is a backward movement. All movements in a cycle must follow a
 * single direction.
 * 
 * 
 * 
 * Note:
 * 
 * 
 * -1000 ≤ nums[i] ≤ 1000
 * nums[i] ≠ 0
 * 1 ≤ nums.length ≤ 5000
 * 
 * 
 * 
 * 
 * Follow up:
 * 
 * Could you solve it in O(n) time complexity and O(1) extra space complexity?
 */
class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] deads = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int j = (nums[i] + i)%n;
            j = j < 0 ? n+j : j;
            if (!map.containsKey(j))
                map.put(j, new HashSet<>());
            map.get(j).add(i);
            if (deads[i])
                continue;
            if (i == j || nums[i]*nums[j] < 0) {
                queue.offer(i);
                deads[i] = true;
                ans++;
            }
        }
        while (!queue.isEmpty()) {
            int x = queue.poll();
            if (!map.containsKey(x))
                continue;
            for (int y : map.get(x))
                if (!deads[y]) {
                    queue.offer(y);
                    deads[y] = true;
                    ans++;
                }
        }
        
        return ans != n;
    }
}
