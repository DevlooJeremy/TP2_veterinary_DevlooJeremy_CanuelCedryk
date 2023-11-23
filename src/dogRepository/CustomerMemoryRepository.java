package dogRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import dogs.model.Customer;

public class CustomerMemoryRepository implements ICustomerRepository{
	
	private Map<Integer,Customer> repository;

	public CustomerMemoryRepository() {
		this.repository = new HashMap<Integer,Customer>();
	}
	
	@Override
	public void add(Customer customer) {
		int id = this.size() + 1;
		customer.setId(id);
		repository.put(id, customer);
		
	}

	@Override
	public Collection<Customer> getList() {
		return this.repository.values();
	}

	@Override
	public int size() {
		return repository.size();
	}

	@Override
	public Customer searchById(int id) {
		return repository.get(id);
	}

}
