/*
 * Name:	Timothy Dietsch
 * Class:	COMP141.B
 * Program:	The Monty Hall Problem
 */

public class Main {

	public static void main(String[] args) {
		
		//Variable Dictionary
		final double MAX = 4E8;	//max amount of games to run
		final double START = 2;	//starting amount of games to run
		double totGames;		//variable recording game amount
		double winStayAmount;	//amount of wins through staying
		double winSwitchAmount;	//amount of wins through switching
		int i;					//for loop
		
		
		//1.0 Initialization
		System.out.print("Timothy Dietsch ~ COMP141.B ~ ");
		System.out.println("The Monty Hall Problem");
		
		System.out.println("Calculates the percentage of wins won"
				+ "through switching doors or keeping the"
				+ "original door");
		
		//2.0 Process
		for (totGames = START;
				totGames <= MAX;
				totGames = totGames * 2) { //Sets games per round
			//each round has twice as many games as the previous one
			
			//resetting win value to zero for each game
			winStayAmount = 0;
			winSwitchAmount = 0;
			
			for (i = 0; i < totGames; i++) { //Goes through each game
				
				MontyHall.setupGame();	//setting up game
				
				if (MontyHall.winStay())		//win by staying
					winStayAmount++;	//increase stay-win counter
				
				
				if (MontyHall.winSwitch()) 		//win by switching
					winSwitchAmount++;	//increase switch-win counter
				
			}//i loop
			
			//3.0 Print results of each game
			MontyHall.printResults( 
					totGames, winStayAmount, winSwitchAmount );
		
		}//totGames loop
		
		//4.0 Terminate Program
		System.out.println("\n\n<<< Program Terminated >>>");

	}

}
