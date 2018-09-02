/** This class essentially controls and updates the model and view of the Tetris game!
	It parses text written in the command line in order to update the model, and consequently,
	the view.

	@author NoorAftab
	@version 2
**/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TetrisGameTextController {

	//instance of TetrisBoard
	private TetrisBoard model;

	//instance of TetrisView
	private TetrisBoardTextView view;

	//initializes game and view variables
	public TetrisGameTextController() {

		model = new TetrisBoard();
		view = new TetrisBoardTextView (model);

		//starts the buffered reader
		readInput();

	}

	/** updates the game's view **/
	public void updateView() {

		System.out.println ("Please enter a move (l, r, d, z, x) or type Quit to end.");

		view.printView();

	}

	/** parses characters written into the command line and executes code accordingly.
		updates the view of the tetris board once a character is a passed in
	**/
	private void readInput () {

		//prints initial view of the board
		updateView();

		//initalizes a reader to the command line
		BufferedReader in = new BufferedReader (new InputStreamReader(System.in));	

		//holds user input
		String line = "";

		try {

			//try to read a line (can throw an IO exception!)
			line = in.readLine();

			//loops as long as 'quit' isn't typed in or the round isnt over
			while (!line.toLowerCase().equals("quit") && !model.isRoundDone) { 

				//if 'l' is typed, move piece left
				if (line.toLowerCase().equals("l")) {

					model.movePieceLeft();

				}

				//if 'r' is typed, move piece right
				else if (line.toLowerCase().equals("r")) {

					model.movePieceRight();

				}

				//if 'd' is typed, move piece down
				else if (line.toLowerCase().equals("d")) {

					model.movePieceDown();

				}

				//rotate clockwise if 'z' is typed
				else if (line.toLowerCase().equals("z")) {

					model.rotateCW();

				}

				//rotated counter-clockwise if 'x' is typed
				else if (line.toLowerCase().equals("x")) {

					model.rotateCCW();

				}

				//informs of error if user types in something not one of the above!
				else {

					System.out.println ("That wasn't a valid input! (Hint: Type slower!)");

				}

				//refreshes the view to show changes that may have occured in the model
				updateView();

				//asks for the next input
				line = in.readLine();

			}

		}

		//catches I/O exceptions
		catch (IOException ioenfe) {

			System.out.println("Error! IOException.");

		}


	}

}