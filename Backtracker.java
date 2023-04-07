import java.util.List;

public class Backtracker <T extends Backtrackable<K>, K extends Object>
{
    private T object;
    private List<K> choices; 

    public Backtracker(T object)
    {
        this.object = object;
        this.choices = object.getChoices();
    }

    public boolean solve(T object)
    {
        for(K choice: choices)
        {
            if(object.add(choice))
            {
                    if(solve(object))
                        return true;
                    else if(!object.solved())
                        object.backtrack();        
            }
        }
        return false;
    }

    public String toString()
    {
        return object.toString();
    }
}
