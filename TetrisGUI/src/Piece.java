/** This class is a superclass for the 7 different Tetromino's! It initializes the 3D piece array,
	handles rotation, and checks where in the 3D array a block of the piece is present

	@author NoorAftab
	@version 3
**/

public abstract class Piece {

	public static final int SIZE = 4;

	/**variable declaration for a 3D array (3D to hold the number of rotations, as well as the 
		2D representation of the piece at each rotation) 
	**/
	protected boolean [][][] piece = new boolean[SIZE][SIZE][SIZE];

	//constructor for Piece
	public Piece () {

	}

	/** this method checks, for a given degree of rotation (which we divide by 90
		in order to get the corresponding rotation we can pass into our 4x4x4 array),
		if the piece at the particular index [row][col] is true

		@param rotation the particular rotation status we want to check the 2D array of
		@param row the row within the 2D array
		@param col the column within the 2D array
		@return returns true if there is a part of the piece present (if the index is true)
	**/
	public boolean isFilled (int rotation, int row, int col) {

		if (piece[rotation/90][row][col]) {

			return true;

		}

		return false;

	}
	
}