import java.util.List;
/**
 * This interface specifies methods needed to interface with a general backtracker object.
 */
interface Backtrackable < T extends Object>
{
    /**
     * This method adds the choice object to the implementing objects data structure
     * @param object the choice to be added
     * @return if the choice was successfully added
     */
    public boolean add(T object); 
    /**
     * this method returns the state of the implementing object back to before the most immediate add call
     */
    public void backtrack();
    /**
     * checks to see if the implenting object is solved
     * @return boolean true if solved and false otherwise
     */
    public boolean solved();
    /**
     * gets all the possible choices
     * @return a List of the choices that you can add to this object
     */
    public List<T> getChoices();
    
}