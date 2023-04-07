import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

public class HexadokuBoard implements Backtrackable<Character>
{
    Character[][] board;
    Integer[] entryPoint;
    ArrayList<Character> choices;
    int numberOfBlankSpaces;
    LinkedList<Integer[]> previousPoints = new LinkedList<>();

    public HexadokuBoard(HexadokuBoardBuilder builder)
    {
        this.board = builder.buildBoard();
        this.entryPoint = builder.buildEntryPoint();
        this.choices = builder.buildChoices();
        this.numberOfBlankSpaces = builder.buildNumberOfBlackSpaces();
    }

    public boolean add(Character ch)
    {   
        boolean successful = this.offer(ch);
        boolean found = false;

        if(successful)
        {
            board[entryPoint[0]][entryPoint[1]] = ch;
            numberOfBlankSpaces--;
            Integer[] temp = {new Integer(entryPoint[0]), new Integer(entryPoint[1])};
            previousPoints.push(temp);

    
            for(int i = 0; i < 16 && !found; i++)
            {
                for(int j = 0; j < 16 && !found; j++)
                {
                    if(board[i][j] == '-')
                    {
                        entryPoint[0] = i;
                        entryPoint[1] = j;
                        found = true;
                    }
                }
            }
        }


        return successful;
    }



    public Integer[] getEntryPoint()
    {
        return entryPoint;
    }

     public boolean offer(Character ch)
     {
         boolean successful = true;
 
         for(int i = 0; i < 16 && successful; i++)
         {
             if(board[entryPoint[0]][i] == ch || board[i][entryPoint[1]] == ch || board[(i % 4) +(4 * (entryPoint[0] / 4))][(i / 4) + (4 * (entryPoint[1] / 4)) ] == ch)
                 successful = false;
         }
 
         return successful;
     }
    //public boolean offer(Character ch)
   // {
    //    return checkRow(ch) && checkColum(ch) && checkBox(ch);
    //}

    private boolean checkRow(Character ch)
    {
        boolean successful = true;
        for(int i = 0; i < 16; i++)
        {
            if(board[i][entryPoint[1]] == ch) 
                successful = false;
        }

        return successful;
    }

    private boolean checkColum(Character ch)
    {
        boolean successful = true;
        for(int i = 0; i < 16; i++)
        {
            if(board[entryPoint[0]][i] == ch) 
                successful = false;
        }

        return successful;
    }

    private boolean checkBox(Character ch)
    {
        boolean successful = true;
        for(int i = 4*(entryPoint[0]/4); i < 4; i++)
        {
            for(int j = 4*(entryPoint[1]/4); j < 4; j++)
            {
                if(board[i][j] == ch) 
                    successful = false;
            }
        }

        return successful;
    }




    public Character remove()
    {
        Character removed = board[entryPoint[0]][entryPoint[1]];
        board[entryPoint[0]][entryPoint[1]] = '-';
        numberOfBlankSpaces++;
        return removed;
    }
    public Character backtrack()
    {
        board[entryPoint[0]][entryPoint[1]] = '-';
        entryPoint = previousPoints.pop();
        Character removed = board[entryPoint[0]][entryPoint[1]];
        board[entryPoint[0]][entryPoint[1]] = '-';

        return removed;
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
        String result = "";

        for(int i = 0; i < 16; i++)
        {
            for(int j = 0; j < 16; j++)
            {
                if(j == 15 || j % 4 != 3)
                    result += board[i][j] + " ";
                else
                    result += board[i][j] + " | ";

            }

            if(i != 15 && i % 4 == 3)
                result += "\n-------------------------------------\n";
            else
                result += "\n";
        }

        return result;
    }
}
