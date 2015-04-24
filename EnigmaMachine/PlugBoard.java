//This class replicates the plugboard on the enigma machine- physical wires connected different letters
//of the alphabet, and all key-presses were routed through the plugboard first. This class creates
//a random char array and compares it to a standard alphabet, then routes characters through it using
//the characters index
public class PlugBoard
{
    private char[] plugArray;
    private char[] alphabet;

    public PlugBoard()
    {
        //Class standard alphabetSize taken from EnigmaMachine
        int alphabetSize = EnigmaMachine.alphabetSize;

        //The randomised array used for routing
        plugArray = new char[alphabetSize];
        //The standard alphabet array compared through
        alphabet = ArrayTools.resetAlphabet();

        //Randomises plugArray
        refreshPlugArray();
    }

    //Randomises plugArray
    public void refreshPlugArray()
    {
        plugArray = ArrayTools.randomAlphabetArray();
    }

    //Assigns plugArray as the input, allows for custom plugArrays
    public void customPlugBoard(char[] customArray)
    {
        plugArray = customArray;
    }

    //Finds the index of input in the alphabet array then gets the char on plugArray with the same index
    //Used for encryption
    public char forwardRoute(char input)
    {
        return plugArray[ArrayTools.getIndex(input, alphabet)];
    }

    //Finds the index of input in the plugArray array then gets the char on the alphabet array with the same index
    //Used for decryption
    public char reverseRoute(char input)
    {
        return alphabet[ArrayTools.getIndex(input, plugArray)];
    }

    //Allows for the object to export its current configuration
    public char[] exportConfig()
    {
        return plugArray;
    }
}