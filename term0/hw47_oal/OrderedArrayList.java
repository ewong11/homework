//Eric WOng
//APCS pd02
//hw47 -- ascending
//2017-12-6
/********************************
 * class OrderedArrayList
 * wrapper class for ArrayList.
 * Imposes the restriction that stored items
 * must remain sorted in ascending order
 ********************************/

//ArrayList's implementation is in the java.util package
import java.util.ArrayList;

public class OrderedArrayList
{
  // instance of class ArrayList, holding objects of type Comparable
  // (ie, instances of a class that implements interface Comparable)
  private ArrayList<Comparable> _data;


  // default constructor initializes instance variable _data
  public OrderedArrayList()
  {
    _data = new ArrayList<Comparable>();
  }


  public String toString()
  {
    String retstr = "[";
    for (int x = 0; x < _data.size(); x++) {
      retstr += _data.get(x) + ",";
    }
    return retstr + "\b" + "]"; //placeholder
  }


  public Comparable remove( int index )
  {
    return _data.remove(index);
  }


  public int size()
  {
    return _data.size();
  }


  public Comparable get( int index )
  {
    return _data.get(index); //placeholder
  }


  public void add(Comparable newVal)
  {

    if (_data.size() == 0) {
      _data.add(newVal);
      System.out.println(_data);
    }
    else {
    for (int i = 0; i < _data.size() ; i++) {
      if (_data.get(i).compareTo(newVal) >= 0) {
        _data.add(i, newVal);
        System.out.println(_data + "h");
        break;
      }
      else
      {
        //for (int s = 0; i < _data.size() ; s++) {
          if (newVal.compareTo(_data.get(i)) < 0) {
        _data.add(i, newVal);
        System.out.println(_data + "j");
}
        break;
      }
      }
    }
}





  // main method solely for testing purposes
  public static void main( String[] args )
  {

    OrderedArrayList Franz = new OrderedArrayList();
    // testing linear search
    for( int i = 0; i < 15; i++ ){
      Franz.add( (int)( 50 * Math.random() ) );}
    System.out.println( Franz );

    //check for sorted-ness
    //if msg does not appear, list was sorted
    for( int i=0; i<Franz.size()-1; i++ ) {
      System.out.println("at i: " + Franz.get(i) );
      if ( Franz.get(i).compareTo(Franz.get(i+1)) > 0 ) {
        System.out.println( " *** NOT sorted *** " );
        break;
      }
    }
  }//end main()

}//end class OrderedArrayList
