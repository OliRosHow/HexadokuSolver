import java.util.Scanner;
import java.util.ArrayList;
/**
 * this class is used to build the hexadoku board object
 */
public class HexadokuBoardBuilder 
{
    private Character[][] board = new Character[16][16];
    private Character[] choices = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    /**
     * constructor for the builder object
     * @param in the Scanner object linked to the file with the unsolved hexadoku puzzle
     */
    public HexadokuBoardBuilder(Scanner in)
    {
        String line;
            for(int i = 0; i < 16; i++)
            {
                line = in.nextLine();
                for(int j = 0; j < 16; j++)
                    this.board[i][j] = (Character) line.charAt(j);

            }

    }
    /**
     * named buildBoard for continuity. returns reference to the pre-built board created on constructor call
     * @return the 16x16 Character board
     */
    public Character[][] buildBoard()
    {
        return this.board;
    }
    /**
     * finds the first blank space in the 16x16 grid
     * @return the zero-indexed point of the blank space in an Integer array of length 2
     */
    public Integer[] buildEntryPoint()
    {
        Integer[] point = {0, 0};

        for(int i = 0; i < 16; i++)
        {
            for(int j = 0; j < 16; j++)
            {
                if(board[i][j] == '-')
                {
                    point[0] = i;
                    point[1] = j;
                    return point;
                }
            }
        }
        return point;
    }
    /**
     * creates the List of possible choices for the game board
     * @return a Character List ranged from hexadecimal 0 to F
     */
    public ArrayList<Character> buildChoices()
    {
        ArrayList<Character> choices = new ArrayList<>();

        for(int i = 0; i < this.choices.length; i++)
            choices.add(this.choices[i]);

        return choices;
    }
}
