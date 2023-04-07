import java.util.List;

interface Backtrackable < T extends Object>
{
    public boolean add(T object);
    public void backtrack();
    public boolean solved();
    public List<T> getChoices();
    
}