/*
 * @lc app=leetcode id=147 lang=java
 *
 * [147] Insertion Sort List
 *
 * https://leetcode.com/problems/insertion-sort-list/description/
 *
 * algorithms
 * Medium (43.92%)
 * Total Accepted:    219.5K
 * Total Submissions: 499.6K
 * Testcase Example:  '[4,2,1,3]'
 *
 * Sort a linked list using insertion sort.
 * 
 * 
 * 
 * 
 * 
 * A graphical example of insertion sort. The partial sorted list (black)
 * initially contains only the first element in the list.
 * With each iteration one element (red) is removed from the input data and
 * inserted in-place into the sorted list
 * 
 * 
 * 
 * 
 * 
 * Algorithm of Insertion Sort:
 * 
 * 
 * Insertion sort iterates, consuming one input element each repetition, and
 * growing a sorted output list.
 * At each iteration, insertion sort removes one element from the input data,
 * finds the location it belongs within the sorted list, and inserts it
 * there.
 * It repeats until no input elements remain.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
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
    public ListNode insertionSortList(ListNode head) {
        ListNode ph = new ListNode();
        ListNode pre, cur = head;
        while (head != null) {
            pre = ph;
            cur = pre.next;
            while (cur != null && cur.val > head.val) {
                pre = cur;
                cur = cur.next;
            }
            cur = head;
            head = head.next;
            cur.next = pre.next;
            pre.next = cur;
        }
        
        cur = ph.next;
        ph.next = null;
        while (cur != null) {
            pre = cur.next;
            cur.next = ph.next;
            ph.next = cur;
            cur = pre;
        }
        return ph.next;
    }
}
