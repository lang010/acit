/*
 * @lc app=leetcode id=92 lang=java
 *
 * [92] Reverse Linked List II
 *
 * https://leetcode.com/problems/reverse-linked-list-ii/description/
 *
 * algorithms
 * Medium (39.96%)
 * Total Accepted:    311.4K
 * Total Submissions: 779.3K
 * Testcase Example:  '[1,2,3,4,5]\n2\n4'
 *
 * Reverse a linked list from position m to n. Do it in one-pass.
 * 
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * 
 * Example:
 * 
 * 
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode h = new ListNode(0, head);
        ListNode pre = h;
        int i = 1;
        ListNode first, cur;
        first = cur = head;
        while (i < m) {
            i++;
            pre = pre.next;
            cur = cur.next;
        }
        ListNode preHead = pre;
        first = cur;
        while (i <= n) {
            i++;
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        preHead.next = pre;
        first.next = cur;
        
        return h.next;
    }
}
