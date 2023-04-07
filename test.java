import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class test 
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner in = new Scanner(new File("Hexaduko3A.txt"));
        HexadokuBoardBuilder builder = new HexadokuBoardBuilder(in);
        HexadokuBoard board = new HexadokuBoard(builder);
/* 
        System.out.println(board.add('3'));
        System.out.println(board.add('4'));
        System.out.println(board.add('D'));
        System.out.println(board.add('0'));
        System.out.println(board.add('A'));
        System.out.println(board.add('B'));
        System.out.println(board.add('7'));
        System.out.println(board.add('8'));
        System.out.println(board.add('6'));
        System.out.println(board.add('2'));
        System.out.println(board.add('5'));
        System.out.println(board.add('1'));
        System.out.println(board.add('E'));
        System.out.println(board.add('9'));
        System.out.println(board.add('8'));
        System.out.println(board.add('F'));
 */
        Backtracker<Backtrackable<Character>, Character> solution = new Backtracker<>(board);

        solution.solve(board);
        System.out.println(board.add('5'));

         
        System.out.println(board);
        System.out.println(board.offer('2'));
        System.out.println(board.getEntryPoint()[0] + " " + board.getEntryPoint()[1]);
        System.out.println(board.solved());

    }   
}
