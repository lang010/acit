/*
 * @lc app=leetcode id=676 lang=java
 *
 * [676] Implement Magic Dictionary
 *
 * https://leetcode.com/problems/implement-magic-dictionary/description/
 *
 * algorithms
 * Medium (55.05%)
 * Total Accepted:    45.6K
 * Total Submissions: 82.8K
 * Testcase Example:  '["MagicDictionary", "buildDict", "search", "search", "search", "search"]\n' +
  '[[], [["hello","leetcode"]], ["hello"], ["hhllo"], ["hell"], ["leetcoded"]]'
 *
 * Design a data structure that is initialized with a list of different words.
 * Provided a string, you should determine if you can change exactly one
 * character in this string to match any word in the data structure.
 * 
 * Implement the MagicDictionary class:
 * 
 * 
 * MagicDictionary() Initializes the object.
 * void buildDict(String[] dictionary) Sets the data structure with an array of
 * distinct strings dictionary.
 * bool search(String searchWord) Returns true if you can change exactly one
 * character in searchWord to match any string in the data structure, otherwise
 * returns false.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input
 * ["MagicDictionary", "buildDict", "search", "search", "search", "search"]
 * [[], [["hello", "leetcode"]], ["hello"], ["hhllo"], ["hell"], ["leetcoded"]]
 * Output
 * [null, null, false, true, false, false]
 * 
 * Explanation
 * MagicDictionary magicDictionary = new MagicDictionary();
 * magicDictionary.buildDict(["hello", "leetcode"]);
 * magicDictionary.search("hello"); // return False
 * magicDictionary.search("hhllo"); // We can change the second 'h' to 'e' to
 * match "hello" so we return True
 * magicDictionary.search("hell"); // return False
 * magicDictionary.search("leetcoded"); // return False
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= dictionary.length <= 100
 * 1 <= dictionary[i].length <= 100
 * dictionary[i] consists of only lower-case English letters.
 * All the strings in dictionary are distinct.
 * 1 <= searchWord.length <= 100
 * searchWord consists of only lower-case English letters.
 * buildDict will be called only once before search.
 * At most 100 calls will be made to search.
 * 
 * 
 */
class MagicDictionary {
    
    String[] dict;

    /** Initialize your data structure here. */
    public MagicDictionary() {
        
    }
    
    public void buildDict(String[] dictionary) {
        dict = dictionary;
    }
    
    public boolean search(String searchWord) {
        for (String s : dict)
            if (check(s, searchWord))
                return true;
        return false;
    }
    
    boolean check(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        int d = 0;
        for (int i = 0; i < s1.length(); i++)
            if (s1.charAt(i) != s2.charAt(i)) {
                d++;
                if (d > 1)
                    return false;
            }
        return d == 1;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */
