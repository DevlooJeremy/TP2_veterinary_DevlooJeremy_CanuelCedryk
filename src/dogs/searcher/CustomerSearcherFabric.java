package dogs.searcher;

public class CustomerSearcherFabric {

	public CustomerSearcherFabric(){
		
	}
	
	public CustomerSearcherByName getStrategyToResearchCustomerByName(String nameToSearch){
		CustomerSearcherByName customerSearcherByName = new CustomerSearcherByName(nameToSearch);
		return customerSearcherByName;
	}
	
	public CustomerSearcherById getStrategyToResearchCustomerById(int idToSearch){
		CustomerSearcherById customerSearcherById = new CustomerSearcherById(idToSearch);
		return customerSearcherById;
	}
}
