//Uses an arraylist to hold all the rotor objects, and a linked list for configuration export
import java.util.*;

//This class holds the rotors and the reflector used to encrypt/decrypt, as well as co-ordinating
//the actual encryption, decryption and rotor shifting
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
        //Print all the rotors in RotorArray
        for (int index = 0; index < RotorArray.size(); index++)
        {
            System.out.println("Rotor " + (index+1) + ":");
            
            Rotor current = RotorArray.get(index);
            ArrayTools.printArray(current.getInputSide());
            ArrayTools.printArray(current.getOutputSide());
        }
        //Print reflector
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
        
        //RotorAssembly will work out what rotors need to be rotated and then do so
        rotate();
        
        return output;
    }
    
    public char reversePass(char input)
    {
        char output = input;
        
        //Loops backwards through the RotorArray
        for (int index = RotorArray.size() - 1; index >= 0; index--)
        {
            Rotor currentRotor = RotorArray.get(index);
            output = currentRotor.reversePass(output);
        }
        
        //RotorAssembly will work out what rotors need to be rotated and then do so
        rotate();
        
        return output;
    }
    
    //Determines what rotors must be rotated, calls shiftRotor method of Rotor class to do so
    public void rotate()
    {
        //shiftNext holds if the next rotor will be rotated; true by default because the first rotor is
        //always shifted
        boolean shiftNext = true;
        
        for (Rotor currentRotor : RotorArray)
        {
            if (shiftNext)
            {
                currentRotor.shiftRotor();
                currentRotor.rotationCount += 1;
                //If the current rotor has been rotated 26 times, rotate the next one
                if (currentRotor.rotationCount == 26)
                {
                    shiftNext = true;
                    currentRotor.rotationCount = 0;
                } else {
                    shiftNext = false;
                }
            }
        }
    }
    
    //Returns the configuration of the Reflector and Rotors
    public List<char[]> exportConfig()
    {
        List<char[]> Configuration = new LinkedList<char[]>();
        
        Configuration.add(AssemblyReflector.exportConfig());
        for (Rotor currentRotor : RotorArray)
        {
            Configuration.add(currentRotor.exportConfig());
        }
        
        return Configuration;
    }
}
