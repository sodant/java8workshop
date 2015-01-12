package humanresourcemanagement;

import humanresourcemanagement.data.IHumanDataAdapter;
import humanresourcemanagement.humans.Human;
import humanresourcemanagement.humans.HumansCollection;
import humanresourcemanagement.humans.HumansCollection.HumanFilter;
import humanresourcemanagement.humans.Student;

import java.util.Comparator;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * 
 * @author Mick Soudant
 * @author Rachél Heimbach
 * @author Brendan Steijn
 */
public class WorkShopAnswers {
	
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
	 * ->->Basic streams.
	 */
	
    public static class HumanSelector {

        public static boolean maleAdults(Human human) {
            return human.isAdult() && human.isMale();
        }

        public static boolean femaleAdults(Human human) {
            return !maleAdults(human);
        }
    }
	
	public static HumansCollection getAdultsLambda(HumansCollection Humans) {
	    return Humans.filter(x -> x.isAdult());
	}
	
	public static HumansCollection getAdultsMethodReference(HumansCollection Humans) {
	    return Humans.filter(Human::isAdult);
	}
	
	public static HumansCollection getMaleAdultsStaticMethodReference(HumansCollection Humans) {
	    return Humans.filter(HumanSelector::maleAdults);
	}
	
	public static HumansCollection sortHumansLambda(HumansCollection Humans) {
	    return Humans.sort((p1,p2) -> p1.name.compareTo(p2.name));
	}
	
	public static HumansCollection sortHumansWithComparing(HumansCollection Humans) {
	    return Humans.sort(Comparator.comparing(Human::getName));
	}
		
    public static HumansCollection getAdultsFunctional(HumansCollection humans) {
    	return humans.filter(new HumanFilter() {
    		@Override
    		public boolean accept(Human Human) {
    			return Human.isAdult();
    		}
    	});
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
    
    public static int getTotalAgeOfAllHumans(HumansCollection humans)
    {
    	return humans.stream().mapToInt(h -> h.age).sum();
    }
    
    public static Stream<Human> sortWithStreams(HumansCollection humans)
    {
    	return humans.stream().sorted((h1, h2) -> h1.name.compareTo(h2.name));
    }

	public static HumansCollection getHumansOver20(HumansCollection humans) {
		return new HumansCollection(humans.stream()
				.filter(h -> h.age > 20)
						.collect(Collectors.toList()));
	}
	
	public static int getTotalAgeOfAllHumansUnder30(HumansCollection humans)
	{
		return humans.stream().filter(h -> h.age < 30).mapToInt(h -> h.age).sum();
	}
	
	public static Human getHermanSales(HumansCollection humans, String[] nameAndGender)
	{
		return humans.stream().filter(
				human -> Stream.of(nameAndGender).allMatch((
						(Predicate<String>) nameOrGender -> human.name == nameOrGender).or(nameOrGender -> human.sex == nameOrGender)))
				.findFirst().get();
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

	public static Optional<String> getOptFromStr(String string)
	{
		return Optional.of(string);
	}
	
	public static String getStrFromOpt(Optional<String> couldBeAString)
	{
		return couldBeAString.orElse(null);
	}
}
