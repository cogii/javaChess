package chess;

public class FreshBoard {
	
	Piece[][] board = new Piece[8][8];
	
	public FreshBoard(){
		
		//instantiating black/white pawns
		for(int i = 0; i < 8; i++) {
			board[1][i] = new Pawn(1, 1, i);
		}
		
		for(int i = 0; i < 8; i++) {
			board[6][i] = new Pawn(0, 6, i);
		}
		
	}
	
	public Piece[][] returnBoard(){
		return board;
	}
}
