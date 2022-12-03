import java.io.*;
import java.util.*;

public class RPS
{
    //static String filename = "input-sample.txt"; //for testing purposes 
    static String filename = "input.txt"; //the original input 
    
    static String [] input;
    static int[] scores; 
  
 
  public static void countScore() throws IOException
  {
      readInputIntoArray(); 
      int scoreSum = 0; 
      for(int i=0; i<scores.length;i++)
      {
          scores[i] = countScore(i); 
          scoreSum+=scores[i]; 
          System.out.println("Round score:"+scores[i]);
      }
      System.out.println("_______________________"); 
      System.out.println("Total score: "+scoreSum); 
      
      //PART TWO
      scoreSum = 0; 
      for(int i=0; i<scores.length;i++)
      {
          scores[i] = countScorePartTwo(i); 
          scoreSum+=scores[i]; 
          System.out.println("Round score:"+scores[i]);
      }
      System.out.println("_______________________"); 
      System.out.println("Total score: "+scoreSum); 
  } 
  /**
  * counts the score of the round 
  */
    public static int countScore(int round)
    {
        int score = 0; 
        String getString = input[round]; 
        char playerA = getString.charAt(0); 
        char playerB = getString.charAt(2); 
        
        switch (playerA)
        {
          case 'A': //rock
              switch (playerB)
              {
                  case 'X': //rock 
                      score+=1; 
                      score+=3; //draw 
                      break;
                      
                  case 'Y': //paper 
                      score+=2; 
                      score+=6; //win 
                      break;
                      
                  case 'Z': //scissors 
                      score+=3; 
                      score+=0; //loose 
                      break; 
              }
            break; 
          case 'B'://paper 
              switch (playerB)
              {
                  case 'X': 
                      score+=1; 
                      score+=0; //loose 
                      break;
                      
                  case 'Y': 
                      score+=2; 
                      score+=3; //draw 
                      break;
                      
                  case 'Z': 
                      score+=3;
                      score+=6; //win  
                      break; 
              }
              break; 
          case 'C'://scissors
              switch (playerB)
              {
                  case 'X': //rock
                      score+=1; 
                      score+=6; //win 
                      break;
                      
                  case 'Y': 
                      score+=2;
                      score+=0; //loose
                      break;
                      
                  case 'Z': 
                      score+=3;
                      score+=3; //draw 
                      break; 
              }
              break; 
        }   
        return score; 
    }
    public static int countScorePartTwo(int round)
    {
        int score = 0; 
        String getString = input[round]; 
        char playerA = getString.charAt(0); 
        char playerB = getString.charAt(2); 
        
        switch (playerA)
        {
          case 'A': //rock
              switch (playerB)
              {
                  case 'X': //need to loose --> scissor
                      score+=3; 
                      score+=0; 
                      break;
                      
                  case 'Y': //need to draw --> rock
                      score+=1; 
                      score+=3;  
                      break;
                      
                  case 'Z': //need to win --> paper 
                      score+=2; 
                      score+=6; 
                      break; 
              }
            break; 
          case 'B'://paper 
              switch (playerB)
              {
                  case 'X': //need to loose --> rock
                      score+=1; 
                      score+=0; 
                      break;
                      
                  case 'Y': //need to draw --> paper
                      score+=2; 
                      score+=3; 
                      break;
                      
                  case 'Z': //need to win -->  scissors
                      score+=3;
                      score+=6;  
                      break; 
              }
              break; 
          case 'C'://scissors
              switch (playerB)
              {
                  case 'X': //need to loose --> paper
                      score+=2; 
                      score+=0; 
                      break;
                      
                  case 'Y': //need to draw --> scissors
                      score+=3;
                      score+=3; 
                      break;
                      
                  case 'Z': //need to win --> rock
                      score+=1;
                      score+=6; 
                      break; 
              }
              break; 
        }   
        return score; 
    }
    /**
     * Die Methode liest den Input der Textdatei in ein Array ein. 
     */
    public static void readInputIntoArray() throws IOException
    {
    int arraySize =0; 
    try
    {
        arraySize = getInputLength(); 
    }
    catch (IOException e) 
    {
        System.out.println("Es ist ein Fehler beim Einlesen passiert!"); 
        System.exit(1); //Programm beenden
    }
    input = new String[arraySize]; //Erstelle leeres Array mit der Anzahl 
    scores = new int[arraySize]; 
    
    FileReader fr = new FileReader(filename);
    BufferedReader br = new BufferedReader(fr);      
    String zeile = "";
    
    for(int i=0; i<arraySize;i++)
    {
         input[i] = br.readLine();
    }
      br.close();
      //array should be read correctly  
    }  
    
    /**
     * Methode bestimmt die Länge der Texteingabe 
     */
    public static int getInputLength() throws IOException
    {
     int size = 0;  
     FileReader fr = new FileReader(filename);
     BufferedReader br = new BufferedReader(fr);  
      //Bestimme die Anzahl der Werte! 
     String zeile = "";
     while( (zeile = br.readLine()) != null )
     {
        System.out.println(zeile);
        size++; 
      }
      br.close();
    return size; 
    }    


}
