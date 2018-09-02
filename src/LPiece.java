/** This class constructs the 4 rotations of the L-shaped tetromino

	@author NoorAftab
	@version 1
**/

public class LPiece extends Piece {

	//constructor for LPiece 
	public LPiece () {

		//initalizes lPiece array
		boolean[][][] lPiece = {

									{
										{true, false, false, false},
										{true, false, false, false},
										{true, true, false, false},
										{false, false, false, false}

									},

									{
										{true, true, true, false},
										{true, false, false, false},
										{false, false, false, false},
										{false, false, false, false}

									},

									{
										{true, true, false, false},
										{false, true, false, false},
										{false, true, false, false},
										{false, false, false, false}

									},

									{
										{false, false, true, false},
										{true, true, true, false},
										{false, false, false, false},
										{false, false, false, false}

									},

							   };

		//assigns values of lPiece to piece
	    for (int i = 0; i < piece.length; i ++) {

	    	for (int j = 0; j < piece[i].length; j++) {

	    		for (int k = 0; k < piece[i][j].length; k++) {

	    			piece[i][j][k] = lPiece[i][j][k];

	    		}
	    	}
	    }															   

	}

}