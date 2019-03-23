/*
 * Name:	Timothy Dietsch
 * Class:	COMP141.B
 * Program:	The Monty Hall Class
 */

import java.util.Random;

public class MontyHall {
		
	//our private data elements
	private static boolean[] myArray = new boolean[3]; 	//num of doors
	private static int contestantDoor;	//contestant's choice door
	private static int revealedDoor;	//door that's revealed by host
	private static Random rand = new Random();
	
	/**
	 * Sets all the doors in the array to false,
	 * then chooses a random door to put the car behind by
	 * setting on of the values to true
	 */
	private static void initDoor() {
		
		int i; //loop index var
		
		//resetting all values of myArray to false
		for (i = 0; i < myArray.length; i++)
			myArray[i] = false;
		
		//Initializing Location of Car
		myArray[rand.nextInt(myArray.length)] = true;
	}
	
	/**
	 * Initializes the contestant's door by choosing a random number
	 */
	private static void initContestantDoor() {
		//Choosing Contestant's Door
		contestantDoor = rand.nextInt(myArray.length);
	}
	
	/**
	 * Initializes the door the host reveals by
	 * choosing a random door and checking if it is not a door with
	 * a car, or a door that the contestant has chosen
	 */
	private static void initRevealedDoor() {
		
		boolean revealedDoorCheck = true;	//loop variable
		while(revealedDoorCheck) {
			
			//Choosing a random door to reveal
			revealedDoor = rand.nextInt(myArray.length);
			
			//Checking if the chosen door doesn't have the car
			//And isn't the contestant's door
			if( (revealedDoor != contestantDoor)
					&& (myArray[revealedDoor] == false ) ) {
				
				//Stop loop
				revealedDoorCheck = false;
			}
			
		}
		
	}
	
	
	
	/**
	 * This sets up up a new game every time it is called
	 * Initializes contestantDoor, revealedDoor, and puts
	 * a car behind another door by setting one of the booleans in the
	 * array to true
	 */
	public static void setupGame() {
		
		initDoor();				//Initializing Doors
		initRevealedDoor();		//Initializing Revealed Door
		initContestantDoor();	//Initializing Contestant's Door
		
	}//setupGame
	
	/**
	 * Outputs true if we have won the game by sticking
	 * with our original choice, the contestant's door
	 * 
	 * @return outputs true if the car isn't behind 
	 * the contestant's door or the revealed door
	 */
	public static boolean winSwitch() {
		
		// if the car isn't behind the contestantDoor and 
		// the revealedDoor, the car has to be behind the one
		// remaining door, and we have won the game
		if ( ! ( myArray[contestantDoor] || myArray[revealedDoor] ))
			return true;
		
		// otherwise the car was behind the contestant's door
		return false;
	
	}//winIfSwitch
	
	/**
	 * Outputs true if we have won the game by switching
	 * our door with the one remaining
	 * 
	 * @return outputs true if the car is behind either
	 * the contestant's door or the revealed door
	 */
	public static boolean winStay() {
		
		// if the car is behind the contestant's door or 
		// the revealed Door, we have won the game
		if ( myArray[contestantDoor] || myArray[revealedDoor] )
			return true;
		
		// otherwise the car was behind the remaining door
		return false;
	
	}//winIfStay
	
	/**
	 * Prints out the wins if stayed and 
	 * the wins if switched into rows
	 * 
	 * @param totGames          total games
	 * @param winStayAmount		wins if stayed
	 * @param winSwitchAmount	wins if switched
	 */
	public static void printResults( double totGames,
			double winStayAmount, double winSwitchAmount ) {
		
		//Percentage of wins for total amount of games
		double winPerStay = (winStayAmount / totGames) * 100;
		double winPerSwitch = (winSwitchAmount / totGames) * 100;
		
		//Start Printing
		System.out.printf("\n\nTotal Games: %10.0f | ", totGames);
		
		System.out.printf("Wins if stayed: %10.0f or %7.5f%% | ",
				winStayAmount, winPerStay);
		
		System.out.printf("Wins if switched: %10.0f or %7.5f%%\n",
				winSwitchAmount, winPerSwitch);

	}//printResults

}//MontyHall
