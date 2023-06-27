import java.util.Random;

//this class works as the backend and will generate the password
public class PasswordGenerator {
	//character pools
	//this strings will be used to generate the password
	public static final String LOWERCASE_CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
	public static final String UPPERCASE_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String NUMBERS = "0123456789";
	public static final String SPECIAL_SYMBOLS = "!@#$%^&*()_+-=[]{};':,./<>?";
	
	private final Random random;
	
	//constructor
	public PasswordGenerator() {
		random = new Random();
	}
	
	public String generatePassword(int length, boolean useLowercaseCharacters, boolean useUppercaseCharacters, boolean useNumbers, boolean useSpecialSymbols) {
		//create a string builder to store the password
		StringBuilder password = new StringBuilder();
		
		//create a string builder to store the character pool
		StringBuilder characterPool = new StringBuilder();
		
		//add the character pools to the character pool string builder
		if(useLowercaseCharacters) characterPool.append(LOWERCASE_CHARACTERS);
		
		if(useUppercaseCharacters) characterPool.append(UPPERCASE_CHARACTERS);
		
		if(useNumbers) characterPool.append(NUMBERS);
		
		if(useSpecialSymbols) characterPool.append(SPECIAL_SYMBOLS);
		
		//loop through the character pool string builder
		for(int i = 0; i < length; i++) {
			//generate a random index number
			int index = random.nextInt(characterPool.length());
			
			//append the character at the index to the password string builder
			password.append(characterPool.charAt(index));
		}
		
		return password.toString();
	}
}
