import java.util.Scanner;
import java.util.ArrayList;

public class HexadokuBoardBuilder 
{
    Character[][] board = new Character[16][16];

    public HexadokuBoardBuilder(Scanner in)
    {
        String line;

            for(int i = 0; i < 16; i++)
            {
                line = in.nextLine();

                for(int j = 0; j < 16; j++)
                {
                    this.board[i][j] = (Character) line.charAt(j);
                }

            }

    }
    
    public Character[][] buildBoard()
    {
        return this.board;
    }

    public Integer[] buildEntryPoint()
    {
        Integer[] point = {0, 0};
        boolean found = false;
        for(int i = 0; i < 16 && !found; i++)
        {
            for(int j = 0; j < 16 && !found; j++)
            {
                if(board[i][j].equals(new Character('-')))
                {
                    point[0] = i;
                    point[1] = j;
                    found = true;
                }
            }
        }
        return point;
    }

    public ArrayList<Character> buildChoices()
    {
        ArrayList<Character> choices = new ArrayList<>();

        choices.add('0');
        choices.add('1');
        choices.add('2');
        choices.add('3');
        choices.add('4');
        choices.add('5');
        choices.add('6');
        choices.add('7');
        choices.add('8');
        choices.add('9');
        choices.add('A');
        choices.add('B');
        choices.add('C');
        choices.add('D');
        choices.add('E');
        choices.add('F');

        return choices;
    }

    public int buildNumberOfBlackSpaces()
    {
        int blankSpaces = 0;
        for(int i = 0; i < 16; i++)
        {
            for(int j = 0; j < 16; j++)
            {
                if(board[i][j].equals(new Character('-')))
                    blankSpaces++;
            }
        }

        return blankSpaces;
    }


}
