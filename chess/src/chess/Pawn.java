package chess;

public class Pawn extends Piece{

	
	public Pawn(int player, int rank, int file) {
		_player = player;
		_rank = rank;
		_file = file;
		_icon = "p";
	}
	
	public Pawn() {
		
	}
	
	@Override
	public boolean Move(int rank, int file) {
		if(file == _file) {
			if(_player == 0) {
				if(rank == (_rank - 1)) {
					_rank = rank;
					return true;
				}
			}
			
			if(_player == 1) {
				if(rank == (_rank + 1)) {
					_rank = rank;
					return true;
				}
			}
		}
		return false;
		
		
		//		if(file != _file) {
//			return false;
//		}
//		
//		if(rank != (_rank + 1)){
//			return false;
//		}
//		
//		return true;
	}

	@Override
	public boolean isWhite() {
		if(_player == 0) {
			return true;
		}
		return false;
	}

}
