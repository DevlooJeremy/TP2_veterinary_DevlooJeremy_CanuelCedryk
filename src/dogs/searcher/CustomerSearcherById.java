package dogs.searcher;

import dogs.model.Customer;

public class CustomerSearcherById implements IEntitySearcher<Customer> {

	private int idToSearch = 0;
	
	public CustomerSearcherById(int idToSearch) {
		this.idToSearch = idToSearch;
	}
	
	@Override
	public boolean isMatching(Customer customer) {
		if(customer.getId() == idToSearch) {
			return true;
		}
		return false;
	}

}
