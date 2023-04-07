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
        
            for(int i = 0; i < choices.size(); i++)
            {
                if(object.add(choices.get(i)))
                {
                        if(solve(object))
                        {
                            return true;
                        }
                        else
                        {
                            if(!object.solved())
                            {
                                object.backtrack();
                            }
                        }


                }
            }
        

        return false;
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
