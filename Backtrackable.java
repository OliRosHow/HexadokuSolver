interface Backtrackable <T extends Object>
{
    public boolean add( T object);
    public boolean solved();
}