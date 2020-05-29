
import java.util.Random;
import java.util.Scanner;

/**
 * This is a program that runs the game BattleShip
 * It is a game between a user and the computer
 */


/**
 * Instantiates the 2D array used for the board
 * Welcomes the user
 */
public class battleShip {
  char[][]board = new char[10][10];
  int coord = 0;
  Scanner input = new Scanner(System.in);
  Random rand = new Random();

  public battleShip() {
    System.out.println("**** Welcome to Battle Ships Game ****");
	System.out.println(" ");
	System.out.println("Right now, the sea is empty.");
	System.out.println(" ");
	
	
	for(int i = 0; i < 10; i++) {
      for(int j = 0; j < board[i].length; j++) {
    	board[i][j] = ' ';
      }
	}
  }
	
  
  /**
   * prints out the battle ship board
   * 'x' is for computer ships won't show up on user display
   */
  public void printBoard() {
    System.out.println("   0123456789"); 
    
	for(int i = 0; i < 10; i++) {
	  // Print Head 
	  System.out.print(i + " |");
		
	  //Print current row
	  for(int j = 0; j < board[i].length; j++) {   
        if(board[i][j] == 'c') {
          //System.out.print(" ");
        System.out.print("c");
		}
        else if(board[i][j] == 'm') {
          System.out.print(" ");
        }
	    else {
		  System.out.print(board[i][j]);
	    }
	  } // end for loop for a row
	  
	  // Print foot
      System.out.println("|" + i);
	}
	
    System.out.println("   0123456789");
    System.out.println("");
  }
  
  
  /**
   * 
   * @param x x-coordinate
   * @param y y-coordinate
   * @param comp computer insert ship or not
   * @return -1: coordinate is not within 10x10 grid
   * @return -2: coordinate already has ship
   * @return  0: successfully inserted ship
   * remembers computer insert ship as 'x'
   */
  public int insertShip(int x, int y, boolean comp) {
    if(x >= 10 || y >= 10){
      return -1;
	}
    
	else if(board[y][x] != ' '){
	  return -2;
	}
    
	else{
	  if(true == comp) {
	    board[y][x] = 'c';
	  }
	  else{
		board[y][x] = '@';
	  }
	  return 0;
		
    }
  }
  
  
  /**
	 * 
	 * @param id: value for ship number
	 * prompts user for coordinates
	 * passes through insertShip conditions
	 * based on return values from insertShip results in print statements
	 */
public void userInputShip(int id) {
  int ShipX;
  int ShipY;
		
    do {
	  System.out.printf("Enter X coordinate for Ship %d: ", id);
	  ShipX = input.nextInt();
	  System.out.printf("Enter Y coordinate for Ship %d: ", id);
	  ShipY = input.nextInt();
			
	  int x = insertShip(ShipX, ShipY, false);
			
	  if(x == -1){
	    System.out.println("You can't place ships outside the 10 by 10 grid, please renter: ");
		}
	  
	  else if(x == -2){
		System.out.println("You can NOT place two or more ships on the same location");
		}
	  
	  else{
		break;
		}
	  
	  } while(true);
	}

/**
 * 
 * @param id: value for ship number
 * 
 * generates random x and y coordinate
 * if passes insertShip conditions (return 0) will print out ship DEPLOYED
 */
	public void compInputShip(int id) {
		int ShipX;
		int ShipY;
			
		do {
		  ShipX = rand.nextInt(1000);
		  ShipY = rand.nextInt(1000);
		  int result = insertShip(ShipX, ShipY, true);
			
		  if(result == 0){
		    System.out.printf("%d. ship DEPLOYED \n", id);
			break;
		  }	
		 }while(true);
	}
	
  
  /**
   * 	fix
   * @param x
   * @param y
   * @param comp
   * @return
   */
  public int sinkShip(int x, int y) {
		
    if(x >= 10 || y >= 10){
	  return -1;
	  }
    
	else if(board[y][x] == '!' || board[y][x] == '-' || board[y][x] == 'x') { //already chosen
	  return -2;
	}
    
	else if(board[y][x] == ' ') { //missed
	  return 1;
	}
    
	else if(board[y][x] == 'c') { //comp ships hit
	  return 2;
	}
    
	else if(board[y][x] == '@') {                        //user ships hit
	  return 3;
	}
	else if(board[y][x] == 'm') {
	  return 4;
	}
	else {
	  return 0;
	}
		
  }
	
  /**
   * fix
   */
  public void userSinkShip() { //PROBLEMS, create loop in main to alternate bw user and comp and print, not reading in correctly 
    int x;
	int y;
	int result;
		
	do {
	  System.out.println("YOUR TURN");
	  System.out.print("Enter X coordinate: ");
	  x = input.nextInt();
	  System.out.print("Enter Y coordinate: ");
	  y = input.nextInt();
		
	  result = sinkShip(x, y);
		
	  if(result == -1) {
	    System.out.println("You can't place ships outside the 10 by 10 grid, please renter: ");
	    continue;
	  }
	  
	  if(result == -2) {
		System.out.println("This has coordinate has already been chosen! Pick a different value: ");
		continue;
	  }
	  
	  switch(result) {
	  case 1:
		  System.out.println("Sorry, you missed");
		  board[y][x] = '-';
		  break;
	  case 2:
		  System.out.println("Boom! You sunk the ship!");
		  board[y][x] = 'x';
		  break;
	  case 3:
		  System.out.println("Oh no, you sunk your own ship :'(");
		  board[y][x] = '!';
		  break;
	  case 4:
		  System.out.println("Sorry, you missed");
		  board[y][x] = '-';
		  break; 
	  default:
		  System.out.println("IMPOSSIBLE");
	  }
	  break;
	}while(true);
	printBoard();
  }
	
  public void compSinkShip() {
    int x;
	int y;
	int result;
	  
	System.out.println("COMPUTER'S TURN");
		    
	do {
	  x = rand.nextInt(1000);
	  y = rand.nextInt(1000);
	  if (x>=10 || y>= 10)
		  continue;
	  if(board[y][x] == 'm') 
		  continue;
	  result = sinkShip(x, y);
	  
	  if(result == -2) {
		  continue;
	  }
	  
	  System.out.printf("Computer Shoots at: %d %d\n", x, y);
	  switch (result) {
	      case 1:
	  	       board[y][x] = 'm';
		       System.out.println("Computer missed");
		       break;
	      case 2:
	           board[y][x] = 'x';
	    	   System.out.println("The Computer sunk one of its own ships");
	    	   break;
	      case 3:
	      	   board[y][x] = '!';
	    	   System.out.println("The Computer sunk one of your ships!");
	    	   break;
	      default:
	    	   System.out.println("Impossible");
	  }
	  break;    
	}while(true);
	printBoard();
  }
  
  /**
   *  prints the board after initializing location of
   *  user ships and computer ships
   */
  public void playGame() {
    userInputShip(1);
	userInputShip(2);
	userInputShip(3);
	userInputShip(4);
	userInputShip(5);
	
	System.out.println(" ");
	System.out.println("Computer is deploying ships");
	compInputShip(1);
	compInputShip(2);
	compInputShip(3);
	compInputShip(4);
	compInputShip(5);
	System.out.println("-----------------------------");
		
	printBoard();
			
}
boolean gameOver() { 
	
	int computerShip = 0; 
	int userShip = 0;
	
	for(int i = 0; i < 10; i++) {
	  for(int j = 0; j < board[i].length; j++) {
	    if(board[i][j] == '@') {
	      userShip++;
	    }
	    else if(board[i][j] == 'c') {
	      computerShip++;
	    }
	  }
	}
	
	System.out.printf("Computer ship: %d   User ship: %d\n", computerShip, userShip);
	if (computerShip == 0) {
		System.out.printf("User Wins\n");
		return true;
	}
	else if (userShip == 0) {
		System.out.printf("Computer Wins\n");
		return true;
	}
	else {
		return false;
	}
	
}

  public void battle() {
	int index = 0;
    do {
        if (index == 0) {
	      userSinkShip();
	      index += 1; // Give computer turn
        }
         else {
	      compSinkShip();
	      index = 0;  // User turn now
        }  
	  }while(!gameOver());
  }

  /**
   * 
   * @param args
   */
  public static void main(String[] args) {
	// TODO Auto-generated method stub
	battleShip battle1 = new battleShip();
	battle1.printBoard();
	battle1.playGame();
	battle1.battle();
	
		
	}
}

