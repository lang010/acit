/*
 * @lc app=leetcode id=251 lang=java
 *
 * [251] Flatten 2D Vector
 *
 * https://leetcode.com/problems/flatten-2d-vector/description/
 *
 * algorithms
 * Medium (46.13%)
 * Total Accepted:    82.4K
 * Total Submissions: 178.6K
 * Testcase Example:  '["Vector2D","next","next","next","hasNext","hasNext","next","hasNext"]\n' +
  '[[[[1,2],[3],[4]]],[null],[null],[null],[null],[null],[null],[null]]'
 *
 * Design and implement an iterator to flatten a 2d vector. It should support
 * the following operations: next and hasNext.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Vector2D iterator = new Vector2D([[1,2],[3],[4]]);
 * 
 * iterator.next(); // return 1
 * iterator.next(); // return 2
 * iterator.next(); // return 3
 * iterator.hasNext(); // return true
 * iterator.hasNext(); // return true
 * iterator.next(); // return 4
 * iterator.hasNext(); // return false
 * 
 * 
 * 
 * 
 * Notes:
 * 
 * 
 * Please remember to RESET your class variables declared in Vector2D, as
 * static/class variables are persisted across multiple test cases. Please see
 * here for more details.
 * You may assume that next() call will always be valid, that is, there will be
 * at least a next element in the 2d vector when next() is called.
 * 
 * 
 * 
 * 
 * Follow up:
 * 
 * As an added challenge, try to code it using only iterators in C++ or
 * iterators in Java.
 * 
 */
class Vector2D {
    
    int i,j;
    int[][] v;

    public Vector2D(int[][] v) {
        this.v = v;
        i = 0;
        j = 0;
    }
    
    public int next() {
        if (hasNext()) {
            return v[i][j++];
        }
        return -1;
    }
    
    public boolean hasNext() {
        while (i < v.length) {
            if (j >= v[i].length) {
                i++;
                j = 0;
            } else {
                return true;
            }
        }
        return false;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(v);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
