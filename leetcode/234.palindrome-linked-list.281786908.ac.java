/*
 * @lc app=leetcode id=234 lang=java
 *
 * [234] Palindrome Linked List
 *
 * https://leetcode.com/problems/palindrome-linked-list/description/
 *
 * algorithms
 * Easy (40.01%)
 * Total Accepted:    517.5K
 * Total Submissions: 1.3M
 * Testcase Example:  '[1,2]'
 *
 * Given a singly linked list, determine if it is a palindrome.
 * 
 * Example 1:
 * 
 * 
 * Input: 1->2
 * Output: false
 * 
 * Example 2:
 * 
 * 
 * Input: 1->2->2->1
 * Output: true
 * 
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
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
    public boolean isPalindrome(ListNode head) {
        int len = 0;
        ListNode p = head;
        while (p != null) {
            len++;
            p = p.next;
        }
        if (len < 2) {
            return true;
        }
        int mid = len/2;
        ListNode pre = null;
        ListNode curr = head;
        while (mid > 0) {
            ListNode tmp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = tmp;
            mid--;
        }
        if (len % 2 == 1) {
            curr = curr.next;
        }
        while (curr != null) {
            if (curr.val != pre.val)
                return false;
            curr = curr.next;
            pre = pre.next;
        }
        return true;
    }
}
