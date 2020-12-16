/*
 * @lc app=leetcode id=86 lang=java
 *
 * [86] Partition List
 *
 * https://leetcode.com/problems/partition-list/description/
 *
 * algorithms
 * Medium (42.70%)
 * Total Accepted:    238.7K
 * Total Submissions: 558.9K
 * Testcase Example:  '[1,4,3,2,5,2]\n3'
 *
 * Given a linked list and a value x, partition it such that all nodes less
 * than x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 * 
 * Example:
 * 
 * 
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
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
    public ListNode partition(ListNode head, int x) {
        ListNode h1 = new ListNode(), h2 = new ListNode();
        ListNode c1 = h1, c2 = h2;
        while (head != null) {
            if (head.val < x) {
                c1.next = head;
                head = head.next;
                c1 = c1.next;
                c1.next = null;
            } else {
                c2.next = head;
                head = head.next;
                c2 = c2.next;
                c2.next = null;
            }
        }
        c1.next = h2.next;
        return h1.next;
    }
}
