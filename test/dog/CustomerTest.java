package dog;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dogs.model.Customer;

class CustomerTest {
	
	private static final String ANY_NAME = "Jean";
	private static final String ANY_LAST_NAME = "Dujardin";
	private static final String ANY_PHONE = "418.380.3141";
	private static final String ANY_EMAIL = "jeandujardin@gmail.com";

	@Test
	void customerCanBeCreated() {
		Customer customer = new Customer(ANY_NAME,ANY_LAST_NAME,ANY_PHONE,ANY_EMAIL);
		
		assertEquals(ANY_NAME,customer.getName());
		assertEquals(ANY_LAST_NAME,customer.getLastName());
		assertEquals(ANY_PHONE,customer.getPhone());
		assertEquals(ANY_EMAIL,customer.getEmail());
	}
	
	@Test
	void customerNameCanBeChanged() {
		Customer customer = new Customer(ANY_NAME,ANY_LAST_NAME,ANY_PHONE,ANY_EMAIL);
		
		customer.setName("Mario");
		
		assertEquals("Mario",customer.getName());
	}
	
	@Test
	void customerLastNameCanBeChanged() {
		Customer customer = new Customer(ANY_NAME,ANY_LAST_NAME,ANY_PHONE,ANY_EMAIL);
		
		customer.setLastName("Bros");
		
		assertEquals("Bros",customer.getLastName());
	}
	
	@Test
	void customerPhoneCanBeChanged() {
		Customer customer = new Customer(ANY_NAME,ANY_LAST_NAME,ANY_PHONE,ANY_EMAIL);
		
		customer.setPhone("418.380.3000");
		
		assertEquals("418.380.3000",customer.getPhone());
	}
	
	@Test
	void customerEmailCanBeChanged() {
		Customer customer = new Customer(ANY_NAME,ANY_LAST_NAME,ANY_PHONE,ANY_EMAIL);
		
		customer.setEmail("mariobros@gmail.com");
		
		assertEquals("mariobros@gmail.com",customer.getEmail());
	}

}
