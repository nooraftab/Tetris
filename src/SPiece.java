/** This class creates the 4 rotations of the S tetromino!

	@author NoorAftab
	@version 1
**/

public class SPiece extends Piece {

	//constructor for the SPiece
	public SPiece () {

		//initalizes sPiece array
		boolean[][][] sPiece = {

									{
										{false, true, true, false},
										{true, true, false, false},
										{false, false, false, false},
										{false, false, false, false}

									},

									{
										{true, false, false, false},
										{true, true, false, false},
										{false, true, false, false},
										{false, false, false, false}

									},

									{
										{false, true, true, false},
										{true, true, false, false},
										{false, false, false, false},
										{false, false, false, false}

									},

									{
										{true, false, false, false},
										{true, true, false, false},
										{false, true, false, false},
										{false, false, false, false}

									}

							   };

		//assigns values of sPiece to piece
	    for (int i = 0; i < piece.length; i ++) {

	    	for (int j = 0; j < piece[i].length; j++) {

	    		for (int k = 0; k < piece[i][j].length; k++) {

	    			piece[i][j][k] = sPiece[i][j][k];

	    		}
	    	}
	    }															   

	}

}