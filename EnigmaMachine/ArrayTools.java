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
        char[] alphabet = new char[alphabetSize];

        for (char c = 'a'; c <= 'z'; c++)
        {
            //97 shifts 'a' to 0 and so on
            alphabet[c - 97] = c;
        }
        return alphabet;
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
        //Save the last char to be moved to the front of the new array
        char shiftChar = rotorArray[rotorArray.length - 1];

        //Loops through the array and makes the previous index value the current one
        for (int index = rotorArray.length - 1; index > 0; index--)
        {
            rotorArray[index] = rotorArray[index - 1];
        }
        //Add the saved value back on
        rotorArray[0] = shiftChar;

        return rotorArray;
    }


    //Returns the index value of the given char in a given array
    public static int getIndex(char input, char[] array)
    {
        //Returns c (the index) as soon as it is found
        for (int c = 0; c < array.length; c++)
        {
            if (array[c] == input)
            {
                return c;
            }
        }

        //Returns 0 if the index can not be found
        return 0;
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