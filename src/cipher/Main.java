package cipher;

//import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws Exception {
    try {
    	//Find Input file and make reader
      File file = new File("/Users/9598657/Desktop/Input.txt");
      BufferedReader br = new BufferedReader(new FileReader(file));
      	//Make output file on desktop
      BufferedWriter out = new BufferedWriter(new FileWriter("/Users/9598657/Desktop/Output.txt"));
      
      	//Read File character by character
      int st;
      while ((st = br.read()) != -1) {
    	  //Turn int into a char
    	  /*
    	   * Doesn't work, seems to output random characters
    	   */
    	char character = (char) st;
        char[] qwerty = {'q','w','e','r','t','y','u','i','o','p','a','s','d','f','g','h','j','k','l','z','x','c','v','b','n','m'};
        char[] abcdef = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        for (int i = 1; i < qwerty.length; i++){
        	if (character == qwerty[i]) {
        			character = abcdef[i];
        			out.write(character);
        	}
        }
      }
      System.out.println("Succeded");
      br.close();
      out.close();
    } catch (IOException e) {
      System.out.println("Just like my grades, Failed.");
    }
  }
}