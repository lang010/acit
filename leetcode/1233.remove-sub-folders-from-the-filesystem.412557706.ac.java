/*
 * @lc app=leetcode id=1233 lang=java
 *
 * [1233] Remove Sub-Folders from the Filesystem
 *
 * https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/description/
 *
 * algorithms
 * Medium (61.45%)
 * Total Accepted:    23.9K
 * Total Submissions: 39K
 * Testcase Example:  '["/a","/a/b","/c/d","/c/d/e","/c/f"]'
 *
 * Given a list of folders, remove all sub-folders in those folders and return
 * in any order the folders after removing.
 * 
 * If a folder[i] is located within another folder[j], it is called a
 * sub-folder of it.
 * 
 * The format of a path is one or more concatenated strings of the form: /
 * followed by one or more lowercase English letters. For example, /leetcode
 * and /leetcode/problems are valid paths while an empty string and / are
 * not.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: folder = ["/a","/a/b","/c/d","/c/d/e","/c/f"]
 * Output: ["/a","/c/d","/c/f"]
 * Explanation: Folders "/a/b/" is a subfolder of "/a" and "/c/d/e" is inside
 * of folder "/c/d" in our filesystem.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: folder = ["/a","/a/b/c","/a/b/d"]
 * Output: ["/a"]
 * Explanation: Folders "/a/b/c" and "/a/b/d/" will be removed because they are
 * subfolders of "/a".
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: folder = ["/a/b/c","/a/b/ca","/a/b/d"]
 * Output: ["/a/b/c","/a/b/ca","/a/b/d"]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= folder.length <= 4 * 10^4
 * 2 <= folder[i].length <= 100
 * folder[i] contains only lowercase letters and '/'
 * folder[i] always starts with character '/'
 * Each folder name is unique.
 * 
 * 
 */
class Solution {
    static class Node {
        Map<String, Node> child = new HashMap<>();
    }
    Node root = new Node();
    List<String> ans = new ArrayList<>();
    public List<String> removeSubfolders(String[] folder) {
        for (String s : folder)
            add(s);
        dfs(root, "");
        return ans;
    }
    
    void add(String s) {
        String[] ls = s.split("/");
        Node cur = root;
        for (int i = 1; i < ls.length; i++) {
            if (cur.child.containsKey(ls[i])
                && cur.child.get(ls[i]).child.size() == 0)
                return;
            if (!cur.child.containsKey(ls[i]))
                cur.child.put(ls[i], new Node());
            cur = cur.child.get(ls[i]);
        }
        cur.child.clear();
    }
    
    void dfs(Node cur, String pre) {
        if (cur.child.size() == 0) {
            ans.add(pre);
            return;
        }
        cur.child.forEach((k, v) -> dfs(v, pre + "/" + k));
    }
}
