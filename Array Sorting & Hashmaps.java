/*
 * Author: Jinhwan Kim
 * Computer Science 201
 * Assignment 1: Array Sorting and Hashmaps
 */

// import the package used for input from the Java Standard Library
import java.util.Scanner;
// import the package for Hashmap
import java.util.HashMap;
// import the package for Map (for entry sets)
import java.util.Map;
//import the package for TreeMap
import java.util.TreeMap;


/**
 * Main class of the application.
 * 
 * This class contains the main method which is where the program starts
 */
public class Assignment
{
	// Part 1	

	/**
	 * Prints the contents of a 2D array with state and capital data 
	 *
	 * @param stateCapitals the 2D array with state and capital 
	 */
	public static void displayStateCapitals (String[][] stateCapitals)
	{
		// Loop through the rows
		for (int i = 0; i < stateCapitals.length; i++)
		{
			// Loop through the columns per row via nested loop
			for (int j = 0; j < stateCapitals[i].length; j++)
			{
				// Separate column values with commas
				System.out.print(stateCapitals[i][j]);
				if (j == 0)
				{
					// Print out a dash between the columns
					System.out.print(" - ");
				}
			}
			// Separate each row values with a new line
			System.out.print("\n");
		}
	}
	
	/**
	 * Uses bubble sort to sort the 2D array by capital
	 * 
	 * @param stateCapitals the 2D array with state and capital
	 * @return the array sorted by capital with bubble sort
	 */
	public static String[][] bubbleSortByCapital(String[][] stateCapitals)
	{
		// Loop through the rows
		// Worst case scenario, the outer loops as much as the size of the array itself
		for (int i = 0; i < stateCapitals.length; i++)
		{
			// Declare a flag for swapped and initialize it to false
			Boolean swapped = false;
			// Loop through every capital until the second to last (which will compare itself with the last)
			for (int j = 0; j < stateCapitals.length - 1; j++)
			{
				// If the capital (column) comes first in alphabet compared to the one in the next state (row) 
				if ( stateCapitals[j][1].compareToIgnoreCase(stateCapitals[j+1][1]) > 0 )
				{
					// Swap the entire row (state-capital pairs) with the next row
		            String[] temp = stateCapitals[j];
		            stateCapitals[j] = stateCapitals[j+1];
		            stateCapitals[j+1] = temp;
					// after the swap, set swapped flag to true
					swapped = true;
				}
			}
			// If the swap did not happen in the inner loop, that means it's all sorted
			if (swapped == false)
			{
				// break out of the nested loop
				break;
			}
		}
		// return sorted 2D array 
		return stateCapitals;
	}
	
	/**
	 * Entry point of the program.
	 *
	 * @param args command line arguments, which are not used in this program
	 */
	public static void main(String[] args)
	{
		
		// Create a 2D array with states and capitals, ordered by state names. 
		String[][] stateCapitals =
		{
			{"Alabama", "Montgomery"},
            {"Alaska", "Juneau"},
            {"Arizona", "Phoenix"},
            {"Arkansas", "Little Rock"},
            {"California", "Sacramento"},
            {"Colorado", "Denver"},
            {"Connecticut", "Hartford"},
            {"Delaware", "Dover"},
            {"Florida", "Tallahassee"},
            {"Georgia", "Atlanta"},
            {"Hawaii", "Honolulu"},
            {"Idaho", "Boise"},
            {"Illinois", "Springfield"},
            {"Indiana", "Indianapolis"},
            {"Iowa", "Des Moines"},
            {"Kansas", "Topeka"},
            {"Kentucky", "Frankfort"},
            {"Louisiana", "Baton Rouge"},
            {"Maine", "Augusta"},
            {"Maryland", "Annapolis"},
            {"Massachusetts", "Boston"},
            {"Michigan", "Lansing"},
            {"Minnesota", "Saint Paul"},
            {"Mississippi", "Jackson"},
            {"Missouri", "Jefferson City"},
            {"Montana", "Helena"},
            {"Nebraska", "Lincoln"},
            {"Nevada", "Carson City"},
            {"New Hampshire", "Concord"},
            {"New Jersey", "Trenton"},
            {"New Mexico", "Santa Fe"},
            {"New York", "Albany"},
            {"North Carolina", "Raleigh"},
            {"North Dakota", "Bismarck"},
            {"Ohio", "Columbus"},
            {"Oklahoma", "Oklahoma City"},
            {"Oregon", "Salem"},
            {"Pennsylvania", "Harrisburg"},
            {"Rhode Island", "Providence"},
            {"South Carolina", "Columbia"},
            {"South Dakota", "Pierre"},
            {"Tennessee", "Nashville"},
            {"Texas", "Austin"},
            {"Utah", "Salt Lake City"},
            {"Vermont", "Montpelier"},
            {"Virginia", "Richmond"},
            {"Washington", "Olympia"},
            {"West Virginia", "Charleston"},
            {"Wisconsin", "Madison"},
            {"Wyoming", "Cheyenne"}
		};
		
		// First, display the contents of the stateCapitals array as is
		System.out.println("States and capitals ordered by state:");
		displayStateCapitals(stateCapitals);
		
		// Now sort the stateCapitals array by capital with a bubble sort
		System.out.println("Sorting by capital using bubble sort...");
		stateCapitals = bubbleSortByCapital(stateCapitals);
		
		// Now display the stateCapitals array sorted by capital which has been bubble-sorted
		System.out.println("States and capitals ordered by capital:");
		displayStateCapitals(stateCapitals);
		
		// Now go through the array and quiz the user on capitals
		// Instantiate a scanner object for input
		Scanner scanner = new Scanner(System.in);
		// Declare a variable to count correct answers by the user
		int correctCount = 0;
		// Loop through the array
		for (int i = 0; i < stateCapitals.length; i++)
		{
			// Prompt user to enter capital for a given state
			System.out.println("Enter a corresponding capital for " + stateCapitals[i][0]);
			// Read and store the user input
			String input = scanner.nextLine();
			
			// Compare the user input to the capital of the state, ignore case
			if (input.equalsIgnoreCase(stateCapitals[i][1]))
			{
				// Display feedback
				System.out.println("Correct!");
				// increase the correct count
				correctCount++;
			}
			else
			{
				// Display feedback
				System.out.println("Wrong!");
			}
		}
		// Display how many capitals the user entered correctly
		System.out.println("Correct Count: " + correctCount);
		
		// Close the scanner object
		// scanner.close();	
		
		// Part 2
		
		// Create a HashMap
		Map<String, String> stateCapitalsHashMap = new HashMap<>();
		// Loop through the stateCapitals 2D array and add each state-capital pair to the hashmap
		for (String[] pair : stateCapitals)
		{
			// Populate the HashMap with state and capital
			stateCapitalsHashMap.put(pair[0],pair[1]);
		}
		
		// Display the content of the HashMap using Map.Entry
		System.out.println("States and capitals from a HashMap:");
		// Loop through the entry sets of the stateCapitals hashmap
        for (Map.Entry<String, String> entry : stateCapitalsHashMap.entrySet())
        {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
		
        // Create a TreeMap using the same steps but with TreeMap class
        // TreeMap will naturally sort the data using binary search tree
        Map<String, String> stateCapitalsTreeMap = new TreeMap<>();
        
        // Loop through the stateCapitals 2D array with a string pair
        for (String[] pair : stateCapitals)
        {
        	// Add each state-capital pair to the TreeMap
        	stateCapitalsTreeMap.put(pair[0],pair[1]);
        }

        // Display the content of the TreeMap using Map.Entry
        System.out.println("States and capitals from a TreeMap:");
        // Loop through each entry of the TreeMap in its entry set form
        for (Map.Entry<String, String> entry : stateCapitalsTreeMap.entrySet())
        {
        	System.out.println(entry.getKey() + " - " + entry.getValue());
        }
        
        
        // Prompt the user to enter a state
        System.out.print("Enter a state to check its capital: ");
        // Read and store the user input for the key (state)
        String input = scanner.nextLine();
        // Convert the input's first letter to upper case, and the rest of it to lower case
        input = input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
        // Use the get method to find a value (capital) match for the key (state)
        String output = stateCapitalsTreeMap.get(input);
        // If match is found
		if (output != null)
		{
			// Display the capital for the entered state 
		    System.out.println("Its capital is: " + output);
		}
        // If match is not found
		else
		{
			// Display not found message
		    System.out.println("No such state was found, check your spelling.");
		}
        // Close the scanner object
        scanner.close();
    	
	}

}
