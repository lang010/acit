/*
 * @lc app=leetcode id=1268 lang=java
 *
 * [1268] Search Suggestions System
 *
 * https://leetcode.com/problems/search-suggestions-system/description/
 *
 * algorithms
 * Medium (64.40%)
 * Total Accepted:    64.2K
 * Total Submissions: 99.7K
 * Testcase Example:  '["mobile","mouse","moneypot","monitor","mousepad"]\r\n"mouse"\r'
 *
 * Given an array of strings products and a string searchWord. We want to
 * design a system that suggests at most three product names from products
 * after each character of searchWord is typed. Suggested products should have
 * common prefix with the searchWord. If there are more than three products
 * with a common prefix return the three lexicographically minimums products.
 * 
 * Return list of lists of the suggested products after each character of
 * searchWord is typed. 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: products = ["mobile","mouse","moneypot","monitor","mousepad"],
 * searchWord = "mouse"
 * Output: [
 * ["mobile","moneypot","monitor"],
 * ["mobile","moneypot","monitor"],
 * ["mouse","mousepad"],
 * ["mouse","mousepad"],
 * ["mouse","mousepad"]
 * ]
 * Explanation: products sorted lexicographically =
 * ["mobile","moneypot","monitor","mouse","mousepad"]
 * After typing m and mo all products match and we show user
 * ["mobile","moneypot","monitor"]
 * After typing mou, mous and mouse the system suggests ["mouse","mousepad"]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: products = ["havana"], searchWord = "havana"
 * Output:
 * [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: products = ["bags","baggage","banner","box","cloths"], searchWord =
 * "bags"
 * Output:
 * [["baggage","bags","banner"],["baggage","bags","banner"],["baggage","bags"],["bags"]]
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: products = ["havana"], searchWord = "tatiana"
 * Output: [[],[],[],[],[],[],[]]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= products.length <= 1000
 * There are no repeated elements in products.
 * 1 <= Σ products[i].length <= 2 * 10^4
 * All characters of products[i] are lower-case English letters.
 * 1 <= searchWord.length <= 1000
 * All characters of searchWord are lower-case English letters.
 * 
 * 
 */
class Solution {
    
    static class Trie {
        String word;
        Trie[] next = new Trie[26];
    };
    
    Trie root;
    
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        root = new Trie();
        for (String s : products) {
            insert(root, s);
        }
        List<List<String>> ans = new ArrayList<>();
        Trie cur = root;
        int id = 0;
        while (id < searchWord.length()) {
            List<String> ls = new ArrayList<>();
            if (cur != null) {
                cur = cur.next[searchWord.charAt(id) - 'a'];
            }
            find(cur, ls);
            ans.add(ls); 
            id++;
        }
        
        return ans;
    }
    
    void insert(Trie node, String s) {
        int id = 0;
        while (id < s.length()) {
            int i = s.charAt(id++) - 'a';
            if (node.next[i] == null)
                node.next[i] = new Trie();
            node = node.next[i];
        }
        node.word = s;
    }
    
    void find(Trie node, List<String> ls) {
        if (node == null)
            return;
        if (ls.size() > 2)
            return;
        if (node.word != null)
            ls.add(node.word);
        for (int i = 0; i < 26; i++)
            find(node.next[i], ls);
    }
}
