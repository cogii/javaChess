package chess;
import java.util.Scanner;

public class Driver {

	//White always starts
	//All check/check mate booleans start as false
	static int _turn = 0;
	static String _input;
	static int _tmp0;
	static int _tmp1;
	static int _tmp3;
	static int _tmp4;
	static int _tmp5;
	static char _tmp6;
	static String _tmp7;
	static boolean _toPlay = false;
	static boolean _toMove = false;
	static boolean _whiteCheck = false;
	static boolean _whiteCheckMate = false;
	static boolean _blackCheck = false;
	static boolean _blackCheckMate = false;
	static Scanner _sc = new Scanner(System.in);
	static Piece[][] _board = new FreshBoard().returnBoard();
	
	public static void main(String[] args) {
		
//		//When the program is run initially, the board will have all the pieces
//		//instantiated in each 
//		Piece[][] _board = new FreshBoard().returnBoard();
// 		
 		//Main while loop which will keep the game going so long as the
 		//black or white player is not in check mate
 		while(_whiteCheckMate == false || _blackCheckMate == false) {
 			//Draws the ASCII board
 	 		new Draw(_board);
 	 		
 	 		//Player turn check
 	 		if(_turn == 0) {
 	 			System.out.println("White Player's Turn" + '\n');
 	 		}else {
 	 			System.out.println("Black Player's Turn" + '\n');
 	 		}
 	 		
 	 		//Selects piece on the board, need a while loop to make sure
 	 		//that a piece of the current player is selected
 	 		while(_toPlay == false) {
 	 	 		System.out.print("Select piece to move: ");
 	 	 		_input = _sc.nextLine();
 	 	 		
 	 	 		//Checks to make sure that the spot selected is a spot on the board
 	 	 		//so we don't have an OutOfBounds issue, and that the piece selected is
 	 	 		//playable by the current player
 	 	 		if(validSpot(_input)) {
 	 	 			_tmp0 = getDigit(_input.charAt(0));
 	 	 			_tmp1 = getDigit(_input.charAt(1));
 	 	 			_input = "";
 	 	 			if(isPlayable(_tmp0, _tmp1)) {
 	 	 	 			_toPlay = true;
 	 	 			}
 	 	 		}
 	 		}
 	 		
 	 		while(_toMove == false) {
 	 			System.out.print("Select spot to move to: ");
 	 			_input = _sc.nextLine();
 	 			
 	 			if(validSpot(_input)) {
 	 				_tmp3 = getDigit(_input.charAt(0));
 	 				_tmp4 = getDigit(_input.charAt(1));

 	 				//TODO: Think I need another method here to make this more clean.
 	 				//TODO: Need to make sure that the move in question is possible by the piece
 	 				//More specifically, that the piece selected is not moving into a space that
 	 				//is in the collection of that same piece
 	 				//to begin with by checking _board[x][y].move(x,y)
 	 				
 	 				
 	 				//TODO: needs to make sure a piece does not overtake another piece in an incorrect manner.
 	 				//Example: Pawn moving forward into an enemy piece. Pawns can only overtake an enemy piece
 	 				//ONLY if it is moving diagonally into an enemy piece.
 	 				if(isPlayable(_tmp3, _tmp4) && _board[_tmp0][_tmp1].Move(_tmp3, _tmp4) == true) {
 	 	 				if((_board[_tmp3][_tmp4] == null || _board[_tmp3][_tmp4] instanceof Piece)) {
 	 	 					_board[_tmp3][_tmp4] = _board[_tmp0][_tmp1];
 	 	 					_board[_tmp0][_tmp1] = null;
 	 	 					_toMove = true;
 	 	 				}
 	 				}
 	 			}
 	 		}
 	 		
 	 		//check if black or white king in check or check mate
 	 		
 	 		//reset all temporary values to null, while loop booleans to false, and change player
 	 		_toPlay = false;
 	 		_toMove = false;
 	 		if(_turn == 0) {
 	 			_turn = 1;
 	 		}else {
 	 			_turn = 0;
 	 		}
 	 		
 	 		
 		}
		

	}
	
	//Checks if the user input is a valid spot on the board
	public static boolean validSpot(String input) {
		
		//If the input is not null, the length is 2, the character at [1] is a digit,
		//the character at [0] is an alphabetic character, the character at [0] is
		// A - H inclusive (upper case or lower case), and the digit at [1] is between
		//1 - 8 inclusive, then it is a valid spot on the board.
		if(input != null) {
			if(input.length() == 2) {
				if(Character.isDigit(input.charAt(1))) {
					_tmp6 = _input.charAt(1);
					_tmp7 = String.valueOf(_tmp6);
					_tmp5 = Integer.parseInt(_tmp7);
					if(Character.isAlphabetic(input.charAt(0))) {
			 	 		if(input.charAt(0) == 'A' || input.charAt(0) == 'a' || 
		 	 	 		   input.charAt(0) == 'B' || input.charAt(0) == 'b' ||
		 	 	 		   input.charAt(0) == 'C' || input.charAt(0) == 'c' ||
		 	 	 		   input.charAt(0) == 'D' || input.charAt(0) == 'd' || 
			 	 		   input.charAt(0) == 'E' || input.charAt(0) == 'e' ||
			 	 		   input.charAt(0) == 'F' || input.charAt(0) == 'f' ||
			 	 		   input.charAt(0) == 'G' || input.charAt(0) == 'g' ||
			 	 		   input.charAt(0) == 'H' || input.charAt(0) == 'h') {
		 	 	 			if(_tmp5 == 1 || _tmp5 == 2 ||
		 	 	 			   _tmp5 == 3 || _tmp5 == 4 ||
		 	 	 			   _tmp5 == 5 || _tmp5 == 6 ||
			 	 			   _tmp5 == 7 || _tmp5 == 8) {
		 	 	 				return true;
		 	 	 			}
			 	 		}
					}
				}
			}
		}
		
		return false;
	}
	
	//Returns an int based on user input
	public static int getDigit(char input) {
		if(Character.isAlphabetic(input)) {
 	 		if(input == 'A' || input == 'a'){
 	 			return 0;
 	 		} 
 	 		if(input == 'B' || input == 'b') {
 	 			return 1;
 	 		}
 	 		if(input == 'C' || input == 'c') {
 	 			return 2;
 	 		}
 	 		if(input == 'D' || input == 'd') {
 	 			return 3;
 	 		}
 	 		if(input == 'E' || input == 'e') {
 	 			return 4;
 	 		}
 	 		if(input == 'F' || input == 'f') {
 	 			return 5;
 	 		}
 	 		if(input == 'G' || input == 'g') {
 	 			return 6;
 	 		}
 	 		if(input == 'H' || input == 'h') {
 	 			return 7;
 	 		}
		}else if(Character.isDigit(input)) {
			_tmp6 = input;
			_tmp7 = String.valueOf(input);
			return Integer.parseInt(_tmp7) - 1;
		}
		
		return -1;
	}
	
	//TODO: Method has two functions. If a piece has been selected, it will verify that the piece
	//being moved is not going to overtake a piece that is in the same collection.
	//Otherwise, this method will check to see if the piece selected belongs to the player.
	//Checks to see if the selected piece belongs to the current player	
	public static boolean isPlayable(int rank, int file) {
		if(_toPlay) {
			if(_board[rank][file] == null || (_board[rank][file] instanceof Piece && _board[rank][file]._player != _turn)) {
				return true;
			}else if(_board[rank][file] != null && _board[rank][file] instanceof Piece && _board[rank][file]._player == _turn ) {
				return false;
			}
		}
		
		if(_board[rank][file] != null && _board[rank][file] instanceof Piece) {
			if(_board[rank][file]._player == _turn) {
				return true;
			}
		}
		return false;
	}
}
