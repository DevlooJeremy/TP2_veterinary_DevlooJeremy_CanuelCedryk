package dog.converter;

import dogs.model.Customer;
import dto.CustomerDTO;

public class CustomerConverter {
	
	public CustomerDTO customerToDTO(Customer customer) {
		CustomerDTO dto = new CustomerDTO(customer.getName(),customer.getLastName(),customer.getPhone(),customer.getEmail(),customer.getId());
		return dto;
	}
	
	public Customer dtoToCustomer(CustomerDTO dto) {
		Customer customer = new Customer(dto.firstName,dto.lastName,dto.phone,dto.email);
		return customer;
	}
}
