package dogs.controller;

import dogRepository.IEntityRepository;
import dogs.model.Customer;
import dogs.view.CustomerListView;
import dto.CustomerDTO;

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

}
