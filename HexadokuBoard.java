import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
/**
 * this class is a backtrackable hexadoku board
 */
public class HexadokuBoard implements Backtrackable<Character>
{
    private Character[][] board;
    private Integer[] entryPoint;
    private ArrayList<Character> choices;
    private LinkedList<Integer[]> previousPoints = new LinkedList<>();

    /**
     * takes a builder object and initializes all of the object parameters
     * @param builder the HexadokuBoardBuilder object linked to the unsolved board file
     */
    public HexadokuBoard(HexadokuBoardBuilder builder)
    {
        this.board = builder.buildBoard();
        this.entryPoint = builder.buildEntryPoint();
        this.choices = builder.buildChoices();
    }
    /**
     * attempts to add a Character at the current cursor possition
     * @return if the Character cannot be added because it violates the rules of hexadoku
     */
    public boolean add(Character ch)
    {   
        boolean successful = this.offer(ch);
        
        if(successful)
        {
            board[entryPoint[0]][entryPoint[1]] = ch;
            Integer[] temp = {entryPoint[0], entryPoint[1]};
            previousPoints.push(temp);
            entryPoint = seek();
        }

        return successful;
    }

    /**
     * moves the entry curror to the next empty space with the fewest number of choices
     * @return the zero-indexed possition of the next emptyspace with the fewest number of choices in a Integer array of length 2
     */
    private Integer[] seek()
    {
        Integer[] point = {0,0};
        int minChoices = 17;

        for(int i = 0; i < 16; i++)
        {
            for(int j = 0; j < 16; j++)
            { 
                if(board[i][j] == '-')
                {
                    int numChoices = 0;
                    entryPoint[0] = i;
                    entryPoint[1] = j;
                    for(Character choice: choices)
                    {
                        if(offer(choice))
                            numChoices++;
                    }
                    if(numChoices < minChoices)
                    {
                        point[0] = i;
                        point[1] = j;
                        minChoices = numChoices;
                    }
                }
            }
        }
        return point;
    }

    /**
     * tests a Character at the current cursor possition
     * @param ch the Character to be tested
     * @return if this Character can be added here
     */
    private boolean offer(Character ch)
    {
         boolean successful = true;
         for(int i = 0; i < 16 && successful; i++)
         {
             if(board[entryPoint[0]][i] == ch || board[i][entryPoint[1]] == ch || board[(i % 4) +(4 * (entryPoint[0] / 4))][(i / 4) + (4 * (entryPoint[1] / 4)) ] == ch)
                 successful = false;
         }
         return successful;
    }
    /**
     * resets the state of the board back to before the most immediate add
     */
    public void backtrack()
    {
        board[entryPoint[0]][entryPoint[1]] = '-';
        entryPoint = previousPoints.pop();
        board[entryPoint[0]][entryPoint[1]] = '-';
    }
    /**
     * checks to see if the board is solved
     * @return true if there are no more empty spaces and false otherwise
     */
    public boolean solved()
    {
        boolean solved = true;
        for(int i = 0; i < 16; i++)
        {
            for(int j = 0; j < 16; j++)
            {
                if(board[i][j] == '-')
                    solved = false;
            }
        }
        return solved;
    }
    /**
     * gets a List of the choices 
     * @return a Character List of all choices linked to this object
     */
    public List<Character> getChoices()
    {
        return choices;
    }
    /**
     * creates a view of the current state of the board
     * @return a String to visualize the board
     */
    public String toString()
    {
        StringBuilder result = new StringBuilder();
        result.append("\n");
        for(int i = 0; i < 16; i++)
        {
            for(int j = 0; j < 16; j++)
            {
                if(j == 15 || j % 4 != 3)
                    result.append(board[i][j] + " ");
                else
                    result.append(board[i][j] + " | ");
            }
            if(i != 15 && i % 4 == 3)
                result.append("\n--------+---------+---------+--------\n");
            else
                result.append("\n");
        }

        return result.toString();
    }
}
