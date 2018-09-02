/** Constructs a JComponent Tetris board, with purple blocks! 

	@author NoorAftab
	@version 3
**/

import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Color;

public class TetrisBoardGUIView extends JComponent {

	//variable to hold our tetris model
	private TetrisBoard model;

	/** constructor for the class
		@param model a passed in TetrisBoard to execute code with
	**/
	public TetrisBoardGUIView (TetrisBoard model) {

		this.model = model;

	}

	/** creates the art for the tetris game (eg the piece, the board) 
		@param g used to draw things 
	**/
	public void paint (Graphics g) {

		//variable to hold the tetris board
		boolean[][] board = model.getBoard();

		//variable to hold the current piece on the board and it's rotation
		Piece piece = model.getCurrentPiece();
		int rot = model.pieceRotation;

		//holds the piece's row and column on the board
		int pieceRow = model.currentPiecePosition[0];
		int pieceCol = model.currentPiecePosition[1];

		//variable to hold the size of a block (for efficiency's sake)
		int size = computeBlockSize();

		//loops through the tetris board
		for (int i = 0; i < board.length; i++) {

			for (int j = 0; j < board[i].length; j++) {

				//paints a block if the index of the board is true
				if (board[i][j]) {

					paintBlock (g, j*size, i*size, size);
					
				}

				//otherwise, checks if the array is looping through the piece
				else if ((i >= pieceRow) && (i < pieceRow + piece.SIZE) &&
					    (j >= pieceCol) && (j < pieceCol + piece.SIZE)) {

					//paints a block if index of the piece's 2D array should have a block
					if (piece.isFilled(rot, i - pieceRow, j - pieceCol)) {

						paintBlock (g, j*size, i*size, size);

					}

				}

			}

		}

		//draws a black rectangular outline to help see the tetris board better!
		g.drawRect (0, 0, model.NUM_COLS*size, model.NUM_ROWS*size);

	}


	/** paints a purple square, along with a black outline over it, using
		a Graphics object, at a given x and y coordinate, with a size parameter
		for the length of the sides!
	**/
	private void paintBlock (Graphics g, int x, int y, int size) { 

		//paints a pretty purple block
		g.setColor (new Color (147, 112, 219));
		g.fillRect (x, y, size, size);

		//paints a classic black outline
		g.setColor(Color.BLACK);
		g.drawRect (x, y, size, size);

	}

	//returns a length for our blocks based on the height the component takes
	private int computeBlockSize () {  

		//splits the component into 18 equal parts to get ideal block dimensions
		int blockSize = getHeight()/model.NUM_ROWS;  

		return blockSize;

	}

}