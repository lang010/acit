/*
 * @lc app=leetcode id=281 lang=java
 *
 * [281] Zigzag Iterator
 *
 * https://leetcode.com/problems/zigzag-iterator/description/
 *
 * algorithms
 * Medium (59.08%)
 * Total Accepted:    67.7K
 * Total Submissions: 114.6K
 * Testcase Example:  '[1,2]\n[3,4,5,6]'
 *
 * Given two 1d vectors, implement an iterator to return their elements
 * alternately.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input:
 * v1 = [1,2]
 * v2 = [3,4,5,6] 
 * Output: [1,3,2,4,5,6]
 * Explanation: By calling next repeatedly until hasNext returns false, the
 * order of elements returned by next should be: [1,3,2,4,5,6].
 * 
 * 
 * 
 * Follow up:
 * 
 * What if you are given k 1d vectors? How well can your code be extended to
 * such cases?
 * 
 * Clarification for the follow up question:
 * The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases.
 * If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic". For
 * example:
 * 
 * 
 * Input:
 * [1,2,3]
 * [4,5,6,7]
 * [8,9]
 * 
 * Output: [1,4,8,2,5,9,3,6,7].
 * 
 * 
 */
public class ZigzagIterator {
    int id = 0;
    Iterator<Integer> it1;
    Iterator<Integer> it2;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        it1 = v1.iterator();
        it2 = v2.iterator();
    }

    public int next() {
        if (!it1.hasNext())
            return it2.next();
        if (!it2.hasNext())
            return it1.next();
        id++;
        if (id%2 == 1)
            return it1.next();
        else
            return it2.next();
    }

    public boolean hasNext() {
        return it1.hasNext() || it2.hasNext();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
