import java.util.ArrayList;

public class RotorAssembly
{
    ArrayList<Rotor> RotorArray;
    Reflector AssemblyReflector;
    
    int alphabetSize;
    int numberOfRotors;
    
    public RotorAssembly(int rotorNumber)
    {
        numberOfRotors = rotorNumber;
        alphabetSize = EnigmaMachine.alphabetSize;
        
        RotorArray = new ArrayList<Rotor>();
        
        createRotors(numberOfRotors);
        AssemblyReflector = new Reflector();
    }
    
    public void createRotors (int numberOfRotors)
    {
        for (int c = 0; c < numberOfRotors; c++)
        {
            RotorArray.add(new Rotor());
        }
    }
    
    public void printRotorConfiguration()
    {
        StringBuilder output = new StringBuilder();
        
        for (int index = 0; index < RotorArray.size(); index++)
        {
            System.out.println("Rotor " + (index+1) + ":");
            
            Rotor current = RotorArray.get(index);
            ArrayTools.printArray(current.getInputSide());
            ArrayTools.printArray(current.getOutputSide());
        }
        System.out.println("Reflector:");
        AssemblyReflector.printReflector();
    }
    
    public char encrypt(char input)
    {
        char output;
        
        output = forwardPass(input);
        output = AssemblyReflector.reflect(output);
        output = reversePass(output);
        
        return output;
    }
    
    public char forwardPass(char input)
    {
        char output = input;
        
        for (Rotor currentRotor : RotorArray)
        {
            output = currentRotor.forwardPass(output);
        }
        
        //rotate();
        
        return output;
    }
    
    public char reversePass(char input)
    {
        char output = input;
        
        for (int index = RotorArray.size() - 1; index >= 0; index--)
        {
            Rotor currentRotor = RotorArray.get(index);
            output = currentRotor.reversePass(output);
        }
        
        //rotate();
        
        return output;
    }
    
    public void rotate()
    {
        boolean shiftNext = true;
        
        for (Rotor currentRotor : RotorArray)
        {
            if (shiftNext)
            {
                currentRotor.shiftRotor();
                currentRotor.rotationCount += 1;
                if (currentRotor.rotationCount == 26)
                {
                    shiftNext = true;
                    currentRotor.rotationCount = 1;
                } else {
                    shiftNext = false;
                }
            }
        }
    }
}
