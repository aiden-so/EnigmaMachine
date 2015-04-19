//java.lang is used to convert chars to lower case
import java.lang.*;

//This class acts as the input-capture for the enigma-machine- it captures input then converts it
//into a suitable format (char[], lower case)
public class Keyboard
{
    //Gets a string input, converts it to a char array, makes it lower case then returns it
    public char[] getFormattedInput(String input)
    {
        return toLower(parseToChar(input));
    }
    
    //parse a String to a char array, then return
    public char[] parseToChar(String input)
    {
        return input.toCharArray();
    }
    
    //for every index of the input array it converts it to lower case then returns
    public char[] toLower(char[] input)
    {
        for (int index = 0; index < input.length; index++)
        {
            input[index] = Character.toLowerCase(input[index]);
        }
        
        return input;
    }
}
