/*
 * @lc app=leetcode id=769 lang=java
 *
 * [769] Max Chunks To Make Sorted
 *
 * https://leetcode.com/problems/max-chunks-to-make-sorted/description/
 *
 * algorithms
 * Medium (55.31%)
 * Total Accepted:    43.2K
 * Total Submissions: 78.1K
 * Testcase Example:  '[4,3,2,1,0]'
 *
 * Given an array arr that is a permutation of [0, 1, ..., arr.length - 1], we
 * split the array into some number of "chunks" (partitions), and individually
 * sort each chunk.  After concatenating them, the result equals the sorted
 * array.
 * 
 * What is the most number of chunks we could have made?
 * 
 * Example 1:
 * 
 * 
 * Input: arr = [4,3,2,1,0]
 * Output: 1
 * Explanation:
 * Splitting into two or more chunks will not return the required result.
 * For example, splitting into [4, 3], [2, 1, 0] will result in [3, 4, 0, 1,
 * 2], which isn't sorted.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: arr = [1,0,2,3,4]
 * Output: 4
 * Explanation:
 * We can split into two chunks, such as [1, 0], [2, 3, 4].
 * However, splitting into [1, 0], [2], [3], [4] is the highest number of
 * chunks possible.
 * 
 * 
 * Note:
 * 
 * 
 * arr will have length in range [1, 10].
 * arr[i] will be a permutation of [0, 1, ..., arr.length - 1].
 * 
 * 
 * 
 * 
 */
class Solution {
    public int maxChunksToSorted(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int l = 0;
        int r = 0;
        int cur = 0;
        while (cur < arr.length) {
            if (arr[cur] > r)
                r = arr[cur];
            else if (arr[cur] < l) {
                while (!stack.isEmpty() && stack.peek() >= arr[cur]) {
                    stack.pop();
                }
                l = arr[cur];
            } else if (cur == r) {
                stack.push(r);
                l = cur+1;
                r = l;
            }
            cur++;
        }
        return stack.size();
    }
}
