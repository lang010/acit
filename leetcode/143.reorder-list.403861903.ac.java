/*
 * @lc app=leetcode id=143 lang=java
 *
 * [143] Reorder List
 *
 * https://leetcode.com/problems/reorder-list/description/
 *
 * algorithms
 * Medium (39.93%)
 * Total Accepted:    291.7K
 * Total Submissions: 730.4K
 * Testcase Example:  '[1,2,3,4]'
 *
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 
 * You may not modify the values in the list's nodes, only nodes itself may be
 * changed.
 * 
 * Example 1:
 * 
 * 
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * 
 * Example 2:
 * 
 * 
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
        ListNode f, s;
        f = s = head;
        while (f.next != null && f.next.next != null) {
            f = f.next.next;
            s = s.next;
        }
        f = s.next;
        s.next = null;
        ListNode h = new ListNode();
        while (f != null) {
            ListNode p = f;
            f = f.next;
            p.next = h.next;
            h.next = p;
        }
        h = h.next;
        while (h != null) {
            ListNode p = h;
            h = h.next;
            p.next = head.next;
            head.next = p;
            head = p.next;
        }
    }
}
