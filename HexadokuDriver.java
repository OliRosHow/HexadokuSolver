import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * This class drives the objects needed to solve a hexadoku puzzle(a sukoku puzzle with 16 chooseable values on a 16x16 grid)
 */
public class HexadokuDriver 
{
    /**
     * This is the main that runs on call via command line
     * @param args the file name of the unsolved hexadoku puzzle; reads only one file(the first one listed on the command line)
     * @throws FileNotFoundException this exception is thrown if the file doen't exist in this level of the directory
     */
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
