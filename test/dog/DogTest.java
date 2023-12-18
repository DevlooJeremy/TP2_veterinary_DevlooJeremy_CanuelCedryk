package dog;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dogs.model.Customer;
import dogs.model.Dog;

class DogTest {
	
	public static final String ANY_NAME = "Jean";
	public static final String ANY_NEW_NAME = "Pierre";
	public static final String ANY_BREED = "Caniche";
	public static final String ANY_NEW_BREED = "Husky";
	public static final float ANY_WEIGHT = 10.0f;
	public static final float ANY_NEW_WEIGHT = 15.0f;

	@Test
	void dogCanBeCreated() {
		//Arrange
		Customer customer = new Customer(CustomerTest.ANY_NAME,CustomerTest.ANY_LAST_NAME,CustomerTest.ANY_PHONE,CustomerTest.ANY_EMAIL);
		//Act
		Dog dog = new Dog(ANY_NAME,ANY_BREED,ANY_WEIGHT,customer);
		
		//Assert
		assertEquals(ANY_NAME,dog.getName());
		assertEquals(ANY_BREED,dog.getBreed());
		assertEquals(ANY_WEIGHT,dog.getWeight());
		assertEquals(customer,dog.getOwner());
	}
	
	@Test
	void dogNameCanBeChanged() {
		//Arrange
		Customer customer = new Customer(CustomerTest.ANY_NAME,CustomerTest.ANY_LAST_NAME,CustomerTest.ANY_PHONE,CustomerTest.ANY_EMAIL);
		Dog dog = new Dog(ANY_NAME,ANY_BREED,ANY_WEIGHT,customer);
		
		//Act
		dog.setName(ANY_NEW_NAME);;
		
		//Assert
		assertEquals(ANY_NEW_NAME,dog.getName());

	}

	@Test
	void dogBreedCanBeChanged() {
		//Arrange
		Customer customer = new Customer(CustomerTest.ANY_NAME,CustomerTest.ANY_LAST_NAME,CustomerTest.ANY_PHONE,CustomerTest.ANY_EMAIL);
		Dog dog = new Dog(ANY_NAME,ANY_BREED,ANY_WEIGHT,customer);
		
		//Act
		dog.setBreed(ANY_NEW_BREED);;
		
		//Assert
		assertEquals(ANY_NEW_BREED,dog.getBreed());

	}
	
	@Test
	void dogWeightCanBeChanged() {
		//Arrange
		Customer customer = new Customer(CustomerTest.ANY_NAME,CustomerTest.ANY_LAST_NAME,CustomerTest.ANY_PHONE,CustomerTest.ANY_EMAIL);
		Dog dog = new Dog(ANY_NAME,ANY_BREED,ANY_WEIGHT,customer);
		
		//Act
		dog.setWeight(ANY_NEW_WEIGHT);;
		
		//Assert
		assertEquals(ANY_NEW_WEIGHT,dog.getWeight());

	}

}
