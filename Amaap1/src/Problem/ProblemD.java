package Problem;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class ProblemD {
	
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter name of 1st Player: ");
        String Name1 = scanner.nextLine();

        System.out.print("Enter name of 2nd Player: ");
        String Name2 = scanner.nextLine();

        int[] Dice1 = prob();
        int[] Dice2 = prob();
        Arrays.sort(Dice1);
        Arrays.sort(Dice2);
        

        System.out.println("Below are dice values for " + Name1 + " -");
        DiceValue(Dice1);
        
        String Player1 = getCombo(Dice1);
        
        System.out.println("Combination for " + Name1 + " is " + Player1);
        System.out.println();
        System.out.println("Below are dice values for " + Name2 + " -");
        DiceValue(Dice2);
        
        
        String Player2 = getCombo(Dice2);
        System.out.println("Combination for " + Name2 + " is " + Player2);

        int result = compareCombinations(Player1, Player2);
        

        if (result < 0) {
            System.out.println("Winner is"+" "+Name1+"..!!" );
        } else if (result > 0) {
            System.out.println("Winner is"+" "+Name2 +"..!!" );
        } else {
            //System.out.println("It's a tie!");
            int c=0,z=0;
            for(int i=0;i<Dice1.length;i++) {
            	
            	for(int j=i+1;j<Dice1.length;j++) {
            	if(Dice1[i]==Dice1[j]) {
            		 c=Dice1[i];
            	}
            	
            			            	
            	}
            	
            }
            if(c==0) {
    			c=Dice1[Dice1.length-1];
    		}
    	

            
            for(int i=0;i<Dice2.length;i++) {
            	for(int j=i+1;j<Dice2.length;j++) {
            	if(Dice2[i]==Dice2[j]) {
            		 z=Dice2[i];
            	}
            	
            		
            	
            	}
            	
            }
            if(z==0) {
    			z=Dice2[Dice2.length-1];
    		}
            
            if(c>z) {
            	System.out.println("Winner is "+" "+Name1 + " ..!!");
            	
            }
            else if(c<z) {
            	System.out.println("Winner is"+" "+Name2 + " ..!!");
            }
            else {
            	System.out.println("tie");
            }
        }

        scanner.close();
    }

    private static int[] prob() {
        int[] dice = new int[5];
        Random random = new Random();
        for (int i = 0; i <5; i++) {
            dice[i] = random.nextInt(6) + 1; 
        }
        return dice;
    }
    public static void DiceValue(int[] dice1) {
    	for(int i=0;i<dice1.length;i++) {
    		System.out.print(dice1[i]+", ");
    	}
    	System.out.println();
    } 

    private static String getCombo(int[] dice) {
        Arrays.sort(dice);
        
        
        if (dice[0] == dice[4]) {
            return "Five of a kind";
        } else if (dice[0] == dice[3] || dice[1] == dice[4]) {
        	
            return "Four of a kind";
             
        } else if ((dice[0] == dice[2] && dice[3] == dice[4]) || (dice[0] == dice[1] && dice[2] == dice[4])) {
            return "Three of a kind and a pair";
        } else if (dice[0] == dice[2] || dice[1] == dice[3] || dice[2] == dice[4]) {
            return "Three of a kind";
        } else if ((dice[0] == dice[1] || dice[2] == dice[3]) || (dice[0] == dice[1] && dice[3] == dice[4])
                || (dice[1] == dice[2] || dice[3] == dice[4])) {
            return "A pair";
        } else {
            return "Highest number";
        }
        
        
    }
    

    private static int compareCombinations(String com1, String com2) {
        String[] combinations = {
        		 "Five of a kind",
 	            "Four of a kind",
 	            "Three of a kind and a pair",
 	            "Three of a kind",
 	            "A pair",
 	            "Highest number"
        };

        int pair1 = Arrays.asList(combinations).indexOf(com1);
        int pair2 = Arrays.asList(combinations).indexOf(com2);
        
        System.out.println();


       return Integer.compare(pair1, pair2);
    }



}
