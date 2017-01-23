import java.util.*;
/*******
 * 
Design a Snake game that is played on a device with screen size = width x height. Play the game online if you are not familiar with the game.

The snake is initially positioned at the top left corner (0,0) with length = 1 unit.

You are given a list of food's positions in row-column order. When a snake eats the food, its length and the game's score both increase by 1.

Each food appears one by one on the screen. For example, the second food will not appear until the first food was eaten by the snake.

When a food does appear on the screen, it is guaranteed that it will not appear on a block occupied by the snake.

Example:
Given width = 3, height = 2, and food = [[1,2],[0,1]].

Snake snake = new Snake(width, height, food);

Initially the snake appears at position (0,0) and the food at (1,2).

|S| | |
| | |F|

snake.move("R"); -> Returns 0

| |S| |
| | |F|

snake.move("D"); -> Returns 0

| | | |
| |S|F|

snake.move("R"); -> Returns 1 (Snake eats the first food and right after that, the second food appears at (0,1) )

| |F| |
| |S|S|

snake.move("U"); -> Returns 1

| |F|S|
| | |S|

snake.move("L"); -> Returns 2 (Snake eats the second food)

| |S|S|
| | |S|

snake.move("U"); -> Returns -1 (Game over because snake collides with border)

 * 
 * */


public class Le_353_Design_Snake_Game {
	//2D position info is encoded to 1D and stored as two copies 
	private Set<Integer> set;      // this copy is good for fast loop-up for eating body case
    private Deque<Integer> body;   // this copy is good for updating tail
    private int score;
    private int[][] food;
    private int foodIndex;
    private int width;
    private int height;
    
    public Le_353_Design_Snake_Game(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        set = new HashSet<>();
        set.add(0);                //intially at [0][0]
        body = new LinkedList<>();
        body.offerLast(0);
    }
    
  
    public int move(String direction) {
        //case 0: game already over: do nothing
        if (score == -1) {
            return -1;
        }
        
        // compute new head
        int rowHead = body.peekFirst() / width;
        int colHead = body.peekFirst() % width;
        
        if(direction.equals("U")) {
        	rowHead--;
        } else if(direction.equals("D")) {
        	rowHead++;
        } else if(direction.equals("L")) {
        	colHead--;
        } else {
        	colHead++;
        }
        
        int head = rowHead * width + colHead;
        
        //case 1: out of boundary or eating body
        
        // check the status
        // new head is legal to be in old tail's position, remove from set temporarily 
        set.remove(body.peekLast());      
        
        if (rowHead < 0 || rowHead == height || colHead < 0 || colHead == width || set.contains(head)) {
            return score = -1;
        }
        
        // add head for case2 and case3
        set.add(head); 
        body.offerFirst(head);
        
        //case2: eating food, keep tail, add head
        if (foodIndex < food.length && rowHead == food[foodIndex][0] && colHead == food[foodIndex][1]) {
            set.add(body.peekLast()); // old tail does not change, so add it back to set
            foodIndex++;
            return ++score;
        }
        
        //case3: normal move, remove tail, add head
        body.pollLast();
        return score;
    }
}
