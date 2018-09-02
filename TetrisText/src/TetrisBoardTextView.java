/** This class prints the Tetris game to the command line, using information from the TetrisBoard model

	@author NoorAftab
	@version 3
**/

import javax.swing.*;

public class TetrisBoardTextView {

	//instance of TetrisBoard to gather game information to display
	private TetrisBoard model;

	/** constructor for TetrisBoardTextView
		@param model assigns an actual passed in TetrisBoard to the model variable 
	**/
	public TetrisBoardTextView (TetrisBoard model) {

		this.model = model;

	}

	/** prints the whole view of our tetris board, including scores and line breaks **/
	public void printView() {


		//prints number of lines cleared
		System.out.println ("Number of lines cleared: " + model.lineScore);

		//prints number of tetrises cleared
		System.out.println ("Number of Tetrises cleared: " + model.tetrisScore);

		//line breaks for da aesthetic (to signify where the board begins)
		System.out.println ("__________");

		//prints the actual board for the tetris game
		printBoard();

		//line breaks for da aesthetic (to signify where the board ends)
		System.out.println("__________");

		//prints out a message if the round is over
		if (model.isRoundDone) {

			System.out.println("sux 2 suk");
		}

	}

	//prints the board to the terminal 
	private void printBoard () {

		//gets the game board from the model
		boolean[][] board = model.board;

		//gets the current piece from the model
		Piece piece = model.currentPiece;

		//gets the current rotation variable from the model
		int rot = model.pieceRotation;

		//stores the current row and column of the piece
		int pieceRow = model.currentPiecePosition[0];
		int pieceCol = model.currentPiecePosition[1];

		//loops through the board
		for (int i = 0; i < board.length; i++) {

			for (int j = 0; j < board[j].length; j++) {

				//prints an X on the board if the index is true
				if (board[i][j]) {

					System.out.print("X");
				}

				//otherwise, checks if the values of i and j are within the confines of the piece's 4x4 array
				else if ((i >= pieceRow) && (i < (pieceRow + piece.SIZE)) && 
						(j >= pieceCol) && (j < (pieceCol + piece.SIZE))) {

					//prints an X if the piece if true at i-pieceRow and j-pieceCol, for a rotation rot
					if (piece.isFilled(rot, i - pieceRow, j - pieceCol)) {

						System.out.print("X");

					}

					//otherwise, prints a space
					else {

						System.out.print(" ");

					}

				}

				//otherwise, prints a space on the board
				else {

					System.out.print(" ");
				}

			}

			//starts a new line after a row is printed
			System.out.println("");

		}


	}

}