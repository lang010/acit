/*
 * @lc app=leetcode id=1171 lang=java
 *
 * [1171] Remove Zero Sum Consecutive Nodes from Linked List
 *
 * https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/description/
 *
 * algorithms
 * Medium (41.34%)
 * Total Accepted:    21K
 * Total Submissions: 50.8K
 * Testcase Example:  '[1,2,-3,3,1]'
 *
 * Given the head of a linked list, we repeatedly delete consecutive sequences
 * of nodes that sum to 0 until there are no such sequences.
 * 
 * After doing so, return the head of the final linked list.  You may return
 * any such answer.
 * 
 * 
 * (Note that in the examples below, all sequences are serializations of
 * ListNode objects.)
 * 
 * Example 1:
 * 
 * 
 * Input: head = [1,2,-3,3,1]
 * Output: [3,1]
 * Note: The answer [1,2,1] would also be accepted.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: head = [1,2,3,-3,4]
 * Output: [1,2,4]
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: head = [1,2,3,-3,-2]
 * Output: [1]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The given linked list will contain between 1 and 1000 nodes.
 * Each node in the linked list has -1000 <= node.val <= 1000.
 * 
 * 
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode pre = new ListNode();
        pre.next = head;
        Map<Integer, ListNode> map = new HashMap<>();
        map.put(0, pre);
        int sum = 0;
        while (head != null) {
            sum += head.val;
            if (map.containsKey(sum)) {
                ListNode ptr = map.get(sum).next;
                while (ptr != head) {
                    sum += ptr.val;
                    map.remove(sum);
                    ptr = ptr.next;
                }
                sum += head.val;
                map.get(sum).next = head.next;
            } else {
                map.put(sum, head);
            }
            head = head.next;
        }
        
        return pre.next;
    }
}
