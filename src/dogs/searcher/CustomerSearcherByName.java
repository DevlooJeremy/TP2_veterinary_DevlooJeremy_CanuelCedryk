package dogs.searcher;

import dogs.model.Customer;

public class CustomerSearcherByName implements IEntitySearcher<Customer> {

	private String nameToSearch = "";
	
	public CustomerSearcherByName(String nameToSearch) {
		this.nameToSearch = nameToSearch;
	}
	
	@Override
	public boolean isMatching(Customer customer) {
		if(customer.getLastName().equals(nameToSearch)) {
			return true;
		}
		return false;
	}

}
