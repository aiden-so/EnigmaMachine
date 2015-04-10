# EnigmaMachine
A re-creation of the WW2 Nazi Enigma Encryption Machine in Java.


  === ABOUT
  This package re-creates the Enigma Machine used in WW2. Unlike the original machine that used a 3-rotor system, this package supports a (somewhat) unlimited number of rotors. It is a work in progress but can currently be used to:
    -Encrypt/decrypt strings
    -Print Plugboard/Rotor/Reflector configurations

Soon to be implemented:
    -Import/Export configuration ability
    -String output for encrypted contents
    -Full integration of Keyboard class (better input sanitation and handling)
    -Load custom configurations for all objects


  === HOW IT WORKS
Initial input is handled differently depending on type (strings are parsed into char arrays, char arrays and chars are not modified). Each char is then routed through the plugboard, and that output is run through every rotor in the RotorAssembly.
The rotors work by using two sides, the 'in' side containing a char array of a normal alphabet, and an 'out' side with a scrambled alphabet. On encryption, the index of the input char is found on the in side and the relevant index of the out side is returned. For the next stage of encryption that char is then used.
After passing through all rotors, the current char value is inversed based on index by the reflector, and then passed down the rotor array in the opposite direction. Finally, the char value is routed again through the plugboard.

Decryption works in the opposite way- reverse routing through the plugboard, passed down the rotor array, reflected, back up the rotor array then reverse routed again through the plugboard.
A better understanding can be gained by creating an enigmaMachine object and calling the 'printConfiguration' method.


  === HOW TO USE IT
    1. Create an EnigmaMachine object.
    2. Input the desired number of rotors.
    3. To encrypt a string, call 'encryptInput' (or 'decryptInput')
      -alternatively, you can encrypt single chars or char arrays
    4. Encrypted value is then returned.
    5. Plugboard/Rotor/Reflector configuration can be found by calling 'printConfiguration'


  === LICENSE
Licensed under a GNU General Public License. See the license file in the root folder for more information.
