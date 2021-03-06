//This is the main class file for the package. It emulates the Enigma Encryption Machine used by
//the nazi party in the second world war. However the original machine implemented only 3 rotors
//in its encryption system, this package supports an unlimited (to an extent) number of rotors.
//See the readme for more details and examples.

import java.util.*;

public class EnigmaMachine
{
    //This is the static constant for alphabetsize used by almost all classes
    public static final int alphabetSize = 26;

    //Rotors is the object that holds all the rotors and the reflector
    //Savemachine is used to import/export machine configurations
    RotorAssembly Rotors;
    PlugBoard ShiftBoard;
    Keyboard Input;
    ConfigSave SaveMachine;

    public EnigmaMachine(int numberOfRotors)
    {
        Rotors = new RotorAssembly(numberOfRotors);
        ShiftBoard = new PlugBoard();
        Input = new Keyboard();

        SaveMachine = new ConfigSave(numberOfRotors);
        //Save the current configuration
        saveConfiguration();
    }

    //      PLUGBOARD TOOLS

    //Generates a new random char array and uses it for the plugboard
    public void refreshPlugBoard()
    {
        ShiftBoard.refreshPlugArray();
    }

    //      GENERAL CONFIGURATION

    //Prints the configuration for all the used parts (plugboard, rotors, reflector)
    public void printConfiguration()
    {
        SaveMachine.printSettings();
    }

    //Gathers all the configurations and passes them to the saving object
    public void saveConfiguration()
    {
        //Linked list to hold the configuration
        List<char[]> Configuration = new LinkedList<char[]>();

        Configuration.add(ShiftBoard.exportConfig());
        Configuration.addAll(Rotors.exportConfig());

        //Pass it to the ConfigSave object
        SaveMachine.save(Configuration);
    }

    //      ENCRYPTION

    //Encrypts a string input and returns an encrypted char array
    public String encryptInput(String input)
    {
        String output = new String(encryptCharArray(Input.getFormattedInput((input))));
        return output;
    }

    //Encrypts all the characters in a char array, returns an encrypted array
    public char[] encryptCharArray(char[] input)
    {
        char[] encryptedOutput = new char[input.length];

        for (int index = 0; index < input.length; index++)
        {
            if (ArrayTools.inAlphabet(input[index]))
            {
                encryptedOutput[index] = encryptChar(input[index]);
            } else {
                encryptedOutput[index] = input[index];
            }
        }

        return encryptedOutput;
    }

    //Encrypt an individual char by routing it through the plugboard, encrypting, then re-routing
    public char encryptChar(char input)
    {
        char output;

        output = ShiftBoard.forwardRoute(input);
        output = Rotors.encrypt(output);
        output = ShiftBoard.forwardRoute(output);

        return output;
    }

    //      DECRYPTION

    //Decrypts a string and returns a char array
    public String decryptInput(String input)
    {
        String decryptedOutput = new String(decryptCharArray(Input.getFormattedInput(input)));
        return decryptedOutput;
    }

    //Decrypts a char array and returns a new one in plaintext
    public char[] decryptCharArray(char[] input)
    {
        char[] decryptedOutput = new char[input.length];

        for (int index = 0; index < input.length; index++)
        {
            if (ArrayTools.inAlphabet(input[index]))
            {
                decryptedOutput[index] = decryptChar(input[index]);
            } else {
                decryptedOutput[index] = input[index];
            }
        }

        return decryptedOutput;
    }

    //Decrypts an indiviudal char by reverse routing through the plugboard, encrypting then re-reverse routing
    public char decryptChar(char input)
    {
        char output;

        output = ShiftBoard.reverseRoute(input);
        output = Rotors.encrypt(output);
        output = ShiftBoard.reverseRoute(output);

        return output;
    }
}