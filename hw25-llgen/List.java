//Eric Wong
//APCS2 p8
//HW25 -- Generically Speaking...
//2018-03-27

/*****************************************************
 * interface List
 * Specifies actions a List must be able to perform.
 * New in Version 4: GENERIC TYPING
 * ---
 * Clyde "Thluffy" Sinclair
 * 2018-03-26m
 *****************************************************/


public interface List<Object>
{
    //add element T to end of list
    //always return true
    public boolean add( Object x );

    //insert element T at index i
    public void add( int i, Object newVal );

    //remove element at index i
    public Object remove( int i );

    //return element at index i
    public Object get( int i );

    //overwrite element at index i, return old element at index i
    public Object set( int i, Object x );

    //return number of elements in list
    public int size();

}//end interface List
