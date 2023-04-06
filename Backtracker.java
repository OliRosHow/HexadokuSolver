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

    public void solve(T object)
    {
        for(K choice: choices)
        {
            if(object.add(choice))
            {
                if(object.solved())
                {
                    this.object = object;
                }
                else
                {
                    solve(object);
                }
            }
        }
     
    }

    public T getBacktrackableObject()
    {
        return object;
    }

    public String toString()
    {
        return object.toString();
    }
}
