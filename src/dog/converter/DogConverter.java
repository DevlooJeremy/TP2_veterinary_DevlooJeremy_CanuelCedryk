package dog.converter;

import dogs.model.Customer;
import dogs.model.Dog;
import dto.CustomerDTO;
import dto.DogDTO;

public class DogConverter {

	public Dog dtoToDog(DogDTO dogDTO) {
		CustomerConverter customerConverter = new CustomerConverter();
		Customer customer = customerConverter.dtoToCustomer(dogDTO.owner);
		Dog dog = new Dog(dogDTO.name,dogDTO.breed,dogDTO.weight,customer);
		return dog;
	}
	
	public DogDTO dogToDTO(Dog dog) {
		Customer customer = dog.getOwner();
		CustomerDTO customerDTO = new CustomerDTO(customer.getName(),customer.getLastName(),customer.getPhone(),customer.getEmail(),0);
		return new DogDTO(dog.getName(),dog.getBreed(),dog.getId(),dog.getWeight(),customerDTO);
	}
}
