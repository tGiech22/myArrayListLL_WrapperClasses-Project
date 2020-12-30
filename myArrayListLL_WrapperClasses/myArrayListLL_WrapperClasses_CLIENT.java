/**
 * This program will duplicate a Java ArrayList all the methods via
 * utilizing a LinkedList.
 *
 * Mr. Marques
 * 1/10/05
 */
import java.util.*;
import java.text.DecimalFormat;
public class myArrayListLL_WrapperClasses_CLIENT
{
    public static void main()
    {
        myArrayListLL_WrapperClasses a = new myArrayListLL_WrapperClasses();
        int selection;
        
        do 
        {
            // get the user's choice, have 0 = quit
            
            do 
            {
                selection = a.menu();
                
                if(a.isBadSelection(selection))
                {
                    a.printBadSelectionMessage();
                }
            } while(a.isBadSelection(selection));
            
            a.doArrayListMethod(selection); // perform their choice
        } while (selection != 0); // 0 = quit
    } // main
} // myArrayListLL_WrapperClasses_CLIENT
