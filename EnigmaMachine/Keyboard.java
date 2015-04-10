//java.lang is used to convert chars to lower case
import java.lang.*;

//This class acts as the input-capture for the enigma-machine- it captures input then converts it
//into a suitable format (char[], lower case)
//This class has not yet been fully integrated with EnigmaMachine, a lot of it is unused
public class Keyboard
{
    public Keyboard()
    {
        //Empty at this point in time
    }
    
    //Gets a string input, converts it to a char array, makes it lower case then returns it
    public char[] getFormattedInput(String input)
    {
        char[] output = new char[input.length()];
        
        output = convertCharArrayToLower(parseToChar(input));
        
        return output;
    }
    
    //Uses inbuilt methods in Java to parse a String to a char array, which it then returns
    public char[] parseToChar(String input)
    {
        char[] charOutput = new char[input.length()];
        
        charOutput = input.toCharArray();
        
        return charOutput;
    }
    
    //Initializes a new char array, then for every index of the input array it converts it to lower case then stores
    //it in the output array
    public char[] convertCharArrayToLower(char[] input)
    {
        char[] output = new char[input.length];
        
        for (int index = 0; index < input.length; index++)
        {
            //Calls the character object method imported from java.lang.*
            output[index] = Character.toLowerCase(input[index]);
        }
        
        return output;
    }
}
