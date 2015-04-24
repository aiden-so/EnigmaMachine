//This is a static class that provides methods to alter and handle char arrays that is
//used by almost all the classes in this package.

public class ArrayTools
{
    //Draws the constant alphabetSize used for many functions from EnigmaMachine
    public static final int alphabetSize = EnigmaMachine.alphabetSize;

    private static GetRandom RNG = new GetRandom();

    //Returns a standard-order alphabet
    public static char[] resetAlphabet()
    {
        return new char[] {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    }

    //Returns a scrambled alphabet
    public static char[] randomAlphabetArray()
    {
        char[] scrambledArray = new char[alphabetSize];
        char[] freshAlphabet = new char[alphabetSize];
        freshAlphabet = resetAlphabet();

        int currentIndex;

        for (int count = 0; count < alphabetSize; count++)
        {
            //Select a random index
            currentIndex = RNG.getRandom(freshAlphabet.length - 1);
            //Copy that char to freshArray
            scrambledArray[count] = freshAlphabet[currentIndex];
            //Delete used array index from the standard alphabet
            freshAlphabet = removeChar(freshAlphabet, currentIndex);
        }

        return scrambledArray;
    }

    //Removes an index from a given array at a given index
    private static char[] removeChar(char[] inputArray, int index)
    {
        //New array with length of one less than input
        char[] modifiedArray = new char[inputArray.length - 1];
        int currentIndex = 0;

        //Loops through the input array, copies over each index if it ISNT eqaul to the given index of inputArray
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

    //Returns the given rotor-array, shifted one position down
    public static char[] shift(char[] rotorArray)
    {
        char[] outputRotor = new char[alphabetSize];
        //Move the char of the last position to the first
        outputRotor[0] = rotorArray[rotorArray.length - 1];

        //Loops through the array and makes the previous index value the current one
        for (int index = rotorArray.length - 1; index > 0; index--)
        {
            outputRotor[index] = rotorArray[index - 1];
        }

        return outputRotor;
    }

    //Returns the index value of the given char in a given array
    public static int getIndex(char input, char[] array)
    {
        //Returns c (the index) as soon as it is found
        for (int c = 0; c < alphabetSize; c++)
        {
            if (array[c] == input)
            {
                return c;
            }
        }

        //Returns -1 if the index can not be found
        return -1;
    }

    //Finds if an element is in the alphabet
    public static boolean inAlphabet(char input)
    {
        for (char c : resetAlphabet())
        {
            if (c == input)
                return true;
        }
        return false;
    }
}