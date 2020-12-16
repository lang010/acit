/*
 * @lc app=leetcode id=588 lang=java
 *
 * [588] Design In-Memory File System
 *
 * https://leetcode.com/problems/design-in-memory-file-system/description/
 *
 * algorithms
 * Hard (46.44%)
 * Total Accepted:    25.1K
 * Total Submissions: 54K
 * Testcase Example:  '["FileSystem","ls","mkdir","addContentToFile","ls","readContentFromFile"]\n' +
  '[[],["/"],["/a/b/c"],["/a/b/c/d","hello"],["/"],["/a/b/c/d"]]'
 *
 * Design an in-memory file system to simulate the following functions:
 * 
 * ls: Given a path in string format. If it is a file path, return a list that
 * only contains this file's name. If it is a directory path, return the list
 * of file and directory names in this directory. Your output (file and
 * directory names together) should in lexicographic order.
 * 
 * mkdir: Given a directory path that does not exist, you should make a new
 * directory according to the path. If the middle directories in the path don't
 * exist either, you should create them as well. This function has void return
 * type.
 * 
 * addContentToFile: Given a file path and file content in string format. If
 * the file doesn't exist, you need to create that file containing given
 * content. If the file already exists, you need to append given content to
 * original content. This function has void return type.
 * 
 * readContentFromFile: Given a file path, return its content in string
 * format.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: 
 * ["FileSystem","ls","mkdir","addContentToFile","ls","readContentFromFile"]
 * [[],["/"],["/a/b/c"],["/a/b/c/d","hello"],["/"],["/a/b/c/d"]]
 * 
 * Output:
 * [null,[],null,null,["a"],"hello"]
 * 
 * Explanation:
 * 
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * You can assume all file or directory paths are absolute paths which begin
 * with / and do not end with / except that the path is just "/".
 * You can assume that all operations will be passed valid parameters and users
 * will not attempt to retrieve file content or list a directory or file that
 * does not exist.
 * You can assume that all directory names and file names only contain
 * lower-case letters, and same names won't exist in the same directory.
 * 
 * 
 */
class FileSystem {
    static class Node {
        Map<String, Node> child = new HashMap<>();
    };
    Node root = new Node();
    Map<String, String> files = new HashMap<>();

    public FileSystem() {
    }
    
    public List<String> ls(String path) {
        String[] arr = path.split("/");
        int n = arr.length;
        List<String> ans = new ArrayList<>();
        if (files.containsKey(path)) {
            ans.add(arr[n-1]);
            return ans;
        }
        Node cur = root;
        for (int i = 1; i < n; i++)
            cur = cur.child.get(arr[i]);
        ans.addAll(cur.child.keySet());
        Collections.sort(ans);
        return ans;
    }
    
    public void mkdir(String path) {
        String[] arr = path.split("/");
        Node cur = root;
        for (int i = 1; i < arr.length; i++) {
            if (!cur.child.containsKey(arr[i]))
                cur.child.put(arr[i], new Node());
            cur = cur.child.get(arr[i]);
        }
    }
    
    public void addContentToFile(String filePath, String content) {
        mkdir(filePath);
        files.put(filePath, files.getOrDefault(filePath, "") + content);
    }
    
    public String readContentFromFile(String filePath) {
        return files.get(filePath);
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */
