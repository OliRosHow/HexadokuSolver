import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

public class HexadokuBoard implements Backtrackable<Character>
{
    private Character[][] board;
    private Integer[] entryPoint;
    private ArrayList<Character> choices;
    private LinkedList<Integer[]> previousPoints = new LinkedList<>();

    public HexadokuBoard(HexadokuBoardBuilder builder)
    {
        this.board = builder.buildBoard();
        this.entryPoint = builder.buildEntryPoint();
        this.choices = builder.buildChoices();
    }

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

    private Integer[] seek()
    {
        Integer[] point = {0,0};
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

    public void backtrack()
    {
        board[entryPoint[0]][entryPoint[1]] = '-';
        entryPoint = previousPoints.pop();
        board[entryPoint[0]][entryPoint[1]] = '-';
    }

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

    public List<Character> getChoices()
    {
        return choices;
    }

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
                result.append("\n-------------------------------------\n");
            else
                result.append("\n");
        }

        return result.toString();
    }
}
