/*
 * @lc app=leetcode id=705 lang=java
 *
 * [705] Design HashSet
 *
 * https://leetcode.com/problems/design-hashset/description/
 *
 * algorithms
 * Easy (64.50%)
 * Total Accepted:    108.2K
 * Total Submissions: 167.7K
 * Testcase Example:  '["MyHashSet","add","add","contains","contains","add","contains","remove","contains"]\n' +
  '[[],[1],[2],[1],[3],[2],[2],[2],[2]]'
 *
 * Design a HashSet without using any built-in hash table libraries.
 * 
 * To be specific, your design should include these functions:
 * 
 * 
 * add(value): Insert a value into the HashSet. 
 * contains(value) : Return whether the value exists in the HashSet or not.
 * remove(value): Remove a value in the HashSet. If the value does not exist in
 * the HashSet, do nothing.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * MyHashSet hashSet = new MyHashSet();
 * hashSet.add(1);         
 * hashSet.add(2);         
 * hashSet.contains(1);    // returns true
 * hashSet.contains(3);    // returns false (not found)
 * hashSet.add(2);          
 * hashSet.contains(2);    // returns true
 * hashSet.remove(2);          
 * hashSet.contains(2);    // returns false (already removed)
 * 
 * 
 * 
 * Note:
 * 
 * 
 * All values will be in the range of [0, 1000000].
 * The number of operations will be in the range of [1, 10000].
 * Please do not use the built-in HashSet library.
 * 
 * 
 */
class MyHashSet {
    
    Bucket[] buckets;
    int mapSize;

    /** Initialize your data structure here. */
    public MyHashSet() {
        mapSize = 10003;
        buckets = new Bucket[mapSize];
        for (int i = 0; i < mapSize; i++) {
            buckets[i] = new Bucket();
        }
    }
    
    public void add(int key) {
        buckets[key%mapSize].add(key);
    }
    
    public void remove(int key) {
        buckets[key%mapSize].remove(key);
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return buckets[key%mapSize].contains(key);
    }
}

public class Bucket {
    List<Integer> ls = new LinkedList<>();
    
    public void add(int key) {
        if (!contains(key))
            ls.add(key);
    }
    
    public void remove(int key) {
        ls.remove((Integer)key);
    }
    
    public boolean contains(int key) {
        return ls.contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
