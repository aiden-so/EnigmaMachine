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
        inputSide = generateStandardAlphabet();
        outputSide = generateRandomAlphabet();
    }
    
    //Calls ArrayTools to return a random char alphabet array
    public char[] generateRandomAlphabet()
    {
        return ArrayTools.randomAlphabetArray();
    }
    
    //Calls ArrayTools to return a standard alphabet in char[] form
    public char[] generateStandardAlphabet()
    {
        return ArrayTools.resetAlphabet();
    }
    
    //Returns the input side of the rotor (standard alphabet)
    public char[] getInputSide()
    {
        return inputSide;
    }
    
    //Returns the output side of the rotor (scrambled alphabet)
    public char[] getOutputSide()
    {
        return outputSide;
    }
    
    //Shifts the output side of the rotor one position, increments the rotation count
    public void shiftRotor()
    {
        outputSide = ArrayTools.shift(outputSide);
        
        rotationCount += 1;
    }
    
    //Finds the index of the input in the input side then returns the corresponding char (by index) of the output side
    public char forwardPass(char input)
    {
        char output;
        int index = ArrayTools.getIndex(input, inputSide);
        output = outputSide[index];
        
        return output;
    }
    
    //Finds the index of the input in the output side then returns the corresponding char (by index) of the input side
    public char reversePass(char input)
    {
        char output;
        int index = ArrayTools.getIndex(input, outputSide);
        output = inputSide[index];
        
        return output;
    }
    
    //Exports the configuration of the scrambled side
    public char[] exportConfig()
    {
        return outputSide;
    }
}