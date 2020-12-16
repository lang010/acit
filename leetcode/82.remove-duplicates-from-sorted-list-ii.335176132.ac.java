/*
 * @lc app=leetcode id=82 lang=java
 *
 * [82] Remove Duplicates from Sorted List II
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/
 *
 * algorithms
 * Medium (37.76%)
 * Total Accepted:    279.4K
 * Total Submissions: 739.9K
 * Testcase Example:  '[1,2,3,3,4,4,5]'
 *
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * 
 * Return the linked list sorted as well.
 * 
 * Example 1:
 * 
 * 
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 1->1->1->2->3
 * Output: 2->3
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        ListNode ans = null;
        ListNode pre = null;
        while (cur != null) {
            ListNode ptr = cur.next;
            while (ptr != null && ptr.val == cur.val)
                ptr = ptr.next;
            if (ptr == cur.next) {
                if (pre != null)
                    pre.next = cur;
                pre = cur;
                pre.next = null;
                if (ans == null)
                    ans = pre;
            }
            cur = ptr;
        }
        return ans;
    }
}
