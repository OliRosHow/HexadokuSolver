import java.util.Set;

public class HexadokuBoard implements Backtrackable<Character>
{
    Character[][] board;
    int[] entryPoint;
    int numberOfBlankSpaces;

    public boolean add(Character ch)
    {

    }

    public boolean solved()
    {
        return numberOfBlankSpaces == 0;
    }

    public Set<Character> getChoices()
    {

    }
}
