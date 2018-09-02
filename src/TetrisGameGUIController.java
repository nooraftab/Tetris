/** Controls the game by updating the model for Tetris and refreshing the view 
	every second as well as when a relevant key is pressed

	Page sed to help create the timer: https://www.math.uni-hamburg.de/doc/java/tutorial/uiswing/misc/timer.html

	@author NoorAftab
	@version 2
**/

import javax.swing.JFrame; 
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent; 
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;
import java.lang.Integer;

public class TetrisGameGUIController extends JPanel implements KeyListener {

	//1 second delay for the timer
	private static final int DROP_RATE = 1000;

	//variable to hold a tetris board (the logic of the game)
	private TetrisBoard model;

	//variable to hold the view of the game
	private TetrisBoardGUIView view;

	//JLabel variables to hold scores for lines and tetrises cleared
	private JLabel lineScoreLabel, tetrisScoreLabel;

	//variable to hold a swing timer
	private Timer timer;

	//contructor sets up the game
	public TetrisGameGUIController() {

		//adds a key listener to the panel
		setFocusable(true); 
		addKeyListener(this);

		//initializes the model and view for tetris
		model = new TetrisBoard();
		view = new TetrisBoardGUIView(model);

		//creates the frame to hold the game board and the scores
		createView();

		//creates the timer to drop pieces down 
		setUpTimer();

	}

	//sets up our timer to drop pieces down
	private void setUpTimer () {

		//initialises the timer with a 1 second delay and an action listener
		timer = new Timer (DROP_RATE, new ActionListener() {

			//sets up the tasks for the timer to repetitively do
			public void actionPerformed (ActionEvent ae) {  //adapted from online (link above)

				//moves current tetromino down and displays the change
				model.movePieceDown();
				refreshDisplay();

				//stops the timer if the game is lost
				if (model.isRoundDone) {

					timer.stop();

				}

			}
		});

		//makes it so the game starts immediately upon opening (hope you have good reflexes!)
		timer.setInitialDelay(0);

		//starts timer
		timer.start();

	}

	//creates the view of the game (the scores and the tetris board)
	private void createView() {
		
		//sets the jpanel to a vertical box layout
		setLayout(new BoxLayout (this, BoxLayout.Y_AXIS));

		//adds the line and tetris scores to the panel
		createScore();

		//adds the board JComponent to the panel
		add(view);

		//creates a jframe and adds this jpanel to it
		JFrame frame = new JFrame();
		frame.setSize(400,700);
		frame.add(this);

		//makes it so closing the frame closes the programs too
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//displays the frame
		frame.setVisible(true);

	}

	//creates scoring jlabels and subpanels and adds them to the larger JPanel
	private void createScore() {

		//creates line subpanel and sets it to have a horizontal box layout
		JPanel linePanel = new JPanel();
		linePanel.setLayout (new BoxLayout(linePanel, BoxLayout.X_AXIS));

		//adds a label for lines made to the linePanel
		JLabel lineLabel = new JLabel ("Lines Cleared: ");
		linePanel.add(lineLabel);

		//adds a score label for number of lines made
		lineScoreLabel = new JLabel (Integer.toString(model.lineScore));
		linePanel.add(lineScoreLabel);

		//adds linePanel to this JPanel
		add(linePanel);

		//creates a tetris subpanel, giving it a horizontal box layout
		JPanel tetrisPanel = new JPanel();
		tetrisPanel.setLayout (new BoxLayout(tetrisPanel, BoxLayout.X_AXIS));

		//adds a label for tetrises made to tetrisPanel
		JLabel tetrisLabel = new JLabel ("Tetrises Formed: ");
		tetrisPanel.add(tetrisLabel);

		//adds a score label for number of tetrises made
		tetrisScoreLabel = new JLabel (Integer.toString(model.tetrisScore));
		tetrisPanel.add(tetrisScoreLabel);

		//adds tetrisPanel to this JPanel
		add(tetrisPanel); 

	}

	//refreshes the scores and the board display
	private void refreshDisplay () {

		//updates score labels
		lineScoreLabel.setText(Integer.toString(model.lineScore));
		tetrisScoreLabel.setText(Integer.toString(model.tetrisScore));

		//updates the graphics of the board
		repaint();

	}

	/** updates the model (and the view) according to which relevant key is pressed
		@param e a key event (here, a pressed key)
	**/
	public void keyPressed (KeyEvent e) {

		//local variable for efficiency
		int key = e.getKeyCode();

		//moves piece down if down arrow was pressed
		if (key == KeyEvent.VK_DOWN) {

			model.movePieceDown();

		}

		//moves piece left if left arrow was pressed
		else if (key == KeyEvent.VK_LEFT) {

			model.movePieceLeft();

		}

		//moves piece right if right arrow was pressed
		else if (key == KeyEvent.VK_RIGHT) {

			model.movePieceRight();

		}

		//rotates piece clockwise if the letter Z is pressed
		else if (key == KeyEvent.VK_Z) {

			model.rotateCW();

		}

		//rotates piece counter-clockwise if the letter X is pressed
		else if (key == KeyEvent.VK_X) {

			model.rotateCCW();

		}

		//updates the scores and graphics of the game
		refreshDisplay();

	}

	/** required function from KeyListener interface
		@param e a KeyEvent (where a key is released) 
	**/
	public void keyReleased (KeyEvent e) {

	}

	/** required function from KeyListener interface
		@param e a KeyEvent (where a key is typed)
	**/
	public void keyTyped (KeyEvent e) {

	}

}