/*
 * @lc app=leetcode id=187 lang=java
 *
 * [187] Repeated DNA Sequences
 *
 * https://leetcode.com/problems/repeated-dna-sequences/description/
 *
 * algorithms
 * Medium (41.05%)
 * Total Accepted:    196K
 * Total Submissions: 477.4K
 * Testcase Example:  '"AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"'
 *
 * All DNA is composed of a series of nucleotides abbreviated as 'A', 'C', 'G',
 * and 'T', for example: "ACGAATTCCG". When studying DNA, it is sometimes
 * useful to identify repeated sequences within the DNA.
 * 
 * Write a function to find all the 10-letter-long sequences (substrings) that
 * occur more than once in a DNA molecule.
 * 
 * 
 * Example 1:
 * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * Output: ["AAAAACCCCC","CCCCCAAAAA"]
 * Example 2:
 * Input: s = "AAAAAAAAAAAAA"
 * Output: ["AAAAAAAAAA"]
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= s.length <= 10^5
 * s[i] is 'A', 'C', 'G', or 'T'.
 * 
 * 
 */
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        int mask = (1<<20) - 1;
        int val = 0;
        for (int i = 0; i < s.length(); i++) {
            int k = 0;
            char c = s.charAt(i);
            if (c == 'C')
                k = 1;
            else if (c == 'G')
                k = 2;
            else if (c == 'T')
                k = 3;
            val = ((val<<2) + k) & mask;
            if (i >= 9) {
                map.put(val, map.getOrDefault(val, 0)+1);
            }
        }
        List<String> ans = new ArrayList<>();
        for (Integer i : map.keySet())
            if (map.get(i) > 1) {
                ans.add(build(i));
            }
        return ans;
    }
    
    String build(int x) {
        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            int k = (x>>(i*2)) & 3;
            if (k == 0)
                sb.append('A');
            else if (k == 1)
                sb.append('C');
            else if (k == 2)
                sb.append('G');
            else
                sb.append('T');
        }
        return sb.toString();
    }
}
