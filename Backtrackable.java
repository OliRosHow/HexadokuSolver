import java.util.Set;

interface Backtrackable <T extends Object>
{
    public boolean add(T object);
    public boolean solved();
    public Set<T> getChoices();
}