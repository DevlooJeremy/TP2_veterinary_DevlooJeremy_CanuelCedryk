package dog;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dogs.model.Dog;

class DogTest {

	@Test
	void dogCanBeCreated() {
		//Arrange
		
		//Act
		Dog dog = new Dog("Jean","Caniche");
		
		//Assert
		assertEquals("Jean",dog.getName());
		assertEquals("Caniche",dog.getBreed());
	}
	
	@Test
	void dogNameCanBeChanged() {
		//Arrange
		Dog dog = new Dog("Jean","Caniche");
		
		//Act
		dog.setName("Pierre");;
		
		//Assert
		assertEquals("Pierre",dog.getName());

	}

	@Test
	void dogBreedCanBeChanged() {
		//Arrange
		Dog dog = new Dog("Jean","Caniche");
		
		//Act
		dog.setBreed("Husky");;
		
		//Assert
		assertEquals("Husky",dog.getBreed());

	}

}
