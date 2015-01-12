package humanresourcemanagementdemo;

import humanresourcemanagement.data.IHumanDataAdapter;
import humanresourcemanagement.humans.Human;
import humanresourcemanagement.humans.HumansCollection;
import humanresourcemanagement.humans.Student;

import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;



/**
 * 
 * @author Mick Soudant
 * @author Rach�l Heimbach
 */
public class WorkShopAssignment {
	
	private Predicate<Human> 	isStudent = (h) -> h instanceof Student;
	
	//  	 ___           _______.     _______. __    _______ .__   __. .___  ___.  _______ .__   __. .___________.
	// 		/   \         /       |    /       ||  |  /  _____||  \ |  | |   \/   | |   ____||  \ |  | |           |
	//	   /  ^  \       |   (----`   |   (----`|  | |  |  __  |   \|  | |  \  /  | |  |__   |   \|  | `---|  |----`
	//	  /  /_\  \       \   \        \   \    |  | |  | |_ | |  . `  | |  |\/|  | |   __|  |  . `  |     |  |     
	//	 /  _____  \  .----)   |   .----)   |   |  | |  |__| | |  |\   | |  |  |  | |  |____ |  |\   |     |  |     
	//	/__/     \__\ |_______/    |_______/    |__|  \______| |__| \__| |__|  |__| |_______||__| \__|     |__|     
	//	  ______   .__   __.  _______                                                                               
	//	 /  __  \  |  \ |  | |   ____|                                                                              
	//	|  |  |  | |   \|  | |  |__                                                                                 
	//	|  |  |  | |  . `  | |   __|                                                                                
	//	|  `--'  | |  |\   | |  |____                                                                               
	//	 \______/  |__| \__| |_______|                                                                              
	//                                                                                                             
	/**
	 * Lambdas
	 * Method references
	 * Functional Interfaces
	 */
	
    public static class HumanSelector {

        public static boolean maleAdults(Human human) {
            return human.isAdult() && human.isMale();
        }

        public static boolean femaleAdults(Human human) {
            return !maleAdults(human);
        }
    }
	
	public static HumansCollection filterWithLambda(HumansCollection Humans) {
		return null; //Filter de lijst humans op volwassenen met behulp van een lambda (De filter methode staat in Humans)
	}
	
	public static HumansCollection filterWithMethodReference(HumansCollection Humans) {
		return null; //Filter de lijst humans op volwassenen met behulp van een method reference
	}
	
	public static HumansCollection filterMaleAdultsWithStaticMethodReference(HumansCollection Humans) {
		return null; //Filter de lijst humans op volwassen mannen met behulp van een static method reference (Kijk naar de humanselector bovenin dit bestand)
		}
	
	public static HumansCollection sortHumansWithLambda(HumansCollection Humans) {
		return null; //Sorteer de lijst humans op naam met behulp van een lambda
	}
	
	public static HumansCollection sortWithComparing(HumansCollection Humans) {
		return null; //Sorteer de lijst humans op naam met behulp van een Comparator
	}
	
    public static HumansCollection filterUsingAnonymousInnerClass(HumansCollection humans) {
    	return null; //Filter de lijst humans op volwassenen, maak daarbij gebruik van de functional interface in de klasse Humans 
    }
		
	//  	 ___           _______.     _______. __    _______ .__   __. .___  ___.  _______ .__   __. .___________.
	// 		/   \         /       |    /       ||  |  /  _____||  \ |  | |   \/   | |   ____||  \ |  | |           |
	//	   /  ^  \       |   (----`   |   (----`|  | |  |  __  |   \|  | |  \  /  | |  |__   |   \|  | `---|  |----`
	//	  /  /_\  \       \   \        \   \    |  | |  | |_ | |  . `  | |  |\/|  | |   __|  |  . `  |     |  |     
	//	 /  _____  \  .----)   |   .----)   |   |  | |  |__| | |  |\   | |  |  |  | |  |____ |  |\   |     |  |     
	//	/__/     \__\ |_______/    |_______/    |__|  \______| |__| \__| |__|  |__| |_______||__| \__|     |__|     
	//	.___________.____    __    ____  ______                                                                     
	//	|           |\   \  /  \  /   / /  __  \                                                                    
	//	`---|  |----` \   \/    \/   / |  |  |  |                                                                   
	// 		|  |       \            /  |  |  |  |                                                                   
	// 		|  |        \    /\    /   |  `--'  |                                                                   
	// 		|__|         \__/  \__/     \______/          
	//  
	/**
	 * Streams
	 */

    public static int getTotalAgeOfAllHumansWithStreams(HumansCollection humans) {
    	return 0; //maak een stream van humans en tel de leeftijden van iedereen bij elkaar op
    }
    
    
    public static Stream<Human> sortAllHumansWithStreams(HumansCollection humans)
    {
    	return null; //maak een stream van humans en sorteer hem op naam
    }
    
 
	public static HumansCollection getAllHumansOlderThan20WithStreams(HumansCollection humans) {
	    return null; //maak een stream van de lijst humans en controleer of ze ouder dan 20 zijn
	}
	
	public static int getTotalAgeOfAllHumansUnder30WithStreams(HumansCollection humans)
	{
		return 0; ////maak een stream van de lijst humans en controleer of ze jonger dan 30 zijn en tel vervolgens hun leeftijden op (gebruik slechts 1 regel code)
	}
	
	public static Human getACertainPersonWithNestedStreams(HumansCollection humans, String[] nameAndGender)
	{
		return null; //maak een stream van de lijst humans en filter de items op naam en geslacht
					//door een stream van nameAndGender te maken (gebruik de functie doesItMatch zoals hieronder beschreven)
	}

	
	//  	 ___           _______.     _______. __    _______ .__   __. .___  ___.  _______ .__   __. .___________.
	// 		/   \         /       |    /       ||  |  /  _____||  \ |  | |   \/   | |   ____||  \ |  | |           |
	//	   /  ^  \       |   (----`   |   (----`|  | |  |  __  |   \|  | |  \  /  | |  |__   |   \|  | `---|  |----`
	//	  /  /_\  \       \   \        \   \    |  | |  | |_ | |  . `  | |  |\/|  | |   __|  |  . `  |     |  |     
	//	 /  _____  \  .----)   |   .----)   |   |  | |  |__| | |  |\   | |  |  |  | |  |____ |  |\   |     |  |     
	//	/__/     \__\ |_______/    |_______/    |__|  \______| |__| \__| |__|  |__| |_______||__| \__|     |__|     
	//	.___________. __    __  .______       _______  _______                                                      
	//	|           ||  |  |  | |   _  \     |   ____||   ____|                                                     
	//	`---|  |----`|  |__|  | |  |_)  |    |  |__   |  |__                                                        
	// 		|  |     |   __   | |      /     |   __|  |   __|                                                       
	// 		|  |     |  |  |  | |  |\  \----.|  |____ |  |____                                                      
	// 		|__|     |__|  |__| | _| `._____||_______||_______|                                                     
	//
	/**
	 * Optionals
	 */
	
	public static Optional<String> getOptionalFromString(String string)
	{
		return null; //maak een optional van string en return hem
	}
	
	public static String getStringFromOptional(Optional<String> couldBeAString)
	{
		return null; // maak een String van couldBeAString en return hem
	}


}
