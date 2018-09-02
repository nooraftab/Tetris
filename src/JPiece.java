/** This class constructs the J tetromino and it's 4rotations

	@author NoorAftab
	@version 1
**/

public class JPiece extends Piece {

	//constructor for jPiece
	public JPiece () {

		//initializes jPiece array
		boolean[][][] jPiece = {

									{
										{false, true, false, false},
										{false, true, false, false},
										{true, true, false, false},
										{false, false, false, false}

									},

									{
										{true, false, false, false},
										{true, true, true, false},
										{false, false, false, false},
										{false, false, false, false}

									},

									{
										{true, true, false, false},
										{true, false, false, false},
										{true, false, false, false},
										{false, false, false, false}

									},

									{
										{false, false, false, false},
										{true, true, true, false},
										{false, false, true, false},
										{false, false, false, false}

									}

								};


		//assigns every value in jPiece to piece
	    for (int i = 0; i < piece.length; i ++) {

	    	for (int j = 0; j < piece[i].length; j++) {

	    		for (int k = 0; k < piece[i][j].length; k++) {

	    			piece[i][j][k] = jPiece[i][j][k];

	    		}
	    	}
	    }								

	}

}