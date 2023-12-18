package dogs.controller;

import java.util.Collection;

import dogRepository.IEntityRepository;
import dogs.model.Customer;
import dogs.view.CustomerListView;

public class CustomerController implements ICustomerController{
	
	private IEntityRepository<Customer> repository;
	
	public CustomerController(IEntityRepository<Customer> repository) {
		this.repository = repository;
	}

	@Override
	public void listCustomer() {
		CustomerListView view = new CustomerListView(this,this.repository);
		view.display();
	}
	
	@Override
	public void showResult(Collection<Customer> result) {
		CustomerListView view = new CustomerListView(this,this.repository);
		view.insertResultOfSearch(result);
		view.display();
	}

}
