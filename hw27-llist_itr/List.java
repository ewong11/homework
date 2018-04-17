/*****************************************************
 * interface List
 * Specifies actions a List must be able to perform.
 * New in Version 6: Iterability via FOREACH
<<<<<<< HEAD
 * (The Iterable interface is a superinterface to interface List, 
=======
 * (The Iterable interface is a superinterface to interface List,
>>>>>>> 3ef7f1e93f51b2c8ed34b93662b685cdbcfa25d4
 * in the actual Java library. Interface Iterable is what allows
 * a for-each loop to be run on a collection class.)
 *****************************************************/

import java.util.Iterator;

<<<<<<< HEAD
public interface List<T> extends Iterable<T> 
{ 
    //add element T to end of list
    //always return true
    public boolean add( T x ); 
=======
public interface List<T> extends Iterable<T>
{
    //add element T to end of list
    //always return true
    public boolean add( T x );
>>>>>>> 3ef7f1e93f51b2c8ed34b93662b685cdbcfa25d4

    //insert element T at index i
    public void add( int i, T newVal );

    //remove element at index i
    public T remove( int i );

    //return element at index i
<<<<<<< HEAD
    public T get( int i ); 

    //overwrite element at index i, return old element at index i
    public T set( int i, T x ); 

    //return number of meaningful elements in list
    public int size(); 
=======
    public T get( int i );

    //overwrite element at index i, return old element at index i
    public T set( int i, T x );

    //return number of meaningful elements in list
    public int size();
>>>>>>> 3ef7f1e93f51b2c8ed34b93662b685cdbcfa25d4

    //return an Iterator over the elements in list
    Iterator<T> iterator();

}//end interface List
