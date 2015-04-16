//These imports are used for writing configurations to file and handling Lists
import java.io.FileWriter;
import java.io.File;
import java.util.*;

//This class exports and imports configurations for plugboard, rotors and reflector. Used to share configurations
//so that different people can encrypt/decrypt with the same initial setup
//Not fully finished/implemented yet
public class ConfigSave
{
    //Stores the configuration output
    private StringBuilder Settings;
    
    private List<char[]> Config;
    
    //Constructor method- initializes the output StringBuilder object
    public ConfigSave()
    {
        Config = new LinkedList<char[]>();
        Settings = new StringBuilder();
    }
    
    public void save(List<char[]> ConfigInput)
    {
        Config = ConfigInput;
    }
    
    //Adds each value of the array provided to the Settings object
    //Incomplete
    public void buildSettings(String type, char[] array)
    {
        String input = "" + type + ": {" + array + "}";
    }
    
    //Saves the stores settings to a file
    public void exportSettings(String type, char[] array)
    {
        //Commented out because this was showing errors, I haven't worked out how to write to file yet
        //File file = new File("C:/Users/Aiden/Desktop/enigmaSettings.txt");
        //FileWriter DocWriter = new FileWriter(file);
    }
    
    //Returns the Settings object in string form for viewing
    public String getSettings()
    {
        return Settings.toString();
    }
}
