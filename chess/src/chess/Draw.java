package chess;


//Draw class will hold the logic for printing out the current chess board.


public class Draw {
	
	public Draw(Piece[][] board) {
		
		for(int i = 0; i < 8; i++) {
			if(i == 0) {System.out.print("A ");}
			if(i == 1) {System.out.print("B ");}
			if(i == 2) {System.out.print("C ");}
			if(i == 3) {System.out.print("D ");}
			if(i == 4) {System.out.print("E ");}
			if(i == 5) {System.out.print("F ");}
			if(i == 6) {System.out.print("G ");}
			if(i == 7) {System.out.print("H ");}
			
			for(int j = 0; j < 8; j++) {
				if(board[i][j] instanceof Piece) {
					System.out.print(" " + board[i][j]._icon + " ");
				}else  {
					System.out.print(" x ");
				}
			}
			System.out.println("");
		}
		
		System.out.println("   1  2  3  4  5  6  7  8  ");
		
	}
}
