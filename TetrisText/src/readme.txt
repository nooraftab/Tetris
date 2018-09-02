Hi!! This the ReadMe for the my command-line Tetris game!

Things to note:

For my 7 tetromino's, I made used the shortcut syntax to initialize the 3D array and then using a for-loop to assign all the values to my piece 3D array! I realised when I was in too deep that I could've just made use of the fact the indices were all initalized to false!

I also wanted the instruction for playing the game to be printed at the top of the board so that it was the first thing you'd see - because of that, I don't call my printView method in the contructor if TetrisGameTextView (I didn't want to have to print the instructions from the view because it felt like bad design to me)

Speaking of bad design, I don't know if it is that I made a lot of my instance variables in TetrisBoard public! It felt more concise and efficient for me to do that, since a getter method would've returned the same thing.

My piece only lands after pressing down again when it's at the bottom of the board - this is the expected behavior!

I also admit my rotateCW() and rotateCCW() are not the classiest methods in the world - I ended up not having methods for rotation in my Piece class at all! I managed to get my pieces to rotate by having a pieceRotation variable in TetrisBoard and only updating that! I figure it works since that's the variable I use when I call .isFilled() from Piece. CS really is wild.

:)
