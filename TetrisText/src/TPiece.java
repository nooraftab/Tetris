/** This class creates the 4 rotations of the T tetromino in Tetris!

	@author NoorAftab
	@version 1
**/

public class TPiece extends Piece {

	//constructor for the TPiece
	public TPiece () {

		//initalizes the t tetromino
		boolean[][][] tPiece = {

									{
										{true, true, true, false},
										{false, true, false, false},
										{false, false, false, false},
										{false, false, false, false}

									},

									{
										{false, true, false, false},
										{true, true, false, false},
										{false, true, false, false},
										{false, false, false, false}

									},

									{
										{false, true, false, false},
										{true, true, true, false},
										{false, false, false, false},
										{false, false, false, false}

									},

									{
										{true, false, false, false},
										{true, true, false, false},
										{true, false, false, false},
										{false, false, false, false}

									}
							   };

		//assigns values of tPiece to piece
	    for (int i = 0; i < piece.length; i ++) {

	    	for (int j = 0; j < piece[i].length; j++) {

	    		for (int k = 0; k < piece[i][j].length; k++) {

	    			piece[i][j][k] = tPiece[i][j][k];

	    		}
	    	}
	    }															   
	}

}