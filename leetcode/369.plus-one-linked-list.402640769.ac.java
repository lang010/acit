/*
 * @lc app=leetcode id=369 lang=java
 *
 * [369] Plus One Linked List
 *
 * https://leetcode.com/problems/plus-one-linked-list/description/
 *
 * algorithms
 * Medium (58.76%)
 * Total Accepted:    51.9K
 * Total Submissions: 87.8K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a non-negative integer represented as a linked list of digits, plus
 * one to the integer.
 * 
 * The digits are stored such that the most significant digit is at the head of
 * the list.
 * 
 * 
 * Example 1:
 * Input: head = [1,2,3]
 * Output: [1,2,4]
 * Example 2:
 * Input: head = [0]
 * Output: [1]
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * The number represented by the linked list does not contain leading zeros
 * except for the zero itself. 
 * 
 * 
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode plusOne(ListNode head) {
        ListNode node = new ListNode(0, head);
        helper(node);
        return node.val == 0 ? node.next : node;
    }
    
    int helper(ListNode node) {
        if (node.next == null)
            node.val++;
        else
            node.val += helper(node.next);
        if (node.val < 10)
            return 0;
        node.val = 0;
        return 1;
    }
}
