/** This class creates the 4 rotations of the OPiece using a 3D array (even though they're
	all exactly the same! It's more for the uniformity of the design of the pieces.)

	@author NoorAftab
	@version 1
**/

public class OPiece extends Piece {

	//constructor for OPiece
	public OPiece () {

		//initalizes oPiece array
		boolean[][][] oPiece = {
									{
										{true, true, false, false},
										{true, true, false, false},
										{false, false, false, false},
										{false, false, false, false}

									},

									{
										{true, true, false, false},
										{true, true, false, false},
										{false, false, false, false},
										{false, false, false, false}

									},

									{
										{true, true, false, false},
										{true, true, false, false},
										{false, false, false, false},
										{false, false, false, false}

									},

									{
										{true, true, false, false},
										{true, true, false, false},
										{false, false, false, false},
										{false, false, false, false}

									}

							   };

		//assigns values of oPiece to piece
	    for (int i = 0; i < piece.length; i ++) {

	    	for (int j = 0; j < piece[i].length; j++) {

	    		for (int k = 0; k < piece[i][j].length; k++) {

	    			piece[i][j][k] = oPiece[i][j][k];

	    		}
	    	}
	    }																			   

	}

}