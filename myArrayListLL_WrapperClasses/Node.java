/**
 * This "Node" holds 'myValue' which is a ptr to an object, and a ptr to
 * the next Node in the ArrayList.
 */
public class Node
{
    private Object myValue; // this is a ptr to an Object
    private Node next;
    /*** Constructor for objects of class Node */
    public Node()
    {
        myValue = null; // set default values
        next = null;
    }

    public Node(Object x)
    {
        myValue = x;
        next = null;
    }

    void setNext(Node n)
    {
        next = n;
    }

    void setMyValue(Object x)
    {
        myValue = x;
    }

    public void setMyValueObject(Object x)
    {
        myValue = x;
    }

    Node getNext()
    {
        return next;
    }

    String getMyValue()
    {
        return myValue.toString();
    }

    Object getMyValueObject()
    {
        return myValue;
    }
}