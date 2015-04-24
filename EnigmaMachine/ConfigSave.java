//Commented out as unused at this moment
//import java.io.FileWriter;
//import java.io.File;
import java.util.*;

//This class exports and imports configurations for plugboard, rotors and reflector. Used to share configurations
//so that different people can encrypt/decrypt with the same initial setup
//Not fully finished/implemented yet
public class ConfigSave {
    //Stores the configuration output
    private List<char[]> Config;

    private int rotorCount;

    //Constructor method- initializes the output StringBuilder object
    public ConfigSave(int rotors) {
        Config = new LinkedList<char[]>();

        rotorCount = rotors;
    }

    public void save(List<char[]> ConfigInput) {
        Config = ConfigInput;
    }

    public void printSettings()
    {
        for (char[] currentArray : Config) {

            printArray(ArrayTools.resetAlphabet());
            printArray(currentArray);
            System.out.printf("\n\n");

        }
    }

    public void printArray(char[] in)
    {
        for (char c : in)
        {
            System.out.printf("%c ", c);
        }

        System.out.println();
    }

}