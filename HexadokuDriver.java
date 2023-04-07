import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class HexadokuDriver 
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner in = new Scanner(new File("Hexaduko1A.txt"));
        HexadokuBoardBuilder builder = new HexadokuBoardBuilder(in);
        Backtrackable<Character> board = new HexadokuBoard(builder);
        Backtracker<Backtrackable<Character>, Character> solution = new Backtracker<>(board);



        System.out.println(solution.solve(board));


    

        System.out.println(board);

    }
    
}
