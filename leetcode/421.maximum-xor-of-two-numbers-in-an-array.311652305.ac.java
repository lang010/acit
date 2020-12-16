/*
 * @lc app=leetcode id=421 lang=java
 *
 * [421] Maximum XOR of Two Numbers in an Array
 *
 * https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/description/
 *
 * algorithms
 * Medium (53.69%)
 * Total Accepted:    75.2K
 * Total Submissions: 140K
 * Testcase Example:  '[3,10,5,25,2,8]'
 *
 * Given an integer array nums, return the maximum result of nums[i] XOR
 * nums[j], where 0 ≤ i ≤ j < n.
 * 
 * Follow up: Could you do this in O(n) runtime?
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [3,10,5,25,2,8]
 * Output: 28
 * Explanation: The maximum result is 5 XOR 25 = 28.
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [0]
 * Output: 0
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [2,4]
 * Output: 6
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: nums = [8,10,2]
 * Output: 10
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: nums = [14,70,53,83,49,91,36,80,92,51,66,70]
 * Output: 127
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 2 * 10^4
 * 0 <= nums[i] <= 2^31 - 1
 * 
 * 
 */
class Solution {
    static class Trie {
        int val;
        Trie left, right;
    }
    
    public int findMaximumXOR(int[] nums) {
        if (nums == null || nums.length < 1)
            return 0;
        Trie tree = build(nums);
        int max = 0;
        for (int x : nums) {
            int y = findXor(tree, x);
            if ((y ^ x) > max)
                max = y ^ x;
        }
        return max;
    }
    
    Trie build(int[] nums) {
        Trie head = new Trie();
        int N = 31;
        head.val = N;
        for (int x : nums) {
            Trie node = head;
            for (int i = N - 1; i >= 0; i--) {
                if ((x & (1 << i)) == 0) {
                    if (node.left == null) {
                        node.left = new Trie();
                        node.left.val = i - 1;
                    }
                    node = node.left;
                } else {
                    if (node.right == null) {
                        node.right = new Trie();
                        node.right.val = i - 1;
                    }
                    node = node.right;
                }
            }
            node.val = x;
        }
        while (head != null && head.val > 0) {
            int x = head.val;
            if (head.left == null) {
                head = head.right;
                continue;
            }
            if (head.right == null) {
                head = head.left;
                continue;
            }
            break;
        }
        
        return head;
    }
    
    int findXor(Trie head, int x) {
        if (head == null) {
            return 0;
        }
        while (head.left != null || head.right != null) {
            if (head.left == null) {
                head = head.right;
                continue;
            }
            if (head.right == null) {
                head = head.left;
                continue;
            }
            if ((x & (1 << head.val)) == 0)
                head = head.right;
            else
                head = head.left;
        }
        return head.val;
    }
}
