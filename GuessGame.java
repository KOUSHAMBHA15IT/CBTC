import java.util.Random;
import java.util.Scanner;
public class GuessGame {
  public static void main(String[] args) {
    Random Random_number= new Random();
    int gen_num=Random_number.nextInt(100);
    int turns=0;
    Scanner scan=new Scanner(System.in);
    System.out.println("Guess a number between 1 to 100, You will have 10 turns!" );
    System.out.println("best of luck!");
    int g;
    int i=0;
    boolean win=false;
    while(win==false) 
    {
       g=scan.nextInt();
       turns++;
     if(g==gen_num) {
       win=true;
     }
      else if(i>8){
      System.out.println("You loose! the right answer was: "+gen_num);
      return;
     }
     else if(g<gen_num){
      i++;
      System.out.println("TRY TO GUESS HIGHER! Turns left: "+(10-i)); 
      }
     else if(g>gen_num){
      i++;
       System.out.println("TRY TO GUESS LOWER! Turns left: "+(10-i));
      }
   }
   scan.close();
    System.out.println("Congratulationa!! You win!");
    System.out.println("Then number was "+gen_num);
    System.out.println("You have exhausted "+turns+" turns to guess the correct number");
    System.out.println("Your score is "+((11-turns)*10)+" out of 100");
  }
}
