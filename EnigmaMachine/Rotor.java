//This class simulates the rotors that obfuscate and pass the signal down the Rotor Assembly chamber to and
//from the reflector. There is no limit on how many rotors can be implemented.
public class Rotor
{
    public int alphabetSize;
    public int rotationCount;
    
    private char[] inputSide;
    private char[] outputSide;
    
    public Rotor()
    {
        //rotationCount stores how many rotations from default the rotor is
        alphabetSize = EnigmaMachine.alphabetSize;
        rotationCount = 0;
        
        //inputSide and outputSide are both char arrays, inputSide is a regular alphabet and outputSide is random
        inputSide = new char[alphabetSize];
        outputSide = new char[alphabetSize];
        inputSide = ArrayTools.resetAlphabet();
        outputSide = ArrayTools.randomAlphabetArray();
    }
    
    //Shifts the output side of the rotor one position, increments the rotation count
    public void shiftRotor()
    {
        outputSide = ArrayTools.shift(outputSide);
        
        rotationCount += 1;
    }

    public char pass(char input, char[] selectSide, char[] outSide)
    {
        int index = ArrayTools.getIndex(input, selectSide);
        input = outSide[index];

        return input;
    }

    //Finds the index of the input in the input side then returns the corresponding char (by index) of the output side
    public char forwardPass(char input)
    {
        return pass(input, inputSide, outputSide);
    }
    
    //Finds the index of the input in the output side then returns the corresponding char (by index) of the input side
    public char reversePass(char input)
    {
        return pass(input, outputSide, inputSide);
    }
    
    //Exports the configuration of the scrambled side
    public char[] exportConfig()
    {
        return outputSide;
    }

    //Speaks for itself, imports and assigns a configuration
    public void importConfig(char[] input)
    {
        outputSide = input;
    }
}