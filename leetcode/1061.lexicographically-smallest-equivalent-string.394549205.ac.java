/*
 * @lc app=leetcode id=1061 lang=java
 *
 * [1061] Lexicographically Smallest Equivalent String
 *
 * https://leetcode.com/problems/lexicographically-smallest-equivalent-string/description/
 *
 * algorithms
 * Medium (66.14%)
 * Total Accepted:    4.6K
 * Total Submissions: 7K
 * Testcase Example:  '"parker"\n"morris"\n"parser"'
 *
 * Given strings A and B of the same length, we say A[i] and B[i] are
 * equivalent characters. For example, if A = "abc" and B = "cde", then we have
 * 'a' == 'c', 'b' == 'd', 'c' == 'e'.
 * 
 * Equivalent characters follow the usual rules of any equivalence
 * relation:
 * 
 * 
 * Reflexivity: 'a' == 'a'
 * Symmetry: 'a' == 'b' implies 'b' == 'a'
 * Transitivity: 'a' == 'b' and 'b' == 'c' implies 'a' == 'c'
 * 
 * 
 * For example, given the equivalency information from A and B above, S =
 * "eed", "acd", and "aab" are equivalent strings, and "aab" is the
 * lexicographically smallest equivalent string of S.
 * 
 * Return the lexicographically smallest equivalent string of S by using the
 * equivalency information from A and B.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: A = "parker", B = "morris", S = "parser"
 * Output: "makkek"
 * Explanation: Based on the equivalency information in A and B, we can group
 * their characters as [m,p], [a,o], [k,r,s], [e,i]. The characters in each
 * group are equivalent and sorted in lexicographical order. So the answer is
 * "makkek".
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: A = "hello", B = "world", S = "hold"
 * Output: "hdld"
 * Explanation:  Based on the equivalency information in A and B, we can group
 * their characters as [h,w], [d,e,o], [l,r]. So only the second letter 'o' in
 * S is changed to 'd', the answer is "hdld".
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: A = "leetcode", B = "programs", S = "sourcecode"
 * Output: "aauaaaaada"
 * Explanation:  We group the equivalent characters in A and B as
 * [a,o,e,r,s,c], [l,p], [g,t] and [d,m], thus all letters in S except 'u' and
 * 'd' are transformed to 'a', the answer is "aauaaaaada".
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * String A, B and S consist of only lowercase English letters from 'a' -
 * 'z'.
 * The lengths of string A, B and S are between 1 and 1000.
 * String A and B are of the same length.
 * 
 */
class Solution {
    int[] set = new int[26];
    public String smallestEquivalentString(String A, String B, String S) {
        for (int i = 0; i < 26; i++)
            set[i] = i;
        for (int i = 0; i < A.length(); i++)
            union(A.charAt(i)-'a', B.charAt(i)-'a');
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray())
            sb.append((char) (find(c-'a')+'a'));
        return sb.toString();
    }
    
    void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x < y)
            set[y] = x;
        else if (x > y)
            set[x] = y;
    }
    
    int find(int x) {
        if (x == set[x])
            return x;
        set[x] = find(set[x]);
        return set[x];
    }
}
