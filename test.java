import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class test 
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner in = new Scanner(new File("Hexadoku.txt"));
        HexadokuBoardBuilder builder = new HexadokuBoardBuilder(in);
        Backtrackable<Character> board = new HexadokuBoard(builder);

        for(Character ch: board.getChoices())
        {
            System.out.println(ch + " " + board.add(ch));
            board.remove();
        }
        
        

    }   
}
