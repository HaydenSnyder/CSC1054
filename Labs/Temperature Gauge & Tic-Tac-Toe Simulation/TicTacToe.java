import java.util.Scanner;

public class TicTacToe 
{
    private char[][] array = new char[3][3]; 
    private char currentPlayer;
    private int movesTotal;

    // Constructor to initialize the game board
    public TicTacToe() 
    {
        // Create a for loop for rows
        for (int i = 0; i < 3; i++) 
        {
            // Create a for loop for columns
            for (int j = 0; j < 3; j++) 
            {
               // Input - for open spaces
                array[i][j] = '-'; 
            }
        }
        currentPlayer = 'X'; 
        movesTotal = 0; 
    }

    // Check if four moves have been played
    public boolean hasFourMovesHaveBeenplayed() 
    {
        return movesTotal >= 4;
    }

    // Get the current player's turn
    public char getCurrentPlayer() 
    {
        return currentPlayer;
    }

    // Method to play a move at the specified x and y position
    public boolean play(int x, int y) 
    {
        // Check for out-of-bounds moves
        if (x < 0 || x >= 3 || y < 0 || y >= 3) 
        {
            return false;
        }

        // Check if the spot is already taken
        if (array[x][y] != '-') 
        {
            return false;
        }

        // Make the move
        array[x][y] = currentPlayer;
        movesTotal++;

        // Switch the player
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';

        return true;
    }

    // Method to display the current board
    public String getBoard() 
    {
      // Create a stringbuilder 
        StringBuilder currentBoard = new StringBuilder();
        
        // Create a for loop to outprint Strings, Rows
        for (int i = 0; i < 3; i++) 
        {
            // Columns
            for (int j = 0; j < 3; j++) 
            {
               // Print out spaces in between letters
                currentBoard.append(array[i][j]).append(" ");
            }
            // Print on new line
            currentBoard.append("\n");
        }
        
        // Ourprint the string
        return currentBoard.toString();
    }
}