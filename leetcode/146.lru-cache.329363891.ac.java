/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 *
 * https://leetcode.com/problems/lru-cache/description/
 *
 * algorithms
 * Medium (34.84%)
 * Total Accepted:    660.5K
 * Total Submissions: 1.9M
 * Testcase Example:  '["LRUCache","put","put","get","put","get","put","get","get","get"]\n' +
  '[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]'
 *
 * Design a data structure that follows the constraints of a Least Recently
 * Used (LRU) cache.
 * 
 * Implement the LRUCache class:
 * 
 * 
 * LRUCache(int capacity) Initialize the LRU cache with positive size
 * capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise
 * return -1.
 * void put(int key, int value) Update the value of the key if the key exists.
 * Otherwise, add the key-value pair to the cache. If the number of keys
 * exceeds the capacity from this operation, evict the least recently used
 * key.
 * 
 * 
 * Follow up:
 * Could you do get and put in O(1) time complexity?
 * 
 * 
 * Example 1:
 * 
 * 
 * Input
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * Output
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 * 
 * Explanation
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // cache is {1=1}
 * lRUCache.put(2, 2); // cache is {1=1, 2=2}
 * lRUCache.get(1);    // return 1
 * lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
 * lRUCache.get(2);    // returns -1 (not found)
 * lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
 * lRUCache.get(1);    // return -1 (not found)
 * lRUCache.get(3);    // return 3
 * lRUCache.get(4);    // return 4
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= capacity <= 3000
 * 0 <= key <= 3000
 * 0 <= value <= 10^4
 * At most 3 * 10^4 calls will be made to get and put.
 * 
 * 
 */
class LRUCache {
    
    static class Node {
        int key;
        int val;
        Node next, pre;
    }
    
    int cap;
    Node head, tail;
    Map<Integer, Node> map;
    

    public LRUCache(int capacity) {
        cap = capacity;
        head = new Node();
        tail = head;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if (node == null)
            return -1;
        forward(node);
        
        return node.val;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null) {
            node = new Node();
            node.key = key;
            node.val = value;
            map.put(key, node);
        } else {
            node.val = value;
        }
        forward(node);
            
        if (map.size() > cap) {
            map.remove(tail.key);
            tail = tail.pre;
            tail.next = null;
        }
    }
    
    void forward(Node node) {
        // Not new node
        if (node.pre != null)
            node.pre.next = node.next;
        if (node.next != null)
            node.next.pre = node.pre;
        // Is last node
        if (tail == node)
            tail = node.pre;
        // New node and Zero node in list.
        if (head.next != null)
            head.next.pre = node;
        else
            tail = node;
        node.next = head.next;
        node.pre = head;
        head.next = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
