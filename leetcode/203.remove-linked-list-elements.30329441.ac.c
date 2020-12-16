/*
 * @lc app=leetcode id=203 lang=c
 *
 * [203] Remove Linked List Elements
 *
 * https://leetcode.com/problems/remove-linked-list-elements/description/
 *
 * algorithms
 * Easy (38.97%)
 * Total Accepted:    410.2K
 * Total Submissions: 1.1M
 * Testcase Example:  '[1,2,6,3,4,5,6]\n6'
 *
 * Remove all elements from a linked list of integers that have value val.
 * 
 * Example:
 * 
 * 
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 * 
 * 
 */
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* removeElements(struct ListNode* head, int val) {
  if (head == 0)
    return head;
  struct ListNode* ptr = removeElements(head->next, val);
  if (head->val == val)	{
    return ptr;
  }
  head->next = ptr;
  return head;
}
