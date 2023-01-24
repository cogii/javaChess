package chess;

abstract class Piece {
	
	//_player - 0 is white, 1 is black.
	//_icon - ASCII representation of character
	public int _player;
	public String _icon;
	int _rank;
	int _file;
	
	//Each piece will have it's own move set
	abstract public boolean Move(int rank, int file);
	//Each piece will need to check if piece is either white or black
	abstract public boolean isWhite();
	
}
