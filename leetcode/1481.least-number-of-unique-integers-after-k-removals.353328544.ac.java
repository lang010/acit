/*
 * @lc app=leetcode id=1481 lang=java
 *
 * [1481] Least Number of Unique Integers after K Removals
 *
 * https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/description/
 *
 * algorithms
 * Medium (55.43%)
 * Total Accepted:    23.7K
 * Total Submissions: 42.8K
 * Testcase Example:  '[5,5,4]\n1'
 *
 * Given an array of integers arr and an integer k. Find the least number of
 * unique integers after removing exactly k elements.
 * 
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: arr = [5,5,4], k = 1
 * Output: 1
 * Explanation: Remove the single 4, only 5 is left.
 * 
 * Example 2:
 * 
 * 
 * Input: arr = [4,3,1,1,3,3,2], k = 3
 * Output: 2
 * Explanation: Remove 4, 2 and either one of the two 1s or three 3s. 1 and 3
 * will be left.
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= arr.length <= 10^5
 * 1 <= arr[i] <= 10^9
 * 0 <= k <= arr.length
 * 
 */
class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : arr)
            map.put(x, map.getOrDefault(x, 0) + 1);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> map.get(a)-map.get(b));
        for (Integer x : map.keySet())
            pq.offer(x);
        while (k > 0 && !pq.isEmpty()) {
            int x = pq.peek();
            if (map.get(x) <= k) {
                k -= map.get(x);
                pq.poll();
            } else
                break;
        }
        return pq.size();
    }
}
