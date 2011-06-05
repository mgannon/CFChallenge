
/** A class to demonstrate the minimum number of moves 
 *  needed to completely cover a chess board
 *  with the movements of a knight.
 *  Credits for concept: http://en.wikipedia.org/wiki/Knight's_tour
 *  
 *  Board space numbers (for input) are from top left 0-63:
 *
 *  0  1  2  3  4  5  6  7
 *  8  9  10 11 12 13 14 15
 *  16 17 18 19 20 21 22 23
 *  24 25 26 27 28 29 30 31
 *  32 33 34 35 36 37 38 39
 *  40 41 42 43 44 45 46 47
 *  48 49 50 51 52 53 54 55
 *  56 57 58 59 60 61 62 63
 *
 * @author Matt Gannon 
 * @version for Code Foo Challenge, IGN project, 5/26/11
 */

public class KnightsTour
{
    public int start;
    public int[] board = {2,3,4,4,4,4,3,2,
			  3,4,6,6,6,6,4,3,
			  4,6,8,8,8,8,6,4,
			  4,6,8,8,8,8,6,4,
			  4,6,8,8,8,8,6,4,
			  4,6,8,8,8,8,6,4,
			  3,4,6,6,6,6,4,3,
			  2,3,4,4,4,4,3,2};
    public int[] orderTraveled =  { -1,-1,-1,-1,-1,-1,-1,-1,
				    -1,-1,-1,-1,-1,-1,-1,-1,
				    -1,-1,-1,-1,-1,-1,-1,-1,
				    -1,-1,-1,-1,-1,-1,-1,-1,
				    -1,-1,-1,-1,-1,-1,-1,-1,
				    -1,-1,-1,-1,-1,-1,-1,-1,
				    -1,-1,-1,-1,-1,-1,-1,-1,
				    -1,-1,-1,-1,-1,-1,-1,-1};
    public int knight;

    public KnightsTour() {
	start = 0;
	 
    }
    
    public KnightsTour(int s) {
	start = s;
	 
    }
    
    
    public void printBoard() {
	// a function to print out the board that shows the number of each move
	System.out.println("the knight took this path to travel over the board:");
	
	for (int i=0;i<64;i++) {
	    int c = this.orderTraveled[i];
            System.out.print(c);
	    if (c < 10 ) { System.out.print(" ");}
            System.out.print(" ");
	    
            if (i==7||i==15||i==23||i==31||i==39||i==47||i==55||i==63) {
                System.out.println("\n");
	    }
        }
	
    }
    
    
    
    public void doTour() {
	//function to do the knights tour around the board, knight moves to 
	//last slot that has lowest number of possible moves from that spot.
	this.knight = this.start;
	board[knight] = 0; //sets beginning spot to 0 
	int lowestLocation;    //just set it to a huge number for initialization
	int lowestValue;
	for(int i=0;i<200;i++) {
            board[knight] = 0;
	    orderTraveled[knight] = i; //sets the current panel to the turn number
	    //the following checks look at the current position's location, and
	    //subtract one from the possible moves of the applicable spots linked to the current spot
	    if ((knight%8) >= 2 ) {
		
		if((knight/8)>= 1) {
		    board[knight-10] = board[knight-10] -1; }
		if((knight/8)<=6 ) {
		    board[knight+6] = board[knight+6] -1;}
	    }
	    
	    if ((knight%8) <= 5) {
		if((knight/8) >= 1) {
		    board[knight-6] = board[knight-6] -1; }
		if((knight/8) <= 6) {
		    board[knight+10] = board[knight+10] -1;}
	    }
	
	    if ((knight/8) >=2 ) {
		if((knight%8) >= 1) {
		    board[knight-17] = board[knight-17] -1;}
		if((knight%8) <= 6) {
		    board[knight-15] = board[knight-15] -1;}
	    }
	    
	    if ((knight/8) <=5 ) {
                if((knight%8) >= 1) {
                    board[knight+15] = board[knight+15] -1;}
                if((knight%8) <= 6) {
                    board[knight+17] = board[knight+17] -1;}
            }
	
	    // the following checks look at the current value of the spaces around it and decide which is the lowest, then moves to it.    
	    lowestValue = 8;
	    lowestLocation= -1;
	    if ((knight%8) >= 2 ) {
	    
                if((knight/8)>= 1) {
                    if (((board[knight-10] <= lowestValue)&&((board[knight-10]) > 0 ))){
				lowestValue = board[knight-10];
				lowestLocation= knight-10;
			    }
		}
                if((knight/8)<=6 ) {
		    if (((board[knight+6] <= lowestValue)&&((board[knight+6]) > 0 ))){
                                lowestValue = board[knight+6];
				lowestLocation = knight+6;
			    }
		}
	    }

            if ((knight%8) <= 5) {
		if((knight/8) >= 1) {
		    if (((board[knight-6] <= lowestValue)&&((board[knight-6]) > 0 ))){
			lowestValue = board[knight-6];
			lowestLocation = knight-6;             
		    }   
		}
                if((knight/8) <= 6) {
		    if (((board[knight+10] <= lowestValue)&&((board[knight+10]) > 0 ))){
			lowestValue = board[knight+10];
			lowestLocation = knight+10;
		    }
		}
	    }
            
	    if ((knight/8) >=2 ) {
                if((knight%8) >= 1) {
		    if (((board[knight-17] <= lowestValue)&&((board[knight-17]) > 0 ))){
			lowestValue = board[knight-17];
			lowestLocation = knight-17;
		    }
		}
                if((knight%8) <= 6) {
		    if (((board[knight-15] <= lowestValue)&&((board[knight-15]) > 0 ))){
			lowestValue = board[knight-15];
			lowestLocation = knight-15;
		    }
		}
            }


            if ((knight/8) <=5 ) {
                if((knight%8) >= 1) {
		    if (((board[knight+15] <= lowestValue)&&((board[knight+15]) > 0 ))){
			lowestValue = board[knight+15];
			lowestLocation = knight+15;
		    }
		}
                if((knight%8) <= 6) {
		    if (((board[knight+17] <= lowestValue)&&((board[knight+17]) > 0 ))){
			lowestValue = board[knight+17];
			lowestLocation = knight+17;
		    }
		}
            }





	    if (i == 62) {                   // was having a bug where it would never take the last
		//space, because there were no possible moves FROM there.... had to make this.
		if ((knight%8) >= 2 ) {
		    
		    if((knight/8)>= 1) {
			if (board[knight-10] ==0){
                                lowestLocation= knight-10;
			}
		    }
		    if((knight/8)<=6 ) {
			if (board[knight+6] == 0 ){
			    lowestLocation = knight+6;
			}
		    }
		}
		    
		if ((knight%8) <= 5) {
		    if((knight/8) >= 1) {
			if (board[knight-6] == 0){
			    lowestLocation = knight-6;
			}
		    }
		    
		    if((knight/8) <= 6) {
			if (board[knight+10] == 0){
			    lowestLocation = knight+10;
			}
		    }    
		}
		
		if ((knight/8) >=2 ) {
		    if((knight%8) >= 1) {
			if (board[knight-17] ==0){
			    lowestLocation = knight-17;
			}
		    }
		    if((knight%8) <= 6) {
			if (board[knight-15] ==0){
			    lowestLocation = knight-15;
			}
		    }
		}
		
		if ((knight/8) <=5 ) {
		    if((knight%8) >= 1) {
			if (board[knight+15] ==0){
			    lowestLocation = knight+15;
			}
		    }
		    if((knight%8) <= 6) {
			if (board[knight+17] == 0){
			    lowestLocation = knight+17;
			}
		    }
		}
	    }
	    
	    if (lowestLocation == -1) {
		return;} //this means that there was no location that was greater than zero or in the case of the last turn, equal to zero
	    
	    knight = lowestLocation; //this moves the knight to the spot with the lowest known number of moves from that spot.
	    
	}
	return;
    }
	


    public static void main(String[] args)
    {
	System.out.println("0 represents where the knight started, and the numbers represent what turn number the knight was on each square.");

	KnightsTour k1 = new KnightsTour(0);
	k1.doTour();
	k1.printBoard();
	
	KnightsTour k2 = new KnightsTour(50);
	k2.doTour();
	k2.printBoard();

	KnightsTour k3 = new KnightsTour(24);
	k3.doTour();
	k3.printBoard();

    }
}