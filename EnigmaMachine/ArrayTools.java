//This is a static class that provides methods to alter and handle char arrays that is
//used by almost all the classes in this package.

public class ArrayTools
{
    public static final int alphabetSize = EnigmaMachine.alphabetSize;
    
    private static GetRandom RNG = new GetRandom();
    
    public static char[] resetAlphabet()
    {
        char[] freshAlphabet = new char[] {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        return freshAlphabet;
    }
    
    public static char[] randomAlphabetArray()
    {
        char[] freshArray = new char[alphabetSize];
        char[] alphabet = new char[alphabetSize];
        alphabet = resetAlphabet();
        
        int currentIndex;
        
        for (int count = 0; count < alphabetSize; count++)
        {
            if (alphabet.length > 1)
            {
                currentIndex = RNG.getRandom(alphabet.length - 1);
            }
            else if (alphabet.length == 1)
            {
                currentIndex = 0;
            }
            else
            {
                break;
            }
            
            freshArray[count] = alphabet[currentIndex];
            //Delete used array index
            alphabet = removeChar(alphabet, currentIndex);
        }
        
        alphabet = resetAlphabet();
        
        return freshArray;
    }
    
    private static char[] removeChar(char[] inputArray, int index)
    {
        char[] modifiedArray = new char[inputArray.length - 1];
        int currentIndex = 0;
        
        for (char current : inputArray)
        {
            if (current != inputArray[index])
            {
                modifiedArray[currentIndex] = current;
                currentIndex++;
            }
        }
        
        return modifiedArray;
    }
    
    public static char[] shift(char[] rotorArray)
    {
        char[] outputRotor = new char[alphabetSize];
        //move the carry-over char
        outputRotor[0] = rotorArray[rotorArray.length - 1];
        
        for (int index = rotorArray.length - 1; index > 0; index--)
        {
            outputRotor[index] = rotorArray[index - 1];
        }
        
        return outputRotor;
    }
    
    public static int getIndex(char input, char[] array)
    {
        int index = 0;
        
        for (int c = 0; c < alphabetSize; c++)
        {
            if (array[c] == input)
            {
                index = c;
            }
        }
       
        return index;
    }
    
    public static void printArray(char[] array)
    {
        StringBuilder output = new StringBuilder();
        
        for (char current : array)
        {
            output.append(current + " ");
        }
        
        System.out.println(output.toString());
    }
}
