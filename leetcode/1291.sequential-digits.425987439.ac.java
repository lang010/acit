/*
 * @lc app=leetcode id=1291 lang=java
 *
 * [1291] Sequential Digits
 *
 * https://leetcode.com/problems/sequential-digits/description/
 *
 * algorithms
 * Medium (57.45%)
 * Total Accepted:    34.6K
 * Total Submissions: 60.2K
 * Testcase Example:  '100\n300'
 *
 * An integer has sequential digits if and only if each digit in the number is
 * one more than the previous digit.
 * 
 * Return a sorted list of all the integers in the range [low, high] inclusive
 * that have sequential digits.
 * 
 * 
 * Example 1:
 * Input: low = 100, high = 300
 * Output: [123,234]
 * Example 2:
 * Input: low = 1000, high = 13000
 * Output: [1234,2345,3456,4567,5678,6789,12345]
 * 
 * 
 * Constraints:
 * 
 * 
 * 10 <= low <= high <= 10^9
 * 
 * 
 */
class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i < 10; i++)
            queue.offer(i);
        while (!queue.isEmpty()) {
            int x = queue.poll();
            if (x >= low && x <= high)
                ans.add(x);
            if (x >= high || x < 0)
                break;
            int v = x%10+1;
            if (v < 10)
                queue.offer(x*10 + v);
        }
        return ans;
    }
}
