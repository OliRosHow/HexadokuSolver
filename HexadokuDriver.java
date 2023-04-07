import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class HexadokuDriver 
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner in = new Scanner(new File(args[0]));
        HexadokuBoardBuilder builder = new HexadokuBoardBuilder(in);
        Backtrackable<Character> board = new HexadokuBoard(builder);
        Backtracker<Backtrackable<Character>, Character> solver = new Backtracker<>(board);

        solver.solve(board);

        System.out.println(board);
    }   
}
