/* Aaron Gold
 * Rock Paper Scissors bot
 */

import java.util.*;

public class Rock_paper_scissors_shoot {
	 final static Scanner keyboard = new Scanner (System.in);
	public static void main(String[] args) {

		String user_answer = "";
		int user_status = 0, tie_counter = 0;
		char repeat = 'y';

		while (repeat == 'y')
		{
			System.out.println("Input rock, paper, or scissors (other to stop): ");
			user_answer = keyboard.nextLine().toLowerCase();

			
			if (user_answer.equals("rock"))
			{
				user_status = 0;
				tie_counter = randomizer(user_status, user_answer, tie_counter);
				//cheat(user_status, user_answer);
		
			}
			else if (user_answer.equals("paper"))
			{
				user_status = 1;
				tie_counter = randomizer(user_status, user_answer, tie_counter);
				//cheat(user_status, user_answer);
			}
			else if (user_answer.equals("scissors"))
			{
				user_status = 2;
				tie_counter = randomizer(user_status, user_answer, tie_counter);
				//cheat(user_status, user_answer);	
			}
			else
			{
				repeat = 'n';
				System.out.println("Goodbye.");
				keyboard.close();
			}
		}
	}
	public static int randomizer(int user_status, String user_answer, int tie_counter) {
		String status = "", choices [] = new String [] {"rock", "paper", "scissors"};
		int  comp = 0;
		
		//Randomizes number from 0-2 to pick from the array
		Random rand = new Random();
		comp = rand.nextInt(2) + 1; 
		System.out.println("You chose " + user_answer);

		//If there are 2 consecutive ties, the game becomes rigged
		if (tie_counter == 2 ) 
		{
			tieBreaker(user_status, choices);
		}
		else
		{
			System.out.println("Computer chose " + choices[comp]);
		
		if (user_status == comp)
		{
			status = "You tied! Rematch!\n";
			tie_counter ++;
		}
		else if( user_status == comp +1 || user_status == comp - 2)
		{
			status = "You won! Congratulations!\n";
			tie_counter = 0;
		}
		else if( user_status == comp -1 || user_status == comp + 2)
		{
			status = "You lost! Please try again.\n";
			tie_counter = 0;
		}
		System.out.println(status);
		}
		return(tie_counter);	
	}
	
	//Rigged game from the beginning
	public static void cheat(int user_status, String userAnswer) 
	{
		String choices [] = new String [] {"rock", "paper", "scissors"};

		System.out.println("You chose " + userAnswer);

		if(user_status != 2)
		{
			System.out.println("Computer chose " + (choices[user_status+1]) + "\nYou lost! Please try again.");
		}
		else
		{
			System.out.println("Computer chose rock\nYou lost! Please try again.\n");
		}
	}

	public static void tieBreaker(int user_status, String choices[])
	{
		//If user did not pick scissors, computer selects 1 value
		//greater than the value of the input (rock = 0, so computer picks 1, which is paper)
		if(user_status != 2) 
		{
			System.out.println("Computer chose " + choices[user_status + 1] + "\nYou lost! Please try again.\n");
		}
		//This has to be scissors, so the computer picks rock
		else 
		{
			System.out.println("Computer chose rock\nYou lost! Please try again.\n");
		}	
	}	

}


	
