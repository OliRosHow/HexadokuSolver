import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class fixFile 
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner inFile = new Scanner(new File("asamshaExample.txt"));
        PrintWriter outFile = new PrintWriter("asamshaExample0F.txt");
        String line;

        while(inFile.hasNextLine())
        {
            line = inFile.nextLine();

            for(int i = 0; i < line.length(); i++)
            {
                switch(line.charAt(i))
                {
                    case '1':
                        outFile.print((char) ( line.charAt(i) - 1));
                        break;
                    case '2':
                        outFile.print((char) ( line.charAt(i) - 1));
                        break;
                    case '3':
                        outFile.print((char) ( line.charAt(i) - 1));
                        break;
                    case '4':
                        outFile.print((char) ( line.charAt(i) - 1));
                        break;
                    case '5':
                        outFile.print((char) ( line.charAt(i) - 1));
                        break;
                    case '6':
                        outFile.print((char) ( line.charAt(i) - 1));
                        break;
                    case '7':
                        outFile.print((char) ( line.charAt(i) - 1));
                        break;
                    case '8':
                        outFile.print((char) ( line.charAt(i) - 1));
                        break;
                    case '9':
                        outFile.print((char) ( line.charAt(i) - 1));
                        break;
                    case 'A':
                        outFile.print('9');
                        break;
                    case 'B':
                        outFile.print((char) ( line.charAt(i) - 1));
                        break;
                    case 'C':
                        outFile.print((char) ( line.charAt(i) - 1));
                        break;
                    case 'D':
                        outFile.print((char) ( line.charAt(i) - 1));
                        break;
                    case 'E':
                        outFile.print((char) ( line.charAt(i) - 1));
                        break;
                    case 'F':
                        outFile.print((char) ( line.charAt(i) - 1));
                        break;
                    case 'G':
                        outFile.print((char) ( line.charAt(i) - 1));
                        break;
                    case '-':
                        outFile.print('-');
                }
            }
            outFile.println();
        }

        inFile.close();
        outFile.close();
    }
}
