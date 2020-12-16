/*
 * @lc app=leetcode id=1286 lang=java
 *
 * [1286] Iterator for Combination
 *
 * https://leetcode.com/problems/iterator-for-combination/description/
 *
 * algorithms
 * Medium (70.79%)
 * Total Accepted:    36.9K
 * Total Submissions: 52.1K
 * Testcase Example:  '["CombinationIterator","next","hasNext","next","hasNext","next","hasNext"]\n' +
  '[["abc",2],[],[],[],[],[],[]]'
 *
 * Design the CombinationIterator class:
 * 
 * 
 * CombinationIterator(string characters, int combinationLength) Initializes
 * the object with a string characters of sorted distinct lowercase English
 * letters and a number combinationLength as arguments.
 * next() Returns the next combination of length combinationLength in
 * lexicographical order.
 * hasNext() Returns true if and only if there exists a next combination.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input
 * ["CombinationIterator", "next", "hasNext", "next", "hasNext", "next",
 * "hasNext"]
 * [["abc", 2], [], [], [], [], [], []]
 * Output
 * [null, "ab", true, "ac", true, "bc", false]
 * 
 * Explanation
 * CombinationIterator itr = new CombinationIterator("abc", 2);
 * itr.next();    // return "ab"
 * itr.hasNext(); // return True
 * itr.next();    // return "ac"
 * itr.hasNext(); // return True
 * itr.next();    // return "bc"
 * itr.hasNext(); // return False
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= combinationLength <= characters.length <= 15
 * All the characters of characters are unique.
 * At most 10^4 calls will be made to next and hasNext.
 * It's guaranteed that all calls of the function next are valid.
 * 
 * 
 */
class CombinationIterator {
    
    char[] chs;
    int n;
    int[] buf;

    public CombinationIterator(String characters, int combinationLength) {
        chs = characters.toCharArray();
        n = combinationLength;
        buf = new int[n];
        for (int i = 1; i < n; i++)
            buf[i] = i;
    }
    
    public String next() {
        StringBuilder sb = new StringBuilder();
        for (int x : buf)
            sb.append(chs[x]);
        int i = n-1;
        while (i > 0 && buf[i] == chs.length - (n-i))
            i--;
        buf[i]++;
        for (i++; i < n; i++)
            buf[i] = buf[i-1]+1;
        return sb.toString();
    }
    
    public boolean hasNext() {
        return buf[0] + n <= chs.length;
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
