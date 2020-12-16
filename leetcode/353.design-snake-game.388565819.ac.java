/*
 * @lc app=leetcode id=353 lang=java
 *
 * [353] Design Snake Game
 *
 * https://leetcode.com/problems/design-snake-game/description/
 *
 * algorithms
 * Medium (35.01%)
 * Total Accepted:    40.2K
 * Total Submissions: 114.8K
 * Testcase Example:  '["SnakeGame","move","move","move","move","move","move"]\n' +
  '[[3,2,[[1,2],[0,1]]],["R"],["D"],["R"],["U"],["L"],["U"]]'
 *
 * Design a Snake game that is played on a device with screen size = width x
 * height. Play the game online if you are not familiar with the game.
 * 
 * The snake is initially positioned at the top left corner (0,0) with length =
 * 1 unit.
 * 
 * You are given a list of food's positions in row-column order. When a snake
 * eats the food, its length and the game's score both increase by 1.
 * 
 * Each food appears one by one on the screen. For example, the second food
 * will not appear until the first food was eaten by the snake.
 * 
 * When a food does appear on the screen, it is guaranteed that it will not
 * appear on a block occupied by the snake.
 * 
 * Example:
 * 
 * 
 * Given width = 3, height = 2, and food = [[1,2],[0,1]].
 * 
 * Snake snake = new Snake(width, height, food);
 * 
 * Initially the snake appears at position (0,0) and the food at (1,2).
 * 
 * |S| | |
 * | | |F|
 * 
 * snake.move("R"); -> Returns 0
 * 
 * | |S| |
 * | | |F|
 * 
 * snake.move("D"); -> Returns 0
 * 
 * | | | |
 * | |S|F|
 * 
 * snake.move("R"); -> Returns 1 (Snake eats the first food and right after
 * that, the second food appears at (0,1) )
 * 
 * | |F| |
 * | |S|S|
 * 
 * snake.move("U"); -> Returns 1
 * 
 * | |F|S|
 * | | |S|
 * 
 * snake.move("L"); -> Returns 2 (Snake eats the second food)
 * 
 * | |S|S|
 * | | |S|
 * 
 * snake.move("U"); -> Returns -1 (Game over because snake collides with
 * border)
 * 
 * 
 */
class SnakeGame {
    
    int[][] food;
    int w, h, fIndex;
    LinkedList<int[]> s;

    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        w = width;
        h = height;
        this.food = food;
        fIndex = 0;
        s = new LinkedList<>();
        s.add(new int[] {0, 0});
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        int[] pos = s.getLast();
        int x = pos[0], y = pos[1];
        switch (direction) {
            case "U":
                x--;
                break;
            case "D":
                x++;
                break;
            case "R":
                y++;
                break;
            case "L":
                y--;
                break;
        }
        if (dead(x, y))
            return -1;
        s.add(new int[] {x, y});
        if (fIndex < food.length && food[fIndex][0] == x && food[fIndex][1] == y) {
            fIndex++;
        } else {
            s.removeFirst();
        }
        return s.size()-1;
    }
    
    boolean dead(int x, int y) {
        if (x < 0 || y < 0 || x >= h || y >= w)
            return true;
        boolean first = true;
        for (int[] cur : s) {
            if (!first && cur[0] == x && cur[1] == y)
                return true;
            first = false;
        }
        return false;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
