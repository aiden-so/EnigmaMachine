//The reflector class replicates the reflector that bounces back the signal that is passed down the rotor chamber
//and sends it back. This class is given a char input then finds the opposite of that char (by index)
public class Reflector
{
    int alphabetSize;
    char[] panel;
    
    public Reflector()
    {
        //Uses the static final alphabet size to construct the array
        alphabetSize = EnigmaMachine.alphabetSize;
        
        //alphabet holds the reflector array used to give corresponding chars, filled randomly with ArrayTools
        panel = ArrayTools.randomAlphabetArray();
    }
    
    //Takes a char input and returns the opposite value (by index)
    //i.e. if input lies at alphabet[2] then alphabet[23] is returned
    //Uses ArrayTools for the index lookup
    public char reflect(char input)
    {
        return panel[(alphabetSize - ArrayTools.getIndex(input, panel)) - 1];
    }
    
    //Exports the configuration
    public char[] exportConfig()
    {
        return panel;
    }

    //Speaks for itself, imports and assigns a configuration
    public void importConfig(char[] input)
    {
        panel = input;
    }
}