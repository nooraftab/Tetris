/** This class creates the 4 rotations of the Z tetromino in Tetris!

	@author NoorAftab
	@version 1
**/

public class ZPiece extends Piece {

	//constructor for the SPiece
	public ZPiece () {

		//initalizes the z tetromino
		boolean[][][] zPiece = {

									{
										{true,true, false, false},
										{false, true, true, false},
										{false, false, false, false},
										{false, false, false, false}

									},

									{
										{false, true, false, false},
										{true, true, false, false},
										{true, false, false, false},
										{false, false, false, false}

									},

									{
										{true,true, false, false},
										{false, true, true, false},
										{false, false, false, false},
										{false, false, false, false}

									},

									{
										{false, true, false, false},
										{true, true, false, false},
										{true, false, false, false},
										{false, false, false, false}

									}

							   };

		//sets the values of zPiece to piece
	    for (int i = 0; i < piece.length; i ++) {

	    	for (int j = 0; j < piece[i].length; j++) {

	    		for (int k = 0; k < piece[i][j].length; k++) {

	    			piece[i][j][k] = zPiece[i][j][k];

	    		}
	    	}
	    }											

	}

}