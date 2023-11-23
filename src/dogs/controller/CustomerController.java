package dogs.controller;

import dogRepository.ICustomerRepository;
import dogs.view.CustomerListView;
import dto.CustomerDTO;

public class CustomerController implements ICustomerController{
	
	private ICustomerRepository repository;
	
	public CustomerController(ICustomerRepository repository) {
		this.repository = repository;
	}

	@Override
	public void listCustomer() {
		CustomerListView view = new CustomerListView(this,this.repository);
		view.display();
	}

}
