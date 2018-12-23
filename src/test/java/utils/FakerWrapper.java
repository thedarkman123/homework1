package utils;

import com.github.javafaker.Faker;

public class FakerWrapper {
	private static Faker faker = new Faker();

	public static String getFakeUserName() {
		return faker.name().fullName(); 
	}
	
	public static String getFakePassword(){
		return faker.internet().password(); 
	} 
}
