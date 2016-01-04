// This is a Fizz Buzz Game
import java.io.*;
import java.util.*;


/**
 *
 * @author Tareq
 */
public class Main {
    
    public static void main(String[] args) {
        
        String fileName = "FizzBuzz.txt";
        int firstDivisible = 0;
        int secondDivisible = 0;
        int numberLimit = 0;
        int initialNumber = 1;
        
        try {
            FileReader read = new FileReader(fileName);
            BufferedReader bufferedRead = new BufferedReader(read);
            
            try {
                // counts number of Players / Lines
                int countPlayers = 0;
                Scanner scanFile = new Scanner( new File (fileName));
                while(scanFile.hasNextLine()){
                    countPlayers++;
                    scanFile.nextLine();
                }
            
                System.out.println("Number of players: "+ countPlayers);

                // Selects divisors and number limit, 
                // determines the divisibility of the number series of each line
                // and prints the final game output
                
                String player;
                
                for(int i = 0; i < countPlayers ; i++){
                    player = bufferedRead.readLine();
                    System.out.println("Player " + (i+1) + ": " + player);
                    
                    StringTokenizer str = new StringTokenizer(player);
                    int[] Elements = new int[3]; // For saving three numbers of a line
                    int count = 0;
                    
                    // Selects the divisors and the number limit
                    while (str.hasMoreElements()){
                        Elements[count] = Integer.parseInt((String)str.nextElement());
                        count++;
                    }
                    firstDivisible = Elements[0];
                    secondDivisible = Elements[1];
                    numberLimit = Elements[2];

                    // determines the divisibility and prints the game result
                    for(initialNumber = 1; initialNumber <= numberLimit; initialNumber++){
                        if(initialNumber % firstDivisible == 0 && 
                                initialNumber % secondDivisible == 0){
                            System.out.print("FB");
                        }
                        else if(initialNumber % firstDivisible == 0){
                            System.out.print("F");
                        }
                        else if(initialNumber % secondDivisible == 0){
                            System.out.print("B");
                        }
                        else
                        System.out.print(initialNumber);
                        
                        if(initialNumber < numberLimit)
                        System.out.print(" ");
                    }

                    System.out.println("");
                }
                
            } catch (IOException ex) {
                System.out.println(ex);
              }
        } catch (FileNotFoundException ex) {
            System.out.println("No file found named " + fileName);
          }
    }
    
}