import java.util.Set;

public class HexadokuBoard implements Backtrackable<Character>
{
    Character[][] board;
    int[] entryPoint;
    Set<Character> choices;
    int numberOfBlankSpaces;

    public HexadokuBoard(HexadokuBoardBuilder builder)
    {
        this.board = builder.buildBoard();
        this.entryPoint = builder.buildEntryPoint();
        this.choices = builder.buildChoices();
        this.numberOfBlankSpaces = builder.buildNumberOfBlackSpaces();
    }
    public boolean add(Character ch)
    {   
        boolean successful = true;
        boolean found = false;

        for(int i = 0; i < 16 && successful; i++)
        {
            if(board[entryPoint[0]][i] == ch || board[i][entryPoint[1]] == ch || board[(i % 4) +(4 * (entryPoint[0] / 4))][(i / 4) + (4 * (entryPoint[1] / 4)) ] == ch)
                successful = false;
        }
        if(successful)
            board[entryPoint[0]][entryPoint[1]] = ch;

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

        return successful;
    }

    public boolean solved()
    {
        return numberOfBlankSpaces == 0;
    }

    public Set<Character> getChoices()
    {
        return choices;
    }
}
