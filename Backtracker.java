import java.util.Set;

public class Backtracker <T extends Backtrackable<K>, K extends Backtrackable<K>>
{
    private T object;
    private Set<K> choices; 

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
                    this.object = object;
                else
                    solve(object);

            }
        }
    }

    public T getBacktrackableObject()
    {
        return object;
    }
}
