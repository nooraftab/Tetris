/** This class focuses on the logic of the Tetris game.
	@author NoorAftab
	@version 1
**/

import java.util.Random;

public class TetrisBoard {

	//variable to hold the 18x10 tetris board
	public boolean[][] board;

	//constants for the number of rows/columns in our board
	private static final int NUM_ROWS = 18;
	private static final int NUM_COLS = 10;

	//constant for incrementing a piece's degree of rotation
	private static final int ROT_INCREMENT = 90;

	//variables to hold the number of lines and tetrises cleared, as well as rotation status
	public int lineScore, tetrisScore, pieceRotation;

	//a variable to hold the current piece on the board
	public Piece currentPiece;

	//array to hold the grid position of the piece. [0] holds the row, [1] holds the column
	public int[] currentPiecePosition = new int[2];

	public boolean isRoundDone;

	/** constructor for TetrisBoard
		it initializes the game board to false, and adds a random piece to the board!
	**/
	public TetrisBoard () {

		board = new boolean[NUM_ROWS][NUM_COLS];
		addRandomPiece();

	}

	/** uses a random number generator to generate a piece at positon (0,3) on the board **/
	private void addRandomPiece () {

		//creates random generator 
		Random rand = new Random();

		//gets random number from 0-6
		int val = rand.nextInt(7);

		//assigns currentPiece to a unique tetromino depending on the number val takes
		switch (val) {

			case 0:

					currentPiece = new IPiece ();
					break;

			case 1:

					currentPiece = new JPiece ();
					break;

			case 2:

					currentPiece = new LPiece ();
					break;

			case 3:

					currentPiece = new OPiece ();
					break;

			case 4:

					currentPiece = new SPiece ();
					break;

			case 5:

					currentPiece = new TPiece ();
					break;

			case 6:

					currentPiece = new ZPiece ();
					break; 

		} 

		//initializes and resets the rotation of a new piece to 0 degrees
		pieceRotation = 0;

		//initalizes the position of the piece to the 0th row and 3rd column
		currentPiecePosition[0] = 0;
		currentPiecePosition[1] = 3;

		
	}	

	/** checks if a piece can move to a particular position by checking for 
		collisions and making sure it wouldn't go out of bounds
	**/
	private boolean isValidMove(Piece piece, int rot, int row, int col) {

		if (!isOutOfBounds(piece, rot, row, col) && 
			!isCollisionDetected(piece, rot, row, col)) {

			return true;

		}

		return false;

	}

	/** makes sure a given piece wouldn't collide with another landed piece
		on the board for an attempted rotation, row, and column for said piece,
		returning true if a collison happens
	**/
	private boolean isCollisionDetected (Piece piece, int rot, int row, int col) {

		//loops through the piece's 4x4 2D array
		for (int i = 0; i < piece.SIZE; i++) {

			for (int j = 0; j < piece.SIZE; j++) {

				//checks if the piece is true at a particular index of the given rotation
				if (piece.isFilled(rot, i, j)) {

					//checks if the board matrix is also true at that particular index
					if (board[row+i][col+j]) {

						return true;

					}

				}

			}

		}

		//returns false if no collision is detected
		return false;
	}

	/** checks, for an attempted rotation, row, and column of a piece, if the piece 
		would go out of the bounds of the board, returning true if it would go
		out of bounds
	**/
	private boolean isOutOfBounds (Piece piece, int rot, int row, int col) {

		//checks if piece's columb would go out the left side of the board
		if (col < 0) {

			return true;

		}

		//checks  other sides of the board
		else {

			//loops through the piece array for an attempted rotation
			for (int i = 0; i < piece.SIZE; i++) {

				for (int j = 0; j < piece.SIZE; j++) {

					//checks if the piece index would be true at the index [i][j]
					if (piece.isFilled(rot, i, j)) {

						//checks if any part of the piece would end up going out the board bound's
						if ((row + i) >= NUM_ROWS || (col + j) >= NUM_COLS) {

							return true;

						}
				
					}

				}

			}

		}

		return false;
	}

	/** moves a piece one row down (as long as it's a valid move) **/
	public void movePieceDown () {

		//increments row by 1 if moving down is a valid move
		if (isValidMove (currentPiece, pieceRotation, currentPiecePosition[0]+1, currentPiecePosition[1])) {

			currentPiecePosition[0]++;

		}

		//if the piece can't move down and is at the the initial position, the round must've ended
		else if (currentPiecePosition[0] == 0 && currentPiecePosition[1] == 3) {

			isRoundDone = true;

		}

		//otherwise, land the piece onto the board
		else {

			landPiece();

		}

	}

	/** moves piece to the left by decrementing the column by 1 **/
	public void movePieceLeft () {

		if (isValidMove (currentPiece, pieceRotation, currentPiecePosition[0], currentPiecePosition[1]-1)) {

			currentPiecePosition[1]--;

		}

	}

	/** moves piece to the right by incrementing the column by 1**/
	public void movePieceRight() {

		if (isValidMove(currentPiece, pieceRotation, currentPiecePosition[0], currentPiecePosition[1]+1)) {

			currentPiecePosition[1]++;

		}

	}

	/** rotates the piece clockwise by increasing the rotation value (that is often passed into
		the pieces .isFilled() method, making sure the value of the rotation doesn't exceed 270
		degrees 
	**/
	public void rotateCW () {
		
		//if rotation is more than 270 degrees, resets it to 0 (assuming that's a valid move)
		if (pieceRotation + ROT_INCREMENT > ROT_INCREMENT*3) {

			if (isValidMove(currentPiece, 0, currentPiecePosition[0], currentPiecePosition[1])) {

				pieceRotation = 0;

			}

		}

		//otherwise, increments the rotation by 90 degrees
		else {

			if (isValidMove(currentPiece, pieceRotation + ROT_INCREMENT,
				 currentPiecePosition[0], currentPiecePosition[1])) {

				pieceRotation += ROT_INCREMENT;

			}

		}

	}

	/** rotates the piece counter-clockwise by decrementing the rotation variable, ensuring it doesnt
		go below 0 degrees **/
	public void rotateCCW () {

		//resets pieceRotation to 270 degrees if it goes below 0 (assuming that's a valid move)
		if (pieceRotation - ROT_INCREMENT < 0) {

			if (isValidMove (currentPiece, ROT_INCREMENT*3, currentPiecePosition[0], currentPiecePosition[1])) {

				pieceRotation = ROT_INCREMENT*3;

			}

		}

		//otherwise, decrements the rotation angle by 90 degrees
		else {

			if (isValidMove (currentPiece, pieceRotation - ROT_INCREMENT, currentPiecePosition[0], currentPiecePosition[1])) {

				pieceRotation -= ROT_INCREMENT;

			} 

		}

	}	


	//adds a tetromino to the board matrix (once it reaches the bottom of the board)
	private void landPiece () {

		//loops through the 4x4 array of the piece
		for (int i = 0; i < currentPiece.SIZE; i++) {

			for (int j = 0; j < currentPiece.SIZE; j++) {

				//sets the relative board index to true if currentPiece is also true at that index
				if (currentPiece.isFilled(pieceRotation, i, j)) {

					board[currentPiecePosition[0]+i][currentPiecePosition[1]+j] = true; 

				}

			}
			
		}	

		//checks for lines forming
		checkLinesFormed();					

		//sets currentPiece to null and adds a new piece to the top of the board
		currentPiece = null;
		addRandomPiece();

	}

	//checks for and removes full lines in the board
	private void checkLinesFormed () {

		//counter to check if a tetris has formed
		int lineCount = 0;

		//loops through board rows
		for (int i = 0; i < NUM_ROWS; i++) {

			//check if a line has formed at row i
			if (isLineFormed(i)) {

				//increments counter
				lineCount++;

				//clears the row if it's all true
				clearLine(i);
			}

		}

		//updates tetrisScore if counter is 4 (meaning a tetris has formed)
		if (lineCount == 4) {

			tetrisScore++;

		}

		//otherwise, updates lineScore to the number of full lines in the board
		else if (lineCount > 0) {

			lineScore += lineCount;

		}

		//resets counter for the next time this function is called
		lineCount = 0;

	}

	/** checks if a given row on the board has all true values (meaning a line has formed)

		@param row is a passed in row for the method to loop through 
		@return returns true if all values are true (returns false if an index is found to be false)
	**/
	private boolean isLineFormed (int row) {

		for (int j = 0; j < NUM_COLS; j++) {

			if (!board[row][j]) {

				return false;

			}

		}

		return true;

	}

	/** function clears a given row by copying all rows above it to one row below
		@param row a passed in row in the board matrix **/
	private void clearLine (int row) {

		//loops through the board above the passed in row
		for (int i = row; i >= 1; i--) {

			for (int j = 0; j < NUM_COLS; j++) {

				//assigns index the value of the index right above it
				board[i][j] = board[i-1][j];

			}

		}

		//assigns all the values in row 0 to false
		for (int j = 0; j < NUM_COLS; j++) {

			board[0][j] = false;
			
		}

	}

}