/**
 * Mr. Marques' SHELL for myArrayListLL_WrapperClasses.
 * >>> Please delete the word "SHELL" below. <<<
 *
 * Your "myArrayListLL" duplicates a Java ArrayList via your User Defined LinkedList
 * You will complete the code to the following methods we have studied:
 * (1) size() // I did this very difficult one for you. You're welcome!
(1) add() // Add a Node at the end of the list. X
(2) size() // I did this very difficult one for you. You're welcome! X
(3) get() // Get a Node at a particular index. X
(4) set() // Set a Node at a particular index. X
(5) remove() // Remove a Node at a particular index. X
(6) addAtIndex() // Add-a-Node at a particular index.X
 *
 */

import javax.swing.JOptionPane;

public class myArrayListLL_WrapperClasses // delete the word SHELL
{
    Node head, tail;
    int myNodeCount;
    
    /*** Constructor for objects of class myArrayListLL */
    public myArrayListLL_WrapperClasses() // delete the word SHELL
    {
        head = tail = null;
        myNodeCount = 0;
    }
    
    //=======================helper methods=======================
    public boolean isBadSelection(int selection)
    {
        return (selection < 0 || selection > 6);
    }
    
    public void printBadSelectionMessage()
    {
        JOptionPane.showMessageDialog(null, "Input was incorrect. \n Please choose again.\n", "Bad Input", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public int menu()
    {
        int selection = 0;
        String choices = "";
                
        // print ArrayList choices here, let 0 = quit
        
        choices += printList("return list") + "\n\n\n" + "Your choices are: \n" +
        " (0) Quit \n (1) Add an Object \n (2) Size: number of Nodes in the list \n" +
        " (3) Get an Object at index value \n (4) Set an Object at index \n" +
        " (5) Remove an Object at index \n (6) Add an Object at index \n" +
        " \n Please enter your selection.";
        
        selection = Integer.parseInt(JOptionPane.showInputDialog(null,choices));
        
        return selection;
    }
    
    public void doArrayListMethod(int selection)
    {
        switch(selection) 
        {
            case 0: JOptionPane.showMessageDialog(null, "Have a good day!!", "Good Bye", JOptionPane.PLAIN_MESSAGE); break;
            case 1: add(); break; // X
            case 2: size(); break; //X
            case 3: get(); break; // X
            case 4: set(); break; // 
            case 5: remove(); break; //X
            case 6: addAtIndex(); break; //X
            
            default: JOptionPane.showMessageDialog(null, "Illegal Entry. Try again.", "ERROR", JOptionPane.ERROR_MESSAGE);
            
            break;
        } // switch
    }
    
    public void size()
    {
        printList("The size is " + myNodeCount);
    }
    
    public void get()
    {
        Node current;
        String output = "";
        int selection;
        
        if(myNodeCount == 0) 
        {
            JOptionPane.showMessageDialog(null, "Nothing in the list", "Empty list", JOptionPane.INFORMATION_MESSAGE);
            
            return;
        }
        
        do 
        {
            selection = Integer.parseInt(JOptionPane.showInputDialog("Enter a number " + (myNodeCount == 1 ? "1 ONLY!!" : "1 - " + myNodeCount)));
            if(selection <= 0 || selection > myNodeCount)
            {
                JOptionPane.showMessageDialog(null, "Enter the proper number, please!!", "ERROR", JOptionPane.INFORMATION_MESSAGE);
            }
        } while(selection <= 0 || selection > myNodeCount);

        current = head;
        for(int i = 0; i < selection - 1; i++)
        {
            current = current.getNext();
        }
        
        JOptionPane.showMessageDialog(null, " " + current.getMyValue(), "get value at an index ", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void add()
    {
        Node n = null;
        n = addObjectMenu();
        
        if(head == null) // empty list
        { 
            head = tail = n;            
        }
        else // more than one Node
        { 
            tail.setNext(n);
            tail = n;
        }
        
        myNodeCount++; // increment count by 1
        printList("Add Node to the end");
    } // add
    
    public Node addObjectMenu() // Asks the user what they want to add. Returns that object.
    {
        Node n = null;
        String choice = "", value = "";
        int selection;
        
        // Ask user what they would like to add
        do 
        {
            choice = "(1) Character \n (2) Short \n (3) Integer \n (4) Long \n (5) Float \n (6) Double \n (7) Boolean";
            selection = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Object choice: \n " + choice, "Add: Choose an Object", JOptionPane.INFORMATION_MESSAGE));
            
            if(selection <= 0 || selection > 7)
            {
                JOptionPane.showMessageDialog(null, "Please enter only within the proper choice boundaries", "ERROR", JOptionPane.INFORMATION_MESSAGE);
            }
        }while (selection <= 0 || selection > 7);
        
        value = JOptionPane.showInputDialog("Enter the value: ");
        
        // add the new node to the tail
        switch (selection) 
        {
            case 1: n = new Node(new Character(value.charAt(0))); break;
            case 2: n = new Node(new Short(Short.parseShort(value))); break;
            case 3: n = new Node(new Integer(Integer.parseInt(value))); break;
            case 4: n = new Node(new Long(Long.parseLong(value))); break;
            case 5: n = new Node(new Float(Float.parseFloat(value))); break;
            case 6: n = new Node(new Double(Double.parseDouble(value))); break;
            case 7: n = new Node(new Boolean(value)); break;
            
            default: JOptionPane.showMessageDialog(null, "Error!!", "Error", JOptionPane.INFORMATION_MESSAGE); break;
        } // switch
        
        return n;
    }
    
    public void set()
    {
        Node current,n;
        int selection;
        
        if(myNodeCount == 0)
        {
            JOptionPane.showMessageDialog(null, "The list is empty"); 
            
            return;
        }
        
        do 
        {
            selection = Integer.parseInt(JOptionPane.showInputDialog("Enter a number " + (myNodeCount==1 ? "1 ONLY!!" : "1 - " + myNodeCount)) );
            
            if (selection<=0 || selection>myNodeCount)
            {
                JOptionPane.showMessageDialog(null, "Enter the proper number, please!!" , "ERROR", JOptionPane.INFORMATION_MESSAGE);
            }
        } while(selection <= 0 || selection > myNodeCount);
        
        current = head;
        n = addObjectMenu();
        
        for(int i = 1; i < selection; i++)
        {
            current = current.getNext();
        }
        
        current.setMyValueObject(n.getMyValueObject());
        
        printList("Set at position " + selection);
    }
    
    public void remove()
    {
        Node current;
        int selection;
        
        if (myNodeCount == 0) 
        {
            JOptionPane.showMessageDialog(null, "Nothing to delete!", "Empty List", JOptionPane.INFORMATION_MESSAGE);
            
            return;
        } 
        else // more than one node
        {  
            do 
            {
                selection = Integer.parseInt(JOptionPane.showInputDialog("Enter a number " + (myNodeCount==1 ? "1 ONLY!!" : "1 - " + myNodeCount)) );
                
                if (selection <= 0 || selection > myNodeCount)
                {
                    JOptionPane.showMessageDialog(null, "Enter the proper number, please!!" , "ERROR", JOptionPane.INFORMATION_MESSAGE);
                }
            } while(selection <= 0 || selection > myNodeCount);
        }
        
        current = head;
        
        if(myNodeCount == 1)
        {
            head = tail = null;
        }
        else // more than one node 
        {  
            if(selection == 1) // remove at front
            { 
                head = head.getNext();
            }
            else if(selection == myNodeCount) // remove at the back
            { 
                for(int i = 1; i < selection - 1; i++)
                {
                    current = current.getNext();
                }
                
                current.setNext(null);
                tail = current;
            }
            else // remove at the middle 
            { 
                for(int i = 1; i < selection - 1; i++)
                {
                    current = current.getNext();
                }        
                
                current.setNext(current.getNext().getNext());
            }
        }
        
        myNodeCount--;
        
        printList("Remove Node #" + selection);
    }
    
    public void addAtIndex()
    {
        Node current = null;
        Node n = null;
        String choice = "", value;
        int selection, i; 
        
        do 
        {
            choice = (myNodeCount == 0 ? "You MUST enter a 1 ONLY!!" : "1 - " + (myNodeCount+1));
            selection = Integer.parseInt(JOptionPane.showInputDialog("Enter a number: (" + choice + ")" ));
            
            if(selection<=0 || selection>myNodeCount+1)
            {
                JOptionPane.showMessageDialog(null, "Enter the proper number, please!!", "ERROR", JOptionPane.INFORMATION_MESSAGE);
            }
        } while(selection <= 0 || selection > myNodeCount + 1);
        
        n = addObjectMenu();

        if(selection == 1) // add front
        {
            n.setNext(head);
            head = n;
        }
        else if(selection == myNodeCount + 1) // add back
        { 
            tail.setNext(n);
            tail = n;
        }
        else // add middle
        { 
            current = head;
            
            for(i = 1; i < selection - 1; i++)
            {
                current = current.getNext();            
            }
            
            n.setNext(current.getNext());
            current.setNext(n);
        }
        
        myNodeCount++;
        
        if(myNodeCount == 1)
        {
            head = tail = n;
        }
        
        printList("Add at index " + selection);
    } // addAtIndex
    
    private String printList(String message) // why do you think this is private?? //don't want user to access the method
    {
        String output = "The list is: \n\t";
        if (head == null)
        {
            output += " nothing in the list!";
        }
        else 
        {
            for(Node current = head; current != tail; current = current.getNext())
            {
                output += current.getMyValueObject() + ", ";
            }
            
            output += tail.getMyValueObject() + ".";
        }
        
        // Return the list to the menu so the user can see the Nodes.
        if (message.compareTo("return list") == 0)
        {
            return output;
        }
        
        JOptionPane.showMessageDialog(null, message + "\n\n" + output, "", JOptionPane.INFORMATION_MESSAGE);
        
        return "";
    }    
} // myArrayListLL
