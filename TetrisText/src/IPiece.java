/** This class constructs the I tetromino & it's 4  rotations!
	
	@author NoorAftab
	@version 1
**/



public class IPiece extends Piece {


	//constructor for the IPiece 
	public IPiece () {

		//shortcut syntax to initialize an iPiece 
		boolean[][][] iPiece = {

								{
									{true, false, false, false},
									{true, false, false, false},
									{true, false, false, false},
									{true, false, false, false}

								},

								{
									{true, true, true, true},
									{false, false, false, false},
									{false, false, false, false},
									{false, false, false, false}

								},

								{
									{true, false, false, false},
									{true, false, false, false},
									{true, false, false, false},
									{true, false, false, false}
									
								},

								{
									{false, false, false, false},
									{false, false, false, false},
									{false, false, false, false},
									{true, true, true, true}

								}

							};

		//loop to set the values of piece equal to iPiece
	    for (int i = 0; i < piece.length; i ++) {

	    	for (int j = 0; j < piece[i].length; j++) {

	    		for (int k = 0; k < piece[i][j].length; k++) {

	    			piece[i][j][k] = iPiece[i][j][k];

	    		}
	    	}
	    }

	}

}