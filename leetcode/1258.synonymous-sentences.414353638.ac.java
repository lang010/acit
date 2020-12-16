/*
 * @lc app=leetcode id=1258 lang=java
 *
 * [1258] Synonymous Sentences
 *
 * https://leetcode.com/problems/synonymous-sentences/description/
 *
 * algorithms
 * Medium (67.43%)
 * Total Accepted:    5.4K
 * Total Submissions: 8K
 * Testcase Example:  '[["happy","joy"],["sad","sorrow"],["joy","cheerful"]]\n' +
  '"I am happy today but was sad yesterday"'
 *
 * Given a list of pairs of equivalent words synonyms and a sentence text,
 * Return all possible synonymous sentences sorted lexicographically.
 * 
 * Example 1:
 * 
 * 
 * Input:
 * synonyms = [["happy","joy"],["sad","sorrow"],["joy","cheerful"]],
 * text = "I am happy today but was sad yesterday"
 * Output:
 * ["I am cheerful today but was sad yesterday",
 * "I am cheerful today but was sorrow yesterday",
 * "I am happy today but was sad yesterday",
 * "I am happy today but was sorrow yesterday",
 * "I am joy today but was sad yesterday",
 * "I am joy today but was sorrow yesterday"]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: synonyms = [["happy","joy"],["cheerful","glad"]], text = "I am happy
 * today but was sad yesterday"
 * Output: ["I am happy today but was sad yesterday","I am joy today but was
 * sad yesterday"]
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: synonyms = [["a","b"],["c","d"],["e","f"]], text = "a c e"
 * Output: ["a c e","a c f","a d e","a d f","b c e","b c f","b d e","b d f"]
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: synonyms = [["a","QrbCl"]], text = "d QrbCl ya ya NjZQ"
 * Output: ["d QrbCl ya ya NjZQ","d a ya ya NjZQ"]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= synonyms.length <= 10
 * synonyms[i].length == 2
 * synonyms[i][0] != synonyms[i][1]
 * All words consist of at most 10 English letters only.
 * text is a single space separated sentence of at most 10 words.
 * 
 * 
 */
class Solution {
    Map<String, String> uf = new HashMap<>();
    Map<String, List<String>> map = new HashMap<>();
    
    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        synonyms.forEach((a) -> union(a.get(0), a.get(1)));
        uf.forEach((k, v) -> {
            String s = find(v);
            if (!map.containsKey(s))
                map.put(s, new ArrayList<>());
            map.get(s).add(k);
        });
        map.forEach((k, v) -> Collections.sort(v));
        StringBuilder sb = new StringBuilder();
        String[] ls = text.split(" ");
        List<String> ans = new ArrayList<>();
        dfs(ans, ls, 0, "");
        return ans;
    }
    
    void dfs(List<String> ans, String[] ls, int id, String pre) {
        while (id < ls.length && !map.containsKey(find(ls[id]))) {
            pre += " " + ls[id++];
        }
        if (id == ls.length) {
            ans.add(pre.substring(1));
            return;
        }
        for (String s : map.get(find(ls[id])))
            dfs(ans, ls, id+1, pre+ " " + s);
    }
    
    void union(String a, String b) {
        a = find(a);
        b = find(b);
        if (!a.equals(b))
            uf.put(a, b);
    }
    
    String find(String a) {
        if (!uf.containsKey(a)) {
            uf.put(a, a);
        }
        String p = uf.get(a);
        if (a.equals(p))
            return p;
        p = find(p);
        uf.put(a, p);
        return p;
    }
}
