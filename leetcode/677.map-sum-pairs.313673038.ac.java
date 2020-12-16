/*
 * @lc app=leetcode id=677 lang=java
 *
 * [677] Map Sum Pairs
 *
 * https://leetcode.com/problems/map-sum-pairs/description/
 *
 * algorithms
 * Medium (53.80%)
 * Total Accepted:    46.5K
 * Total Submissions: 86.5K
 * Testcase Example:  '["MapSum", "insert", "sum", "insert", "sum"]\n' +
  '[[], ["apple",3], ["ap"], ["app",2], ["ap"]]'
 *
 * Implement the MapSum class:
 * 
 * 
 * MapSum() Initializes the MapSum object.
 * void insert(String key, int val) Inserts the key-val pair into the map. If
 * the key already existed, the original key-value pair will be overridden to
 * the new one.
 * int sum(string prefix) Returns the sum of all the pairs' value whose key
 * starts with the prefix.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input
 * ["MapSum", "insert", "sum", "insert", "sum"]
 * [[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
 * Output
 * [null, null, 3, null, 5]
 * 
 * Explanation
 * MapSum mapSum = new MapSum();
 * mapSum.insert("apple", 3);  
 * mapSum.sum("ap");           // return 3 (apple = 3)
 * mapSum.insert("app", 2);    
 * mapSum.sum("ap");           // return 5 (apple + app = 3 + 2 = 5)
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= key.length, prefix.length <= 50
 * key and prefix consist of only lowercase English letters.
 * 1 <= val <= 1000
 * At most 50 calls will be made to insert and sum.
 * 
 * 
 */
class MapSum {
    
    static class Node {
        int val;
        Node[] next = new Node[26];
    }
    
    Node head = new Node();

    /** Initialize your data structure here. */
    public MapSum() {
        
    }
    
    public void insert(String key, int val) {
        Node node = head;
        for (int i = 0; i < key.length(); i++) {
            int id = key.charAt(i) - 'a';
            if (node.next[id] == null)
                node.next[id] = new Node();
            node = node.next[id];
        }
        node.val = val;
    }
    
    public int sum(String prefix) {
        Node node = head;
        for (int i = 0; i < prefix.length(); i++) {
            int id = prefix.charAt(i) - 'a';
            node = node.next[id];
            if (node == null)
                return 0;
        }
        return sum(node);
    }
    
    int sum(Node node) {
        if (node == null)
            return 0;
        int s = node.val;
        for (int i = 0; i < node.next.length; i++)
            s += sum(node.next[i]);
        return s;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
