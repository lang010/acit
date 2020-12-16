/*
 * @lc app=leetcode id=1105 lang=java
 *
 * [1105] Filling Bookcase Shelves
 *
 * https://leetcode.com/problems/filling-bookcase-shelves/description/
 *
 * algorithms
 * Medium (57.72%)
 * Total Accepted:    20.1K
 * Total Submissions: 34.7K
 * Testcase Example:  '[[1,1],[2,3],[2,3],[1,1],[1,1],[1,1],[1,2]]\n4'
 *
 * We have a sequence of books: the i-th book has thickness books[i][0] and
 * height books[i][1].
 * 
 * We want to place these books in order onto bookcase shelves that have total
 * width shelf_width.
 * 
 * We choose some of the books to place on this shelf (such that the sum of
 * their thickness is <= shelf_width), then build another level of shelf of the
 * bookcase so that the total height of the bookcase has increased by the
 * maximum height of the books we just put down.  We repeat this process until
 * there are no more books to place.
 * 
 * Note again that at each step of the above process, the order of the books we
 * place is the same order as the given sequence of books.  For example, if we
 * have an ordered list of 5 books, we might place the first and second book
 * onto the first shelf, the third book on the second shelf, and the fourth and
 * fifth book on the last shelf.
 * 
 * Return the minimum possible height that the total bookshelf can be after
 * placing shelves in this manner.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: books = [[1,1],[2,3],[2,3],[1,1],[1,1],[1,1],[1,2]], shelf_width = 4
 * Output: 6
 * Explanation:
 * The sum of the heights of the 3 shelves are 1 + 3 + 2 = 6.
 * Notice that book number 2 does not have to be on the first shelf.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= books.length <= 1000
 * 1 <= books[i][0] <= shelf_width <= 1000
 * 1 <= books[i][1] <= 1000
 * 
 * 
 */
class Solution {
    public int minHeightShelves(int[][] books, int shelf_width) {
        int n = books.length;
        int[] dp = new int[n+1];
        for (int i = 0; i < n; i++) {
            int sum = books[i][0];
            int max = books[i][1];
            dp[i+1] = dp[i] + books[i][1];
            for (int j = i-1; j >= 0 && sum + books[j][0] <= shelf_width; j--) {
                sum += books[j][0];
                max = Math.max(max, books[j][1]);
                dp[i+1] = Math.min(dp[i+1], dp[j] + max);
            }
        }
        return dp[n];
    }
}
