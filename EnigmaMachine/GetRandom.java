//This import is used for random number generation
import java.util.Random;

//This class generates random number on demand
public class GetRandom
{
    private Random RNG;
    
    public GetRandom()
    {
        RNG = new Random();
    }
    
    //Returns a random number between 0 and (roof+1)
    public int getRandom(int roof)
    {
        return RNG.nextInt(roof + 1);
    }
}
