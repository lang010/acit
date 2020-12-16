/*
 * @lc app=leetcode id=445 lang=java
 *
 * [445] Add Two Numbers II
 *
 * https://leetcode.com/problems/add-two-numbers-ii/description/
 *
 * algorithms
 * Medium (55.84%)
 * Total Accepted:    208K
 * Total Submissions: 372.4K
 * Testcase Example:  '[7,2,4,3]\n[5,6,4]'
 *
 * You are given two non-empty linked lists representing two non-negative
 * integers. The most significant digit comes first and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the
 * lists is not allowed.
 * 
 * 
 * 
 * Example:
 * 
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode p1 = l1, p2 = l2;
        while (p2 != null) {
            p1.val = p1.val + p2.val;
            p2 = p2.next;
            if (p1.next == null) {
                p1.next = p2;
                break;
            }
            p1 = p1.next;
        }
        p1 = l1;
        int left = p1.val/10;
        p1.val %= 10;
        while (p1.next != null) {
            p1 = p1.next;
            p1.val += left;
            left = p1.val/10;
            p1.val %= 10;
        }
        if (left != 0)
            p1.next = new ListNode(left);
        return reverse(l1);
    }
    
    ListNode reverse(ListNode l) {
        if (l == null || l.next == null)
            return l;
        ListNode pre = l;
        ListNode cur = pre.next;
        pre.next = null;
        while (cur != null) {
            ListNode n = cur.next;
            cur.next = pre;
            pre = cur;
            cur = n;
        }
        return pre;
    }
}
