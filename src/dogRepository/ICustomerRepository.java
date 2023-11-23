package dogRepository;

import java.util.Collection;

import dogs.model.Customer;
import dogs.model.Dog;

public interface ICustomerRepository {

public void add(Customer customer);
	
	public Collection<Customer> getList();
	
	public int size();
	
	public Customer searchById(int id);
}
