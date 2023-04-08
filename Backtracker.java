import java.util.List;
/**
 * this class is a generic backtracking solver
 */
public class Backtracker <T extends Backtrackable<K>, K extends Object>
{
    private T object;
    private List<K> choices; 
    /**
     * constructer for the general backtracker
     * @param object the Backtrackable object
     */
    public Backtracker(T object)
    {
        this.object = object;
        this.choices = object.getChoices();
    }
    /**
     * solves the Backtrackable object through recursive backtracking calls
     * @param object the Backtrackable object
     * @return true if there is a path forward from a given choice and false otherwise
     */
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
    /**
     * toString method to call the Backtrackable object's toString method
     */
    public String toString()
    {
        return object.toString();
    }
}
